package de.elnarion.asciidoc.extension.plantuml;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.asciidoctor.ast.AbstractBlock;
import org.asciidoctor.ast.Block;
import org.asciidoctor.ast.Document;
import org.asciidoctor.extension.Treeprocessor;

import net.sourceforge.plantuml.code.TranscoderUtil;

/**
 * This Treeprocessor extracts PlantUML text blocks, encodes them and converts
 * them to image blocks which refer to a configured remote PlantUML server.
 */
public class RemotePlantUMLTreeprocessor extends Treeprocessor {

	private static final String STYLE = "style";
	private static final String WIDTH = "width";
	private static final String HEIGHT = "height";
	private static final Logger LOGGER = LogManager.getLogManager()
			.getLogger(RemotePlantUMLTreeprocessor.class.getName());

	/**
	 * Instantiates a new RemotePlantUMLTreeprocessor.
	 */
	public RemotePlantUMLTreeprocessor() {
		// Default constructor
	}

	/**
	 * Instantiates a new RemotePlantUMLTreeprocessor with specific configurations
	 * e.g. an address to a remote PlantUML-Server.
	 *
	 * @param paramConfig - Map<String, Object> - the PreProcessor configuration
	 */
	public RemotePlantUMLTreeprocessor(Map<String, Object> paramConfig) {
		super(paramConfig);
	}

	@Override
	public Document process(Document paramDocument) {
		List<AbstractBlock> blocks = paramDocument.getBlocks();
		processBlocks(blocks);
		return null;
	}

	private void processBlocks(List<AbstractBlock> blocks) {
		if (blocks != null) {
			for (int i = 0; i < blocks.size(); i++) {
				AbstractBlock currentBlock = blocks.get(i);
				if (currentBlock instanceof Block) {
					processBlock(blocks, i, currentBlock);
				}
				List<AbstractBlock> subBlocks = currentBlock.getBlocks();
				if (subBlocks != null) {
					processBlocks(subBlocks);
				}
			}
		}
	}

	/**
	 * Helper method to process a asciidoc block and to get a more structured code.
	 *
	 * @param paramBlocks - List - the list of all blocks of a document
	 * @param paramIndex  - int - the index of the current block
	 * @param paramBlock  - AbstractBlock - the current block to process
	 */
	private void processBlock(List<AbstractBlock> paramBlocks, int paramIndex, AbstractBlock paramBlock) {
		Block block = (Block) paramBlock;
		@SuppressWarnings("rawtypes")
		Map attributes = block.getAttributes();
		Long firstAttribute = Long.valueOf(1);
		if (attributes.containsKey(STYLE) || attributes.containsKey(firstAttribute)) {
			String attributeValue = (String) (attributes.containsKey(STYLE) ? attributes.get(STYLE)
					: attributes.get(Long.valueOf(1l)));
			if ("plantuml".equalsIgnoreCase(attributeValue)) {
				Block imageBlock = createImageBlock(block, attributes);
				paramBlocks.set(paramIndex, imageBlock);
			}
		}
	}

	/**
	 * Creates the image block with the data of the plant uml diagram block.
	 *
	 * @param paramPlantUMLDiagramBlock - Block - the plantuml diagram block which
	 *                                  should be replaced by the image block
	 * @param paramBlockAttributes      - Map - the attributes of the plantuml
	 *                                  diagram block
	 * @return Block - the image block
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Block createImageBlock(Block paramPlantUMLDiagramBlock, Map paramBlockAttributes) {
		List<String> lines = paramPlantUMLDiagramBlock.lines();
		String url = (String) paramPlantUMLDiagramBlock.getParent().getAttr("remote_plantuml_url");
		if (url == null)
			throw new IllegalStateException("Remote PlantUML Extension: attribute remote_plantuml_url not found");
		String encodedPlantUMLString = convertPlantUMLLines(lines);
		Map newAttributes = new HashMap();
		newAttributes.put("alt", paramBlockAttributes.get(Long.valueOf(2l)));
		newAttributes.put("title", paramBlockAttributes.get(Long.valueOf(2l)));
		if (paramBlockAttributes.containsKey(WIDTH)) {
			newAttributes.put(WIDTH, paramBlockAttributes.get(WIDTH));
		}
		if (paramBlockAttributes.containsKey(HEIGHT)) {
			newAttributes.put(HEIGHT, paramBlockAttributes.get(HEIGHT));
		}
		newAttributes.put("target", url + encodedPlantUMLString);
		return createBlock((AbstractBlock) paramPlantUMLDiagramBlock.getParent(), "image", "", newAttributes,
				new HashMap());
	}

	/**
	 * Converts all lines of a plant UML diagram block to an encoded string which
	 * can be sent to a plantuml server.
	 *
	 * @param paramDiagramContentLines - List - the lines of the diagram block
	 * @return String - the encoded string
	 */
	private String convertPlantUMLLines(List<String> paramDiagramContentLines) {
		String result = "";
		if (paramDiagramContentLines != null) {
			StringBuilder toConvert = new StringBuilder();
			for (String line : paramDiagramContentLines) {
				toConvert.append(line);
				toConvert.append(System.lineSeparator());
			}
			try {
				result = TranscoderUtil.getDefaultTranscoder().encode(toConvert.toString());
			} catch (IOException e) {
				LOGGER.severe("Transcoding to PlantUML failed. Error is " + e.getMessage());
			}
		}
		return result;
	}

}

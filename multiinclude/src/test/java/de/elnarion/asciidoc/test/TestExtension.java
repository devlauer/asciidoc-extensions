package de.elnarion.asciidoc.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Asciidoctor.Factory;
import org.asciidoctor.Attributes;
import org.asciidoctor.Options;
import org.asciidoctor.SafeMode;
import org.asciidoctor.extension.RubyExtensionRegistry;
import org.junit.Test;

/**
 * The Class TestExtension.
 */
public class TestExtension {

	/**
	 * Test extension.
	 * 
	 * @throws IOException
	 */
	@Test
	public void testExtension() throws IOException {
		Asciidoctor asciidoctor = Factory.create();
		RubyExtensionRegistry rubyReg = asciidoctor.rubyExtensionRegistry();
		rubyReg.loadClass(
				TestExtension.class.getClassLoader().getResourceAsStream("elnarion/multi-include-processor/extension.rb"));
		rubyReg.includeProcessor("MultiIncludeProcessor");
		Attributes asciidocAttributes = new Attributes();
		asciidocAttributes.setAllowUriRead(true);
		asciidocAttributes.setBackend("docbook");
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("backend", "docbook");
		attributes.put("allow-uri-read", "true");
		Options asciidocOptions = new Options();
		asciidocOptions.setSafe(SafeMode.UNSAFE);
		asciidocOptions.setInPlace(true);
		asciidocOptions.setToFile(false);
		String testResult = asciidoctor.convertFile(new File("./src/test/resources/multitest/test.adoc"), asciidocOptions);
		assertTrue(testResult.contains("multixcontent2"));

	}

}

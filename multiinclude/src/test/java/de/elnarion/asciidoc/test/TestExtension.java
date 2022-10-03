package de.elnarion.asciidoc.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Asciidoctor.Factory;
import org.asciidoctor.Options;
import org.asciidoctor.SafeMode;
import org.asciidoctor.extension.RubyExtensionRegistry;
import org.junit.jupiter.api.Test;

/**
 * The Class TestExtension.
 */
class TestExtension {

	/**
	 * Test extension.
	 * 
	 * @throws IOException
	 */
	@Test
	void testExtension() throws IOException {
		Asciidoctor asciidoctor = Factory.create();
		RubyExtensionRegistry rubyReg = asciidoctor.rubyExtensionRegistry();
		rubyReg.loadClass(
				TestExtension.class.getClassLoader().getResourceAsStream("elnarion/multi-include-processor/extension.rb"));
		rubyReg.includeProcessor("MultiIncludeProcessor");
		Options asciidocOptions =Options.builder().safe(SafeMode.UNSAFE).inPlace(true).toFile(false).build();
		String testResult = asciidoctor.convertFile(new File("./src/test/resources/multitest/test.adoc"), asciidocOptions);
		assertTrue(testResult.contains("multixcontent2"));

	}

}

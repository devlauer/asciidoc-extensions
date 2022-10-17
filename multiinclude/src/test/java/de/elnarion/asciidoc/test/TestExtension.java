package de.elnarion.asciidoc.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Asciidoctor.Factory;
import org.asciidoctor.Options;
import org.asciidoctor.SafeMode;
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
		Options asciidocOptions = Options.builder().safe(SafeMode.UNSAFE).inPlace(true).toFile(false).build();
		String testResult = asciidoctor.convertFile(new File("./src/test/resources/multitest/test.adoc"),
				asciidocOptions);
		System.out.println(testResult);
		assertAll(() -> assertTrue(testResult.contains("multicontent1")),
				() -> assertTrue(testResult.contains("multicontent2")),
				() -> assertTrue(testResult.contains("multixcontent2")));

	}

}

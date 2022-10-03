package de.elnarion.asciidoc.extension.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Asciidoctor.Factory;
import org.asciidoctor.Attributes;
import org.asciidoctor.Options;
import org.asciidoctor.SafeMode;
import org.junit.jupiter.api.Test;

/**
 * This class tests the RemotePlantUMLTreeprocessor.
 */
class TestRemotePlantUMLTreeprocessor {

	/**
	 * Simple test of the plant UML replacement.
	 */
	@Test
	void testPlantUMLReplacement() {
		Asciidoctor asciidoctor = Factory.create();
		Attributes asciidocAttributes = Attributes.builder().attribute("remote_plantuml_url", "http://www.plantuml.com/plantuml/png/").allowUriRead(true).backend("html").build();
		
		Options asciidocOptions = Options.builder().safe(SafeMode.UNSAFE).inPlace(true).toFile(false).attributes(asciidocAttributes).build();

		String testResult = asciidoctor.convertFile(new File("./src/test/resources/test.adoc"), asciidocOptions);
		assertTrue(testResult.contains("www.plantuml.com"));

	}

}

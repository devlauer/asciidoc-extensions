package de.elnarion.asciidoc.extension.test;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Asciidoctor.Factory;
import org.asciidoctor.Attributes;
import org.asciidoctor.Options;
import org.asciidoctor.SafeMode;
import org.junit.Test;

/**
 * This class tests the RemotePlantUMLTreeprocessor.
 */
public class TestRemotePlantUMLTreeprocessor {

	/**
	 * Simple test of the plant UML replacement.
	 */
	@Test
	public void testPlantUMLReplacement() {
		Asciidoctor asciidoctor = Factory.create();
		Attributes asciidocAttributes = new Attributes();
		asciidocAttributes.setAttribute("remote_plantuml_url", "http://www.plantuml.com/plantuml/png/");
		asciidocAttributes.setAllowUriRead(true);
		asciidocAttributes.setBackend("docbook");

		Options asciidocOptions = new Options();
		asciidocOptions.setSafe(SafeMode.UNSAFE);
		asciidocOptions.setInPlace(true);
		asciidocOptions.setToFile(false);
		asciidocOptions.setAttributes(asciidocAttributes);

		String testResult = asciidoctor.convertFile(new File("./src/test/resources/test.adoc"), asciidocOptions);
		System.out.println(testResult);
		assertTrue(testResult.contains("www.plantuml.com"));

	}

}

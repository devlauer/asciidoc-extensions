package de.elnarion.asciidoc.extension;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.extension.JavaExtensionRegistry;
import org.asciidoctor.extension.spi.ExtensionRegistry;

import de.elnarion.asciidoc.extension.plantuml.RemotePlantUMLTreeprocessor;

/**
 * This class implements a Java Service Interface (ExtensionRegistry) and is
 * loaded by asciidoctorj from classpath. It registers the PlantRemoteUML
 * Extension
 */
public class RemotePlantUMLExtensionRegistry implements ExtensionRegistry {

	@Override
	public void register(Asciidoctor asciidoctor) {
		JavaExtensionRegistry javaExtensionRegistry = asciidoctor.javaExtensionRegistry();
		javaExtensionRegistry.treeprocessor(RemotePlantUMLTreeprocessor.class);

	}

}

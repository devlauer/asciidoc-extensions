package de.elnarion.asciidoc.extension;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.extension.RubyExtensionRegistry;
import org.asciidoctor.jruby.extension.spi.ExtensionRegistry;

/**
 * This class implements a Java Service Interface (ExtensionRegistry) and is
 * loaded by asciidoctorj from classpath. It registers the PlantRemoteUML
 * Extension
 */
public class MultiIncludeExtensionRegistry implements ExtensionRegistry {

	@Override
	public void register(Asciidoctor asciidoctor) {
		RubyExtensionRegistry rubyReg = asciidoctor.rubyExtensionRegistry();
		rubyReg.loadClass(
				this.getClass().getClassLoader().getResourceAsStream("MultiIncludeProcessor.rb"));
		rubyReg.includeProcessor("MultiIncludeProcessor"); 		
	}

}

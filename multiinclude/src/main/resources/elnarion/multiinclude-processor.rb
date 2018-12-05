RUBY_ENGINE == 'opal' ? (require 'multi-include-processor/extension') : (require_relative 'multi-include-processor/extension')

Asciidoctor::Extensions.register do
  include_processor MultiIncludeProcessor
end
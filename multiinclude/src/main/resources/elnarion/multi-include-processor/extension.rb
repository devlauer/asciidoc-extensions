class MultiIncludeProcessor < Asciidoctor::Extensions::IncludeProcessor
  def process doc, reader, multitarget, attributes
    puts 'target'+multitarget
    Dir[File.join reader.dir, multitarget].sort.reverse_each do |target|
      attributesString = attributes.map{|k,v| "#{k}=#{v}"}.join(',')
      content = 'include::'+target+'['+attributesString+']'      
      reader.push_include content, target, target, 1, attributes
    end
    reader
  end

  def handles? target
    target.include? '*'
  end
end
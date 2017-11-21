package xml.xmlSchema.util;


import java.io.File;
import java.io.IOException;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
 
import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
 
/**
 * Clase de utilidad para validar un xml con un schema
 *
 */
public class ValidadorXMLSchema {
	
	/**
	 * Valida un documento XML con un esquema XML (XSD).
	 * @param xml Archivo que contiene el documento xml a validar
	 * @param xmlSchema Archivo que contiene el esquema que define el formato v�lido.
	 * @return El Document (DOM) del archivo xml.
	 * @throws ParserConfigurationException En caso de error de configuraci�n (no deber�a producirse).
	 * @throws SAXException En caso de detectar un error de validaci�n.
	 * @throws IOException  en caso de error al obtener la informaci�n desde los archivos  (no deber�a producirse).
	 */
	public static Document validate(File xml, File xmlSchema) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		factory.setNamespaceAware(true);  
		factory.setValidating(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaSource",   xmlSchema);  
 
 
		// Parseando el documento  
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();  
		documentBuilder.setErrorHandler(new ErrorHandler() {
			public void warning(SAXParseException ex) throws SAXException {
				throw ex;
			} 	
			public void error(SAXParseException ex) throws SAXException {
				throw ex;
			}
			public void fatalError(SAXParseException ex) throws SAXException {
				throw ex;
			}				
		});  
 
		return documentBuilder.parse(xml);  
	}
	
	
	
}
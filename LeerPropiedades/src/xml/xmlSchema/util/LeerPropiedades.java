package xml.xmlSchema.util;

import java.io.File;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import xml.xmlSchemaDefinicion.Properties;


public class LeerPropiedades {
	private String xmlFilePath;
	private String schemaFilePath;
	private Document documentDOM;
	private JSONObject documentJSON;

	public LeerPropiedades(){
		xmlFilePath 		= "src/xml/properties.xml";
		schemaFilePath	= "src/xml/xmlSchemaDefinicion/propertiesXMLSchema.xsd";  
		validarCargarArchivo(); 
		convertirDocumentoJSON();
	}
	
	public LeerPropiedades(String xmlFilePath,String schemaFilePath){
		this.xmlFilePath = xmlFilePath; 		
		this.schemaFilePath = schemaFilePath;	
		validarCargarArchivo();
		convertirDocumentoJSON();
	}
	

	private void validarCargarArchivo() {		
		File	 xml	  = new File(xmlFilePath);
		File	 schema	  = new File(schemaFilePath);
		try {
			documentDOM = ValidadorXMLSchema.validate(xml, schema);	
			imprimirValores();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void imprimirValores(){
		System.out.println("El documento está bien formado y es válido");
		System.out.println(documentDOM.getFirstChild().getAttributes().getNamedItem("nombre"));
		NodeList tipo = documentDOM.getElementsByTagName("tipo");
		System.out.println("Tipo producto = "+tipo.item(0).getFirstChild().getNodeValue());
		
		NodeList modulos =  documentDOM.getElementsByTagName("modulo");			
		for(int i=0;i<modulos.getLength();i++){
			System.out.println("Modulo licenciado = "+modulos.item(i).getFirstChild().getNodeValue());
			
		}		
	}
	
	private JSONObject convertirDocumentoJSON(){
		documentJSON = new JSONObject();
		
		documentJSON.put(Properties.NOMBRE,  documentDOM.getFirstChild().getAttributes().getNamedItem("nombre"));
		NodeList tipo = documentDOM.getElementsByTagName("tipo");
		documentJSON.put(Properties.TIPO,tipo.item(0).getFirstChild().getNodeValue());
		
		JSONArray modulos = new JSONArray();
		NodeList nModulos =  documentDOM.getElementsByTagName("modulo");			
		for(int i=0;i<nModulos.getLength();i++){
			modulos.add(nModulos.item(i).getFirstChild().getNodeValue());
		}	
		
		documentJSON.put(Properties.MODULOS, modulos);

		return documentJSON;
	}
	
	public Document getDocumentoDOM() {
		return documentDOM;
	}

	public JSONObject getDocumentoJSON() {
		return documentJSON;
	}
	
}

package xml.xmlSchema.util;

 
/**
 * Aplicaci�n para validar los XML con un esquema
 * 
 */
public class ValidarXML  {
	public static void main(String[] args) {

		
		LeerPropiedades lp = new LeerPropiedades();
		
			
		System.out.println(lp.getDocumentoJSON().toString());
		
		System.out.println(lp.getDocumentoDOM().getXmlVersion());
	}
}   
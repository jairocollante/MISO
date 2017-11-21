package plano;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LeerPropiedades {
	 
	 public static void main(String arg[]) {
	 
		 LeerPropiedades miPrincipal = new LeerPropiedades();
	  miPrincipal.leerArchivo();
	 }
	 
	 /**
	  * Lee un archivo de propiedades desde una ruta especifica
	  * y se imprime en pantalla.
	  */
	 private void leerArchivo() {
	  try {
	   
	/**Creamos un Objeto de tipo Properties*/
	   Properties propiedades = new Properties();
	    
	   /**Cargamos el archivo desde la ruta especificada*/
	  /* propiedades
	     .load(new FileInputStream("/src/plano/aplicacion.properties"));
	 */
	   
	   propiedades.load( LeerPropiedades.class.getClassLoader().getResourceAsStream("plano/aplicacion.properties") );
	   
	   
	   /**Obtenemos los parametros definidos en el archivo*/
	   String aplicacion = propiedades.getProperty("aplicacion");
	   String tipo = propiedades.getProperty("tipo");
	   
	   String login = propiedades.getProperty("Login");
	   String compras = propiedades.getProperty("Compras");
	 
	   /**Imprimimos los valores*/
	   System.out.println("Nombre: "+aplicacion + "\n" +"Pagina: "+ tipo + "\n" +"Login: "+login+"\n" +"Compras: "+compras );
	       
	    
	  } catch (FileNotFoundException e) {
	   System.out.println("Error, El archivo no exite");
	  } catch (IOException e) {
	   System.out.println("Error, No se puede leer el archivo");
	  }
	 }
	}

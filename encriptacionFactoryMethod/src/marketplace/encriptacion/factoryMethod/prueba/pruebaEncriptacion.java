package marketplace.encriptacion.factoryMethod.prueba;


import marketplace.encriptacion.factoryMethod.creador.ConcretoCreador;
import marketplace.encriptacion.factoryMethod.creador.Creador;
import marketplace.encriptacion.factoryMethod.producto.Encriptacion;

public class pruebaEncriptacion {

	public static void main(String[] args) {
		
		Creador  creador = new ConcretoCreador();
		Encriptacion a = creador.factoryMethodA();
		
		String par= a.encriptar("jjj");
		
		System.out.println(par);
		
		par= a.desencriptar(par);
		
		System.out.println(par);
		
		
		Encriptacion b = creador.factoryMethodB();
		
		par= b.encriptar("iii");
		
		System.out.println(par);
		
		par= b.desencriptar(par);
		
		System.out.println(par);

	}

}

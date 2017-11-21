package marketplace.encriptacion.factoryMethod.creador;

import marketplace.encriptacion.factoryMethod.producto.EncriptacionMetodoA;
import marketplace.encriptacion.factoryMethod.producto.Encriptacion;
import marketplace.encriptacion.factoryMethod.producto.EncriptacionMetodoB;

public class ConcretoCreador extends Creador {

	@Override
	public Encriptacion factoryMethodA() {
		
		return new EncriptacionMetodoA();
	}

	@Override
	public Encriptacion factoryMethodB() {
		
		return new EncriptacionMetodoB();
	}
	

}

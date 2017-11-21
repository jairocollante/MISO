package marketplace.encriptacion.factoryMethod.producto;

public class EncriptacionMetodoA implements Encriptacion {

	private final String semillaMetodoA="AAAA";
	
	@Override
	public String encriptar(String par) {
		System.out.println("Encriptacion Metodo A");
		return par+semillaMetodoA;		
	}

	@Override
	public String desencriptar(String par) {
		System.out.println("Desencriptacion Metodo A");
		if(par.length() - semillaMetodoA.length() >= 0)
			return par.substring(0,par.length()-semillaMetodoA.length());
		else
			return par;
	}
	

}

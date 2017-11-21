package marketplace.encriptacion.factoryMethod.producto;

public class EncriptacionMetodoB implements Encriptacion {
	
	private final String semillaMetodoB="BBBB";

	@Override
	public String encriptar(String par) {
		System.out.println("Encriptacion Metodo B");
		return par+semillaMetodoB;
	}

	@Override
	public String desencriptar(String par) {
		System.out.println("Desencriptacion Metodo B");
		if(par.length() - semillaMetodoB.length() >= 0)
			return par.substring(0,par.length()-semillaMetodoB.length());
		else
			return par;
	}

}

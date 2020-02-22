package excepciones;

public class MiExcepcion extends Exception {
	private int codError;
	
	public MiExcepcion(int codError) {
		super();
		this.codError = codError;
	}
	
	@Override
	public String getMessage() {
		
		String mensaje="";
		
		switch(codError) {
			case 1:
				mensaje="Error, elementos es lista vacía ";
				break;
			case 2: 
				mensaje="Error, elementos es null";
				break;
			case 3: 
				mensaje="Error, fraccion <0";
				break;
			case 4:
				mensaje="Error, fraccion >1";
				break;
		}
		return mensaje;
	}
}

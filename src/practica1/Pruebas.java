package practica1;
import excepciones.EmptyListException;
import excepciones.MiExcepcion;

public class Pruebas {

<<<<<<< HEAD
	public static void main(String[] args) {
=======
	public static void main(String[] args) throws MiExcepcion, EmptyListException {
		// TODO Auto-generated method stub
>>>>>>> 4210d2fb9454930d523c7689b858e44b2b57c976
		GestorGrupos g = new GestorGrupos();
		int[] elementos = new int[]{3,5,5,1,1,7,1,7,5,3,3,3,3};
		
		float fraccion = 0.67f; 
		
		int[][] lista = g.dividir_lista(elementos,fraccion);
		
		for(int i = 0; i<lista.length;i++) {
			for(int j = 0; j<lista[i].length;j++) {
				System.out.println(lista[i][j]);
			}

		}
		
	}

}

package practica1;
import excepciones.EmptyListException;
import excepciones.MiExcepcion;

public class Pruebas {

	public static void main(String[] args) throws MiExcepcion, EmptyListException {
		// TODO Auto-generated method stub
		GestorGrupos g = new GestorGrupos();
		int[] elementos = new int[13];
		elementos[0] = 3;
		elementos[1] = 5;
		elementos[2] = 5;
		elementos[3] = 1;
		elementos[4] = 1;
		elementos[5] = 7;
		elementos[6] = 1;
		elementos[7] = 7;
		elementos[8] = 5;
		elementos[9] = 3;
		elementos[10] = 3;
		elementos[11] = 3;
		elementos[12] = 3;
		
		
		float fraccion = 0.67f; 
		
		int[][] lista = g.dividir_lista(elementos,fraccion);
		
		for(int i = 0; i<lista.length;i++) {
			for(int j = 0; j<lista[i].length;j++) {
				System.out.println(lista[i][j]);
			}

		}
		
	}

}

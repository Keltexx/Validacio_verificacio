package practica1;

import excepciones.*;

import java.util.ArrayList;
import java.util.List;

public class GestorGrupos {
	
	public int[][] dividir_lista(int[] elementos, float fraccion) throws MiExcepcion {
		int[][] lista_dividida = new int[2][];

			if (elementos == null)
				throw new NullListException();
			else if (elementos.length <= 0)
				throw new EmptyListException();
			else if (fraccion < 0)
				throw new LowerFractionException();
			else if (fraccion > 1)
				throw new UpperFractionException();
			else {
				List<Integer> aux = new ArrayList<>();

				for (int i = 0; i < elementos.length; i++){
					if (!aux.contains(elementos[i])){
						aux.add(elementos[i]);
					}
				}

				int cant1 = 0;
				int cant2;
				int cantTotal = 0;

				for (int i = 0; i < aux.size(); i++){
					for (int j = 0; j < elementos.length; j++){
						if (aux.get(i).equals(elementos[j])){
							cant1++;
						}
					}
					cant2 = Math.round(cant1 * fraccion);
					cantTotal += cant2;
					cant1 = 0;
				}
			
				//int cant = (int) (elementos.length * fraccion);
//				int[][] lista_dividida = new int[2][];
				int[] lista0= new int[cantTotal];
				int[] lista0_elem = new int[cantTotal];
				int[] lista1= new int[elementos.length - cantTotal];
				int[] lista1_elem= new int[elementos.length - cantTotal];
				for(int i = 0; i<lista0.length;i++) {
					lista0[i]=-1;
					lista0_elem[i]=-1;
				}
				for(int i = 0; i<lista1.length;i++) {
					lista1[i]=-1;
					lista1_elem[i]=-1;
				}
				
				for(int i = 0; i< elementos.length; i++) {
					int num_apariciones_elementos = contar_apariciones(elementos[i],elementos);
					int cant_colocar_en_0= Math.round(fraccion*num_apariciones_elementos); 
					//int cant_colocar_en_1 = num_apariciones_elementos - cant_colocar_en_0;
					int num_apariciones_lista0 = contar_apariciones(elementos[i],lista0_elem);
					//int num_apariciones_lista1 = contar_apariciones(elementos[i],lista1_elem);
					if(num_apariciones_lista0<cant_colocar_en_0) {
						int j =0;
						while(lista0[j]!=-1) {
							j++;	
						}
						lista0[j]=i;
						lista0_elem[j]=elementos[i];
						
						
					}else { //if(num_apariciones_lista1<cant_colocar_en_1) {
						int j =0;
						while(lista1[j]!=-1) {
							j++;
						}
						lista1[j]=i;
						lista1_elem[j]=elementos[i];
					}
				}
				

				lista_dividida[0] = lista0;
				lista_dividida[1] = lista1;
				return lista_dividida;
			}


		//return lista_dividida;

	}
	
	public int contar_apariciones(int elem, int[] elementos) {
		int num_apariciones=0;
		for(int i = 0; i< elementos.length;i++) {
			if(elementos[i]==elem)
				num_apariciones++;
		}
		return num_apariciones;
	}

	public int[] obtener_grupos(int[] lista) {
		// Dada lista de elementos, devuelve lista de etiquetas
		// Para lista ejemplo, debería devolver [3,5,1,7]
		return null;
	}

	public int[] obtener_subtotales_por_grupo(int[] lista, int[] grupos) {
		// Dada lista de elementos y una lista de grupos,
		// devuelve una lista con los subtotales por grupo
		// Para lista ejemplo, debería devolver [5,3,3,2]
		return null;
	}
	


}

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
				int[] lista_grupos = obtener_grupos(elementos);
				int[] lista_apariciones = obtener_subtotales_por_grupo(elementos, lista_grupos);
				int cant=0;
				for(int i = 0; i<lista_apariciones.length; i++) {
					cant+=Math.round(fraccion*lista_apariciones[i]);
				}


				
				
			
				//int cant = (int) (elementos.length * fraccion);
//				int[][] lista_dividida = new int[2][];
				int[] lista0= new int[cant];
				int[] lista0_elem = new int[cant];
				int[] lista1= new int[elementos.length - cant];
				int[] lista1_elem= new int[elementos.length - cant];
				for(int i = 0; i<lista0.length;i++) {
					lista0[i]=-1;
					lista0_elem[i]=-1;
				}
				for(int i = 0; i<lista1.length;i++) {
					lista1[i]=-1;
					lista1_elem[i]=-1;
				}
				
				
				for(int i = 0; i< elementos.length; i++) {
					for(int j = 0; j<lista_grupos.length; j++) {
						if(elementos[i]==lista_grupos[j]) {
							int num_apariciones_elementos = lista_apariciones[j];
							int cant_colocar_en_0= Math.round(fraccion*num_apariciones_elementos); 
							int num_apariciones_lista0 = contar_apariciones(elementos[i],lista0_elem);
							if(num_apariciones_lista0<cant_colocar_en_0) {
								int k =0;
								while(lista0[k]!=-1) {
									k++;	
								}
								lista0[k]=i;
								lista0_elem[k]=elementos[i];
								
								
							}else { //if(num_apariciones_lista1<cant_colocar_en_1) {
								int k =0;
								while(lista1[k]!=-1) {
									k++;
								}
								lista1[k]=i;
								lista1_elem[k]=elementos[i];
							}
						
						}
					}
				}
				
//				for(int i = 0; i< elementos.length; i++) {
//					int num_apariciones_elementos = contar_apariciones(elementos[i],elementos);
//					int cant_colocar_en_0= Math.round(fraccion*num_apariciones_elementos); 
//					//int cant_colocar_en_1 = num_apariciones_elementos - cant_colocar_en_0;
//					int num_apariciones_lista0 = contar_apariciones(elementos[i],lista0_elem);
//					//int num_apariciones_lista1 = contar_apariciones(elementos[i],lista1_elem);
//					if(num_apariciones_lista0<cant_colocar_en_0) {
//						int j =0;
//						while(lista0[j]!=-1) {
//							j++;	
//						}
//						lista0[j]=i;
//						lista0_elem[j]=elementos[i];
//						
//						
//					}else { //if(num_apariciones_lista1<cant_colocar_en_1) {
//						int j =0;
//						while(lista1[j]!=-1) {
//							j++;
//						}
//						lista1[j]=i;
//						lista1_elem[j]=elementos[i];
//					}
//				}
				

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
		ArrayList<Integer> g = new ArrayList<>();
		for(int i = 0; i<lista.length ; i++) {
			if(!g.contains(lista[i])) {
				g.add(lista[i]);
			}
		}
		int[] grupos = new int[g.size()];
		for(int i = 0; i<g.size();i++)
			grupos[i] = g.get(i);
			
		return grupos;
	}

	public int[] obtener_subtotales_por_grupo(int[] lista, int[] grupos) {
		// Dada lista de elementos y una lista de grupos,
		// devuelve una lista con los subtotales por grupo
		// Para lista ejemplo, debería devolver [5,3,3,2]
		int[] subtotales = new int[grupos.length];
		for(int i = 0; i<grupos.length;i++) {
			subtotales[i] = contar_apariciones(grupos[i],lista);
		}
		
		return subtotales;
	}
	


}

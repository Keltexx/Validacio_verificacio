package test;

import practica1.GestorGrupos;

public class GestorGruposStub extends GestorGrupos {
	public int[] grupos; 
	
	@Override
	public int[] obtener_grupos(int[] elementos) {
		return this.grupos;
	}
}

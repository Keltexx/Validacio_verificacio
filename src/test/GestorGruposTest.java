package test;

import excepciones.MiExcepcion;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import practica1.GestorGrupos;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class GestorGruposTest {
    private int[] elementos;
    private float fraccion;
    private int[][] solucion;
    private static GestorGrupos gestor;
    private static GestorGruposStub gestorGrupos; 
    private int[] dependencia;

    public GestorGruposTest (int[] elementos, float fraccion, int[][] solucion, int[] dependencias) {
        this.elementos = elementos;
        this.fraccion = fraccion;
        this.solucion = solucion;
        this.dependencia = dependencias;
    }

    @BeforeClass
    public static void iniciarGestor() {
        gestor = new GestorGrupos();
        gestorGrupos = new GestorGruposStub();        
    }

    @AfterClass
    public static void eliminarGestor() {
        gestor = null;
        gestorGrupos = null;
    }

    @Parameters
    public static Collection <Object[]> datos() {
        return Arrays.asList(new Object[][]{
                {new int[]{1}, 0.6f, new int[][]{{0},{}},new int[]{1}},
                {new int[]{1,2,3,3,2,1}, 0f, new int[][]{{},{0,1,2,3,4,5}},new int[]{1,2,3}},
                {new int[]{1,2,3,3,2,1}, 0.6f, new int[][]{{0,1,2},{3,4,5}},new int[]{1,2,3}},
                {new int[]{1,1,1,1,1,1}, 0.3f, new int[][]{{0,1},{2,3,4,5}}, new int[] {1}},
                {new int[]{1,2,3,4,5,6}, 0.6f, new int[][]{{0,1,2,3,4,5},{}},new int[]{1,2,3,4,5,6}},
                {new int[]{3,5,5,1,1,7,1,7,5,3,3,3,3}, 0.67f, new int[][]{{0,1,2,3,4,5,9,10},{6,7,8,11,12}},new int[]{3,5,1,7}}
        });

    }

    @Test
    public void dividir_lista() throws MiExcepcion{
    	gestorGrupos.grupos = dependencia;
    	assertArrayEquals(this.solucion, gestor.dividir_lista(this.elementos, this.fraccion));
    }

    /*
    @Test
    public void obtener_grupos() {
    }

    @Test
    public void obtener_subtotales_por_grupo() {
    }

     */
}
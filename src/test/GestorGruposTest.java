package test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class GestorGruposTest {
    private int[] elementos;
    private float fraccion;
    private int [][] solucion;

    @Parameters
    public static List<Object[]> datos() {
        return Arrays.asList(new Object[][]{{3,3,5,7,7,5,3,3,5,7}, {3,3,5,7,7,5,3,3,5,7}});
    }

    @Test
    public void dividir_lista() {
    }

    @Test
    public void obtener_grupos() {
    }

    @Test
    public void obtener_subtotales_por_grupo() {
    }
}
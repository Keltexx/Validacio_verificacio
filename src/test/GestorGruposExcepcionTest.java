package test;

import excepciones.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import practica1.GestorGrupos;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class GestorGruposExcepcionTest {
    private int[] elementos;
    private float fraccion;
    private MiExcepcion excepcion;
    private static GestorGrupos gestor;

    public GestorGruposExcepcionTest (int[] elementos, float fraccion, MiExcepcion excepcion) {
        this.elementos = elementos;
        this.fraccion = fraccion;
        this.excepcion = excepcion;
    }

    @BeforeClass
    public static void iniciarGestor() {
        gestor = new GestorGrupos();
    }

    @AfterClass
    public static void eliminarGestor() {
        gestor = null;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> datos() {
        return Arrays.asList(new Object[][]{
                {null, 0.3f, new NullListException()},
                {new int[]{}, 1f, new EmptyListException()},
                {new int[]{1,2,3,3,2,1}, 50f,new LowerFractionException()},
                {new int[]{1,2,3,3,2,1}, -3f, new UpperFractionException()},
        });

    }

    @Test(expected= MiExcepcion.class)
    public void testSomeMethodWithExpected() throws MiExcepcion {
        gestor.dividir_lista(this.elementos, this.fraccion);
    }


}

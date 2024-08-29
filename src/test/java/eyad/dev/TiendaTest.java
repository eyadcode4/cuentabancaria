package eyad.dev;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.ArrayList;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TiendaTest {


      private Tienda tienda;
    private Computador computador1;
    private Computador computador2;
    private Computador computador3;


    @BeforeEach
    public void setUp() {
        tienda = new Tienda("Banana", "jose", "123");
        computador1 = new Computador("Apple", 16, "i7", "Os10", 1900.00);
        computador2 = new Computador("HP", 16, "Intel i7", "Windows 10", 1000.00);
        computador3 = new Computador("Lenovo", 16, "i7", "Window 11", 1800.00);
    }


    @Test
    public void testAgregarComputador() {
        tienda.agregarUnComputador(computador1);
        Computador encontrado = tienda.buscarUnComputador("Apple");
        assertNotNull(encontrado);
        assertEquals("Apple", encontrado.getMarca());
    }


    @Test
    public void testEliminarUnComputadorExistente() {
        tienda.agregarUnComputador(computador1);
        tienda.agregarUnComputador(computador2);
       
        tienda.eliminarUnComputador("HP");
       
        Computador encontrado = tienda.buscarUnComputador("Hp");
        assertNull(encontrado);
    }


    @Test
    public void testEliminarUnComputadorInexistente() {
        tienda.agregarUnComputador(computador1);
       
        tienda.eliminarUnComputador("Lenovo");
       
        Computador encontrado = tienda.buscarUnComputador("Apple");
        assertNotNull(encontrado);
    }


    @Test
    public void testBuscarComputadorExistente() {
        tienda.agregarUnComputador(computador2);
        Computador encontrado = tienda.buscarUnComputador("HP");
        assertNotNull(encontrado);
        assertEquals("HP", encontrado.getMarca());
    }


    @Test
    public void testBuscarComputadorInexistente() {
        Computador encontrado = tienda.buscarUnComputador("Hawawi");
        assertNull(encontrado);
    }


    @Test
    public void testListarComputadores() {
        tienda.agregarUnComputador(computador1);
        tienda.agregarUnComputador(computador2);
        tienda.agregarUnComputador(computador3);


        ArrayList<Computador> esperado = new ArrayList<>();
        esperado.add(computador1);
        esperado.add(computador2);
        esperado.add(computador3);


        tienda.listarInfoTodosComputadores();


        for (Computador comp : esperado) {
            Computador encontrado = tienda.buscarUnComputador(comp.getMarca());
            assertNotNull(encontrado);
            assertEquals(comp.getMarca(), encontrado.getMarca());
        }
    }


    @Test
    public void testListarComputadoresVacio() {
        tienda.listarInfoTodosComputadores();
        assertTrue(tienda.buscarUnComputador("Apple") == null && tienda.buscarUnComputador("HP") == null);
    }
   
}

package eyad.dev;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ComputadorTest {


    @Test
    public void testConstructor() {
        Computador computador = new Computador("Apple", 16, "Intel i7", "Os 10", 2000);


        assertEquals("Apple", computador.getMarca());
        assertEquals(16, computador.getMemoria());
        assertEquals("Intel i7", computador.getcaracteristicasDelProcesador());
        assertEquals("Os 10", computador.getSistemaOperativo());
        assertEquals(2000.00, computador.getPrecio());
    }


    @Test
    public void testSettersAndGetters() {
        Computador computador = new Computador("acer", 16, "Intel i7", "Windows 10", 1250.00);


        computador.setMarca("HP");
        assertEquals("HP", computador.getMarca());


        computador.setMemoria(16);
        assertEquals(16, computador.getMemoria());


        computador.setcaracteristicasDelProcesador("Intel i7");
        assertEquals("Intel i7", computador.getcaracteristicasDelProcesador());


        computador.setSistemaOperativo("Windows 12");
        assertEquals("Windows 12", computador.getSistemaOperativo());


        computador.setPrecio(1250.00);
        assertEquals(1250.00, computador.getPrecio());
    }


    @Test
    public void testToString() {
        Computador computador = new Computador("Lenovo", 16, "i9", "Window12", 1900);


        String expected = "Marca: Lenovo, Memoria: 16 GB, Procesador: i9, Sistema Operativo: Window12, Precio: $1900.0";
        assertEquals(expected, computador.toString());
    }
   
}

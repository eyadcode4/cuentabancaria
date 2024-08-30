package eyad.dev;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void testConstructor() {
        Cuenta cuenta = new Cuenta(7000, 2);
        assertEquals(7000, cuenta.saldo, 0.0014);
        assertEquals(2, cuenta.tasaAnual, 0.001);
        assertEquals(0, cuenta.numeroDeConsignaciones);
        assertEquals(0, cuenta.numeroDeRetiros);
        assertEquals(0, cuenta.comisionMensual, 0.001);
    }

    @Test
    void testConsignar() {
        Cuenta cuenta = new Cuenta(7000, 2);
        cuenta.consignar(2000);
        assertEquals(9000, cuenta.saldo, 0.001);
        assertEquals(1, cuenta.numeroDeConsignaciones);
    }

    @Test
    void testConsignarMontoCeroONegativo() {
        Cuenta cuenta = new Cuenta(7000, 2);
        cuenta.consignar(0);
        assertEquals(7000, cuenta.saldo, 0.001);
        assertEquals(0, cuenta.numeroDeConsignaciones);

        cuenta.consignar(-500);
        assertEquals(7000, cuenta.saldo, 0.001);
        assertEquals(0, cuenta.numeroDeConsignaciones);
    }

    @Test
    void testRetirar() {
        Cuenta cuenta = new Cuenta(7000, 2);
        cuenta.retirar(1000);
        assertEquals(6000, cuenta.saldo, 0.001);
        assertEquals(1, cuenta.numeroDeRetiros);
    }

    @Test
    void testRetirarMontoMayorQueSaldo() {
        Cuenta cuenta = new Cuenta(7000, 2);
        cuenta.retirar(8000);
        assertEquals(7000, cuenta.saldo, 0.001);
        assertEquals(0, cuenta.numeroDeRetiros);
    }

    @Test
    void testCalcularInteresMensual() {
        Cuenta cuenta = new Cuenta(10000, 12);
        cuenta.calcularInteresMensual();
        assertEquals(10100, cuenta.saldo, 0.001);
    }

    @Test
    void testGenerarExtractoMensual() {
        Cuenta cuenta = new Cuenta(10000, 12);
        cuenta.generarExtractoMensual();
        assertEquals(10100, cuenta.saldo, 0.001);
        assertEquals(0, cuenta.comisionMensual, 0.001);
    }

    @Test
    void testImprimir() {
        Cuenta cuenta = new Cuenta(12000, 12);
        String resultado = cuenta.imprimir();
        assertTrue(resultado.contains("Saldo: 12000.0"));
        assertTrue(resultado.contains("Comisión Mensual: 0.0"));
        assertTrue(resultado.contains("Número de consignaciones: 0"));
        assertTrue(resultado.contains("Número de retiros: 0"));
    }
}
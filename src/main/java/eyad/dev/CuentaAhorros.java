package eyad.dev;

public class CuentaAhorros extends Cuenta {
    boolean activa;

    public CuentaAhorros(float saldo, float tasaAnual) {
        super(saldo, tasaAnual);
        this.activa = saldo >= 10000;
    }

    @Override
    public void consignar(float monto) {
        if (activa) {
            super.consignar(monto);
            verificarEstadoCuenta();
        }
    }

    @Override
    public void retirar(float monto) {
        if (activa) {
            super.retirar(monto);
            verificarEstadoCuenta();
        }
    }

    @Override
    public void generarExtractoMensual() {
        if (numeroDeRetiros > 4) {
            comisionMensual += (numeroDeRetiros - 4) * 1000;
        }
        super.generarExtractoMensual();
        verificarEstadoCuenta();
    }

    private void verificarEstadoCuenta() {
        activa = saldo >= 10000;
    }

    @Override
    public String imprimir() {
        return super.imprimir() + "\nActiva: " + activa;
    }
}
package eyad.dev;

public class Cuenta {
    protected float saldo;
    protected int numeroDeConsignaciones = 0;
    protected int numeroDeRetiros = 0;
    protected float tasaAnual;
    protected float comisionMensual = 0;

    public Cuenta(float saldo, float tasaAnual) {
        this.saldo = saldo;
        this.tasaAnual = tasaAnual;
    }

    public void consignar(float monto) {
        if (monto > 0) {
            saldo += monto;
            numeroDeConsignaciones++;
        }
    }

    public void retirar(float monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            numeroDeRetiros++;
        }
    }

    public void calcularInteresMensual() {
        float interesMensual = (saldo * (tasaAnual / 12)) / 100;
        saldo += interesMensual;
    }

    public void generarExtractoMensual() {
        saldo -= comisionMensual;
        calcularInteresMensual();
    }

    public String imprimir() {
        return "Saldo: " + saldo + "\nComisión Mensual: " + comisionMensual +
               "\nNúmero de consignaciones: " + numeroDeConsignaciones +
               "\nNúmero de retiros: " + numeroDeRetiros;
    }
}
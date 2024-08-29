package eyad.dev;

import java.util.ArrayList;

import java.util.Iterator;

public class Tienda {

    private String nombre;
    private String propietario;
    private String identificadorTributario;
    private ArrayList<Computador> computadores;

    public Tienda(String nombre, String propietario, String identificadorTributario) {
        this.nombre = nombre;
        this.propietario = propietario;
        this.identificadorTributario = identificadorTributario;
        this.computadores = new ArrayList<>();
    }

    public void agregarUnComputador(Computador computador) {
        computadores.add(computador);
        System.out.println("Agregado Computador: " + computador.getMarca()+" a la tienda");
    }

    public void eliminarUnComputador(String marca) {
        Iterator<Computador> iterator = computadores.iterator();
        while (iterator.hasNext()) {
            Computador computador = iterator.next();
            if (computador.getMarca().equalsIgnoreCase(marca)) {
                iterator.remove();
                System.out.println("Computador eliminado: " + marca);
                return;
            }
        }
        System.out.println("No se encuentra el computador con la marca " + marca );
    }

    public Computador buscarUnComputador(String marca) {
        for (Computador computador : computadores) {
            if (computador.getMarca().equalsIgnoreCase(marca)) {
                return computador;
            }
        }
        return null;
    }

    public void listarInfoTodosComputadores() {
        if (computadores.isEmpty()) {
            System.out.println("No hay ningun computador en la tienda.");
        } else {
            System.out.println("Lista de computadores en la tienda:");
            for (Computador computador : computadores) {
                System.out.println(computador);
            }
        }
    }

}
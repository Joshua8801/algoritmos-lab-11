package ejercicio3;

public class HashEncadenamiento {

    static int tamaño = 7;

    // Nodo de la lista enlazada
    static class Nodo {
        int clave;
        String nombre;
        Nodo siguiente;

        Nodo(int clave, String nombre) {
            this.clave = clave;
            this.nombre = nombre;
            this.siguiente = null;
        }
    }

    // Tabla hash (arreglo de nodos)
    static Nodo[] tabla = new Nodo[tamaño];

    public static void main(String[] args) {

        insertar(10, "Juan");
        insertar(17, "Ana");
        insertar(24, "Luis");
        insertar(31, "Rosa");
        insertar(5, "Pedro");
        insertar(12, "Carla");

        System.out.println("\nTABLA FINAL:");
        mostrar();

        buscar(24);

        eliminar(17);

        System.out.println("\nDESPUÉS DE ELIMINAR 17:");
        mostrar();
    }

    // FUNCIÓN HASH
    static int hash(int k) {
        return k % 7;
    }

    // INSERTAR (encadenamiento real)
    static void insertar(int clave, String nombre) {

        int h = hash(clave);

        Nodo nuevo = new Nodo(clave, nombre);

        if (tabla[h] == null) {
            tabla[h] = nuevo;
        } else {
            Nodo actual = tabla[h];

            // ir al final de la lista
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }

            actual.siguiente = nuevo;
        }
    }

    // BUSCAR
    static void buscar(int clave) {

        int h = hash(clave);

        Nodo actual = tabla[h];
        int nodo = 1;

        while (actual != null) {

            if (actual.clave == clave) {

                System.out.println("\nEncontrado:");
                System.out.println("Nombre: " + actual.nombre);
                System.out.println("Índice: " + h);
                System.out.println("Nodo en la lista: " + nodo);
                return;
            }

            actual = actual.siguiente;
            nodo++;
        }

        System.out.println("No encontrado");
    }

    // ELIMINAR
    static void eliminar(int clave) {

        int h = hash(clave);

        Nodo actual = tabla[h];
        Nodo anterior = null;

        while (actual != null) {

            if (actual.clave == clave) {

                if (anterior == null) {
                    tabla[h] = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }

                return;
            }

            anterior = actual;
            actual = actual.siguiente;
        }
    }

    // MOSTRAR TABLA
    static void mostrar() {

        for (int i = 0; i < tamaño; i++) {

            System.out.print(i + ": ");

            Nodo actual = tabla[i];

            while (actual != null) {
                System.out.print(actual.clave + "-" + actual.nombre + " -> ");
                actual = actual.siguiente;
            }

            System.out.println("null");
        }
    }
}
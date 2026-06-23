package ejercicio2;

public class HashSondeoComparacion {

    static int tamaño = 7;

    public static void main(String[] args) {

        int[] valores = {10, 17, 24, 31, 4};

        System.out.println("=== SONDEO LINEAL ===");
        sondeoLineal(valores);

        System.out.println("\n=== SONDEO CUADRÁTICO ===");
        sondeoCuadratico(valores);
    }

    // SONDEO LINEAL
    public static void sondeoLineal(int[] valores) {

        int[] tabla = inicializar();

        for (int x : valores) {

            int h = x % 7;
            int i = 0;

            while (tabla[(h + i) % 7] != -1) {
                i++;
            }

            tabla[(h + i) % 7] = x;

            System.out.println("Insertado: " + x);
            mostrar(tabla);
        }
    }

    // SONDEO CUADRÁTICO
    public static void sondeoCuadratico(int[] valores) {

        int[] tabla = inicializar();

        for (int x : valores) {

            int h = x % 7;
            int i = 0;

            while (tabla[(h + i * i) % 7] != -1) {
                i++;
            }

            tabla[(h + i * i) % 7] = x;

            System.out.println("Insertado: " + x);
            mostrar(tabla);
        }
    }

    // INICIALIZAR TABLA
    public static int[] inicializar() {

        int[] tabla = new int[tamaño];

        for (int i = 0; i < tamaño; i++) {
            tabla[i] = -1;
        }

        return tabla;
    }

    // MOSTRAR TABLA
    public static void mostrar(int[] tabla) {

        for (int i = 0; i < tamaño; i++) {
            System.out.print(tabla[i] + " ");
        }

        System.out.println();
    }
}
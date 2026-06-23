package ejercicio1;

public class TablaHash {

    public static void main(String[] args) {

        int tamaño = 11;

        int[] tabla = new int[tamaño];

        // Inicializar posiciones vacías con -1
        for(int i = 0; i < tamaño; i++){
            tabla[i] = -1;
        }

        int[] valores = {3,14,25,36,47,58};


        // Insertar valores
        for(int valor : valores){

            int indice = valor % 11;

            if(tabla[indice] == -1){

                tabla[indice] = valor;

            }else{

                System.out.println("Colisión en índice " 
                + indice + " para el valor " + valor);
            }
        }


        // Mostrar tabla
        System.out.println("\nTabla Hash:");

        for(int i = 0; i < tabla.length; i++){

            System.out.println("Índice " + i + " : " + tabla[i]);
        }
    }
}
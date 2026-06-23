package ejercicio5;

public class HashRehash {

    private int[] table;
    private int size;
    private int count;

    public HashRehash(int size) {

        this.size = size;
        this.count = 0;

        table = new int[size];

        for(int i = 0; i < size; i++) {
            table[i] = -1;
        }

    }

    private int hash(int key) {
        return key % size;
    }

    private double factorCarga() {
        return (double) count / size;
    }

    public void insert(int key) {


        int pos = hash(key);
        int i = 0;

        while(table[pos] != -1) {
            i++;
            pos = (hash(key) + i) % size;
        }

        table[pos] = key;
        count++;
        
        if(factorCarga() > 0.75) {
            System.out.println("Factor excedido: " + factorCarga());
            rehash(17);
        }

        System.out.println("Insertado " + key + " | α = " + factorCarga());
    }

    private void rehash(int newSize) {

        System.out.println("\n--- REHASHING ---");
        mostrar();

        int[] oldTable = table;

        table = new int[newSize];
        size = newSize;
        count = 0;

        for(int i = 0; i < size; i++) {
            table[i] = -1;
        }

        for(int x : oldTable) {
            if(x != -1) {
                insert(x);
            }
        }

        System.out.println("--- NUEVA TABLA ---");
        mostrar();
    }
    
    public void mostrar() {

        for(int i = 0; i < size; i++) {
            System.out.println(i + " -> " + table[i]);
        }

    }

}

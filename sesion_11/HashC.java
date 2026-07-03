package sesion_11;

public class HashC<T> {

    private static final int EMPTY = 0;
    private static final int OCCUPIED = 1;
    private static final int DELETED = -1;

    private static class Entry<E> {

        Register<E> register;
        int state;

        Entry() {
            register = null;
            state = EMPTY;
        }
    }
    
    private Entry<T>[] table;
    private int size;
    private int count;

    @SuppressWarnings("unchecked")
    public HashC(int size) {

        this.size = size;
        this.count = 0;

        table = (Entry<T>[]) new Entry[size];

        for (int i = 0; i < size; i++) {
            table[i] = new Entry<>();
        }
    }
    
    private int hash(int key) {
        return Math.abs(key) % size;
    }

    private double loadFactor() {
        return (double) count / size;
    }

    private int sondeoLineal(int key, int intento) {
        return (hash(key) + intento) % size;
    }

    private int sondeoCuadratico(int key, int intento) {
        return (hash(key) + intento * intento) % size;
    }

    public void insert(Register<T> reg) {

        if (search(reg.getKey()) != null) {
            System.out.println("La clave ya existe");
            return;
        }

        int intento = 0;

        while (intento < size) {

            int pos = sondeoLineal(reg.getKey(), intento);

            if (table[pos].state != OCCUPIED) {

                table[pos].register = reg;
                table[pos].state = OCCUPIED;
                count++;

                System.out.println("Insertado " + reg + " en posición " + pos);

                if (loadFactor() > 0.75) {
                    rehash();
                }

                return;
            }

            intento++;
        }

        System.out.println("Tabla llena");
    }

    public Register<T> search(int key) {

        int intento = 0;

        while (intento < size) {

            int pos = sondeoLineal(key, intento);

            if (table[pos].state == EMPTY) {
                return null;
            }

            if (table[pos].state == OCCUPIED &&
                table[pos].register.getKey() == key) {

                return table[pos].register;
            }

            intento++;
        }

        return null;
    }

    public void delete(int key) {

        int intento = 0;

        while (intento < size) {

            int pos = sondeoLineal(key, intento);

            if (table[pos].state == EMPTY) {
                break;
            }

            if (table[pos].state == OCCUPIED &&
                table[pos].register.getKey() == key) {

                table[pos].state = DELETED;
                table[pos].register = null;
                count--;

                System.out.println("Clave eliminada: " + key);
                return;
            }

            intento++;
        }

        System.out.println("Clave no encontrada");
    }

    private void rehash() {

        System.out.println("\n--- REHASHING ---");

        Entry[] tablaAnterior = table;

        size = size * 2 + 1;

        table = new Entry[size];

        for (int i = 0; i < size; i++) {
            table[i] = new Entry();
        }

        count = 0;

        for (Entry entry : tablaAnterior) {
            if (entry.state == OCCUPIED) {
                insert(entry.register);
            }
        }
    }

    public void printTable() {

        System.out.println("\n===== HASH CERRADO =====");

        for (int i = 0; i < size; i++) {

            System.out.print(i + " -> ");

            if (table[i].state == EMPTY) {
                System.out.println("0 (EMPTY)");
            } else if (table[i].state == DELETED) {
                System.out.println("-1 (DELETED)");
            } else {
                System.out.println("1 (OCCUPIED) " + table[i].register);
            }
        }
    }
}
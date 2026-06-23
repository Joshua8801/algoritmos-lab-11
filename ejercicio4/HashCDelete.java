package ejercicio4;

public class HashCDelete {

    private class Entry {

        int key;
        int state;

        public Entry() {
            state = EMPTY;
        }

        public Entry(int key) {
            this.key = key;
            this.state = OCCUPIED;
        }
    }

    // Estados de la celda
    private static final int EMPTY = 0;
    private static final int OCCUPIED = 1;
    private static final int DELETED = 2;

    private Entry[] table;
    private int size;

    public HashCDelete(int size) {

        this.size = size;
        table = new Entry[size];

        for(int i = 0; i < size; i++) {
            table[i] = new Entry();
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(int key) {

        int pos = hash(key);
        int start = pos;

        while(table[pos].state == OCCUPIED) {

            pos = (pos + 1) % size;

            if(pos == start) {
                System.out.println("Tabla llena");
                return;
            }
        }

        table[pos].key = key;
        table[pos].state = OCCUPIED;

        System.out.println("Insertado " + key +" en posición " + pos);
    }

    public boolean search(int key) {

        int pos = hash(key);
        int start = pos;

        while(table[pos].state != EMPTY) {
        	
            if(table[pos].state == OCCUPIED && table[pos].key == key) {
                return true;
            }

            // si es DELETED sigue buscando
            pos = (pos + 1) % size;

            if(pos == start)
                break;
        }
        return false;
    }

    public void delete(int key) {

        int pos = hash(key);
        int start = pos;

        while(table[pos].state != EMPTY) {

            if(table[pos].state == OCCUPIED && table[pos].key == key) {

                table[pos].state = DELETED;

                System.out.println( key + " eliminado");
                return;
            }

            pos = (pos + 1) % size;

            if(pos == start)
                break;
        }
        System.out.println( "No encontrado");
    }

    public void printTable() {

        for(int i = 0; i < size; i++) {

            System.out.print(i + " -> ");

            if(table[i].state == EMPTY) {
            	
                System.out.println("EMPTY");

            } else if(table[i].state == DELETED) {

                System.out.println("DELETED");

            } else {

                System.out.println(
                    table[i].key
                );
            }

        }

    }

}
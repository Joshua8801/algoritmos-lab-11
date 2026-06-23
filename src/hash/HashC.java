package hash;

public class HashC {

    private static class Element {
        Register register;
        boolean isAvailable;

        public Element() {
            this.register = null;
            this.isAvailable = true;
        }
    }

    private Element[] table;
    private int size;

    public HashC(int size) {
        this.size = size;
        this.table = new Element[size];

        for (int i = 0; i < size; i++) {
            table[i] = new Element();
        }
    }

    private int hash(int key) {
        return key % size;
    }

    public void insert(Register reg) {
        int index = hash(reg.getKey());
        int start = index;

        do {
            if (table[index].isAvailable) {
                table[index].register = reg;
                table[index].isAvailable = false;
                System.out.println("Insertado: " + reg + " en posición " + index);
                return;
            }

            index = (index + 1) % size;
        } while (index != start);

        System.out.println("Tabla llena. No se pudo insertar: " + reg);
    }

    public Register search(int key) {
        int index = hash(key);
        int start = index;

        do {
            if (!table[index].isAvailable && table[index].register.getKey() == key) {
                return table[index].register;
            }

            index = (index + 1) % size;
        } while (index != start);

        return null;
    }

    public void delete(int key) {
        int index = hash(key);
        int start = index;

        do {
            if (!table[index].isAvailable && table[index].register.getKey() == key) {
                table[index].register = null;
                table[index].isAvailable = true;
                System.out.println("Eliminado lógicamente: clave " + key);
                return;
            }

            index = (index + 1) % size;
        } while (index != start);

        System.out.println("No se encontró la clave: " + key);
    }

    public void printTable() {
        System.out.println("\nEstado de la tabla hash:");
        for (int i = 0; i < size; i++) {
            if (table[i].isAvailable) {
                System.out.println(i + " -> vacío");
            } else {
                System.out.println(i + " -> " + table[i].register);
            }
        }
    }
}
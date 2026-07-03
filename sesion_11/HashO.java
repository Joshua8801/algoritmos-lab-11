package sesion_11;

public class HashO<T> {

    private LinkedList<Register<T>>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashO(int size) {
        this.size = size;
        table = new LinkedList[size];

        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) {
        return Math.abs(key) % size;
    }

    public void insert(Register<T> reg) {
        int pos = hash(reg.getKey());
        table[pos].add(reg);

        System.out.println("Insertado " + reg + " en lista " + pos);
    }

    public Register<T> search(int key) {
        int pos = hash(key);

        Node<Register<T>> aux = table[pos].getHead();

        while (aux != null) {
            if (aux.getData().getKey() == key) {
                return aux.getData();
            }

            aux = aux.getNext();
        }

        return null;
    }

    public void delete(int key) {
        int pos = hash(key);

        Node<Register<T>> aux = table[pos].getHead();

        while (aux != null) {
            if (aux.getData().getKey() == key) {
                table[pos].remove(aux.getData());

                System.out.println("Eliminado: " + aux.getData());

                return;
            }

            aux = aux.getNext();
        }

        System.out.println("Clave no encontrada");
    }

    public void printTable() {
        System.out.println("\n===== HASH ABIERTO =====");

        for (int i = 0; i < size; i++) {
            System.out.print(i + " -> ");

            Node<Register<T>> aux = table[i].getHead();

            while (aux != null) {
                System.out.print(aux.getData() + " -> ");
                aux = aux.getNext();
            }

            System.out.println("null");
        }
    }
}

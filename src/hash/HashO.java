package hash;

import java.util.LinkedList;

public class HashO {

    private LinkedList<Register>[] table;
    private int size;

    // crea una lista vacia en cada pósicion
    public HashO(int size) {
        this.size = size;
        this.table = new LinkedList[size];

        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    //calcula el indice
    private int hash(int key) {
        return key % size;
    }

    public void insert(Register reg) {
        int index = hash(reg.getKey());
        table[index].add(reg);

        System.out.println("Insertado: " + reg +
                " en la lista " + index);
    }

    public Register search(int key) {
        int index = hash(key);

        for (Register reg : table[index]) {
            if (reg.getKey() == key) {
                return reg;
            }
        }

        return null;
    }

    public void delete(int key) {
        int index = hash(key);

        for (Register reg : table[index]) {
            if (reg.getKey() == key) {
                table[index].remove(reg);
                System.out.println("Eliminado: " + reg);
                return;
            }
        }

        System.out.println("Clave no encontrada");
    }

    public void printTable() {
        System.out.println("\n===== TABLA HASH ABIERTA =====");

        for (int i = 0; i < size; i++) {
            System.out.print(i + " -> ");

            for (Register reg : table[i]) {
                System.out.print(reg + " -> ");
            }

            System.out.println("null");
        }
    }
}
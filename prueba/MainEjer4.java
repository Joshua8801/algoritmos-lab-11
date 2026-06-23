package prueba;

import ejercicio4.HashCDelete;

public class MainEjer4 {

    public static void main(String[] args) {

        HashCDelete hash = new HashCDelete(7);

        hash.insert(5);
        hash.insert(12);
        hash.insert(19);
        hash.insert(26);

        System.out.println("\nTABLA INICIAL");

        hash.printTable();

        System.out.println("\nELIMINAR 12");

        hash.delete(12);
        hash.printTable();

        System.out.println("\nBuscar 19: " + hash.search(19));

        System.out.println("\nINSERTAR 33");

        hash.insert(33);
        hash.printTable();

    }

}
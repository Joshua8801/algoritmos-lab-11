package hash;

public class TestHash {
    public static void main(String[] args) {
        HashC hash = new HashC(11); // tabla de tamaño 11

        hash.insert(new Register(34, "Ana"));
        hash.insert(new Register(3, "Luis"));
        hash.insert(new Register(7, "Carlos"));
        hash.insert(new Register(30, "Rosa"));
        hash.insert(new Register(11, "Pedro"));
        hash.insert(new Register(8, "Lucia"));
        hash.insert(new Register(7, "Maria"));
        hash.insert(new Register(23, "Juan"));
        hash.insert(new Register(41, "Sofia"));
        hash.insert(new Register(16, "Diego"));
        hash.insert(new Register(34, "Elena"));

        hash.printTable();

        System.out.println("\nBuscando clave 23:");
        Register encontrado = hash.search(23);
        System.out.println(encontrado != null ? encontrado : "No encontrado");

        System.out.println("\nEliminando clave 30:");
        hash.delete(30);

        hash.printTable();
    }
}
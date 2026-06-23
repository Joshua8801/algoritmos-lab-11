package hash;

public class TestHashO {

    public static void main(String[] args) {

        HashO hash = new HashO(7);

        hash.insert(new Register(10, "Juan"));
        hash.insert(new Register(17, "Ana"));
        hash.insert(new Register(24, "Luis"));
        hash.insert(new Register(31, "Rosa"));
        hash.insert(new Register(5, "Pedro"));
        hash.insert(new Register(12, "Carla"));

        hash.printTable();

        System.out.println("\nBuscando clave 24:");
        Register r = hash.search(24);

        if (r != null)
            System.out.println(r);
        else
            System.out.println("No encontrado");

        System.out.println("\nEliminando clave 17");
        hash.delete(17);

        hash.printTable();
    }
}
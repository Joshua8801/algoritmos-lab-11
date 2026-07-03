package sesion_11;

public class LinkedList<T> {

    private Node<T> head;

    public LinkedList() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void add(T data) {

        Node<T> nuevo = new Node<>(data);

        if (head == null) {
            head = nuevo;
            return;
        }

        Node<T> aux = head;

        while (aux.getNext() != null) {
            aux = aux.getNext();
        }

        aux.setNext(nuevo);
    }

    public boolean remove(T data) {

        if (head == null)
            return false;

        if (head.getData().equals(data)) {
            head = head.getNext();
            return true;
        }

        Node<T> anterior = head;
        Node<T> actual = head.getNext();

        while (actual != null) {

            if (actual.getData().equals(data)) {
                anterior.setNext(actual.getNext());
                return true;
            }

            anterior = actual;
            actual = actual.getNext();
        }

        return false;
    }

    public Node<T> getHead() {
        return head;
    }
}
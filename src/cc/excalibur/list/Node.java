package cc.excalibur.list;

public class Node<T> {
    public Node<T> prev;
    public T val;
    public Node<T> next;

    public Node(Node<T> prev, T val, Node<T> next) {
        this.prev = prev;
        this.val = val;
        this.next = next;
    }
}

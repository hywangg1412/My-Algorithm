public class Node {
    public int data;
    public Node next;

    public Node(int x, Node p) {
        data = x;
        next = p;
    }

    public Node(int x) {
        this(x, null);
    }
}

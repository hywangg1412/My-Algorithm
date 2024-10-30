public class Node {
    int data;
    Node next;
    Node prev;

    Node(int x, Node p, Node q) {
        this.data = x;
        this.next = p;
        this.prev = q;
    }
}
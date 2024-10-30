public class Main {
    public static void main(String[] args) {
        System.out.println("Circular Linked List:");
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.add(1);
        circularLinkedList.add(2);
        circularLinkedList.add(3);
        circularLinkedList.traverse();
        circularLinkedList.rotate();
        circularLinkedList.traverse();
        circularLinkedList.removeHead();
        circularLinkedList.traverse();
        circularLinkedList.removeTail();
        circularLinkedList.traverse();
    }
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Doubly Linked List:");
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addLast(5);
        doublyLinkedList.addLast(10);
        doublyLinkedList.addTop(2);
        doublyLinkedList.forwardTraverse();
        doublyLinkedList.reverseTraverse();
        doublyLinkedList.removeData(10);
        doublyLinkedList.forwardTraverse();
        doublyLinkedList.removeLast();
        doublyLinkedList.forwardTraverse();
        System.out.println("Size: " + doublyLinkedList.size());
    }
}

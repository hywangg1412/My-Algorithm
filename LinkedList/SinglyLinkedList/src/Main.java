public class Main {
    public static void main(String[] args) {
        System.out.println("Singly Linked List:");
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.add(10);
        singlyLinkedList.add(20);
        singlyLinkedList.add(30);
        singlyLinkedList.traverse();
        singlyLinkedList.removeHead();
        singlyLinkedList.traverse();
        singlyLinkedList.insertIndex(15, 2);
        singlyLinkedList.traverse();
        singlyLinkedList.removeIndex(2);
        singlyLinkedList.traverse();
    }
}

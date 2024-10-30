package Queue;

public class QueueLinkedList {
    protected Node head, tail;

    public QueueLinkedList() {
        head = tail = null;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return (head == null);
    }

    // Get the element at the front of the queue
    public Object front() throws Exception {
        if (isEmpty()) throw new Exception("Queue is empty!");
        return head.data;
    }

    // Remove and return the element at the front of the queue
    public Object dequeue() throws Exception {
        if (isEmpty()) throw new Exception("Queue is empty!");
        Object x = head.data;
        head = head.next;
        if (head == null) tail = null; // If queue becomes empty, update tail
        return x;
    }

    // Add an element to the end of the queue
    public void enqueue(Object x) {
        if (isEmpty()) {
            head = tail = new Node(x);
        } else {
            tail.next = new Node(x);
            tail = tail.next;
        }
    }

    // Get the number of elements in the queue
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Print the elements in the queue
    public void traverse() {
        Node current = head;
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Elements in queue: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println(); // New line after printing all elements
    }

    // Clear the queue
    public void clear() {
        head = tail = null;
    }

    // Peek the last element in the queue
    public Object peek() throws Exception {
        if (isEmpty()) throw new Exception("Queue is empty!");
        return tail.data; // Return the data of the tail node
    }

    // Rotate the queue by moving the front to the back
    public void rotate() {
        if (!isEmpty() && head != tail) {
            tail.next = head; // Connect tail to head
            tail = head; // Update tail to current head
            head = head.next; // Move head to the next node
            tail.next = null; // Set new tail's next to null
        }
    }

    // Node class for linked list
    protected class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }
}

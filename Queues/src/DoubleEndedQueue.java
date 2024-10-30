public class DoubleEndedQueue {
    protected Node head, tail;

    public DoubleEndedQueue() {
        head = tail = null;
    }

    // Check if the deque is empty
    public boolean isEmpty() {
        return (head == null);
    }

    // Add an element to the front of the deque
    public void enqueueFront(Object x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // Add an element to the rear of the deque
    public void enqueueRear(Object x) {
        Node newNode = new Node(x);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Remove and return the element from the front of the deque
    public Object dequeueFront() throws Exception {
        if (isEmpty()) throw new Exception("Deque is empty!");
        Object x = head.data;
        head = head.next;
        if (head == null) tail = null; // If deque becomes empty, update tail
        return x;
    }

    // Remove and return the element from the rear of the deque
    public Object dequeueRear() throws Exception {
        if (isEmpty()) throw new Exception("Deque is empty!");
        Object x = tail.data;
        if (head == tail) { // If only one element
            head = tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null; // Remove last node
            tail = current; // Update tail
        }
        return x;
    }

    // Get the number of elements in the deque
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Print the elements in the deque
    public void traverse() {
        Node current = head;
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return;
        }

        System.out.print("Elements in deque: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println(); // New line after printing all elements
    }

    // Clear the deque
    public void clear() {
        head = tail = null;
    }

    // Peek at the front element without removing it
    public Object peekFront() throws Exception {
        if (isEmpty()) throw new Exception("Deque is empty!");
        return head.data;
    }

    // Peek at the rear element without removing it
    public Object peekRear() throws Exception {
        if (isEmpty()) throw new Exception("Deque is empty!");
        return tail.data;
    }

    // Remove all occurrences of a specified element
    public void removeAll(Object x) {
        Node current = head;
        Node previous = null;
        while (current != null) {
            if (current.data.equals(x)) {
                if (previous == null) { // Element to remove is at head
                    head = current.next;
                    if (head == null) { // If deque becomes empty
                        tail = null;
                    }
                } else {
                    previous.next = current.next;
                    if (current == tail) { // If removing tail
                        tail = previous;
                    }
                }
            } else {
                previous = current; // Move previous to current
            }
            current = current.next; // Move to the next node
        }
    }

    // Check if the deque contains a specific element
    public boolean contains(Object x) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(x)) {
                return true;
            }
            current = current.next;
        }
        return false;
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

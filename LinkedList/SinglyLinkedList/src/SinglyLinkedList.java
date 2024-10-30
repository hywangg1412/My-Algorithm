public class SinglyLinkedList {
    Node head; // The head node of the list
    Node tail; // The tail node of the list

    // Constructor to initialize an empty list
    public SinglyLinkedList() {
        this.head = this.tail = null; // Both head and tail are null for an empty list
    }

    // Check if the list is empty
    boolean isEmpty() {
        return this.head == null; // Returns true if head is null
    }

    // Traverse the list and print each node's value
    void traverse() {
        Node p = this.head;
        int count = 0;

        while (p != null) {
            System.out.println(" -> " + p.data);
            p = p.next;
            count++;
        }
        System.out.println("Total: " + count);
    }

    // Add a new node with value x to the end of the list
    void add(int x) {
        Node q = new Node(x);
        if (this.isEmpty()) {
            this.head = this.tail = q;
        } else {
            this.tail.next = q;
            this.tail = q;
        }
    }

    // Add a new node with value x to the beginning of the list
    void addTop(int x) {
        Node q = new Node(x);
        if (this.isEmpty()) {
            this.head = this.tail = q;
        } else {
            q.next = this.head;
            this.head = q;
        }
    }

    // Insert a new node with value x at the specified index
    void insertIndex(int x, int index) {
        Node q = new Node(x);
        if (index < 1) {
            throw new IndexOutOfBoundsException("-> Invalid Number");
        } else if (index == 1) {
            addTop(x);
        } else {
            Node current = this.head;
            for (int count = 1; count < index - 1 && current != null; count++) {
                current = current.next;
            }
            if (current == null) {
                throw new IndexOutOfBoundsException("-> Index out of bounds");
            }
            q.next = current.next;
            current.next = q;
            if (q.next == null) {
                this.tail = q;
            }
        }
    }

    // Remove the head node from the list
    void removeHead() {
        if (this.isEmpty()) {
            System.out.println("-> Empty Already");
        } else {
            this.head = this.head.next;
            if (this.head == null) {
                this.tail = null;
            }
        }
    }

    // Remove the tail node from the list
    void removeTail() {
        if (this.isEmpty()) {
            System.out.println("-> Already Empty");
        } else if (this.head == this.tail) {
            this.head = this.tail = null;
        } else {
            Node current = this.head;
            while (current.next != this.tail) {
                current = current.next;
            }
            current.next = null;
            this.tail = current;
        }
    }

    // Remove the node at the specified index
    void removeIndex(int index) {
        if (index < 1) {
            throw new IndexOutOfBoundsException("-> Invalid Number");
        } else if (index == 1) {
            removeHead();
        } else {
            Node current = this.head;

            for (int count = 1; count < index - 1 && current != null; count++) {
                current = current.next;
            }
            if (current == null || current.next == null) {
                throw new IndexOutOfBoundsException("-> Index out of bounds");
            }
            current.next = current.next.next;
            if (current.next == null) {
                this.tail = current;
            }
        }
    }
}

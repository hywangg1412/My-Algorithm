public class CircularLinkedList {
    Node head;
    Node tail;

    public CircularLinkedList() {
        this.head = this.tail = null;
    }

    // Check if the list is empty
    boolean isEmpty() {
        return this.head == null;
    }

    // Traverse the list and print each node's value
    void traverse() {
        if (this.isEmpty()) {
            System.out.println("List is empty");
        } else {
            Node q = this.head;
            int count = 0;

            do {
                System.out.print(" -> " + q.data);
                q = q.next;
                ++count;
            } while (q != this.head);

            System.out.println();
            System.out.println("Total: " + count);
        }
    }

    // Add a new node with value x to the end of the list
    void add(int x) {
        Node q = new Node(x, null);
        if (this.isEmpty()) {
            this.head = this.tail = q;
            this.tail.next = this.head;
        } else {
            this.tail.next = q;
            this.tail = q;
            this.tail.next = this.head;
        }
    }

    // Rotate the head of the list to the next node
    void rotate() {
        if (this.isEmpty()) {
            System.out.println("-> Already Empty");
        } else {
            this.head = this.head.next;
        }
    }

    // Remove the head node from the list
    void removeHead() {
        if (this.isEmpty()) {
            System.out.println("-> Already Empty");
        } else if (this.head == this.tail) {
            this.head = this.tail = null;
        } else {
            this.head = this.head.next;
            this.tail.next = this.head;
        }
    }

    // Remove the tail node from the list
    void removeTail() {
        if (this.isEmpty()) {
            System.out.println("-> Already Empty");
        } else if (this.head == this.tail) {
            this.head = this.tail = null;
        } else {
            Node current;
            for (current = this.head; current.next != this.tail; current = current.next) {
            }

            current.next = this.head;
            this.tail = current;
        }
    }

    // Remove a specific node by value x
    void removeByValue(int x) {
        if (this.isEmpty()) {
            System.out.println("-> Already Empty");
            return;
        }

        Node current = this.head;
        Node previous = null;

        do {
            if (current.data == x) {
                if (previous != null) {
                    previous.next = current.next;
                    if (current == this.tail) {
                        this.tail = previous;
                    }
                } else {
                    removeHead(); // If it's the head node
                }
                return;
            }
            previous = current;
            current = current.next;
        } while (current != this.head);

        System.out.println("-> Value not found");
    }

    // Clear the entire list
    void clear() {
        this.head = null;
        this.tail = null;
    }

    // Get the size of the list
    int size() {
        if (isEmpty()) {
            return 0;
        }

        int count = 0;
        Node current = this.head;

        do {
            count++;
            current = current.next;
        } while (current != this.head);

        return count;
    }
}

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    int count = 0;

    public DoublyLinkedList() {
        this.head = this.tail = null;
    }

    // Check if the list is empty
    boolean isEmpty() {
        return this.head == null;
    }

    // Clear all elements in the list
    void clear() {
        this.head = this.tail = null;
        this.count = 0;
    }

    // Traverse the list from head to tail and print values
    void forwardTraverse() {
        for(Node p = this.head; p != null; p = p.next) {
            System.out.print(" -> " + p.data);
        }
        System.out.println();
    }

    // Traverse the list from tail to head and print values
    void reverseTraverse() {
        for(Node p = this.tail; p != null; p = p.prev) {
            System.out.print(" -> " + p.data);
        }
        System.out.println();
    }

    // Add a value to the end of the list
    void addLast(int x) {
        if (this.isEmpty()) {
            this.head = this.tail = new Node(x, null, null);
        } else {
            Node newNode = new Node(x, null, this.tail);
            this.tail.next = newNode;
            this.tail = newNode;
        }
        ++this.count;
    }

    // Add a value to the front of the list
    void addTop(int x) {
        if (this.isEmpty()) {
            this.head = this.tail = new Node(x, null, null);
        } else {
            Node newNode = new Node(x, this.head, null);
            this.head.prev = newNode;
            this.head = newNode;
        }
        ++this.count;
    }

    // Remove the first element from the list
    void removeFirst() {
        if (this.isEmpty()) {
            System.out.println("-> Already Empty");
        } else if (this.head == this.tail) {
            this.head = this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
            --this.count;
        }
    }

    // Remove the last element from the list
    void removeLast() {
        if (this.isEmpty()) {
            System.out.println("-> Already Empty");
        } else if (this.head == this.tail) {
            this.head = this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
            --this.count;
        }
    }

    // Remove all data from the list
    void removeAllData() {
        if (this.isEmpty()) {
            System.out.println("-> Already Empty");
        } else {
            this.head = null;
            this.tail = null;
            this.count = 0;
        }
    }

    // Remove a specific value from the list
    void removeData(int x) {
        if (this.isEmpty()) {
            System.out.println("-> Already Empty");
        } else {
            for(Node current = this.head; current != null; current = current.next) {
                if (current.data == x) {
                    if (current == this.head) {
                        this.head = this.head.next;
                        if (this.head != null) {
                            this.head.prev = null;
                        }
                    } else if (current == this.tail) {
                        this.tail = this.tail.prev;
                        if (this.tail != null) {
                            this.tail.next = null;
                        }
                    } else {
                        current.prev.next = current.next;
                        current.next.prev = current.prev;
                    }
                    --this.count;
                    break;
                }
            }
        }
    }

    // Sort the data in the list
    void sortData() {
        Node next;
        if (this.isEmpty()) {
            System.out.println("-> List Empty");
        } else {
            for(Node current = this.head; current != null && current.next != null; current = next) {
                next = current.next;
                if (current.data > next.data) {
                    int temp = current.data;
                    current.data = next.data;
                    next.data = temp;
                }
            }
        }
    }

    // Return the size of the list
    int size() {
        return this.count;
    }

    // Clone the current list
    public DoublyLinkedList clone() {
        DoublyLinkedList cloneList = new DoublyLinkedList();
        if (this.isEmpty()) {
            System.out.println("-> Nothing To Clone !!! ");
            return cloneList;
        } else {
            Node current = this.head;
            Node prevNode = null;
            for(; current != null; current = current.next) {
                Node newNode = new Node(current.data, null, prevNode);
                if (prevNode != null) {
                    prevNode.next = newNode;
                } else {
                    cloneList.head = newNode;
                }
                prevNode = newNode;
            }
            cloneList.tail = prevNode;
            return cloneList;
        }
    }

    // Check if two lists are equal
    public boolean equal(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof DoublyLinkedList)) {
            return false;
        } else {
            DoublyLinkedList otherList = (DoublyLinkedList)obj;
            Node current1 = this.head;
            Node current2 = otherList.head;
            while(current1 != null && current2 != null) {
                if (current1.data != current2.data) {
                    return false;
                }
                current1 = current1.next;
                current2 = current2.next;
            }
            return current1 == null && current2 == null;
        }
    }

    // Check if the list contains a specific value
    boolean contains(int x) {
        Node current = head;
        while (current != null) {
            if (current.data == x) {
                return true; // Value found
            }
            current = current.next;
        }
        return false; // Value not found
    }

    // Find the position of a specific value in the list and return the position (1-based index)
    int find(int x) {
        Node current = head;
        int index = 1; // Start from index 1
        while (current != null) {
            if (current.data == x) {
                return index; // Return position
            }
            current = current.next;
            index++;
        }
        return -1; // Value not found
    }

    // Remove all occurrences of a specific value
    void removeAllOccurrences(int x) {
        if (this.isEmpty()) {
            System.out.println("-> Already Empty");
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.data == x) {
                Node toRemove = current;
                if (current == head) {
                    removeFirst();
                    current = head; // Reset current after removing head
                } else if (current == tail) {
                    removeLast();
                    current = null; // End the loop after removing tail
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    current = current.next; // Move to the next node
                }
                --this.count;
            } else {
                current = current.next; // Move to the next node
            }
        }
    }
}

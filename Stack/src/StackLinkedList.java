import java.util.EmptyStackException;

public class StackLinkedList {
    protected Node head; // The top node of the stack
    int count = 0; // Count of elements in the stack

    public StackLinkedList() {
        head = null; // Initialize the stack as empty
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return (head == null);
    }

    // Add an element to the top of the stack
    public void push(int x) {
        head = new Node(x, head); // Create a new node pointing to the current head
        count++; // Increment the count
    }

    // Get the top element of the stack
    public int top() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Throw exception if the stack is empty
        }
        return head.data; // Return the data of the head node
    }

    // Remove and return the top element of the stack
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException(); // Throw exception if the stack is empty
        }
        int x = head.data; // Store the top element
        head = head.next; // Move head to the next node
        count--; // Decrement the count
        return x; // Return the removed element
    }

    // Get the number of elements in the stack
    public int size() {
        return count; // Return the count
    }

    // Print all elements in the stack
    public void traverse() {
        Node q = head; // Start from the head
        if (isEmpty()) {
            System.out.println("-> Stack is empty."); // Print if empty
            return;
        }
        System.out.print("Elements in stack: ");
        while (q != null) {
            System.out.print(q.data + " "); // Print each element
            q = q.next; // Move to the next node
        }
        System.out.println(); // New line after printing
    }

    // Clear the stack
    public void clear() {
        head = null; // Set head to null to remove all elements
        count = 0; // Reset the count
    }

    // Check if the stack contains a specific element
    public boolean contains(int x) {
        Node current = head; // Start from the head
        while (current != null) {
            if (current.data == x) {
                return true; // Return true if found
            }
            current = current.next; // Move to the next node
        }
        return false; // Return false if not found
    }

    // Search for an element and return its position
    public int search(int x) {
        Node current = head; // Start from the head
        int position = 0; // Initialize position counter
        while (current != null) {
            if (current.data == x) {
                return position; // Return the position if found
            }
            current = current.next; // Move to the next node
            position++; // Increment position counter
        }
        return -1; // Return -1 if not found
    }

    // Reverse the stack
    public void reverse() {
        Node previous = null; // Initialize previous node
        Node current = head; // Start from the head
        while (current != null) {
            Node next = current.next; // Store next node
            current.next = previous; // Reverse the link
            previous = current; // Move previous forward
            current = next; // Move current forward
        }
        head = previous; // Set the new head to the last processed node
    }

    // Print elements in reverse order
    public void printReverse() {
        printReverse(head); // Call the helper method
        System.out.println(); // New line after printing
    }

    private void printReverse(Node node) {
        if (node == null) return; // Base case
        printReverse(node.next); // Recursive call
        System.out.print(node.data + " "); // Print after returning from recursion
    }

    // Node class representing each element in the stack
    private static class Node {
        int data; // Data of the node
        Node next; // Pointer to the next node

        public Node(int x, Node p) {
            data = x; // Set the data
            next = p; // Set the next node
        }

        public Node(int x) {
            this(x, null); // Call the other constructor
        }
    }
}

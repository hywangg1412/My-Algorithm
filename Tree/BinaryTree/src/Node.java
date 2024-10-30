public class Node {
    int data;         // Value of the node
    Node left;       // Reference to the left child
    Node right;      // Reference to the right child

    // Constructor to create a new node with given data
    public Node(int data) {
        this.data = data;
        this.left = null;  // Left child is null by default
        this.right = null; // Right child is null by default
    }
}

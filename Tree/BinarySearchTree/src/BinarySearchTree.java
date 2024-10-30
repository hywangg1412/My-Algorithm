import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    // Insert a node
    public Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }
        if (value < node.data) {
            node.left = insert(node.left, value);
        } else if (value > node.data) {
            node.right = insert(node.right, value);
        }
        return node;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    // Find maximum value
    public int findMax(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("Tree is empty");
        }
        while (node.right != null) {
            node = node.right;
        }
        return node.data;
    }

    // Count nodes
    public int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public int countNodes() {
        return countNodes(root);
    }

    // Check if balanced
    public boolean isBalanced(Node node) {
        return height(node) != -1;
    }

    private int height(Node node) {
        if (node == null) return 0;
        int leftHeight = height(node.left);
        if (leftHeight == -1) return -1;
        int rightHeight = height(node.right);
        if (rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) return -1;
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Find lowest common ancestor (LCA)
    public Node findLCA(Node node, int n1, int n2) {
        if (node == null) return null;
        if (node.data > n1 && node.data > n2) return findLCA(node.left, n1, n2);
        if (node.data < n1 && node.data < n2) return findLCA(node.right, n1, n2);
        return node;
    }

    // Mirror the tree
    public void mirror(Node node) {
        if (node == null) return;
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        mirror(node.left);
        mirror(node.right);
    }

    public void mirror() {
        mirror(root);
    }

    // Pre-order traversal
    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    // Post-order traversal
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public void postOrder() {
        postOrder(root);
        System.out.println();
    }

    // Breadth-first (level-order) traversal
    public void breadthFirst() {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        System.out.println();
    }
}

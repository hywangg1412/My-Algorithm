import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
    Node root;

    public CompleteBinaryTree() {
        root = null;
    }

    // Insert Node in a Complete Binary Tree
    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.left == null) {
                current.left = newNode;
                return;
            } else {
                queue.add(current.left);
            }

            if (current.right == null) {
                current.right = newNode;
                return;
            } else {
                queue.add(current.right);
            }
        }
    }

    // Level Order Traversal
    public void levelOrderTraversal() {
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

    // In-Order Traversal (recursive)
    public void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    // Pre-Order Traversal (recursive)
    public void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // Post-Order Traversal (recursive)
    public void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    // Find Minimum Value (level-order)
    public int findMin() {
        if (root == null) return Integer.MAX_VALUE;

        int min = root.data;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            min = Math.min(min, current.data);

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return min;
    }

    // Find Maximum Value (level-order)
    public int findMax() {
        if (root == null) return Integer.MIN_VALUE;

        int max = root.data;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            max = Math.max(max, current.data);

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return max;
    }

    // Count the Number of Nodes
    public int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // Check if the Tree is Complete
    public boolean isComplete() {
        if (root == null) return true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean mustBeLeaf = false;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.left != null) {
                if (mustBeLeaf) return false;
                queue.add(current.left);
            } else {
                mustBeLeaf = true;
            }

            if (current.right != null) {
                if (mustBeLeaf) return false;
                queue.add(current.right);
            } else {
                mustBeLeaf = true;
            }
        }
        return true;
    }
}

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    // Insert method for a binary tree
    Node insert(Node current, int nodeValue) {
        if (current == null) {
            return new Node(nodeValue);
        }

        if (nodeValue < current.data) {
            current.left = insert(current.left, nodeValue);
        } else {
            current.right = insert(current.right, nodeValue);
        }
        return current;
    }

    // Wrapper method for insertion
    void insert(int nodeValue) {
        root = insert(root, nodeValue);
    }

    // Pre-order traversal
    void preOrderTraverse(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderTraverse(node.left);
            preOrderTraverse(node.right);
        }
    }

    void preOrder() {
        preOrderTraverse(root);
        System.out.println();
    }

    // In-order traversal
    void inOrderTraverse(Node node) {
        if (node != null) {
            inOrderTraverse(node.left);
            System.out.print(node.data + " ");
            inOrderTraverse(node.right);
        }
    }

    void inOrder() {
        inOrderTraverse(root);
        System.out.println();
    }

    // Post-order traversal
    void postOrderTraverse(Node node) {
        if (node != null) {
            postOrderTraverse(node.left);
            postOrderTraverse(node.right);
            System.out.print(node.data + " ");
        }
    }

    void postOrder() {
        postOrderTraverse(root);
        System.out.println();
    }

    // Breadth-first traversal (level-order)
    void breadthFirstTraverse() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        System.out.println();
    }

    // Search method
    boolean search(Node node, int key) {
        if (node == null) {
            return false;
        }
        if (key == node.data) {
            return true;
        }
        return key < node.data ? search(node.left, key) : search(node.right, key);
    }

    // Wrapper method for search
    boolean search(int key) {
        return search(root, key);
    }

    // Height of the tree
    int height(Node node) {
        if (node == null) {
            return -1; // Return -1 for height of an empty tree
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Wrapper method for height
    int height() {
        return height(root);
    }

    // Delete method
    Node delete(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    // Wrapper method for delete
    void delete(int key) {
        root = delete(root, key);
    }

    // Helper method to find the minimum value node
    int minValue(Node node) {
        int minValue = node.data;
        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }
        return minValue;
    }
}

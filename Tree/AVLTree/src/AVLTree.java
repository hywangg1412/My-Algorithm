public class AVLTree {
    Node root;

    // Node class for AVL Tree
    static class Node {
        int key;
        Node left, right;
        int height;

        public Node(int key) {
            this.key = key;
            this.height = 1; // New node is initially added at leaf
        }
    }

    // Insert a key in the AVL tree
    public void insert(int key) {
        root = insert(root, key);
    }

    private Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node; // Duplicates are not allowed
        }

        // Update height and balance the tree
        updateHeight(node);
        return balance(node);
    }

    // Delete a key from the AVL tree
    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node node, int key) {
        if (node == null) {
            return node; // Key not found
        }

        if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
            // Node with only one child or no child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Node with two children: get the inorder successor (smallest in the right subtree)
            node.key = minValueNode(node.right).key;
            node.right = delete(node.right, node.key);
        }

        // Update height and balance the tree
        updateHeight(node);
        return balance(node);
    }

    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private Node balance(Node node) {
        int balanceFactor = getBalance(node);

        // Left Left Case
        if (balanceFactor > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }

        // Left Right Case
        if (balanceFactor > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right Right Case
        if (balanceFactor < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }

        // Right Left Case
        if (balanceFactor < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node; // Already balanced
    }

    private Node rotateLeft(Node node) {
        Node newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;

        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    private Node rotateRight(Node node) {
        Node newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;

        updateHeight(node);
        updateHeight(newRoot);
        return newRoot;
    }

    private void updateHeight(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    // Inorder traversal of the AVL tree
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }

    // Check if the tree is an AVL tree
    public boolean isAVL() {
        return isAVLRec(root) != -1;
    }

    private int isAVLRec(Node node) {
        if (node == null) {
            return 0; // Base case: height of an empty node is 0
        }

        int leftHeight = isAVLRec(node.left);
        if (leftHeight == -1) return -1; // Left subtree is not AVL

        int rightHeight = isAVLRec(node.right);
        if (rightHeight == -1) return -1; // Right subtree is not AVL

        // Check balance factor
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Not balanced
        }

        return Math.max(leftHeight, rightHeight) + 1; // Return height of the subtree
    }
}

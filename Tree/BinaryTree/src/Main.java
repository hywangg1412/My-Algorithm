public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        // Insert nodes into the binary tree
        binaryTree.insert(5);
        binaryTree.insert(3);
        binaryTree.insert(8);
        binaryTree.insert(1);
        binaryTree.insert(4);
        binaryTree.insert(7);
        binaryTree.insert(9);

        // Display tree traversals
        System.out.print("Pre-order Traversal: ");
        binaryTree.preOrder();

        System.out.print("In-order Traversal: ");
        binaryTree.inOrder();

        System.out.print("Post-order Traversal: ");
        binaryTree.postOrder();

        System.out.print("Breadth-first (Level-order) Traversal: ");
        binaryTree.breadthFirstTraverse();

        // Search for nodes
        int searchKey = 4;
        System.out.println("Searching for " + searchKey + ": " + (binaryTree.search(searchKey) ? "Found" : "Not Found"));

        searchKey = 10;
        System.out.println("Searching for " + searchKey + ": " + (binaryTree.search(searchKey) ? "Found" : "Not Found"));

        // Calculate height of the tree
        System.out.println("Height of the tree: " + binaryTree.height());

        // Delete a node
        System.out.println("Deleting node with value 3");
        binaryTree.delete(3);
        System.out.print("In-order Traversal after deletion: ");
        binaryTree.inOrder();
    }
}

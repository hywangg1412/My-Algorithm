public class Main {
    public static void main(String[] args) {
        // Create an instance of CompleteBinaryTree
        CompleteBinaryTree tree = new CompleteBinaryTree();

        // Insert nodes into the tree
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(60);
        tree.insert(70);

        // Test Level Order Traversal
        System.out.println("Level Order Traversal:");
        tree.levelOrderTraversal();

        // Test In-Order Traversal
        System.out.println("In-Order Traversal:");
        tree.inOrder(tree.root);
        System.out.println();

        // Test Pre-Order Traversal
        System.out.println("Pre-Order Traversal:");
        tree.preOrder(tree.root);
        System.out.println();

        // Test Post-Order Traversal
        System.out.println("Post-Order Traversal:");
        tree.postOrder(tree.root);
        System.out.println();

        // Test Find Minimum Value
        System.out.println("Minimum value in the tree: " + tree.findMin());

        // Test Find Maximum Value
        System.out.println("Maximum value in the tree: " + tree.findMax());

        // Test Count Nodes
        System.out.println("Number of nodes in the tree: " + tree.countNodes(tree.root));

        // Test if the tree is Complete
        System.out.println("Is the tree complete? " + tree.isComplete());
    }
}

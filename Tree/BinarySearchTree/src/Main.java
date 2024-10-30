public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert nodes
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Traversals
        System.out.print("Pre-order: ");
        bst.preOrder();

        System.out.print("Post-order: ");
        bst.postOrder();

        System.out.print("Breadth-first: ");
        bst.breadthFirst();

        // Find maximum value
        System.out.println("Maximum value: " + bst.findMax(bst.root));

        // Count nodes
        System.out.println("Total nodes: " + bst.countNodes());

        // Check if balanced
        System.out.println("Is balanced: " + bst.isBalanced(bst.root));

        // Find LCA
        Node lca = bst.findLCA(bst.root, 20, 40);
        System.out.println("Lowest Common Ancestor of 20 and 40: " + (lca != null ? lca.data : "None"));

        // Mirror the tree
        bst.mirror();
        System.out.print("Pre-order after mirroring: ");
        bst.preOrder();
    }
}

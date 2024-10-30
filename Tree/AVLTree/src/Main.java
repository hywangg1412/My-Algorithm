public class Main {
    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        // Inserting keys into the AVL tree
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(40);
        avlTree.insert(50);
        avlTree.insert(25);

        // Printing the inorder traversal of the AVL tree
        System.out.println("Inorder traversal of the constructed AVL tree:");
        avlTree.inorder();
    }
}

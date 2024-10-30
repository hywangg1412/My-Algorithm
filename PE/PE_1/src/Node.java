public class Node {
    Pupil data;
    Node left,right;
    int level;

    public Node(Pupil data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.level = 0;
    }
}

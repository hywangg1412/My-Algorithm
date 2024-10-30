import java.util.Stack;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    void insert(Pupil data){
        root = insert(root,data,0);
    }

    public Node insert(Node root , Pupil data, int level) {
        if (root == null) {
            root = new Node(data);
            root.level = level;
            return root;
        }
        if (data.rollNo < root.data.rollNo) {
            root.left = insert(root.left, data, level + 1);
        } else if(data.rollNo > root.data.rollNo) {
            root.right  = insert(root.right,data,level+1);
        }
        return root;
    }

    void descreaseMarks(){
        int minMark = findMinMarks(root);
        descreaseMarksRec(root, minMark / 2.0);
    }

    int findMinMarks(Node root){
        if (root == null) return Integer.MAX_VALUE;
        int leftMin = findMinMarks(root.left);
        int rightMin = findMinMarks(root.right);
        return Math.min(root.data.mark, Math.min(leftMin, rightMin));
    }

    void descreaseMarksRec(Node root, double decrease){
        if (root == null) return;
        root.data.mark -= decrease;
        descreaseMarksRec(root.left,decrease);
        descreaseMarksRec(root.right, decrease);
    }

    boolean isAVL(){
        return isAVLRec(root) != -1;
    }

    int isAVLRec(Node root){
        if (root == null) return 0;
        int leftHeight = isAVLRec(root.left);
        int rightHeight = isAVLRec(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1){
            return -1;
        }
        return Math.max(leftHeight,rightHeight) + 1;
    }

    void preOrder(){
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node = stack.pop();
            System.out.println("RollNo: " + node.data.rollNo + ", Mark: " + node.data.mark);
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.right);
        }
    }

    void radixSort(Pupil[] arr){
        int maxMark = getMaxMark(arr);
        for (int exp = 1; maxMark / exp > 0; exp *= 10){
            countSort(arr,exp);
        }
    }

    int getMaxMark(Pupil[] arr){
        int max = arr[0].mark;
        for (Pupil pupil : arr){
            if (pupil.mark > max){
                max = pupil.mark;
            }
        }
        return max;
    }

    void countSort(Pupil[] arr, int exp){
        int n = arr.length;
        Pupil[] output = new Pupil[n];
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            count[(arr[i].mark / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++){
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i].mark / exp) % 10] - 1] = arr[i];
            count[(arr[i].mark / exp) % 10]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }
}



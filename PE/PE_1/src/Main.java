public class Main {
    public static void main(String[] args) {
        Pupil[] pupils = {
                new Pupil(5, 5), new Pupil(3, 3), new Pupil(2, 2), new Pupil(4, 44),
                new Pupil(7, 47), new Pupil(6, 100), new Pupil(8, 88), new Pupil(1, 11), new Pupil(9, 99)
        };
        BinarySearchTree bst = new BinarySearchTree();
        for(Pupil pupil : pupils){
            bst.insert(pupil);
        }

        bst.descreaseMarks();
        bst.preOrder();
        System.out.println("Is AVL: " + bst.isAVL());

        bst.radixSort(pupils);
        System.out.println("Sorted pupils by Mark: ");
        for (Pupil pupil : pupils){
            System.out.println("Rollno: " + pupil.rollNo + ", Mark: " + pupil.mark);
        }
    }
}
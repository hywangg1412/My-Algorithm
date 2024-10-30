public class Main {
    public static void main(String[] args) {
        // Create a stack using StackArrayList
        StackArrayList stackArrayList = new StackArrayList(10);

        // Push elements into StackArrayList
        System.out.println("Pushing elements into StackArrayList:");
        for (int i = 1; i <= 5; i++) {
            stackArrayList.push("Item " + i);
            System.out.println("Pushed: Item " + i);
        }

        // Traverse StackArrayList
        System.out.print("Elements in StackArrayList: ");
        stackArrayList.traverse();

        // Pop elements from StackArrayList
        System.out.println("Popping elements from StackArrayList:");
        while (!stackArrayList.isEmpty()) {
            System.out.println("Popped: " + stackArrayList.pop());
        }

        // Create a stack using StackLinkedList
        StackLinkedList stackLinkedList = new StackLinkedList();

        // Push elements into StackLinkedList
        System.out.println("Pushing elements into StackLinkedList:");
        for (int i = 1; i <= 5; i++) {
            stackLinkedList.push(Integer.parseInt("Item " + i));
            System.out.println("Pushed: Item " + i);
        }

        // Traverse StackLinkedList
        System.out.print("Elements in StackLinkedList: ");
        stackLinkedList.traverse();

        // Pop elements from StackLinkedList
        System.out.println("Popping elements from StackLinkedList:");
        while (!stackLinkedList.isEmpty()) {
            System.out.println("Popped: " + stackLinkedList.pop());
        }
    }
}

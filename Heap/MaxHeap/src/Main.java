public class Main {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);

        // Inserting elements into the max-heap
        maxHeap.insert(15);
        maxHeap.insert(20);
        maxHeap.insert(10);
        maxHeap.insert(30);
        maxHeap.insert(25);

        System.out.println("Heap elements:");
        maxHeap.printHeap(); // Print the heap

        // Remove the maximum element
        System.out.println("Removed max: " + maxHeap.removeMax());

        System.out.println("Heap after removal:");
        maxHeap.printHeap(); // Print the heap after removal
    }
}

public class Main {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);

        // Inserting elements into the min-heap
        minHeap.insert(15);
        minHeap.insert(20);
        minHeap.insert(10);
        minHeap.insert(30);
        minHeap.insert(5);

        System.out.println("Heap elements:");
        minHeap.printHeap(); // Print the heap

        // Remove the minimum element
        System.out.println("Removed min: " + minHeap.removeMin());

        System.out.println("Heap after removal:");
        minHeap.printHeap(); // Print the heap after removal
    }
}

public class PriorityQueue {
    private MaxHeap heap;

    public PriorityQueue(int maxSize) {
        heap = new MaxHeap(maxSize); // Initialize the heap
    }

    // Method to insert an element into the priority queue
    public void insert(int element) {
        heap.insert(element); // Use the heap's insert method
    }

    // Method to remove and return the highest priority element
    public int remove() {
        return heap.removeMax(); // Use the heap's remove method
    }

    // Method to check if the priority queue is empty
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // Method to get the current size of the priority queue
    public int size() {
        return heap.getSize();
    }

    // Method to peek at the highest priority element without removing it
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority Queue is empty");
        }
        return heap.heap[0]; // Return the root of the heap
    }

    // Method to print the elements in the priority queue
    public void printQueue() {
        heap.printHeap();
    }
}

public class MaxHeap {
    public int[] heap;
    public int size;
    public int maxSize;

    // Constructor to initialize the heap
    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[maxSize];
    }

    // Method to insert a new element into the heap
    public void insert(int element) {
        if (size == maxSize) {
            throw new IllegalStateException("Heap is full");
        }
        heap[size] = element; // Add the new element at the end
        size++;
        heapifyUp(size - 1); // Restore heap property
    }

    // Method to remove and return the maximum element from the heap
    public int removeMax() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int max = heap[0]; // The maximum element
        heap[0] = heap[size - 1]; // Replace the root with the last element
        size--;
        heapifyDown(0); // Restore heap property
        return max;
    }

    // Method to restore the heap property after insertion
    private void heapifyUp(int index) {
        int temp = heap[index];
        while (index > 0 && temp > heap[parent(index)]) {
            heap[index] = heap[parent(index)];
            index = parent(index);
        }
        heap[index] = temp;
    }

    // Method to restore the heap property after removal
    private void heapifyDown(int index) {
        int largerChildIndex;
        while (index < size / 2) { // While the node has at least one child
            largerChildIndex = leftChild(index);
            if (largerChildIndex + 1 < size && heap[largerChildIndex] < heap[largerChildIndex + 1]) {
                largerChildIndex++; // Use the right child if it's larger
            }
            if (heap[index] >= heap[largerChildIndex]) {
                break; // The heap property is restored
            }
            // Swap
            int temp = heap[index];
            heap[index] = heap[largerChildIndex];
            heap[largerChildIndex] = temp;
            index = largerChildIndex; // Move down the tree
        }
    }

    // Get the index of the parent node
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Get the index of the left child
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // Get the index of the right child
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // Method to get the current size of the heap
    public int getSize() {
        return size;
    }

    // Method to check if the heap is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to print the elements of the heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}

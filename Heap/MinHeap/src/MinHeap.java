public class MinHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    // Constructor to initialize the min-heap
    public MinHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[maxSize];
    }

    // Method to insert a new element into the min-heap
    public void insert(int element) {
        if (size == maxSize) {
            throw new IllegalStateException("Heap is full");
        }
        heap[size] = element; // Add the new element at the end
        size++;
        heapifyUp(size - 1); // Restore heap property
    }

    // Method to remove and return the minimum element from the min-heap
    public int removeMin() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int min = heap[0]; // The minimum element
        heap[0] = heap[size - 1]; // Replace the root with the last element
        size--;
        heapifyDown(0); // Restore heap property
        return min;
    }

    // Method to restore the heap property after insertion
    private void heapifyUp(int index) {
        int temp = heap[index];
        while (index > 0 && temp < heap[parent(index)]) {
            heap[index] = heap[parent(index)];
            index = parent(index);
        }
        heap[index] = temp;
    }

    // Method to restore the heap property after removal
    private void heapifyDown(int index) {
        int smallerChildIndex;
        while (index < size / 2) { // While the node has at least one child
            smallerChildIndex = leftChild(index);
            if (smallerChildIndex + 1 < size && heap[smallerChildIndex] > heap[smallerChildIndex + 1]) {
                smallerChildIndex++; // Use the right child if it's smaller
            }
            if (heap[index] <= heap[smallerChildIndex]) {
                break; // The heap property is restored
            }
            // Swap
            int temp = heap[index];
            heap[index] = heap[smallerChildIndex];
            heap[smallerChildIndex] = temp;
            index = smallerChildIndex; // Move down the tree
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

    // Method to get the current size of the min-heap
    public int getSize() {
        return size;
    }

    // Method to check if the min-heap is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to print the elements of the min-heap
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
}

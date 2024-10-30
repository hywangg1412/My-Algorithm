public class CircularQueue {
    private Object[] queue;
    private int front, rear, size, capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new Object[capacity];
        front = rear = size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void enqueue(Object item) {
        if (isFull()) {
            throw new RuntimeException("Queue is full!");
        }
        queue[rear] = item;
        rear = (rear + 1) % capacity; // Wrap around
        size++;
    }

    public Object dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        Object item = queue[front];
        front = (front + 1) % capacity; // Wrap around
        size--;
        return item;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        return queue[front];
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return capacity;
    }

    public void clear() {
        front = rear = size = 0;
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return queue[(front + index) % capacity];
    }

    public boolean contains(Object item) {
        for (int i = 0; i < size; i++) {
            if (queue[(front + i) % capacity].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = queue[(front + i) % capacity];
        }
        return array;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CircularQueue: ");
        for (int i = 0; i < size; i++) {
            sb.append(queue[(front + i) % capacity]).append(" ");
        }
        return sb.toString();
    }

    public void traverse() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Elements in queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }
}
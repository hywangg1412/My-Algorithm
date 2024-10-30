public class LinkedCircularQueue {
    private Node front;
    private Node rear;
    private int size;

    public LinkedCircularQueue() {
        front = rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = rear = newNode;
            rear.next = front; // Point rear to front to make it circular
        } else {
            rear.next = newNode;
            rear = newNode;
            rear.next = front; // Maintain circularity
        }
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        int item = front.data;
        if (front == rear) { // Only one element in the queue
            front = rear = null;
        } else {
            front = front.next;
            rear.next = front; // Maintain circularity
        }
        size--;
        return item;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        return front.data;
    }

    public void rotate() {
        if (!isEmpty()) {
            front = front.next; // Move front to the next node
            rear = rear.next;   // Maintain rear pointer to the new front
        }
    }

    public void traverse() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        Node current = front;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != front);
        System.out.println();
    }
}
public class QueueArrayList {
    protected Object[] a;
    protected int max;
    protected int first, last;

    public QueueArrayList() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public QueueArrayList(int max1) {
        max = max1;
        a = new Object[max];
        first = last = -1;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return (first == -1);
    }

    // Check if the queue is full
    public boolean isFull() {
        return ((first == 0 && last == max - 1) || (first == last + 1));
    }

    // Grow the array size when the queue is full
    private boolean grow() {
        int max1 = max + max / 2;
        @SuppressWarnings("unchecked")
        Object[] a1 = new Object[max1];
        if (a1 == null) return false;

        int j = 0;
        if (last >= first) {
            for (int i = first; i <= last; i++) {
                a1[j++] = a[i];
            }
        } else {
            for (int i = first; i < max; i++) {
                a1[j++] = a[i];
            }
            for (int i = 0; i <= last; i++) {
                a1[j++] = a[i];
            }
        }
        a = a1;
        first = 0;
        last = max - 1;
        max = max1;
        return true;
    }

    // Add an element to the end of the queue
    public void enqueue(Object x) {
        if (isFull() && !grow()) return;
        if (last == max - 1 || last == -1) {
            a[0] = x;
            last = 0;
            if (first == -1) first = 0;
        } else {
            a[++last] = x;
        }
    }

    // Get the element at the front of the queue
    public Object front() throws Exception {
        if (isEmpty()) throw new Exception("-> Empty Queue");
        return a[first];
    }

    // Remove and return the element at the front of the queue
    public Object dequeue() throws Exception {
        if (isEmpty()) throw new Exception("-> Empty Queue");
        Object x = a[first];
        if (first == last) {
            first = last = -1;
        } else if (first == max - 1) {
            first = 0;
        } else {
            first++;
        }
        return x;
    }

    // Get the number of elements in the queue
    public int size() {
        if (first == -1) return 0;
        if (first <= last) {
            return last - first + 1;
        } else {
            return max - first + last + 1;
        }
    }

    // Print the elements in the queue
    public void traverse() {
        if (isEmpty()) {
            System.out.println("-> Empty Queue");
        } else {
            int i = first;
            System.out.print("Elements in queue: ");
            while (true) {
                System.out.print(a[i] + " ");
                if (i == last) break;
                i = (i + 1) % max;
            }
            System.out.println();
        }
    }
}

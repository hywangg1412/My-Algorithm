import java.lang.reflect.Array;
import java.util.EmptyStackException;

public class StackArrayList {
    protected Object[] a;
    int top, max;

    @SuppressWarnings("unchecked")
    public StackArrayList() {
        this(50);
    }

    @SuppressWarnings("unchecked")
    public StackArrayList(int max1) {
        max = max1;
        a = new Object[max];
        top = -1;
    }

    protected boolean grow() {
        int max1 = max + max / 2;
        @SuppressWarnings("unchecked")
        Object[] a1 = new Object[max1];
        if (a1 == null) return false;
        System.arraycopy(a, 0, a1, 0, top + 1);
        a = a1;
        max = max1;
        return true;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == max - 1);
    }

    public void clear() {
        top = -1;
    }

    public void push(Object x) {
        if (isFull() && !grow()) return;
        a[++top] = x;
    }

    public Object top() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return a[top];
    }

    public Object pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        Object x = a[top];
        top--;
        return x;
    }

    public Object peek() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return a[top];
    }

    public Object[] toArray() {
        @SuppressWarnings("unchecked")
        Object[] arr = new Object[size()];
        System.arraycopy(a, 0, arr, 0, size());
        return arr;
    }

    public boolean contains(Object item) {
        for (int i = 0; i <= top; i++) {
            if (a[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    public int search(Object item) {
        for (int i = top; i >= 0; i--) {
            if (a[i].equals(item)) {
                return top - i + 1;
            }
        }
        return -1;
    }

    public void traverse() {
        for (int i = 0; i <= top; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public int size() {
        return top + 1;
    }
}

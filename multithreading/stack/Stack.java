package multithreading.stack;

public class Stack {
    private int[] arr;
    private int stackTop;
    Object lock;

    public Stack(int capacity) {
        arr = new int[capacity];
        stackTop = -1;
        lock = new Object();
    }

    public boolean push(int elemnt) {
        synchronized (lock) {
            if (isFull()) {
                return false;
            }
            ++stackTop;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            arr[stackTop] = elemnt;
            return true;
        }
    }

    public int pop() {
        synchronized (lock) {
            if (isEmpty()) {
                return Integer.MIN_VALUE;
            }
            int top = arr[stackTop];
            arr[stackTop] = Integer.MIN_VALUE;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            stackTop--;
            return top;
        }

    }

    public boolean isEmpty() {
        return stackTop < 0;
    }

    public boolean isFull() {
        return stackTop > arr.length - 1;
    }

}

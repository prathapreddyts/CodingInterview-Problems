package multithreading.stack;

public class PopThread implements Runnable {
    private Stack stack;

    public PopThread(Stack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < 10) {
            int poppedElement = stack.pop();
            if (poppedElement != Integer.MIN_VALUE) {
                System.out.println("Popped element: " + poppedElement);
                count++;
            }
        }
    }
}

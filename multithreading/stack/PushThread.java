package multithreading.stack;

public class PushThread implements Runnable {
    private Stack stack;

    public PushThread(Stack stack) {
        this.stack = stack;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < 10) {
            boolean pushed = stack.push(100);
            if (pushed) {
                System.out.println("Pushed: 100");
                count++;
            }
        }
    }
}

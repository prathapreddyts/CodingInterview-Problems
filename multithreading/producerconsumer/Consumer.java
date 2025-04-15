package multithreading.producerconsumer;

public class Consumer implements Runnable {
    private BlockingQueue queue;

    public Consumer(BlockingQueue q) {
        this.queue = q;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            int item = queue.remove();
            System.out.println("Consumed: " + item);
        }
    }
}

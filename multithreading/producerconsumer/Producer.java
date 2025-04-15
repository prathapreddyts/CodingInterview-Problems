package multithreading.producerconsumer;

public class Producer implements Runnable {
    private BlockingQueue queue;

    public Producer(BlockingQueue q) {
        this.queue = q;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            queue.add(i);
            System.out.println("Produced: " + i);
        }
    }
}

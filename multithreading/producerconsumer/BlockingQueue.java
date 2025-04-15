package multithreading.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    private Queue<Integer> queue;
    private int capacity;

    public BlockingQueue(int cap) {
        capacity = cap;
        queue = new LinkedList<>();
    }

    public void add(int item) {
        synchronized (queue) {
            while (queue.size() == capacity) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            queue.add(item);
            queue.notifyAll(); // notify consumers
        }
    }

    public int remove() {
        synchronized (queue) {
            while (queue.isEmpty()) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            int item = queue.poll();
            queue.notifyAll(); // notify producers
            return item;
        }
    }
}

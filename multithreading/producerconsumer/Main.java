package multithreading.producerconsumer;


public class Main {
    public static void main(String[] args) {
        BlockingQueue queue = new BlockingQueue(5); // capacity of 5

        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Processing complete.");
    }
}

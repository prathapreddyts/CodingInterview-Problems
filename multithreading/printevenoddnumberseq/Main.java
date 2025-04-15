package multithreading.printevenoddnumberseq;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Printer printer = new Printer();

        Thread evenThread = new Thread(new EvenThread(printer), "EvenThread");
        Thread oddThread = new Thread(new OddThread(printer), "OddThread");

        oddThread.start();
        evenThread.start();


        oddThread.join();
        evenThread.join();
    }
}


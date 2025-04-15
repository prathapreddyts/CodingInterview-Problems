package multithreading.printevenoddnumberseq;
public class OddThread implements Runnable {
    private final Printer printer;

    public OddThread(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i += 2) {
            try {
                printer.printOdd(i);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}


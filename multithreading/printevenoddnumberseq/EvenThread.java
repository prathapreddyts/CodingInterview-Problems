package multithreading.printevenoddnumberseq;

public class EvenThread implements Runnable {
    private final Printer printer;

    public EvenThread(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        for (int i = 2; i <= 10; i += 2) {
            try {
                printer.printEven(i);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}


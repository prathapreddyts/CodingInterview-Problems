package multithreading.printevenoddnumberseq;

class Printer {
    boolean isOddTurn = true;

    public synchronized void printOdd(int number) throws InterruptedException {
        while (!isOddTurn) {
            wait();
        }
        System.out.println("Odd: " + number);
        isOddTurn = false;
        notify();
    }

    public synchronized void printEven(int number) throws InterruptedException {
        while (isOddTurn) {
            wait();
        }
        System.out.println("Even: " + number);
        isOddTurn = true;
        notify();
    }
}


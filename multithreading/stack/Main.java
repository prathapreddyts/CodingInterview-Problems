package multithreading.stack;

public class Main {
    public static void main(String[] args) {
        Stack sharedStack = new Stack(5);

        Thread pushThread = new Thread(new PushThread(sharedStack));
        Thread popThread = new Thread(new PopThread(sharedStack));

        pushThread.start();
        popThread.start();
    }
}


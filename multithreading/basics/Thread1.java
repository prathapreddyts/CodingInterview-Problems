package multithreading.basics;

public class Thread1 extends Thread{
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("Running Thread1 "+i);
        }
    }
}

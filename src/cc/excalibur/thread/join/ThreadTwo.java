package cc.excalibur.thread.join;

public class ThreadTwo extends Thread{
    @Override
    public void run() {
        System.out.println("Thread - two run");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

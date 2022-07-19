package cc.excalibur.thread;

/**
 * @author Excalibur
 * @date 2022/4/25 14:31
 * @IDE IntelliJ IDEA
 */
public class SynchronizedDemo implements Runnable {
    @Override
    public void run() {
        synchronized (this){
            System.out.println("Lock");
        }
    }

}

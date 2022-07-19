package cc.excalibur.thread.join;

public class ThreadOne extends  Thread{
    @Override
    public void run() {
        System.out.println("thread -one run");
        ThreadTwo threadTwo=new ThreadTwo();
        threadTwo.start();
        try {
            threadTwo.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


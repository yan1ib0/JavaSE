package cc.excalibur.thread;

import java.util.concurrent.*;

public class TestThread {
    public static void main(String[] args) {
        //       WareHouse wareHouse=new WareHouse();
        //        Producer p=new Producer(wareHouse);
        //        p.setPriority(10);
        //        Consumer c1=new Consumer(wareHouse);
        //        Consumer c2=new Consumer(wareHouse);
        //
        //            p.start();
        //            c1.start();
        //            c2.start();
        //        ThreadOne threadOne=new ThreadOne();
        //        threadOne.start();
        //        Thread t=new Thread();

        Runnable runnable = () -> System.out.println("Hello World");
        //用线程池管理线程的执行
        ExecutorService exec = new ThreadPoolExecutor(
                2,
                4,
                3,
                TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        Future<?> future = exec.submit(runnable);
        //        try {
        //            Thread.sleep(100);
        //        } catch (InterruptedException e) {
        //            throw new RuntimeException(e);
        //        }
        System.out.println(future.isDone());
        exec.shutdown();

    }
}

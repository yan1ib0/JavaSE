package cc.excalibur.thread;

import cc.excalibur.thread.join.ThreadOne;
import cc.excalibur.thread.join.ThreadTwo;
import cc.excalibur.thread.model.Consumer;
import cc.excalibur.thread.model.Producer;
import cc.excalibur.thread.model.WareHouse;

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
        ThreadOne threadOne=new ThreadOne();
        threadOne.start();

    }
}

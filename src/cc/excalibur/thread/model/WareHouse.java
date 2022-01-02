package cc.excalibur.thread.model;

import java.util.ArrayList;

public class WareHouse {
    private ArrayList<String> list = new ArrayList<>();

    public synchronized void add() throws InterruptedException {
        if (list.size() < 20)
            list.add("a");
        else {
            this.notifyAll();
            this.wait();
        }
    }

    public synchronized void get() throws InterruptedException {
        if (list.size() > 0)
            list.remove(0);
        else {
            this.notifyAll();
            this.wait();
        }
    }

}

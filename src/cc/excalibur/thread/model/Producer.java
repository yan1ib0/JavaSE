package cc.excalibur.thread.model;

public class Producer extends Thread {
    private WareHouse wareHouse;

    public Producer(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }

    @Override
    public void run() {
        while (true) {
            try {
//            synchronized (wareHouse) {
                wareHouse.add();
//            }
                System.out.println("生产者存入了一件货物");
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

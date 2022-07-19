package cc.excalibur.thread.model;

public class Consumer extends Thread {
    private WareHouse wareHouse;

    public Consumer(WareHouse wareHouse) {
        this.wareHouse = wareHouse;
    }

    @Override
    public void run() {
        while (true) {
            try {
//            synchronized (wareHouse) {
                wareHouse.get();
//            }
                System.out.println("消费者取出了一件货物");

                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

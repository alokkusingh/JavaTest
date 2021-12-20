package alok.test.thread;

public class MyThread4 {

    public static void main(String[] args) throws InterruptedException {

        Object lock = new Object();
        MyData data = new MyData();

        Thread t1 = new Thread(new AProducer(lock, data));
        Thread t2 = new Thread(new Consumer(lock, data));

        t1.start();
        t2.start();

        t2.join();
    }
}

class AProducer implements Runnable {

    Object lock;
    MyData data;

    AProducer(Object lock, MyData data) {
        this.lock = lock;
        this.data = data;
    }

    public void run() {

        int i = 0;
        while (i < 10) {
            synchronized (lock) {
                System.out.println("Producing data: " + ++i);
                data.setData(i);
                lock.notify();

                try {
                    lock.wait();
                } catch (InterruptedException ie) {

                }
            }


        }

    }
}


class Consumer implements Runnable {

    Object lock;
    MyData data;

    Consumer(Object lock, MyData data) {
        this.lock = lock;
        this.data = data;
    }

    @Override
    public void run() {

        int i = 0;
        while (i < 10) {
            synchronized (lock) {
                System.out.println("Consumed data: " + data.getData());
                lock.notify();

                try {
                    lock.wait();
                } catch (InterruptedException ie) {

                }

            }

        }

    }
}

class MyData {
    int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}


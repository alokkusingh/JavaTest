package alok.test.semaphore;

public class Printer implements Runnable {
	private Semaphore mutex;

	public Printer(Semaphore mutex) {
		this.mutex = mutex;
	}

	@Override
	public void run() {
		mutex.acquire();
		print();
		try {Thread.sleep(2000);} catch (InterruptedException e) {e.printStackTrace();}
		mutex.release();
	}

	public void print() {
		System.out.println("Printing... " + Thread.currentThread().getName());
	}
}

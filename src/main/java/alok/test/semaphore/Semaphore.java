package alok.test.semaphore;

public class Semaphore {
	private int counter;
	
	public Semaphore(int init) {
		counter = init;
	}
		
	//Acquiring the lock
	public synchronized void acquire() {
		while(counter == 0) {
			try {wait();} catch (InterruptedException e) {e.printStackTrace();}
		}
		counter--;		
		System.out.println("acquired, aviable resource: " + counter);
	}
	
	//Releasing the lock
	public synchronized void release() {	
		counter++;
		System.out.println("released, aviable resource: " + counter);

		if (counter-1 == 0)
		notify();
	}
	

}

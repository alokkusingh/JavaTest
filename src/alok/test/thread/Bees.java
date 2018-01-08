package alok.test.thread;

public class Bees {
	public static void main(String[] args) {
		try {
			new Bees().go();
		} catch (Exception e) {
			System.out.println("thrown to main: " + e.getStackTrace());
			e.printStackTrace();
		}
	}

	synchronized void go() throws InterruptedException {
		Thread t1 = new Thread();
		t1.start();
		System.out.print("1 ");
		// since the main thread is the owner of the resource (not t1) - IllegalMonitorStateException - if the current thread is not the owner of the object's monitor.
		t1.wait(5000);
		
		//but the below will work
		//wait(5000);
		
		System.out.print("2 ");
	}
}
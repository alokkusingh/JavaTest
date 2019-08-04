package alok.test.thread;

/**
 * * Java program to create a deadlock by imposing circular wait. * 
 * * @author
 * WINDOWS 8 *
 */
class DeadLock {
	/* * This method request two locks, first String and then Integer */ 
	public void method1() {
		synchronized (String.class) {
			System.out.println(Thread.currentThread().getName() + " method1 - Aquired lock on String.class object");
			synchronized (Integer.class) {
				System.out.println(Thread.currentThread().getName() + " method1 - Aquired lock on Integer.class object");
			}
		}
	}

	/*
	 * * This method also requests same two lock but in exactly * Opposite order
	 * i.e. first Integer and then String. * This creates potential deadlock, if
	 * one thread holds String lock * and other holds Integer lock and they wait
	 * for each other, forever.
	 */ public void method2() {
		synchronized (Integer.class) {
			System.out.println(Thread.currentThread().getName() + " method2 - Aquired lock on Integer.class object");
			synchronized (String.class) {
				System.out.println(Thread.currentThread().getName() + " method2 - Aquired lock on String.class object");
			}
		}
	}
}

public class CreateDeadlock implements Runnable {
	
	DeadLock d = new DeadLock();
	
	@Override
	public void run() {
		while (true) {
			Integer rand = (int) (Math.random() * 10);
			switch (rand % 2) {
				case 0:
					d.method1();
					break;
				case 1:
					d.method2();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		 Thread t1 = new Thread(new CreateDeadlock());
		 Thread t2 = new Thread(new CreateDeadlock());
		 
		 t1.start();
		 t2.start();
		 
		 System.out.println("Waiting for thread to be completed");
		 t1.join();
		 t2.join();
	 }


}

// Read more:
// http://javarevisited.blogspot.com/2010/10/what-is-deadlock-in-java-how-to-fix-it.html#ixzz4jlAKoWTg


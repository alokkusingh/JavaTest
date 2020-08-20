package alok.test.thread;

import java.util.stream.IntStream;

class MyTask implements Runnable {

	ThreadLocal<Integer> count = new ThreadLocal<>();
	
	@Override
	public synchronized void run() {

		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("Going to wait for few seconds");
				wait(1);
				//Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("I got interrupt signal");
				e.printStackTrace();

				//if I am not taking below action no one can interrupt me!
				break;
			}
			System.out.println(i);
		}

		System.out.println("Completing");
	}
	
}

public class IntruptTest {

	static Thread t = new Thread(new MyTask());
	
	public static void main(String[] args) {
		t.start();
		
		t.interrupt();
	}
}

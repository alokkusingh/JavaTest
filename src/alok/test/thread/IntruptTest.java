package alok.test.thread;

import java.util.stream.IntStream;

class MyTask implements Runnable {

	ThreadLocal<Integer> count = new ThreadLocal<>();
	
	@Override
	public synchronized void run() {
		
		for (int i = 0; i < 100; i++) {
				{try {
					wait(5);
					//Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					break;
				}
				System.out.println(i);
				}
		}
		
	}
	
}

public class IntruptTest {

	static Thread t = new Thread(new MyTask());
	
	public static void main(String[] args) {
		t.start();
		
		t.interrupt();
	}
}

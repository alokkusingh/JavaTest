package alok.test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class MyMutex {
}

class RunnableX implements Runnable {
	MyMutex mutex;
	
	RunnableX(MyMutex mut) {
		mutex = mut;
	}
	
	@Override
	public void run() {
		synchronized (mutex) {
			try {
				mutex.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("RunnableX completd!");
		}		
	}	
}

class RunnableY implements Runnable {
	MyMutex mutex;
	
	RunnableY(MyMutex mut) {
		mutex = mut;
	}
	
	@Override
	public void run() {
		synchronized (mutex) {
			try {
				mutex.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("RunnableY completd!");
		}		
	}	
}

class RunnableZ implements Runnable {
	MyMutex mutex;
	
	RunnableZ(MyMutex mut) {
		mutex = mut;
	}
	
	@Override
	public void run() {
		synchronized (mutex) {
			try {
				mutex.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("RunnableZ completd!");
		}		
	}	
}


public class MyThread3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyMutex mutex = new MyMutex();

		ExecutorService executorService = Executors.newFixedThreadPool(3);
		executorService.execute(new RunnableX(mutex));
		executorService.execute(new RunnableY(mutex));
		executorService.execute(new RunnableZ(mutex));

		try {
			executorService.awaitTermination(10000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Completed!");
	}

}

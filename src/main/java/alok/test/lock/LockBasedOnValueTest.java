package alok.test.lock;

import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockBasedOnValueTest {

	final static int MAX_THREAD = 3;
	final static Lock[] locksForAbcOperation = new Lock[MAX_THREAD];
	
	static {
		for (int i = 0; i < MAX_THREAD; ++i) {
			// with fairness enabled
			locksForAbcOperation[i] = new ReentrantLock(true);
		}
	}
	
	public static void main(String args[]) {
		
		String[] ids = {"alok","xyz","xyz","xyz","singh","kumar","amit","amit","amit","neha","suhail","ram","raidon","raidon","raidon"};
		
		ExecutorService abcTaskService = Executors.newFixedThreadPool(MAX_THREAD);
		for (int i = 0; i < ids.length; i++) {
			abcTaskService.submit(new Task(ids[i], i));
		}
		
		abcTaskService.shutdown();
	}
	
	
	
	static Lock getLockForAbcOperation(String id) {
		return locksForAbcOperation[id.hashCode() & (MAX_THREAD - 1)];
	}
}

class Task implements Runnable {

	String id;
	int index;
	Task(String id, int index) {
		this.id = id;
		this.index = index;
	}
	
	@Override
	public void run() {
		Lock lock = LockBasedOnValueTest.getLockForAbcOperation(id);
		try {
			System.out.printf("[%s %s\t%s-%d\t%s]\tTrying to acquire the lock\n", LocalTime.now() ,Thread.currentThread().getName(), id, index, lock.hashCode());
			lock.lock();
			System.out.printf("[%s %s\t%s-%d\t%s]\t\t\tLock acquired\n",LocalTime.now() , Thread.currentThread().getName(), id, index, lock.hashCode());
			System.out.printf("[%s %s\t%s-%d\t%s]\tPerforming task\n", LocalTime.now() ,Thread.currentThread().getName(), id, index, lock.hashCode());
			Thread.sleep((int)(Math.random() * 3000));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.printf("[%s %s\t%s-%d\t%s]\t\t\tReleasing the lock\n", LocalTime.now() ,Thread.currentThread().getName(), id, index, lock.hashCode());
			lock.unlock();
		}
	}
	
}

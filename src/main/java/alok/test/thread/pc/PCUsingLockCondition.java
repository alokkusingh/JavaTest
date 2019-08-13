package alok.test.thread.pc;

import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class PCUsingLockCondition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MyOwnProducer implements Callable<Void> {

	Queue<Double> queue;
	Lock lock;
	Condition writeCondition;
	Condition readCondition;
	int maxSize;
	
	MyOwnProducer(Queue<Double> queue, Lock lock, Condition writeCondition, Condition readCondition, int maxSize) {
		this.queue = queue;
		this.lock = lock;
		this.writeCondition = writeCondition;
		this.readCondition = readCondition;
		this.maxSize = maxSize;
	}
	
	@Override
	public Void call() throws Exception {
		
		while (true) {
			try {
				lock.lock();
				while (queue.size() == maxSize) {
					writeCondition.await();
				}
				queue.add(Math.random());
			} finally {
				lock.unlock();
			}
			readCondition.signal();
		}
	}
}

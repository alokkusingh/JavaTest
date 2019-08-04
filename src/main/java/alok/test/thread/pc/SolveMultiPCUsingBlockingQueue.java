package alok.test.thread.pc;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by gaurav on 17/3/17.
 */
public class SolveMultiPCUsingBlockingQueue {

	public static void main(String[] args) {

		int n = 3; // number of producers and consumers

		BlockingQueue<Integer> queue = new LinkedBlockingDeque<>();

		for (int i = 0; i < n; i++) {

			new Thread(new Producer(queue, 5), "Producer " + i).start();
			new Thread(new Consumer(queue), "Consumer " + i).start();
		}
	}
}

class Producer implements Runnable {

	BlockingQueue queue;
	Integer size;
	private static Integer counter = 0;

	Producer(BlockingQueue q, Integer size) {
		this.queue = q;
		this.size = size;
	}

	@Override
	public void run() {

		while (true) {

			while (queue.size() < size) {
				queue.add(counter);
				System.out.println("Thread " + Thread.currentThread().getId() + "  Produced: " + counter);
				counter++;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}
}

class Consumer implements Runnable {

	BlockingQueue queue;

	Consumer(BlockingQueue q) {
		this.queue = q;
	}

	@Override
	public void run() {

		while (true) {

			while (queue.size() > 0) {
				System.out.println("Thread " + Thread.currentThread().getId() + " Consumed: " + queue.remove());
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
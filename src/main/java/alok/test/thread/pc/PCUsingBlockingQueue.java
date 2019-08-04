package alok.test.thread.pc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ProducerX implements Runnable {
	private final BlockingQueue queue;

	ProducerX(BlockingQueue q) {
		queue = q;
	}

	public void run() {
		try {
			while (true) {
				queue.put(produce());
			}
		} catch (InterruptedException ex) {
		}
	}

	Object produce() {
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Produced - 1 item");
		return new Integer(1);
	}
}

class ConsumerX implements Runnable {
	private final BlockingQueue queue;

	ConsumerX(BlockingQueue q) {
		queue = q;
	}

	public void run() {
		try {
			while (true) {
				consume(queue.take());
			}
		} catch (InterruptedException ex) {
		}
	}

	void consume(Object x) {
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Consuumed - 1 item");
	}
}

public class PCUsingBlockingQueue {
	public static void main(String[] args) {
		BlockingQueue q = new LinkedBlockingQueue();
		ProducerX p = new ProducerX(q);
		ConsumerX c1 = new ConsumerX(q);
		ConsumerX c2 = new ConsumerX(q);
		new Thread(p).start();
		new Thread(c1).start();
		new Thread(c2).start();
	}
}
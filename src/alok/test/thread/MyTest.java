package alok.test.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*class Lock {

	private boolean isLocked = false;

	public synchronized void lock() throws InterruptedException {
		while (isLocked) {
			wait();
		}
		isLocked = true;
	}

	public synchronized void unlock() {
		isLocked = false;
		notify();
	}
}*/

class MyBlockingQueue<E> {
	private Queue<E> queue;
	private String queueName;
	private int size;

	public MyBlockingQueue(int size, String name) {
		queueName = name;
		this.size = size;
		queue = new LinkedList<E>();
	}

	public synchronized Boolean enqueue(E data) {
		while (queue.size() == size) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.queue.add(data);

		System.out.println("[" + queueName + "] added: " + data + ", avaiable: " + queue.size() + "/" + size + "]");
		notifyAll();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public synchronized E dequeue() {
		while (queue.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		E data = this.queue.peek();
		System.out.println("[" + queueName + "] removed: " + data + ", avaiable: [" + queue.size() + "/" + size + "]");

		notifyAll();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}
}

abstract class Goods {
}

class Pen extends Goods {
}

class Book extends Goods {
}

class Market {
	public static int penConter;
	public static int bookCounter;
	private static Market instance = new Market();

	private MyBlockingQueue<Integer> penStock = new MyBlockingQueue<Integer>(10, "Pen Q");
	private MyBlockingQueue<Integer> bookStock = new MyBlockingQueue<Integer>(10, "Book Q");

	private Market() {
	}

	public static Market getInstance() {
		return instance;
	}

	public void startBusiness() {

		ExecutorService executor = Executors.newFixedThreadPool(3);
		executor.submit(new PenProducer("[Pen Producer  1] "));
		executor.submit(new PenConsumer("[Pen Consumer  1] "));
		executor.submit(new BookProducer("[Book Producer 1]"));
		executor.submit(new BookConsumer("[Book Consumer 2]"));

		executor.shutdown();
		try {
			executor.awaitTermination(5, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public MyBlockingQueue<Integer> getPenStock() {
		return penStock;
	}

	public MyBlockingQueue<Integer> getBookStock() {
		return bookStock;
	}
}

abstract class Producer {
	private String producerName;

	public Producer(String producerName) {
		super();
		this.producerName = producerName;
	}

	public String getProducerName() {
		return producerName;
	}

	abstract public void produce();
}

class PenProducer extends Producer implements Runnable {

	static final int MAX_ITEM = 10;
	private static final Pen item = new Pen();

	public PenProducer(String producerName) {
		super(producerName);
	}

	@Override
	public void run() {
		produce();
	}

	@Override
	public void produce() {
		while (true) {

			Market.getInstance().getPenStock().enqueue(++Market.penConter);
			System.out.println("PenProducer:: added: " + Market.penConter);
		}
	}

}

class BookProducer extends Producer implements Runnable {

	static final int MAX_ITEM = 10;
	private static final Book item = new Book();

	public BookProducer(String producerName) {
		super(producerName);
	}

	@Override
	public void run() {
		produce();
	}

	@Override
	public void produce() {
		while (true) {

			Market.getInstance().getBookStock().enqueue(++Market.bookCounter);
			System.out.println("BookProducer:: added: " + Market.bookCounter);
		}
	}

}

class PenConsumer implements Runnable {

	public PenConsumer(String consumerName) {
	}

	@Override
	public void run() {
		while (true) {
			consumePen();
		}
	}

	public void consumePen() {

		int item = Market.getInstance().getPenStock().dequeue();
		System.out.println("\tPenConsume:: consumed: " + item);

	}
}

class BookConsumer implements Runnable {

	public BookConsumer(String consumerName) {
	}

	@Override
	public void run() {
		while (true) {
			consumeBook();
		}
	}

	public void consumeBook() {

		int item = Market.getInstance().getBookStock().dequeue();
		System.out.println("\tBookConsume:: consumed: " + item);
	}

}

public class MyTest {

	public static void main(String[] args) {
		System.out.println("Market starting");
		Market market = Market.getInstance();
		System.out.println("Business starting");
		market.startBusiness();
		System.out.println("Buisness closed!");
	}
}

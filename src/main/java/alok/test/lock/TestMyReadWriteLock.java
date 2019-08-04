package alok.test.lock;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class Writer implements Runnable {

	Lock lock;
	
	Map<Integer,String> collection;
	
	Writer(Lock writeLock, Map<Integer,String> collection) {
		this.lock = writeLock;
		this.collection = collection;
	}
	
	@Override
	public void run() {
		lock.lock();
		System.out.println("\tWrite lock acuqired: " + Thread.currentThread().getId());
		String str = null;
		try {
			str = UUID.randomUUID().toString();
			collection.put((int)(Math.random()*10), str);
		} finally {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock.unlock();
			System.out.println("\tWrite lock released: " + Thread.currentThread().getId());
		}
	}
}

class Reader implements Callable<String> {

	Lock lock;
	Map<Integer,String> collection;
	
	Reader(Lock readLock, Map<Integer,String> collection) {
		this.lock = readLock;
		this.collection = collection;
	}
	
	@Override
	public String call() throws Exception {
		lock.lock();
		System.out.println("\t\tRead lock acuqired: " + Thread.currentThread().getId());
		String str = null;
		try {
			str = collection.put((int)(Math.random()*10), str);
		} finally {
			Thread.sleep(2000);
			lock.unlock();
			System.out.println("\t\tRead lock released: " + Thread.currentThread().getId());
		}
		return str;
	}
	
}

public class TestMyReadWriteLock {

	static Map<Integer, String> dataMap = new HashMap<>();
	
	static ReadWriteLock rwLock = new ReentrantReadWriteLock();
	static Lock rLock = rwLock.readLock();
	static Lock wLock = rwLock.writeLock();
	
	{
		dataMap.put(0, "Hello");
		dataMap.put(1, "Hi");
		dataMap.put(2, "Hola");
		dataMap.put(3, "Bonzure");
		dataMap.put(4, "Bye");
		dataMap.put(5, "Welcome");
		dataMap.put(6, "Thank");
		dataMap.put(7, "Great");
		dataMap.put(8, "Weeldone");
		dataMap.put(9, "Problem");
	}
	
	public static void main(String[] args) {

		
		

		new Thread(new Runnable() {

			ExecutorService readService = Executors.newFixedThreadPool(5);
			
			@Override
			public void run() {
				LinkedList<Future<String>> returns = new LinkedList<>();
				
				for (int i = 0; i < 100; i++) {
					returns.add(readService.submit(new Reader(rLock, dataMap)));
				}
				
				readService.shutdown();
				
				for (int i = 0; i < 100; i++) {
					try {
						System.out.println("Read: " + returns.get(i).get());
					} catch (InterruptedException | ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Read completed!");
				
			}
			
		}).start();
		
		new Thread(new Runnable() {
			ExecutorService writeService = Executors.newFixedThreadPool(2);

			@SuppressWarnings("unchecked")
			@Override
			public void run() {
				LinkedList<Future<Void>> returns = new LinkedList<>();
					
				for (int i = 0; i < 100; i++) {
					returns.add((Future<Void>) writeService.submit(new Writer(wLock, dataMap)));
				}
					
				writeService.shutdown();
					
				for (int i = 0; i < 100; i++) {
					System.out.println("Write: " + returns.get(i));
				}
				System.out.println("Write completed!");
			}
			
		}).start();
	}
}

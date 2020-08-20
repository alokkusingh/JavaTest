package alok.test.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CollableTest {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		//ExecutorService executor = Executors.newFixedThreadPool(5);
		//ExecutorService executor = Executors.newSingleThreadExecutor();
	
		Future<String> future = executor.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {

				try {
					Thread.sleep((int)(Math.random() * 10000));
				} catch (InterruptedException e) {
					System.out.println("\tThread: I am interrupted!");
					// below "Hello World" will not be printed!
				}
				return "\tHello World";
			}
			
		});
		executor.shutdown();
		System.out.println("We are processing your request...");
		
		try {
			System.out.println(future.get(4000, TimeUnit.MILLISECONDS));
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.out.println("Request Timeout, please try again...");
			System.out.println("Interrupted: " + future.cancel(true));  // interrupt if running - should be interrupted because thread is in sleep
			//System.out.println("Interrupted: " + future.cancel(false));  // will not send Interrupt signal, but will return true
		}
	}
}

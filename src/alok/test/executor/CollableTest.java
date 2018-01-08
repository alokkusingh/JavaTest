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
				
				Thread.sleep((int)(Math.random() * 10000));
				return "Hello World";
			}
			
		});
		
		System.out.println("We are processing your request...");
		
		try {
			System.out.println(future.get(5000, TimeUnit.MILLISECONDS));
			
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			future.cancel(true);
			System.out.println("Request Timeout, please try again...");
		}
		executor.shutdownNow();

	}

}

package alok.test.Callable;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {

	public static void main(String[] args) {
		ExecutorService executer = Executors.newFixedThreadPool(5);
		ArrayList<Future<Integer>> resultList = new ArrayList<Future<Integer>>();
		
		//long startTime = System.nanoTime();
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 20000; i++) {
			resultList.add(executer.submit(new Sum(10, i)));
		}
		
		executer.shutdown();
		
		for (Future<Integer> result : resultList) {
			try {
				System.out.println("Future result is - " + result.get() + "; And Task done is " + result.isDone());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Elapsed time: " + (System.currentTimeMillis()-startTime));
	}

}

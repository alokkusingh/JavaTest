package alok.test.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

	public static void main(String[] args) {
		
		//Assign max concurrent user for printer
		Semaphore mutex = new Semaphore(3);
		
		//create 5 workers
		ExecutorService threadPoolService = Executors.newFixedThreadPool(5);
		
		//schedule 50 tasks to 5 workers
		for (int i = 0; i < 50; i++) {
			threadPoolService.execute(new Printer(mutex));
			// instaed of execute method we can use submit and get the Future object and can get the staus of the thread 
			// if we want return value then use Collable interface class and call .get() from Furture oobject
			
			System.out.println("Submited task: print " + i);
		}
		
		threadPoolService.shutdown();
		while (!threadPoolService.isTerminated()) {   }  
		
		System.out.println("Finished all tasks");  
	}

}

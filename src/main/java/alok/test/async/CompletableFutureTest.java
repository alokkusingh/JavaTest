package alok.test.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class CompletableFutureTest {

	
	public static void main(String[] args) {

		IntStream.range(0, 100)
			.forEachOrdered(new TaskProcessor(dataConsumer));
		
		System.out.println("All task submitted!!!");
	}
	
	static Consumer<String> dataConsumer = new Consumer<String>() {
		@Override
		public void accept(String processedData) {
			System.out.printf("%s\tTask completd::%s\n", Thread.currentThread().getName(), processedData);
		}
	};

}

class TaskProcessor implements IntConsumer {

	final static int NUMBER_OF_CORE = 5;
	Consumer<String> consumer;
	ExecutorService cpuBoundService = Executors.newFixedThreadPool(NUMBER_OF_CORE);
	//ExecutorService ioBoundService = Executors.newFixedThreadPool(9);
	
	
	TaskProcessor(Consumer<String> consumer) {
		this.consumer = consumer;
	}
	
	@Override
	public void accept(int value) {
		
		CompletableFuture.supplyAsync(() -> value, cpuBoundService)
			.thenApply(x ->  {
				// this will run by the same thread as the parent thread
				try {Thread.sleep((long) (Math.random()*1000));} catch (InterruptedException e) {e.printStackTrace();}
				System.out.printf("%s\t%s\n", Thread.currentThread().getName(), "This is CPU bound operation");
				return "Value: " + x;
			})
			.thenApplyAsync(x -> {
				// this will run by other thread and belongs to other thread pool
				try {Thread.sleep((long) (Math.random()*2000));} catch (InterruptedException e) {e.printStackTrace();}
				System.out.printf("%s\t%s\n", Thread.currentThread().getName(), "This is IO bound operation");
				return x.toUpperCase();
			}, cpuBoundService)
			.thenAccept(consumer)
			.thenRun(() -> {
				//System.out.println("--------- Shuting down the execuotr services!!!----------------");
				cpuBoundService.shutdown();
				//ioBoundService.shutdown();
			});
	}
}




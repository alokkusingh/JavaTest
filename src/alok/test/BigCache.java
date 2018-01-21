package alok.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Employee {
	Integer id;
	String name;
	StringBuilder department;
	public Employee(Integer id, String name, StringBuilder department) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
	}
}

public class BigCache {

	static int max = 1000000;
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		
		
		ExecutorService ec = Executors.newSingleThreadExecutor();
		Future<?> ft = ec.submit(new Runnable() {
			Map<Integer,Employee> empMap = new HashMap<>();
			
			@Override
			public void run() {
				for (int i = 0; i < BigCache.max; ++i) {
					empMap.put(i, new Employee(i, "Name: " + i, new StringBuilder("IT")));
				}
				System.out.println(max + " Employee created in heap");
				try {
					Thread.sleep(120000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("Waiting thread to be completed!");
		ft.get();
		System.out.println("Thread completed!");
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("System shutodown executed!");
				
			}
			
		}));
		
		Thread.sleep(60000);
		
		System.out.println("System shutodown!");
	}
}

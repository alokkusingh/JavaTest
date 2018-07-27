package alok.test.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class TaskA implements Runnable {

	CyclicBarrier cb;
	Map<String, Integer> outputMap;
	
	TaskA(CyclicBarrier cb, Map<String, Integer> outputMap) {
		this.cb = cb;
		this.outputMap = outputMap;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(20000);
			outputMap.put("A", 65);
			System.out.println("Task A completed awaiting other tasks!");
			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Task A other tasks completed!");
	}
	
}

class TaskB implements Runnable {

	CyclicBarrier cb;
	Map<String, Integer> outputMap;
	
	TaskB(CyclicBarrier cb, Map<String, Integer> outputMap) {
		this.cb = cb;
		this.outputMap = outputMap;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(10000);
			outputMap.put("B", 66);
			System.out.println("Task B completed awaiting other tasks!");
			cb.await();
		} catch (InterruptedException | BrokenBarrierException e) {
			e.printStackTrace();
		}
		System.out.println("Task B other tasks completed!");
	}
	
}

public class CyclicBarrierTest {
	
	public static void main(String[] args) throws InterruptedException {
		Map<String, Integer> data = new HashMap<>();
		CyclicBarrier cb = new CyclicBarrier(2, new Runnable() {

			@Override
			public void run() {
				System.out.println("Both the tasks completed!");
				System.out.println("Data: " + data);
			}
			
		});
		
		Thread ta = new Thread(new TaskA(cb, data));
		Thread tb = new Thread(new TaskB(cb, data));
		
		ta.start();
		tb.start();
		
		System.out.println("Tasks submitted!");
		//ta.join();
		//tb.join();
		
		System.out.println("Main completing!");
	}
}

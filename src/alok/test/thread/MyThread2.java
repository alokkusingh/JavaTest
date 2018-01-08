package alok.test.thread;

class Resource {
	public void print(String str) {
		System.out.println(str);
	}
}

class Runnable1 implements Runnable {

	Resource resource;
	Runnable1(Resource res) {
		resource = res;
	}
		
	@Override
	public void run() {
        synchronized (resource) {
        	try {
        		// for the below norify is optional by other thread
        		// the thread will wakeup either reciving on the notify or given timeout
        		// if the timeout is before the resource gets released by other thread
        		//	- the resource will be get the resource when other resource release the resourec (but no notify needed) 
				resource.wait(1000);
				
				//for the below notify is madatory by other thread
				//if other thread never sends notify the thread will never wakeup
        		//resource.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	
        	resource.print("Runnable1");
        }
	}
}

class Runnable2 implements Runnable {

	Resource resource;
	Runnable2(Resource res) {
		resource = res;
	}
		
	@Override
	public void run() {
        synchronized (resource) {
        	try {
				Thread.sleep(5500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        	resource.print("Runnable2");
        }
	}
}

public class MyThread2 {

	public static void main(String[] args) {
		Resource resource = new Resource();
		Thread t1 = new Thread(new Runnable1(resource));
		Thread t2 = new Thread(new Runnable2(resource));

		t1.start();
		t2.start();
		
		System.out.println("Done!");
	}

}

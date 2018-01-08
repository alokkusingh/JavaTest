package alok.test.thread;

public class StartMain implements Runnable{

	@Override
	public void run() {
		System.out.println("StartMain started");
		
	}	
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Creating StartMain thread");
		Thread t = new Thread(new StartMain());
		System.out.println("StartMain starting");
		t.start();

		System.out.println("StartMain submitted");
		t.join();
		System.out.println("competing main()");
	}



}

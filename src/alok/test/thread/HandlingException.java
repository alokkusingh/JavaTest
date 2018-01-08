package alok.test.thread;

public class HandlingException {

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			public void run() {
				throw new RuntimeException();
			}
		});

		t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("exception " + e + " from thread " + t);
			}
		});

		t.start();
	}
}

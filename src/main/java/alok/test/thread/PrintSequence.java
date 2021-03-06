package alok.test.thread;

public class PrintSequence {

	static Integer data = new Integer(1);

	public static void main(String[] args) {

		Thread evenThread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					System.out.println("Even Thread: waiting to enter the lock");
					synchronized (PrintSequence.class) {
						System.out.println("Even Thread: entered the lock");
						if (data % 2 == 0) {
							System.out.println("Even Thread: " + data);
							++data;
							System.out.println("Even Thread: releasing the lock");
							PrintSequence.class.notify();
						} else {
							try {
								System.out.println("Even Thread: waiting to aquire the lock");
								PrintSequence.class.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		});

		Thread oddThread = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					System.out.println("Odd  Thread: waiting to enter the lock");
					synchronized (PrintSequence.class) {
						System.out.println("Odd  Thread: entered the lock");
						if (data % 2 != 0) {
							System.out.println("Odd  Thread: " + data);
							++data;
							System.out.println("Odd  Thread: releasing the lock");
							PrintSequence.class.notify();
						} else {
							try {
								System.out.println("Odd  Thread: waiting to aquire the lock");
								PrintSequence.class.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}

				}
			}
		});

		evenThread.start();
		oddThread.start();
	}
}
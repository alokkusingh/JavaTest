package alok.test;

class MyTestNoPublic extends Thread {

	{
		System.out.println("Non-Static block!");
	}
	
	static {
		System.out.println("Static block!");
	}
	
	public static void myTest() {
		System.out.println("Constructor!");
	}
	
	public void run() {
		System.out.println("run called!");
	}
	
	
	public static void main(String[] args) {

		System.out.println("Main!");
		myTest();
		
		(new MyTestNoPublic()).start();
	}

}

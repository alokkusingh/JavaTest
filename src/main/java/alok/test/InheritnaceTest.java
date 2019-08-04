package alok.test;

class MyBase {
	private int privateIntVar;
	private static int privateStaticInt;
	
	void myTest() {
		System.out.println("MyBase test");
	}
}


class MyDerive extends MyBase {
	//below will be error - incompatible method 
	/*int myTest() {
		System.out.println("MyBase test");
		return 0;
	}*/
}

public class InheritnaceTest {
    public static void main(String[] args) {
    	MyBase base = new MyDerive();
    	
    	//compilation error
    	//base.privateIntVar = 10;
    	
    	//complilation error
    	//base.privateStaticInt;
    }
}

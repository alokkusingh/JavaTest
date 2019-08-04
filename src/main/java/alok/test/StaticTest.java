package alok.test;

class Base {
	static void myMethod() {
		System.out.println("Base MyMethod");
	}
}

class Derive extends Base {
	static void myMethod() {
		System.out.println("Derive MyMethod");
	}
}

public class StaticTest {

	public static void main(String[] args) {
		Base b = new Derive();
		
		b.myMethod(); //this will call Base Static method
		Base.myMethod(); // this will call Base Static method
		Derive.myMethod(); // This will call derive non-Static method

	}

}

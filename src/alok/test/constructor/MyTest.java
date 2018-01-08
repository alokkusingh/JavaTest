package alok.test.constructor;

class Base {
	int x;
	int y;
	String str;
	Base () {
		System.out.println(" 0 ");
		myPrivate();
	}
	
	Base (int x, int y, String str) {
		System.out.println(" 1 ");
		this.x = x;
		this.y = y;
		this.str = str;
		
		myPrivate();
		myProtected();
	}
	
	private void myPrivate() {
		System.out.println("Base myPrivate");
	}
	
	protected void myProtected() {
		System.out.println("Base myProtected");
	}
}

class Derive extends Base {
	Derive () {
		System.out.println(" 2 ");
	}
	
	Derive (int x, int y, String str) {
		super(x,y,str);
		//this();
		System.out.println(" 3 ");
	}
	
	private void myPrivate() {
		System.out.println("Derive myPrivate");
	}
	
	protected void myProtected() {
		System.out.println("Derive myProtected");
	}
}

public class MyTest {

	public static void main(String[] args) {
        new Derive(1,2,"Alok");
	}

}

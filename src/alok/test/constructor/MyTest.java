package alok.test.constructor;

class Base {
	int x;
	int y;
	String str;
	
	static {
		System.out.println(" BS ");
	}
	
	{
		System.out.println(" BI ");
	}
	
	Base () {
		System.out.println(" BUC ");
		myPrivate();
	}
	
	Base (int x, int y, String str) {
		System.out.println(" BPC ");
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
	static {
		System.out.println(" DS ");
	}
	
	{
		System.out.println(" DI ");
	}
	
	Derive () {
		System.out.println(" DUC ");
	}
	
	Derive (int x, int y, String str) {
		super(x,y,str);
		//this(); // error constructor call cant be second line
		System.out.println(" DPC ");
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

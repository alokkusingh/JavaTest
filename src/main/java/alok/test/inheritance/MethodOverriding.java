package alok.test.inheritance;

class Base {
	public void method1(String str, String str2) {
		System.out.println("Base::method1");
	}
	
	public Base method2() {
		return this;
	}
}

class Derive extends Base {
	//diffrent return type is not permitted
	/*public int method1(String str, String str2) {
		System.out.println("Derive::method1");
		return 0;
	}*/
	
	
	public void method1(String str, String str2, String str3) {
		System.out.println("Derive::method1");
	}
	
	//from Java 5 onwards, which enable to use subtype of return type of overridden method. 
	public Derive method2() {
		return this;
	}
}


public class MethodOverriding {

	public static void main(String[] args) {

		Base b = new Derive();
		b.method1("Alok", "Singh");
		
		//below not permitted
		//b.method1("Alok", "Kumar", "Singh");
		
		Derive d = new Derive();
		d.method1("Alok", "Singh");
		d.method1("Alok", "Kumar", "Singh");

	}

}

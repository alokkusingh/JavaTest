package alok.test.innerclass;

class MyClass {
	protected void doSomething() {
		System.out.println("Doing something - not applicable if you need something special!");
	}
}

interface MyInterface {
	public void doSomething();
}

public class AnonymousInnerClass {

	public static void main(String[] args) {
		//this is one example of annonymous inner clss
		// this will genarate class file with name AnonymousInnerClass$1.class
		MyClass myClass = new MyClass() {
			public void doSomething() {
				System.out.println("Doing something special!");
			}
		};
		
		myClass.doSomething();
		
		//this is another example of annonymous inner clss
		// this will genarate class file with name AnonymousInnerClass$2.class
		MyInterface myInterface = new MyInterface() {

			@Override
			public void doSomething() {
				System.out.println("Actually doing something!");
			}			
		};
		
		myInterface.doSomething();
		
	}

}

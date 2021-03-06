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
		// this is one example of anonymous inner class
		// this will generate class file with name AnonymousInnerClass$1.class
		MyClass myClass = new MyClass() {
			public void doSomething() {
				System.out.println("Doing something special!");
			}
		};
		myClass.doSomething();

		// this is another example of anonymous inner class
		// this will generate class file with name AnonymousInnerClass$2.class
		MyInterface myInterface = new MyInterface() {

			@Override
			public void doSomething() {
				System.out.println("Actually doing something!");
			}			
		};
		myInterface.doSomething();

		// this is another example of anonymous inner class
		// this will generate class file with name AnonymousInnerClass$3.class
		MyInterface myInterface2 = () -> System.out.println("Actually doing something!");
		myInterface2.doSomething();
	}
}

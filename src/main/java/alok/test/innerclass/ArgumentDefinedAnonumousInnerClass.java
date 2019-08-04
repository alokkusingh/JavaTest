package alok.test.innerclass;

interface AnInterface {
	void doSomething();
}

interface BnInterface {
	void doSomething(int x);
}

class AClass {
	void doSomething(AnInterface anInterface) {
		anInterface.doSomething();
	}
	
	void doSomething(BnInterface bnInterface) {
		bnInterface.doSomething(10);
	}
}

public class ArgumentDefinedAnonumousInnerClass {

	public static void main(String[] args) {

		AClass aClass = new AClass();
		
		// an example
		aClass.doSomething(new AnInterface() {
			@Override
			public void doSomething() {
				System.out.println("Actually doing something");

			}
		});
	
		/*
		//in java 8 this will be writen as below
		aClass.doSomething(() -> {
			System.out.println("Actually doing something");
		};
		
		// or
		aClass.doSomething(() -> System.out.println("Actually doing something");
		*/
		
		
		// another example
		aClass.doSomething(new BnInterface() {
			@Override
			public void doSomething(int i) {
				System.out.println("Actually doing diffrent " + i);

			}
		});
	
		/*
		//in java 8 this will be writen as below
		aClass.doSomething((int i) -> {
			System.out.println("Actually doing something " + i);
		};
		
		//or
		aClass.doSomething(i -> {
			System.out.println("Actually doing something " + i);
		};
		
		// or
		aClass.doSomething((i) -> System.out.println("Actually doing something " + i);
		
		//or
		aClass.doSomething(i -> System.out.println("Actually doing something " + i);
		
		*/

	}
}

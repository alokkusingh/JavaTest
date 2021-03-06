package alok.test;

class Test {
	
}

class Test2 extends Test {
	
}

class Test3 extends Test {
	
}

public class InstanceofTest {

	public static void main(String[] args) throws ClassNotFoundException {
		Test test = new Test();
		Test test2 = new Test2();
		Test test3 = new Test3();
		System.out.println("test is instnaceof Test? " + (test instanceof Test)); //true
		System.out.println("test is instnaceof Object? " + (test instanceof Object)); //true
		
		System.out.println("test2 is instnaceof Test? " + (test2 instanceof Test)); //true
		System.out.println("test2 is instnaceof Object? " + (test2 instanceof Object)); //true
		System.out.println("test2 is instnaceof Test2? " + (test2 instanceof Test2)); //true
		System.out.println("test2 is instnaceof Test3? " + (test2 instanceof Test3)); //false
		
		System.out.println("test2 isInstance alok.test.Test? " + (Class.forName("alok.test.Test").isInstance(test2))); //true
		System.out.println("test2 isInstance java.lang.Object? " + (Class.forName("java.lang.Object").isInstance(test2))); //true
		System.out.println("test2 isInstance alok.test.Test2? " + (Class.forName("alok.test.Test2").isInstance(test2))); //true
		System.out.println("test2 isInstance alok.test.Test3? " + (Class.forName("alok.test.Test3").isInstance(test2))); //false

		System.out.println("test3 is instnaceof Test? " + (test3 instanceof Test)); //true
		System.out.println("test3 is instnaceof Object? " + (test3 instanceof Object)); //true
		System.out.println("test3 is instnaceof Test2? " + (test3 instanceof Test2)); //false
		System.out.println("test3 is instnaceof Test3? " + (test3 instanceof Test3)); //true
	}

}

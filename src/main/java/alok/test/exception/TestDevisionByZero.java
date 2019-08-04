package alok.test.exception;

public class TestDevisionByZero {

	public static void main(String[] args) {
		
		int zero = 0;
		
		try {
			
			int x = 1 / zero;
		
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException");	
		}
		
		System.out.println("Got here");

	}
}

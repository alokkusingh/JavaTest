package alok.test.exception;

/*
				Throwable
					|
			-----------------
			|				|
		  Error			Exception
		  					|
		  			-----------------
		  			|				|
		  	RuntimeException	OtherCheckedException
		  			|
		  OtherUncheckedException
 */

public class TestDevisionByZero {

	public static void main(String[] args) {
		
		int zero = 0;
		
		try {

			int x = 1 / zero;
		//} catch (Throwable e) {
			//Not Ok as next line will complain
		} catch (Error e) {                // Ok, because they are for 2 different family
			System.out.println("Error");
		//} catch (Exception e) {
			//Not Ok as next line will complain
		//} catch (RuntimeException e) {
			// notOk as next line will complain
		} catch (ArithmeticException e) {
			System.out.println("ArithmeticException");	
		}
		
		System.out.println("Got here");

	}
}

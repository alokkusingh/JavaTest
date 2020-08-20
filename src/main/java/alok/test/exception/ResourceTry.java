package alok.test.exception;

class MyAutoCloseable implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("Close all the resources");		// 2
	}
	
}

public class ResourceTry {

	public static void main(String[] args) {
		try(MyAutoCloseable resource1 = new MyAutoCloseable(); MyAutoCloseable resource2 = new MyAutoCloseable()) {
			System.out.println("Do some operation");		// 1
			//throw new Exception("Throwing exception");
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());	//3 (if thrown)
		}
		
		System.out.println("Out of try block");				// 4

	}

}

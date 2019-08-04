package alok.test.exception;

class MyAutoCloseable implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("Close all the resources");
	}
	
}

public class ResourceTry {

	public static void main(String[] args) {
		try(MyAutoCloseable resource1 = new MyAutoCloseable(); MyAutoCloseable resource2 = new MyAutoCloseable()) {
			//throw new Exception("Throwing exception");
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
		
		System.out.println("Out of try block");

	}

}

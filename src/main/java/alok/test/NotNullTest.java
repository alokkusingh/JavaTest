package alok.test;

//import org.eclipse.jdt.annotation.NonNull;

public class NotNullTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		myTest("Alok");
		myTest(null);


	}
	
//	static void myTest(@NonNull String str) {
static void myTest(String str) {
		System.out.println("Sring Length: " + str.length());
	}

}

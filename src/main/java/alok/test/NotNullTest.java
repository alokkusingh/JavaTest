package alok.test;

//import org.eclipse.jdt.annotation.NonNull;


import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Objects;

public class NotNullTest {

	private Integer x;
	private String y;

	public NotNullTest(Integer x, String y) {

		this.x = Objects.requireNonNull(x, "x must not be null");
		this.y = y;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		myTest("Alok");
		myTest(null); // this will lead to IDE warning because str is @NonNull anotated

		String str = myTest2();
		if (str.length() == 10) // this will lead to IDE warning because str is @Nullable anotated
			System.out.println("Length is ten");

		NotNullTest notNullTest = new NotNullTest(1, "Alok");
		NotNullTest notNullTest1 = new NotNullTest(1, null);
		NotNullTest notNullTest2 = new NotNullTest(null, "Alok"); // this will throw NPE with custom message

		notNullTest.hashCode();
		notNullTest1.hashCode();
		notNullTest2.hashCode();

	}
	
	static void myTest(@NonNull String str) {
		System.out.println("String: " + str);
	}

	static @Nullable
	String myTest2() {
		return "Hello";
	}
}


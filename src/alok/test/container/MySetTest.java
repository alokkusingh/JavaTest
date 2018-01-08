
package alok.test.container;

import java.util.HashSet;
import java.util.Set;

public class MySetTest {

	public static void main(String[] args) {

		Set<Object> myCont = new HashSet<>();
		
		System.out.println(myCont.add(1234));
		System.out.println("Size: " + myCont.size());
		System.out.println(myCont.add(new Integer(1234)));
		System.out.println("Size: " + myCont.size());
		
		System.out.println(myCont.add("Alok"));
		System.out.println("Size: " + myCont.size());
		System.out.println(myCont.add(new String("Alok")));
		System.out.println("Size: " + myCont.size());
		
		System.out.println(myCont);
	}

}


package alok.test.container;

import java.util.HashSet;
import java.util.Set;

public class MySetTest {

	public static void main(String[] args) {

		Set<Object> myCont = new HashSet<>();
		
		System.out.println(myCont.add(1234)); 						// true (auto boxing has happened)
		System.out.println("Size: " + myCont.size()); 				// Size: 1
		System.out.println(myCont.add(new Integer(1234))); 	// false
		System.out.println("Size: " + myCont.size());				// Size: 1
		
		System.out.println(myCont.add("Alok"));						// true
		System.out.println("Size: " + myCont.size());				// Size: 2
		System.out.println(myCont.add(new String("Alok")));	// false
		System.out.println("Size: " + myCont.size());				// Size: 2
		
		System.out.println(myCont);
	}

}

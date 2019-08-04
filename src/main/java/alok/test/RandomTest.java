package alok.test;

import java.math.BigDecimal;
import java.util.BitSet;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class RandomTest {

	public RandomTest() {
		System.out.println("Constructor Test");
	}
	
	//method can be same name as constructor
	public void RandomTest() {
		System.out.println("Test");
	}


	public static void main(String[] args) {
		RandomTest x = new RandomTest();
		x.RandomTest();
		
		BitSet myBits = new BitSet(16);
		BitSet myBits2 = new BitSet(16);
		
	      for(int i = 0; i < 16; i++) {
	          if((i % 2) == 0) myBits.set(i);
	          if((i % 5) == 0) myBits2.set(i);
	       }
	      
		System.out.println(myBits);
		System.out.println(myBits2);
		
		myBits.or(myBits2);
		System.out.println(myBits);
		System.out.println(myBits2);
		
		List<NoEquals> myList = new LinkedList();
		
		myList.add(new NoEquals(5));
		myList.add(new NoEquals(4));
		myList.add(new NoEquals(7));
		myList.add(new NoEquals(9));
		
		System.out.println(myList);
		
		Collections.sort(myList);
		System.out.println(myList);
		
		System.out.println(0.1 * 3);
		System.out.println((0.1 * 3) == 0.3);

		Integer i1 = 128;
		Integer i2 = 128;
		System.out.println("i1 == i2: " + (i1 == i2));
		System.out.println("i1.equals(i2): " + (i1.equals(i2)));
		
		i1 = 127;
		i2 = 127;
		System.out.println("i1 == i2: " + (i1 == i2));
	}

}


class NoEquals implements Comparable<NoEquals>{
	int i = 10;

	NoEquals(int i) {
	   this.i = i;	
	}
	
	@Override
	public String toString() {
		return "noEquals [i=" + i + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(NoEquals o) {
		
		if (this.i == o.i)
			return 0;
		
		if (this.i < o.i)
			return -1;
		
		return 1;
	}


}
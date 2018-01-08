package alok.test.compare;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

class AClass implements Comparable<AClass>{
	int id;
	AClass(int id) {
		this.id = id;
	}
	
	@Override
	public int compareTo(AClass o) {
		System.out.println("compareTo");
		if (this.id < o.id)
			return -1;
			
		if (this.id > o.id)
			return 1;
		
		return 0;
	}

	@Override
	public String toString() {
		return "AClass [id=" + id + "]";
	}
}

class AClassComparatorDesc implements Comparator<AClass> {

	@Override
	public int compare(AClass o1, AClass o2) {
		System.out.println("compare");
			if (o1.id > o2.id)
				return -1;
				
			if (o1.id < o2.id)
				return 1;
			
			return 0;
	}	
}

public class MyTest {

	public static void main(String[] args) {
		LinkedList<AClass> cClasMist = new LinkedList<AClass>();
		cClasMist.add(new AClass(2));
		cClasMist.add(new AClass(3));
		cClasMist.add(new AClass(1));
		
		System.out.println(cClasMist.get(0));
		System.out.println(Arrays.toString(cClasMist.toArray()));
		
		Collections.sort(cClasMist);
		System.out.println(Arrays.toString(cClasMist.toArray()));
		System.out.println(cClasMist.get(0));
		
		Collections.sort(cClasMist, new AClassComparatorDesc());
		System.out.println(Arrays.toString(cClasMist.toArray()));
		System.out.println(cClasMist.get(0));
		
		Iterator itr = cClasMist.listIterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}

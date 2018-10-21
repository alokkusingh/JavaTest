package alok.test.container;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class MyTestClass {
	public int a;

	public MyTestClass(int a) {
		super();
		this.a = a;
	}

	@Override
	public int hashCode() {
		
		int rand = (int) (Math.random() * 10);
		System.out.println(rand);
		return rand;
		//return 1;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("equals called");
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		MyTestClass other = (MyTestClass) obj;
		if (a != other.a)
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "MyTestClass [a=" + a + "]";
	}
	
	
}

public class HashMapTest {

	public static void main(String[] args) {
		Map<MyTestClass,String> myContainer = new HashMap<>();
		
		MyTestClass myObj = new MyTestClass(5);
		MyTestClass myObj2 = new MyTestClass(6);
		
		myContainer.put(myObj, "Alok");
		myContainer.put(myObj2, "Singh");
		
		System.out.println(myContainer.get(myObj2));
		
		for (Entry<MyTestClass, String> entry: myContainer.entrySet()) {
			System.out.println(entry.getKey() + " --> " + entry.getValue());
		}

	}

}

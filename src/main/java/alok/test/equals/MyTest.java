package alok.test.equals;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * 
 * MyTest class
 *
 */
class MyBaseTest {
	public Map<String,String> mapPhonebook = new HashMap<String,String>();
	MyBaseTest mySibling;
	private int x;
	
	/**
	 * 
	 * @param x
	 */
	MyBaseTest(final int x) 
	{
		this.x = x;
		mapPhonebook.put("Alok", "9916661247");
		mapPhonebook.put("Rachna", "9945739428");
		mapPhonebook.put("Alok", "9916661248");
	}
	
	/**
	 * 
	 * @param x
	 * @param mySib
	 */
	MyBaseTest(int x, MyBaseTest mySib) 
	{
		this.x = x;
		mapPhonebook.put("Alok", "9916661247");
		mapPhonebook.put("Rachna", "9945739428");
		mapPhonebook.put("Alok", "9916661248");
		this.mySibling = mySib;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * 
	 */
	public String toString()
	{
		Set<String> keys = mapPhonebook.keySet();
		StringBuffer strPhoneEntries = new StringBuffer();
		for (String key: keys) {
			strPhoneEntries.append("\tName: " + key + ", Number: " + mapPhonebook.get(key) + "\n");
		}
		
		//Set<Map.Entry<String, String>> setPhoneEntries = mapPhonebook.entrySet();
		//StringBuffer strPhoneEntries = new StringBuffer();
		//for (Map.Entry<String, String> record: setPhoneEntries)  {
		//	strPhoneEntries.append("Name: " + record.getKey() + ", Number: " + record.getValue() + "\n");
		//}
		
		if (mySibling != null)
			strPhoneEntries.append("My Sibling's private member X: " + mySibling.x);
		
		String str = "X is: " + x + "\nPhone Book Entries Are:\n" + strPhoneEntries;
			
		return str;
	}
	
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	public static boolean printMeData(int... list)
	{
		for (int i : list)
			System.out.printf("Data: %d\n", i);
		return true;
	}
	
	
	public boolean equals(Object maObject)
	{
		System.out.println("MyTest.equals() called");
		
        if (maObject == this) return true;                        // identical 
        if (maObject == null) return false;                       // null
		
		if (this.x == ((MyBaseTest)maObject).getX())
			return true;
		
		return false;
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	public static boolean printMeData(String... list)
	{
		for (String i : list)
			System.out.printf("Data: %s\n", i);
		return true;
	}
}

class MyAnotherTest extends MyBaseTest {
	private int y;
	
	MyAnotherTest(final int x, final int y)
	{
		super(x);
		this.y = y;
	}
	
	public int getY() {
		return y;
	}	
	
	public boolean setY(final int y) {
		this.y = y;
		return true;
	}	
	
	@Override
	public String toString() {
		return "MyAnotherTest [y=" + y + ", " + super.toString() + "]";
	}
	
	public boolean equals(Object maObject)
	{	
		System.out.println("MyAnotherTest.equals() called");
		
        if (maObject == this) return true;                        // identical 
        if (maObject == null) return false;                       // null
		
		if (super.equals(maObject) && this.y == ((MyAnotherTest)maObject).getY())
			return true;
		
		return false;
	}
}

public class MyTest {

	public static void main(String[] args) {
		MyBaseTest myTest = new MyAnotherTest(1,2);
		//MyTest myTest = new MyTest(1);
		System.out.println(myTest);
		//System.out.println(((MyAnotherTest) myTest).getY());
		
		MyAnotherTest aTest = new MyAnotherTest(1,2);

		System.out.println(aTest);
		System.out.println(((MyAnotherTest)myTest).equals(aTest));	
		System.out.println("myTest.mapPhonebook == aTest.mapPhonebook: " + myTest.mapPhonebook.equals(aTest.mapPhonebook));
		
		((MyAnotherTest)myTest).setY(5);
		((MyAnotherTest)myTest).mapPhonebook.remove("Alok");
		System.out.println("myTest.mapPhonebook == aTest.mapPhonebook: " + myTest.mapPhonebook.equals(aTest.mapPhonebook));
		System.out.println(myTest);
		System.out.println(aTest);
		
		System.out.println(((MyAnotherTest)myTest).equals(aTest));	
		System.out.println(myTest.equals(aTest));	

	}

}

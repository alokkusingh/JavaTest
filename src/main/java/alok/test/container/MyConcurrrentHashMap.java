package alok.test.container;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyConcurrrentHashMap {

	public static void main(String[] args) {
		Map<String, String> myMap = new ConcurrentHashMap<>();
		
		String result = myMap.putIfAbsent("1", "Alok");
		System.out.println("Result: " + result); //null
		
		result = myMap.putIfAbsent("1", "Alok");
		System.out.println("Result: " + result); //Alok
		
		result = myMap.putIfAbsent("1", "Singh");
		System.out.println("Result: " + result); //Alok

		result = myMap.putIfAbsent("1", "Singh");
		System.out.println("Result: " + result); //Alok

		result = myMap.putIfAbsent("2", "Singh");
		System.out.println("Result: " + result); //null

	}

}

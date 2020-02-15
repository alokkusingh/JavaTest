package alok.test;

import java.util.HashMap;
import java.util.Map;

public class StringCount {

	static Map<String,Integer> countString(String line) {
	
		Map<String, Integer> stringCountmap = new HashMap<>();
		if (line != null) {
			for (String word: line.split("\\s")) {
				Integer count = stringCountmap.put(word, 1);
				if (count != null) {
					stringCountmap.put(word, ++count);
				}
			}
		}
				
		return stringCountmap;
	}
	
	public static void main(String[] args) {
		String str = "You young whippersnappers and your and newfangled 	post-Java-1.6 trickery! Seriously, at least one project in my company still runs on Java";

		System.out.println(countString(str));
	}

}

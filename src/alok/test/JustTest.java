package alok.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 * 
 * @author alok
 * Facebook Class - maintains the Facbook account details including posts
 */
public class JustTest {
	
	public static void main(String args[]) {
		System.out.println("args length: " + args.length);
		
		String[][] arr = new String[2][3];
		
		System.out.println("arr length: " + arr.length);
		System.out.println("arr[0] length: " + arr[0].length);
		System.out.println("arr[1] length: " + arr[1].length);
		
		System.out.println();
		arr[1] = args;
		System.out.println("arr length: " + arr.length);
		System.out.println("arr[0] length: " + arr[0].length);
		System.out.println("arr[1] length: " + arr[1].length);
		System.out.println("arr[1][0]: " + arr[1][0]);
		
		System.out.println();
		float[][] myFloat = new float[2][2];		
		System.out.println("myFloat[1][1]:" + myFloat[1][1]);
		
		System.out.println();
		System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
		
		System.out.println();
		try {
			int x = 0 / 0;
		} catch (Exception e) {
			System.out.println("Exception start: " + e.getMessage());
			e.printStackTrace();
			System.out.println("Exception end");
			//return;
			//System.exit(1);
		} finally {
			System.out.println("FInally block executed");
		}
		
		Byte[] b = {0};
		
		myFunc(1, 2, 3, 4, 'a', 'z', 'A', 'Z');
		
		
		System.out.println(isAnagram("Alok", "Alok"));
		System.out.println(isAnagram("Alok", "Singh"));
		System.out.println(isAnagram("Singh", "Alok"));
		System.out.println(isAnagram("Alok", "kola"));
		
	
		System.out.println("Alok".codePointAt(0));
		System.out.println("Alok".compareTo("alok"));
		System.out.println("Alok".matches("^A..*$"));
		
		System.out.println(String.join(",", "Alok", "Kumar", "Singh"));
		List<String> myList = new LinkedList<>();
		myList.add("Singh");
		myList.add("Alok");
		myList.add("Kumar");
		System.out.println(String.join(",", myList));
		
		System.out.println(String.format("%s-%s-%s %08d", "Alok", "Singh", "Kumar", 1031983));
		
		String strL = "YES      leading spaces        are valid,    problemsetters are         evillllll";
		String[] strArr = strL.split("[\\s|,|\\?|'|!|_|@|\\.]+");
		System.out.println(strArr.length);
		for (String str: strArr) {
			System.out.println(str);
		}
		
		System.out.println("100.comareTo(251): " + "100".compareTo("251"));
		
	}
	
	static void myFunc (int... intList) {
		System.out.println("Inside myFunc");
		for (int i: intList ) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	
	static boolean isAnagram (String A, String B) {
		
		System.out.print("Anagram: " + A + " - " + B + " : ");
		
		if (A.length() != B.length()) {
			return false;
		}
		
		String str1 = A.toUpperCase();
		String str2 = B.toUpperCase();
		
		int matches[] = new int[26];
			
		for (int i = 0; i < A.length(); i++) {
			++matches[str1.charAt(i) - 'A'];
			--matches[str2.charAt(i) - 'A'];
		}
		
		/*if (Arrays.equals(matches, new int[26])) {
			return true;
		}*/
		for (int match : matches) {
			if (match != 0) {
				return false;
			}
		}
		
		return true;
	}
}

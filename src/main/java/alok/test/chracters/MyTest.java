package alok.test.chracters;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class MyTest {

	static void printEncoodedCharater(String encodedChar) {
		System.out.println("Character: " + encodedChar);

		try {
			System.out.println("Default: " + Arrays.toString(encodedChar.getBytes()));
			System.out.println("US-ASCII: " + Arrays.toString(encodedChar.getBytes("US-ASCII")));
			System.out.println("ISO-8859-1: " + Arrays.toString(encodedChar.getBytes("ISO-8859-1")));
			System.out.println("UTF-8: " + Arrays.toString(encodedChar.getBytes("UTF-8")));
			System.out.println("UTF-16: " + Arrays.toString(encodedChar.getBytes("UTF-16")));
			System.out.println("UTF-16BE: " + Arrays.toString(encodedChar.getBytes("UTF-16BE")));
			System.out.println("UTF-16LE: " + Arrays.toString(encodedChar.getBytes("UTF-16LE")));
		} catch (Exception e) {

		}

		System.out.println();
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		byte b = 0b00000101;
		// char s = "\u1F602";
		System.out.println(b);
		printEncoodedCharater("a");
		printEncoodedCharater("€");
		printEncoodedCharater("\u1F602");
		
		
		char[] chars = new char[] {'\u0097'}; 
		String str = new String(chars); 
		byte[] bytes = str.getBytes(); 
		System.out.println(Arrays.toString(bytes));
		bytes = str.getBytes("UTF-8"); 
		System.out.println(Arrays.toString(bytes));
		bytes = str.getBytes("US-ASCII"); 
		System.out.println(Arrays.toString(bytes));
		
		//Read more: http://www.java67.com/2012/09/top-10-tricky-java-interview-questions-answers.html#ixzz4jgCTC8pZ
	}

}

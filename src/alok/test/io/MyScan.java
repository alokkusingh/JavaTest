package alok.test.io;

import java.util.*;

public class MyScan {
	public static void main(String[] args) {
		//Error beacuse unexpected int value in 2nd place
		//String in = "1 a 10 . 100 1000";
		String in = "1 10 100 1000";
		Scanner s = new Scanner(in);
		int accum = 0;
		for (int x = 0; x < 4; x++) {
			accum += s.nextInt();
		}
		System.out.println(accum);
	}
}
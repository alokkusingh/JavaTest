package alok.test.string;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static String getSmallestAndLargest(String s, int k) {
		String smallest = "";
		String largest = "";

		// Complete the function
		// 'smallest' must be the lexicographically smallest substring of length
		// 'k'
		// 'largest' must be the lexicographically largest substring of length
		// 'k'
		for (int i = 0; i < (s.length() - 2); i++) {
			if (smallest.length() == 0)
				smallest = s.substring(i, i+3);
			
			if (largest.length() == 0) {
				largest = s.substring(i, i+3);
			}

			if (smallest.compareTo(s.substring(i, i+3)) > 0) {
				smallest = s.substring(i, i+3);
			}
			
			if (largest.compareTo(s.substring(i, i+3)) < 0) {
				largest = s.substring(i, i+3);
			}
			
		}

		return smallest + "\n" + largest;
	}


	public static void main(String[] args) {
		//Scanner scan = new Scanner(System.in);
		//String s = scan.next();
		//int k = scan.nextInt();
		///scan.close();

		System.out.println(getSmallestAndLargest("ZASKFDLklhfsdfsDLJFSJGIHEKHIPEINNNFIGHKkjgksfgjrotyotoyjtkjkLJOIOEHEKHKKDJGKFGJkfjhglfhjtrhkjfkhjnfglhkjflgjhtrljhfljhfgljhfgljhfgljhtrklyjhtrkjhfgkljhfgjhfljhtrljlfjhfgljhfglkjhflyjtljtrlyjhtryjtrtykhrktherktjhtrkyjhkujhtykhtryhrthHKLJHLHRLHTLRHLKHTRLKHLHRLHLKHLKHKLHLKHLHKLHKHJKHKJHKJHJKHKHJKHKHHLHLHLHKHKJHKJKKHKHKHKHKHHKHKHKHKHkhktryhtlhtklhtrkyhtrkyhtrkjyhtrkyhrekthtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkhtrkyhtrkrtkyhtrklyhjrOEOHKDHFksdhfklHLHKHLHKKJHJHKGKLHLHJLJHLHLHLHLHHLHLHLHH", 240));
	}
}
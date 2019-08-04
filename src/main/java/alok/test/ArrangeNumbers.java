package alok.test;

import java.util.Arrays;

public class ArrangeNumbers {
	

	static void arrange(int[] arr) {
		if (arr == null) {
			return;
		}

		for (int i = 0, j = arr.length - 1; i < arr.length && j >= i;) {
			boolean iOddPlace = false;
			boolean jOddPlace = false;

			if (i < arr.length) {
				if ((i % 2) == (arr[i] % 2)) {
					i++;
				} else {
					iOddPlace = true;
				}
			}

			if (j >= 0) {

				if ((j % 2) == (arr[j] % 2)) {
					j--;
				} else {
					jOddPlace = true;
				}

				if (iOddPlace && jOddPlace) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;

					i++;
					j--;
				}
			}
		}
	}

	public static void main(String args[]) {
		int[] arr = new int[] { 1, 2, 4, 6, 3, 9, 5, 8, 10 };
		
		System.out.println(Arrays.toString(arr));
		arrange(arr);
		System.out.println(Arrays.toString(arr));
	}
}
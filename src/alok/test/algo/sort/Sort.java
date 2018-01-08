package alok.test.algo.sort;

import java.util.Arrays;

//Complexity
//Worst-case performance	 O(n^{2})
//Best-case performance	 O(n)
//Average performance	 O(n^{2})
//Worst-case space complexity	 O(1) 
class BubbleSort {
	public static void sort(int[] arr) {
		boolean swapped;
		for (int i = 0; i < arr.length - 1; i++) {
			swapped = false;
			for (int j = 0; j < arr.length - 2; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}

			if (!swapped) {
				break;
			}
		}
	}
}

// https://en.wikipedia.org/wiki/Sorting_algorithm#Stability
// Complexity
// Worst-case performance - n^2 (when fully sorted or when fully unsorted)
// Avergae-case performance - n/2 on random sorted
// Good for real time use
class QuickSort {
	private static int partition(int[] arr, int low, int high) {
		System.out.println(Arrays.toString(arr));
		int pivot = arr[high];

		int i = low - 1, j = low;
		while (j < high) {
			if (arr[j] < pivot) {
				++i;
				if (i < j) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			++j;
		}

		arr[high] = arr[++i];
		arr[i] = pivot;

		return i;
	}

	public static void sort(int[] arr, int low, int high) {
		if (low < high) {
			int pi = partition(arr, low, high);
			sort(arr, low, pi - 1);
			sort(arr, pi + 1, high);
		}
	}
}

class MergeSort {
	private static void merge(int arr[], int l, int m, int r) {
		System.out.println("l: " + l + ", m: " + m + ", r: " + r);
		System.out.println(Arrays.toString(Arrays.copyOfRange(arr, l, m)));
		System.out.println(Arrays.toString(Arrays.copyOfRange(arr, m + 1, r)));
		// find the size of both aprt of the array
		int size1 = m - l + 1;
		int size2 = r - (m + 1) + 1;

		// Allocate temp array for both the size
		int L[] = new int[size1];
		int R[] = new int[size2];

		// place the data in these 2 arrays
		for (int i = 0; i < size1; ++i)
			L[i] = arr[i];

		for (int j = 0; j < size2; ++j)
			R[j] = arr[m + 1 + j];

		int i = 0, j = 0, k = l;
		while (i < size1 && j < size2) {
			if (L[i] < R[j]) {
				arr[k] = L[i];
				++k;
				++i;
			} else {
				arr[k] = R[j];
				++k;
				++j;
			}
		}

		while (i < size1) {
			arr[k] = L[i];
			++k;
			++i;
		}

		while (j < size2) {
			arr[k] = R[j];
			++k;
			++j;
		}
	}

	public static void sort(int arr[], int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;
			sort(arr, l, m);
			sort(arr, m + 1, r);
			merge(arr, l, m, r);
		}
	}
}

class SortSubArray {
	public static void findMinLengthUnsortedArray(int[] arr, int[] startAndIndex) {
		// startAndIndex[0] = 3;
		// startAndIndex[1] = 8;
		// 0 1 2 3 4 5 6 7 8 9 10
		// {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60}
		startAndIndex[0] = 0;
		startAndIndex[1] = arr.length - 1;
		for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
			if (i > 0) {
				if (arr[i] < arr[i - 1] && startAndIndex[0] == 0) {
					startAndIndex[0] = i - 1;
				}
			}

			if (j < arr.length - 1) {
				if (arr[j] > arr[j + 1] && startAndIndex[1] == (arr.length - 1)) {
					startAndIndex[1] = (j + 2 < arr.length) ? j + 2 : arr.length - 1;
				}
			}

			if (arr[i] > arr[j]) {
				startAndIndex[0] = (i - 1 < 0) ? 0 : i - 1;
				startAndIndex[1] = j;
				break;
			}
		}
		
		// find the MIN and MAX of the subarray
		int min = startAndIndex[0], max = startAndIndex[1];
		for (int i = startAndIndex[0]; i <= startAndIndex[1]; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
			if (arr[i] > max) {
				max = arr[i];
			}
		}

		//check before subarray subarray doent have greater than min 
		for (int i = 0; i < startAndIndex[0]; i++) {
			if (arr[i] > min) {
				startAndIndex[0] = i;
				break;
			}
		}
		
		//check after subarray doenat have small than max
		for (int i = arr.length-1; i > startAndIndex[1]; i--) {
			if (arr[i] < max) {
				startAndIndex[1] = i;
				break;
			}
		}
	}
}

public class Sort {
	public static void main(String[] args) {

		int[] arr = { 2, 3, 1, 6, 10, 12 };
		BubbleSort.sort(arr);
		// System.out.println(Arrays.toString(arr));

		int[] arr2 = { 2, 1, 4, 3, 7, 9, 6 };
		System.out.println("Orig: " + Arrays.toString(arr2));
		QuickSort.sort(arr2, 0, arr2.length - 1);
		System.out.println(Arrays.toString(arr2));

		int[] arr3 = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println("Orig: " + Arrays.toString(arr3));
		QuickSort.sort(arr3, 0, arr3.length - 1);
		System.out.println(Arrays.toString(arr3));

		int[] arr4 = { 7, 6, 5, 4, 3, 2, 1 };
		System.out.println("Orig: " + Arrays.toString(arr4));
		QuickSort.sort(arr4, 0, arr4.length - 1);
		System.out.println(Arrays.toString(arr4));

		int[] arr5 = { 7, 6, 5, 4, 3, 2, 1 };
		System.out.println("Orig: " + Arrays.toString(arr5));
		MergeSort.sort(arr5, 0, arr5.length - 1);
		System.out.println(Arrays.toString(arr5));

		int[] arr6 = { 10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60 };
		//int[] arr6 = { 10, 12, 20, 30, 25, 2, 32, 31, 35, 50, 60 };
		//int[] arr6 = {0, 1, 15, 25, 6, 7, 30, 40, 50};
		System.out.println("Orig: " + Arrays.toString(arr6));
		int[] startAndEndIndex = new int[2];
		SortSubArray.findMinLengthUnsortedArray(arr6, startAndEndIndex);
		System.out.println(Arrays.toString(startAndEndIndex));
		QuickSort.sort(arr6, startAndEndIndex[0], startAndEndIndex[1]);
		System.out.println(Arrays.toString(arr6));
	}
}

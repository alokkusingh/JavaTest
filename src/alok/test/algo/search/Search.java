package alok.test.algo.search;

public class Search {

	public static int binarySearch(int[] arr, int start, int end, int num) {

		if (end >= start) {
			int mid = start + (end - 1) / 2;

			if (arr[mid] == num) {
				return mid;
			}

			if (num < arr[mid]) {
				return binarySearch(arr, start, mid - 1, num);
			}
			
			return binarySearch(arr, mid + 1, end, num);	
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 10 };
		System.out.println(binarySearch(arr, 0, arr.length - 1, 2));
		System.out.println(binarySearch(new int[]{1,2,3}, 0, 2, 1));
		System.out.println(binarySearch(new int[]{1}, 0, 0, 1));
	}

}

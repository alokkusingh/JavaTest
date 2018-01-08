package alok.test;

public class OrganizeArray {
	
	static int returnFirst(int a, int b) {
	    return a;
	}
	
	public static void main(String[] args) {
		
		int[] arr = new int[] {1,0,0,0,1,0,1,0,1,0,0,0,0,1,1,1,0};
		System.out.println("Before arranging the array");
		int i = 0;
		int j = arr.length - 1;
		int count = 0;
		
		while (i<j) {
			
			++count;
			if (arr[i] == 0) {
				i++;
				continue;
			}
			
			if (arr[j] == 1) {
				j--;
				continue;
			}
			
			//swap the element
			arr[i] = returnFirst(arr[j], arr[j] = arr[i]);
			
			i++;
			j--;
		}
		
		System.out.println("After arranging the array, number of elements:" + arr.length + ", number of iter: " + count);
		for(int k: arr) {
			System.out.println(k);
		}


	}

}

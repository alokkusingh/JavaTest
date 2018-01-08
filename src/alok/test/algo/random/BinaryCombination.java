package alok.test.algo.random;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class GenerateBinary {
	static Integer[] A;
	static {
	    A = new Integer[10];
	}
	
	public static void Binary(final  int n) {
		if (n < 1) {
			System.out.println(Arrays.toString(A));
			return;
		}
		
		A[n-1] = 0;
		Binary(n-1);
		
		A[n-1] = 1;
		Binary(n-1);
	}
	
}

class GenerateStringPermutation {
	char[] strCombination;
	Character[] uniqueChars;
	static int permutaioncount;
	
	public GenerateStringPermutation(String str) {
		strCombination = str.toCharArray();
		uniqueChars = getUniqueCharArray(str);		
	}
	
	private void generatePermutaion(int n) {
		if (n < 1) {
			System.out.println(Arrays.toString(strCombination));
			++permutaioncount;
			return ;
		}
		
		for (char ch : uniqueChars) {
			strCombination[n-1] = ch;
			generatePermutaion(n-1);
		}
	}
	
	public int printPermutation() {
		generatePermutaion(strCombination.length); 
		return permutaioncount;
	}
	
	private Character[] getUniqueCharArray(String str) {
		
		Set<Character> uniqueSet = new HashSet<>();
		for (char ch : str.toCharArray()) {
			uniqueSet.add(ch);
		}
		
		return uniqueSet.toArray(new Character[0]);
	}
}

public class BinaryCombination {

	public static void main(String[] args) {
		GenerateBinary.Binary(10);
		
		GenerateStringPermutation stringPermutaion = new GenerateStringPermutation("aloks");
		System.out.println("Number of Permutaions And Cobinations: " + stringPermutaion.printPermutation());
	}

}

package alok.test.bit;

public class MyTest {

	static boolean bitIsSet (int number, int bit) {

		if (((number>>(bit-1)) % 2) == 1) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println("48 has 3rd bit set: " + bitIsSet(48, 3));
		System.out.println("1 has 3rd bit set: " + bitIsSet(1, 3));
		System.out.println("2 has 3rd bit set: " + bitIsSet(2, 3));
		System.out.println("3 has 3rd bit set: " + bitIsSet(3, 3));
		System.out.println("5 has 3rd bit set: " + bitIsSet(5, 3));
		System.out.println("7 has 3rd bit set: " + bitIsSet(7, 3));
		System.out.println("8 has 3rd bit set: " + bitIsSet(8, 3));
		System.out.println("9 has 3rd bit set: " + bitIsSet(9, 3));
		System.out.println("10 has 3rd bit set: " + bitIsSet(10, 3));
		System.out.println("11 has 3rd bit set: " + bitIsSet(11, 3));
		System.out.println("12 has 3rd bit set: " + bitIsSet(12, 3));
	}

}

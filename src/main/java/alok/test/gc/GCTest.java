package alok.test.gc;

public class GCTest {

	static int[] arr = new int[2*1024*1024]; //8 MB  -> 2 MB x 4 byte
	public static void main(String[] args)
	{
		System.out.println("GCTest");
	}
}

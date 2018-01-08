package alok.test.string;

public class MyMatch {

	static final String KEYSPACE = "cassaeconet";
	public static void main(String[] args) {
		String col = "cassaeconet.otp_data";
		System.out.println(col.matches("^" + KEYSPACE + ".*"));
	}
}

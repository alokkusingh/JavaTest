package alok.test;

import java.text.*;
import java.util.Locale;

public class NumberFormatTest {
	public static void main(String[] args) throws ParseException {
		String[] sa = { "111.234", "222.5678" };
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		for (String s : sa) {
			System.out.println("Without Format: " + nf.parse(s));
			System.out.println("With Format: "+ nf.format(nf.parse(s)));
			
		}
	}
}

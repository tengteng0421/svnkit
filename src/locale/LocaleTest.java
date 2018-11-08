package locale;

import java.text.NumberFormat;
import java.util.Locale;

public class LocaleTest {
	public static void main(String[] args) {

		Locale l = new Locale("zh", "cn");
		String country = l.getDisplayCountry();
		System.out.println(country);
		NumberFormat format = NumberFormat.getCurrencyInstance(l);
		String format2 = format.format(123.45);
		System.out.println(format2);
	}

}

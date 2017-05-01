package TapAeConverter.AeConverter;

public class BaseConverter extends Converter {

	public BaseConverter(int base) {
		super(base);
	}

	public int convert(int n) {
		int number = n;
		StringBuilder r = new StringBuilder();
		while (number > 0) {
			r.insert(0, number % base);
			number = number / base;
		}
		if (r.length() == 0) {
			r.insert(0, 0);
		}
		return Integer.parseInt(r.toString());
	}

}

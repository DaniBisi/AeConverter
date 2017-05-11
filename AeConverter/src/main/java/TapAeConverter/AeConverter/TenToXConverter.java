package TapAeConverter.AeConverter;

public class TenToXConverter extends Converter {

	public TenToXConverter(int base) {
		super(base);
	}

	public String convert(int n) {
		int number = n;
		StringBuilder r = new StringBuilder();
		while (number > 0) {
			int val = number % base;
			if(val>9){ 
				
				r.insert(0, (char)(val+55));
			}
			else{
				r.insert(0, number % base);
			}
			number = number / base;
		}
		if (r.length() == 0) {
			r.insert(0, 0);
		}
		return r.toString();
	}

}

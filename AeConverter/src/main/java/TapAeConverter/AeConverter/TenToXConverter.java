package TapAeConverter.AeConverter;

import java.util.ArrayList;

public class TenToXConverter extends Converter {
	
	public TenToXConverter(int base) {
		super(base);
	}

	public String convert(int n) {
		int number = n;
		StringBuilder r = new StringBuilder();
		StringBuilder stepsB = new StringBuilder();
		
		while (number > 0) {
			stepsB.setLength(0);
			int val = number % base;
			stepsB.append(number);
			stepsB.append("%");
			stepsB.append(base);
			stepsB.append(" = ");
			if(val>9){ 	
				r.insert(0, (char)(val+55));
				stepsB.append((char)(val+55));
			}
			else{
				r.insert(0, val);
				stepsB.append(val);
			}
			number = number / base;
			steps.add(stepsB.toString());
		}
		if (r.length() == 0) {
			r.insert(0, 0);
		}
		return r.toString();
	}

}

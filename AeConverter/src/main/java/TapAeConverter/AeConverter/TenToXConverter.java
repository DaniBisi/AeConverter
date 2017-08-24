package TapAeConverter.AeConverter;

import java.util.ArrayList;

public class TenToXConverter extends Converter {
	StringBuilder r;
	StringBuilder stepsB;
	int startIndex;
	public TenToXConverter(int base) {
		super(base);
		r= new StringBuilder();
		stepsB= new StringBuilder();
		startIndex = 0;
	}

	public String convert(int n) {
		int number = n;

		if(number<0){
				r.insert(0,"-");
				number = -number ;
				startIndex = 1;
			}
		if (n == 0) {
			r.insert(0, 0);
		}
		else {
			
			convertNotNullNotZero(number);
		}
		
		return r.toString();
	}
	
	private void convertNotNullNotZero(int number){
		int n = number;
		while (n > 0) {
			stepsB.setLength(0);
			int val = n % base;
			stepsB.append(n);
			stepsB.append("%");
			stepsB.append(base);
			stepsB.append(" = ");
			if(val>9){ 	
				val = val + 55;
				r.insert(startIndex, (char)(val));
				stepsB.append((char)(val));
			}
			else{
				r.insert(startIndex, val);
				stepsB.append(val);
			}
			n = n / base;
			steps.add(stepsB.toString());
		}
	}

}

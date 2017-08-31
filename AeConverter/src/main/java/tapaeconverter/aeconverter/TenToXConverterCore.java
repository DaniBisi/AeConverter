package tapaeconverter.aeconverter;

public class TenToXConverterCore extends ConverterCore {
	StringBuilder r;
	StringBuilder stepsB;
	int startIndex;
	public TenToXConverterCore(int base) {
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
			stepsB.setLength(0);
			stepsB.append(n);
			stepsB.append("%");
			stepsB.append(base);
			stepsB.append(" = ");
			stepsB.append("0");
			steps.add(stepsB.toString());
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

package TapAeConverter.AeConverter;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.google.common.math.*;

public class XtoTenConverter extends Converter {

	private static final Logger LOGGER = LogManager.getLogger(XtoTenConverter.class);

	public XtoTenConverter(int base) {
		super(base);
	}

	public int getBase() {
		return base;
	}

	public String deConvert(String n) {
		String number = n;
		int nLenght = number.length()-1;
		int i = nLenght;
		Integer sum = 0;
		while (i >= 0) {
			if (Character.getNumericValue(n.charAt(i)) >= base) {
				throw new IllegalArgumentException();
			}
			int val = Character.getNumericValue(n.charAt(i));
			sum = sum + val * IntMath.pow(base, nLenght - i);
			i = i - 1;
		}
		return sum.toString();
	}

}

package TapAeConverter.AeConverter;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class BaseDeConverter extends Converter{

	private static final Logger LOGGER = LogManager.getLogger(BaseDeConverter.class);
	
	public BaseDeConverter(int base) {
		super(base);
	}

	public int getBase() {
		return base;
	}

	public int deConvert(int n) {
		int number = n;
		int r;
		int sum = 0;
		int position = 0;
		while (number > 0) {	
			r = number % 10;
			if(r>=base){
				LOGGER.error("CIFRA MAGGIORE DELLA BASE");
				throw new IllegalArgumentException();
			}
			sum = (int) (sum + r*(Math.pow(base, position)));
			LOGGER.info("Passagio:" + position+ "Somma:"+ sum);
			number = number / 10;
			position = position +1;
		}
		return sum;
	}

}

package TapAeConverter.AeConverter;

import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.google.common.math.*;

public class XtoTenConverter extends Converter {

	private static final Logger LOGGER = LogManager.getLogger(XtoTenConverter.class);
	private StringBuilder resultsB;
	private CheckSymbol checkSymbol;
	public XtoTenConverter(int base,CheckSymbol cSymbol) {
		super(base);
		resultsB= new StringBuilder();
		checkSymbol = cSymbol;
		BasicConfigurator.resetConfiguration();
		BasicConfigurator.configure();
	}

	public int getBase() {
		return base;
	}

	public String deConvert(String n) {
		int nLenght = n.length()-1;
		int i = nLenght;
		Integer sum = 0;
		if(!checkSymbol.checkSymbols(n, base)){
			LOGGER.error("IllegalArgumentEception: Character not found in dictionary");
			throw new IllegalArgumentException();
		}
		while (i >= 0) {
			resultsB.setLength(0);
			int val = Character.getNumericValue(n.charAt(i));
			resultsB.append(val);
			resultsB.append("*(");
			resultsB.append(this.base);
			resultsB.append("^");
			resultsB.append( nLenght - i);
			resultsB.append(")");
			steps.add(resultsB.toString());
			sum = sum + val * IntMath.pow(base, nLenght - i);
			i = i - 1;
		}
		return sum.toString();
	}

}

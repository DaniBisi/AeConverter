package TapAeConverter.AeConverter;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.google.common.math.*;

public class XtoTenConverter extends Converter {

	private static final Logger LOGGER = LogManager.getLogger(XtoTenConverter.class);
	private String results;
	private CheckSymbol checkSymbol;
	public XtoTenConverter(int base,CheckSymbol cSymbol) {
		super(base);
		results ="";
		checkSymbol = cSymbol;
		BasicConfigurator.resetConfiguration();
		BasicConfigurator.configure();
	}

	public int getBase() {
		return base;
	}

	public String deConvert(String n) {
		StringBuilder resultsB= new StringBuilder();
		int nLenght = n.length()-1;
		int i = nLenght;
		Integer sum = 0;
		if(!checkSymbol.checkSymbols(n, base)){
			LOGGER.error("IllegalArgumentEception: Character not found in dictionary");
			throw new IllegalArgumentException();
		}
		while (i >= 0) {
			int val = Character.getNumericValue(n.charAt(i));
			if(i!=nLenght){
				resultsB.append("+");
			}
			resultsB.append(val);
			resultsB.append("*(10^");
			resultsB.append( nLenght - i);
			resultsB.append(")");
			sum = sum + val * IntMath.pow(base, nLenght - i);
			i = i - 1;
		}
		results = resultsB.toString();
		return sum.toString();
	}

	public String getStepByStep() {
		return results;
	}

}

package tapaeconverter.aeconverter;

import java.util.Map;

public class CheckSymbolCore {

	protected Map<String, Integer> dictionarySym;

	public CheckSymbolCore(Map<String, Integer> dictionarySym) {
		this.dictionarySym = dictionarySym;
	}

	public boolean checkSymbols(String strToCheck, int base) {
		return checkBase(base) && checkDigit(strToCheck, base);
	}

	protected boolean checkDigit(String strToCheck, int base) {
		String digit;
		for (int i = 0; i < strToCheck.length(); i++) {
			digit = strToCheck.substring(i, i + 1);
			Integer result = dictionarySym.get(digit);
			if ((result == null) || result >= base) {
				return false;
			}
		}
		return true;
	}

	public void setDictionarySym(Map<String, Integer> dS) {
		dictionarySym = dS;

	}

	protected boolean checkBase(int base) {
		return base > 0 && base < 17;
	}

}

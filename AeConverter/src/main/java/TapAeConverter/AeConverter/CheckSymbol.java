package TapAeConverter.AeConverter;

import java.util.Map;


public class CheckSymbol {

	private Map<String, Integer> dictionarySym;

	public CheckSymbol(Map<String, Integer> dictionarySym) {
		this.dictionarySym = dictionarySym;
	}

	public boolean checkSymbols(String strToCheck, int base) {
		if(base<0 || base>16){
			return false;
		}
		for(int i=0; i<strToCheck.length();i++){
			String digit = strToCheck.substring(i, i+1);
			Integer result = dictionarySym.get(digit);
			if((!("0".equals(digit)) && result == null) || result>= base) {
				return false ;
			}
		}
		return true;
	}

}

package TapAeConverter.AeConverter;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestCheckSymbol {
	private Map<String, Integer> DictionarySym;
	private CheckSymbol s1;
	private String strToCheck;
	private int base;

	public TestCheckSymbol() {
		DictionarySym = new HashMap<String,Integer>();
		DictionarySym.put("0", 0);
		DictionarySym.put("1", 1);
		DictionarySym.put("2", 2);
		DictionarySym.put("3", 3);
		DictionarySym.put("4", 4);
		DictionarySym.put("5", 5);
		DictionarySym.put("6", 6);
		DictionarySym.put("7", 7);
		DictionarySym.put("8", 8);
		DictionarySym.put("9", 9);
		DictionarySym.put("A", 10);
		DictionarySym.put("B", 11);
		DictionarySym.put("C", 12);
		DictionarySym.put("D", 13);
		DictionarySym.put("E", 14);
		DictionarySym.put("F", 15);
		s1 = new CheckSymbol(DictionarySym);
	}

	
	@Test
	public void test0() {
		strToCheck = "0";
		base = 2;
		assertEquals(true, s1.checkSymbols(strToCheck, base));
	}
	@Test
	public void testSymbol(){
		strToCheck = "2";
		base = 2;
		assertEquals(false, s1.checkSymbols(strToCheck, base));
	}

	@Test
	public void testSymbolMoreThanOneDigit(){
		strToCheck = "24";
		base = 5;
		assertEquals(true, s1.checkSymbols(strToCheck, base));
	}
	@Test
	public void testNegative() {
		strToCheck = "0";
		base = -1;
		assertEquals(false, s1.checkSymbols(strToCheck, base));
	}
	@Test
	public void testExcedeLimit() {
		strToCheck = "0";
		base = 17;
		assertEquals(false, s1.checkSymbols(strToCheck, base));
	}

	@Test
	public void testExcedeLimitMoreThanOneChar() {
		strToCheck = "0W";
		base = 17;
		assertEquals(false, s1.checkSymbols(strToCheck, base));
	}

}

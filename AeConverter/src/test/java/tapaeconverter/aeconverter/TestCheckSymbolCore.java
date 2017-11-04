package tapaeconverter.aeconverter;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import tapaeconverter.aeconverter.CheckSymbolCore;

import java.util.HashMap;
//import java.util.HashMap;
import java.util.Map;

public class TestCheckSymbolCore {
	private Map<String, Integer> DictionarySym;
	private CheckSymbolCore s1;
	private String strToCheck;
	private int base;

	public TestCheckSymbolCore() {

		DictionarySym = mock(Map.class);
		s1 = new CheckSymbolCore(DictionarySym);
	}

	@Test
	public void test0() {
		strToCheck = "0";
		base = 2;
		when(DictionarySym.get(anyString())).thenReturn(0);
		assertEquals(true, s1.checkDigit(strToCheck, base));
	}

	@Test
	public void testSymbol() {
		strToCheck = "2";
		base = 2;
		when(DictionarySym.get(anyString())).thenReturn(2);
		assertEquals(false, s1.checkDigit(strToCheck, base));
	}

	@Test
	public void testSymbolMoreThanOneDigit() {
		strToCheck = "24";
		base = 5;
		when(DictionarySym.get(anyString())).thenReturn(2, 4);
		assertEquals(true, s1.checkDigit(strToCheck, base));
	}

	@Test
	public void testExcedeLimitMoreThanOneChar() {
		strToCheck = "0W";
		base = 16;
		when(DictionarySym.get(anyString())).thenReturn(0);
		when(DictionarySym.get(anyString())).thenReturn(null);
		assertEquals(false, s1.checkSymbols(strToCheck, base));
	}

	@Test
	public void testCheckSymbolOk() {
		strToCheck = "5";
		base = 16;
		when(DictionarySym.get(anyString())).thenReturn(5);
		assertEquals(true, s1.checkSymbols(strToCheck, base));
	}

	@Test
	public void testCheckSymbolWrongBase() {
		strToCheck = "5";
		base = 17;
		when(DictionarySym.get(anyString())).thenReturn(5);
		assertEquals(false, s1.checkSymbols(strToCheck, base));
	}

	@Test
	public void testCheckSymbolWrongString() {
		strToCheck = "6";
		base = 5;
		when(DictionarySym.get(anyString())).thenReturn(6);
		assertEquals(false, s1.checkSymbols(strToCheck, base));
	}

	// #################### TestCheckBase ###############
	@Test
	public void testCheckBaseExceedUnderLimitFalse() {
		base = 0;
		assertEquals(false, s1.checkBase(base));
	}

	@Test
	public void testCheckBaseExceedUpperLimit() {
		base = 17;
		assertEquals(false, s1.checkBase(base));
	}

	@Test
	public void testCheckBaseUpperLimit() {
		base = 16;
		assertEquals(true, s1.checkBase(base));
	}

	@Test
	public void testCheckBaseUnderLimit() {
		base = 1;
		assertEquals(true, s1.checkBase(base));
	}
	
	
	// ################# End Test CheckBase ####################
	

	@Test
	public void testSetDictionary(){
		Map<String, Integer> dS;
		dS = new HashMap<>();
		dS.put("test", 1);
		s1.setDictionarySym(dS);
		assertEquals(dS, s1.dictionarySym);
	}
}

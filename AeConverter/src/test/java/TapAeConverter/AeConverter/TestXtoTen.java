package TapAeConverter.AeConverter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

public class TestXtoTen {
	private XtoTenConverter b1;
	private CheckSymbol c1;
	public TestXtoTen() {
		this.c1 = mock(CheckSymbol.class);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testConstructor() {
		setUpBaseConverter(1,true);
		assertEquals(1, b1.getBase());
	}

	@Test
	public void testBase2Zero() {
		setUpBaseConverter(2,true);
		String n= "0";
		assertEquals("0", b1.deConvert(n));
	}

	@Test
	public void testBase2one() {
		setUpBaseConverter(2,true);
		String n= "1";
		assertEquals("1", b1.deConvert(n));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testWrongNumber() {
		setUpBaseConverter(2,false);
		String n= "201";
		b1.deConvert(n);
	}
	@Test
	public void testBase2NotZeroNotOne() {
		setUpBaseConverter(2,true);
		String n= "101";
		assertEquals("5", b1.deConvert(n));
	}
	@Test
	public void testBase5NotZeroNotOne() {
		setUpBaseConverter(5,true);
		String n= "23";
		assertEquals("13", b1.deConvert(n));
	}

	@Test
	public void testBase16() {
		setUpBaseConverter(16,true);
		String n= "AF";
		assertEquals("175", b1.deConvert(n));
	}@Test
	public void testBase13() {
		setUpBaseConverter(13,true);
		String n= "AB";
		assertEquals("141", b1.deConvert(n));
	}


	public void setUpBaseConverter(int n,boolean mockResponse) {
		when(c1.checkSymbols(anyString(), anyInt())).thenReturn(mockResponse);
		this.b1 = new XtoTenConverter(n,c1);
	}
	@Test
	public void testStepByStepZero(){
		setUpBaseConverter(13,true);
		ArrayList<String> steps= new ArrayList<String>();
		steps.add("0*(13^0)");
		String n = "0";
		b1.deConvert(n);
		assertEquals(steps, b1.getStepByStep());
	}
	@Test
	public void testStepByStepMoreDigitNumber(){
		setUpBaseConverter(13,true);
		setUpBaseConverter(13,true);
		ArrayList<String> steps= new ArrayList<String>();
		steps.add("11*(13^0)");
		steps.add("10*(13^1)");
		String n = "AB";
		b1.deConvert(n);
		assertEquals(steps, b1.getStepByStep());
		
	}
}

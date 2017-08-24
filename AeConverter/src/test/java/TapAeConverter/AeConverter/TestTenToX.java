package TapAeConverter.AeConverter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TestTenToX {

	@Test
	public void testConverter0(){
		int n = 0;
		int base = 5;
		TenToXConverter b1 = new TenToXConverter(base);
		assertEquals("0", b1.convert(n));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testBase0(){
		int n = 0;
		int base = 0;
		TenToXConverter b1 = new TenToXConverter(base);
		assertEquals("0", b1.convert(n));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testBase1(){
		int n = 0;
		int base = 1;
		TenToXConverter b1 = new TenToXConverter(base);
		assertEquals("0", b1.convert(n));
	}
	@Test
	public void testConverter1(){
		int n = 1;
		int base = 4;
		TenToXConverter b1 = new TenToXConverter(base);
		assertEquals("1", b1.convert(n));
	}
	@Test
	public void testConverter(){
		int n = 12;
		int base = 4;
		TenToXConverter b1 = new TenToXConverter(base);
		assertEquals("30", b1.convert(n));
	}
	@Test
	public void testNumberEqual0(){
		int n = 0;
		int base = 4;
		TenToXConverter b1 = new TenToXConverter(base);
		assertEquals("0", b1.convert(n));
	}
	@Test
	public void testCharAddiction(){
		int n = 100;
		int base = 15;
		TenToXConverter b1 = new TenToXConverter(base);
		assertEquals("6A", b1.convert(n));
	}
	@Test
	public void testModulusNine(){
		int n = 117;
		int base = 12;
		TenToXConverter b1 = new TenToXConverter(base);
		assertEquals("99", b1.convert(n));
	}
	@Test
	public void testNegative(){
		int n = -1;
		int base = 4;
		TenToXConverter b1 = new TenToXConverter(base);
		assertEquals("-1", b1.convert(n));
	}
	@Test
	public void testConverterBaseDestBigger(){
		int n = 12;
		int base = 12;
		TenToXConverter b1 = new TenToXConverter(base);
		assertEquals("10", b1.convert(n));
	}
	
	@Test
	public void testConverterA(){
		int n = 15;
		int base = 16;
		TenToXConverter b1 = new TenToXConverter(base);
		assertEquals("F", b1.convert(n));
	}
	@Test
	public void testConverterBigNumber(){
		int n = 2634;
		int base = 16;
		TenToXConverter b1 = new TenToXConverter(base);
		assertEquals("A4A", b1.convert(n));
	}
	@Test(expected = IllegalArgumentException.class)
	public void testConverterWrongBase(){
		int n = 12;
		int base = -1;
		TenToXConverter b1 = new TenToXConverter(base);
		b1.convert(n);
	}
	@Test
	public void testStep(){
		int n = 12;
		int base = 12;
		TenToXConverter b1= new TenToXConverter(base);
		ArrayList<String> steps= new ArrayList<String>();
		steps.add("12%12 = 0");
		steps.add("1%12 = 1");
		b1.convert(n);
		assertEquals(steps, b1.getStepByStep());
		
	}
}

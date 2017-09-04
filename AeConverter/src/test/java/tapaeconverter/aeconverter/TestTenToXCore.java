package tapaeconverter.aeconverter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import tapaeconverter.aeconverter.TenToXConverterCore;

public class TestTenToXCore extends TestConverterCore {

	@Test
	public void testConverter0() {
		int n = 0;
		int base = 5;
		TenToXConverterCore b1 = new TenToXConverterCore(base);
		assertEquals("0", b1.convert(n));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testBase0() {
		int n = 0;
		int base = 0;
		TenToXConverterCore b1 = new TenToXConverterCore(base);
		assertEquals("0", b1.convert(n));
	}

	@Test
	public void testConverter1() {
		int n = 1;
		int base = 4;
		TenToXConverterCore b1 = new TenToXConverterCore(base);
		assertEquals("1", b1.convert(n));
	}

	@Test
	public void testConverter() {
		int n = 12;
		int base = 4;
		TenToXConverterCore b1 = new TenToXConverterCore(base);
		assertEquals("30", b1.convert(n));
	}

	@Test
	public void testNumberEqual0() {
		int n = 0;
		int base = 4;
		TenToXConverterCore b1 = new TenToXConverterCore(base);
		assertEquals("0", b1.convert(n));
	}

	@Test
	public void testNumberEqual0Size() {
		int n = 0;
		int base = 4;
		TenToXConverterCore b1 = new TenToXConverterCore(base);
		b1.convert(n);
		assertEquals(1, b1.getStepByStep().size());
	}

	@Test
	public void testCharAddiction() {
		int n = 100;
		int base = 15;
		TenToXConverterCore b1 = new TenToXConverterCore(base);
		assertEquals("6A", b1.convert(n));
	}

	@Test
	public void testModulusNine() {
		int n = 117;
		int base = 12;
		TenToXConverterCore b1 = new TenToXConverterCore(base);
		assertEquals("99", b1.convert(n));
	}

	@Test
	public void testNegative() {
		int n = -1;
		int base = 4;
		TenToXConverterCore b1 = new TenToXConverterCore(base);
		assertEquals("-1", b1.convert(n));
	}

	@Test
	public void testConverterBaseDestBigger() {
		int n = 12;
		int base = 12;
		TenToXConverterCore b1 = new TenToXConverterCore(base);
		assertEquals("10", b1.convert(n));
	}

	@Test
	public void testConverterA() {
		int n = 15;
		int base = 16;
		TenToXConverterCore b1 = new TenToXConverterCore(base);
		assertEquals("F", b1.convert(n));
	}

	@Test
	public void testConverterBigNumber() {
		int n = 2634;
		int base = 16;
		TenToXConverterCore b1 = new TenToXConverterCore(base);
		assertEquals("A4A", b1.convert(n));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConverterWrongBase() {
		int n = 12;
		int base = -1;
		TenToXConverterCore b1 = new TenToXConverterCore(base);
		b1.convert(n);
	}

	@Test
	public void testStep() {
		int n = 12;
		int base = 12;
		TenToXConverterCore b1 = new TenToXConverterCore(base);
		ArrayList<String> steps = new ArrayList<String>();
		steps.add("12%12 = 0");
		steps.add("1%12 = 1");
		b1.convert(n);
		assertEquals(steps, b1.getStepByStep());

	}
}

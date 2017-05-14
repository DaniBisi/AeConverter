package TapAeConverter.AeConverter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestXtoTen {
	private XtoTenConverter b1;

	@Test
	public void testConstructor() {
		setUpBaseConverter(1);
		assertEquals(1, b1.getBase());
	}

	@Test
	public void testBase2Zero() {
		setUpBaseConverter(2);
		String n= "0";
		assertEquals("0", b1.deConvert(n));
	}

	@Test
	public void testBase2one() {
		setUpBaseConverter(2);
		String n= "1";
		assertEquals("1", b1.deConvert(n));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testWrongNumber() {
		setUpBaseConverter(2);
		String n= "201";
		b1.deConvert(n);
	}
	@Test
	public void testBase2NotZeroNotOne() {
		setUpBaseConverter(2);
		String n= "101";
		assertEquals("5", b1.deConvert(n));
	}
	@Test
	public void testBase5NotZeroNotOne() {
		setUpBaseConverter(5);
		String n= "23";
		assertEquals("13", b1.deConvert(n));
	}

	@Test
	public void testBase16() {
		setUpBaseConverter(16);
		String n= "AF";
		assertEquals("175", b1.deConvert(n));
	}@Test
	public void testBase13() {
		setUpBaseConverter(13);
		String n= "AB";
		assertEquals("141", b1.deConvert(n));
	}


	public void setUpBaseConverter(int n) {
		this.b1 = new XtoTenConverter(n);
	}
}
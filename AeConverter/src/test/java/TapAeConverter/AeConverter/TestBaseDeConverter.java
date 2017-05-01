package TapAeConverter.AeConverter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestBaseDeConverter {
	private BaseDeConverter b1;

	@Test
	public void testConstructor() {
		setUpBaseConverter(1);
		assertEquals(1, b1.getBase());
	}

	@Test
	public void testBase2Zero() {
		setUpBaseConverter(2);
		int n = 0;
		assertEquals(0, b1.deConvert(n));
	}

	@Test
	public void testBase2one() {
		setUpBaseConverter(2);
		int n = 1;
		assertEquals(1, b1.deConvert(n));
	}
	@Test(expected=IllegalArgumentException.class)
	public void testWrongNumber() {
		setUpBaseConverter(2);
		int n = 201;
		b1.deConvert(n);
	}
	@Test
	public void testBase2NotZeroNotOne() {
		setUpBaseConverter(2);
		int n = 101;
		assertEquals(5, b1.deConvert(n));
	}
	@Test
	public void testBase5NotZeroNotOne() {
		setUpBaseConverter(5);
		int n = 23;
		assertEquals(13, b1.deConvert(n));
	}

	public void setUpBaseConverter(int n) {
		this.b1 = new BaseDeConverter(n);
	}
}

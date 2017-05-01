package TapAeConverter.AeConverter;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestBaseConverter {

	@Test
	public void testConverter0(){
		int n = 0;
		int base = 5;
		BaseConverter b1 = new BaseConverter(base);
		assertEquals(0, b1.convert(n));
	}
	@Test
	public void testConverter1(){
		int n = 12;
		int base = 4;
		BaseConverter b1 = new BaseConverter(base);
		assertEquals(30, b1.convert(n));
	}
	@Test
	public void testConverter(){
		int n = 12;
		int base = 4;
		BaseConverter b1 = new BaseConverter(base);
		assertEquals(30, b1.convert(n));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConverterWrongBase(){
		int n = 12;
		int base = -1;
		BaseConverter b1 = new BaseConverter(base);
		b1.convert(n);
	}
}

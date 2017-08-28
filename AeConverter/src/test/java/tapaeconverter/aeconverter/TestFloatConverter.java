package tapaeconverter.aeconverter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tapaeconverter.aeconverter.BinaryFloatConverter;

public class TestFloatConverter {

	@Test
	public void testZero(){
		float n = 0.0f;
		BinaryFloatConverter f1 = new BinaryFloatConverter();
		assertEquals("00000000000000000000000000000000", f1.convert(n));
	}
}

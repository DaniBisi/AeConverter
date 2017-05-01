package TapAeConverter.AeConverter;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFloatConverter {

	@Test
	public void testZero(){
		float n = 0.0f;
		BinaryFloatConverter f1 = new BinaryFloatConverter();
		assertEquals("00000000000000000000000000000000", f1.convert(n));
	}
}

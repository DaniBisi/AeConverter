package tapaeconverter.aeconverter;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import tapaeconverter.aeconverter.ConverterCore;

public abstract class TestConverterCore {
	private class ConcreteConverter extends ConverterCore {
		public ConcreteConverter(int base) {
			super(base);
		}
	};

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorBase1() {
		ConverterCore p1 = new ConcreteConverter(0);
	}

	@Test
	public void testConstructor() {
		ConverterCore p1 = new ConcreteConverter(1);
		assert (true);
	}
}

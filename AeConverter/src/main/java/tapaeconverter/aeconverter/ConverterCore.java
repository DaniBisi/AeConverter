package tapaeconverter.aeconverter;

import java.util.ArrayList;
import java.util.List;

public abstract class ConverterCore {
	protected int base;
	protected List<String> steps;

	public ConverterCore(int base) {
		steps = new ArrayList<>();
		setBase(base);
	}

	public ConverterCore() {
		steps = new ArrayList<>();
	}

	public void setBase(int base) {
		checkBase(base);
		this.base = base;
	}

	protected void checkBase(int base) {
		if (base < 1) {
			throw new IllegalArgumentException();
		}
	}

	public List<String> getStepByStep() {
		return steps;
	}
}

package TapAeConverter.AeConverter;

import java.util.ArrayList;
import java.util.List;

public abstract class Converter {
	protected int base;
	protected List<String> steps;
	public Converter(int base) {
		steps=new ArrayList<>();
		if (base <= 1) {
			throw new IllegalArgumentException();
		}
		this.base = base;
	}
	public List<String> getStepByStep() {
		return steps;
	}
}

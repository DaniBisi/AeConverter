package TapAeConverter.AeConverter;

import java.util.ArrayList;

public abstract class Converter {
	protected int base;
	protected ArrayList<String> steps;
	public Converter(int base) {
		steps=new ArrayList<String>();
		if (base <= 0) {
			throw new IllegalArgumentException();
		}
		this.base = base;
	}
	public ArrayList<String> getStepByStep() {
		return steps;
	}
}

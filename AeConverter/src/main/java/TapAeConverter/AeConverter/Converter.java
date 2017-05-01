package TapAeConverter.AeConverter;

public abstract class Converter {
protected int base;
	public Converter (int base){
		if(base <=0) {
			throw new IllegalArgumentException();
		}
		this.base = base;
	}
}

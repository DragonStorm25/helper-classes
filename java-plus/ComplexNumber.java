public class ComplexNumber {
	private double realNumber = 0.0;
	private double imaginaryNumber = 0.0;

	public ComplexNumber() {}
	
	public ComplexNumber(double real, double i) {
		realNumber = real;
		imaginaryNumber = i;
	}
	
	public String toString() {
		return this.getRealComponent() + (this.getImaginaryComponent() < 0 ? " - ":" + ") + Math.abs(this.getImaginaryComponent()) + "i";
	}
	
	public ComplexNumber add(ComplexNumber c) {
		ComplexNumber ret = ComplexNumber.add(this, c);
		this.setRealComponent(ret.getRealComponent());
		this.setImaginaryComponent(ret.getImaginaryComponent());
		return ret;
	}
	
	public ComplexNumber subtract(ComplexNumber c) {
		ComplexNumber ret = ComplexNumber.subtract(this, c);
		this.setRealComponent(ret.getRealComponent());
		this.setImaginaryComponent(ret.getImaginaryComponent());
		return ret;
	}
	
	public ComplexNumber multiply(ComplexNumber c) {
		ComplexNumber ret = ComplexNumber.multiply(this, c);
		this.setRealComponent(ret.getRealComponent());
		this.setImaginaryComponent(ret.getImaginaryComponent());
		return ret;
	}
	
	public ComplexNumber divide(ComplexNumber c) {
		ComplexNumber ret = ComplexNumber.divide(this, c);
		this.setRealComponent(ret.getRealComponent());
		this.setImaginaryComponent(ret.getImaginaryComponent());
		return ret;
	}
	
	public ComplexNumber conjugate() {
		ComplexNumber ret = ComplexNumber.conjugate(this);
		this.setRealComponent(ret.getRealComponent());
		this.setImaginaryComponent(ret.getImaginaryComponent());
		return ret;
	}
	
	public ComplexNumber getConjugate() {
		return ComplexNumber.conjugate(this);
	}
	
	public static ComplexNumber add(ComplexNumber c1, ComplexNumber c2) {
		return new ComplexNumber(c1.getRealComponent() + c2.getRealComponent(), 
				c1.getImaginaryComponent() + c2.getImaginaryComponent());
	}
	
	public static ComplexNumber subtract(ComplexNumber c1, ComplexNumber c2) {
		return new ComplexNumber(c1.getRealComponent() - c2.getRealComponent(), 
				c1.getImaginaryComponent() - c2.getImaginaryComponent());
	}
	
	public static ComplexNumber multiply(ComplexNumber c1, ComplexNumber c2) {
		double real1 = c1.getRealComponent()*c2.getRealComponent();
		double real2 = -c1.getImaginaryComponent()*c2.getImaginaryComponent();
		double imaginary1 = c1.getRealComponent()*c2.getImaginaryComponent();
		double imaginary2 = c1.getImaginaryComponent()*c2.getRealComponent();
		return new ComplexNumber(real1 + real2, imaginary1 + imaginary2);
	}
	
	public static ComplexNumber divide(ComplexNumber c1, ComplexNumber c2) {
		c1 = c1.multiply(c2.getConjugate());
		c2 = c2.multiply(c2.getConjugate());
		return new ComplexNumber(c1.getRealComponent()/c2.getRealComponent(), c1.getImaginaryComponent()/c2.getRealComponent());
	}
	
	public static ComplexNumber conjugate(ComplexNumber c) {
		return new ComplexNumber(c.getRealComponent(), -c.getImaginaryComponent());
	}
	
	public void setRealComponent(double d) {realNumber = d;}
	public void setImaginaryComponent(double d) {imaginaryNumber = d;}
	public double getRealComponent() {return realNumber;}
	public double getImaginaryComponent() {return imaginaryNumber;}

}

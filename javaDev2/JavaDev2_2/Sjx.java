package JavaDev2_2;

public class Sjx {
	double a;
	double b;
	double c;
	
	public Sjx(double a, double b, double c) throws NotSjxException {
		this.a = a;
		this.b = b;
		this.c = c;	
		
		if (a + b <= c || a + c <= b || b + c <= a) {
			throw new NotSjxException("Unable to build a triangle given the parameter values");
		}
	}
	public double getArea() {
		return a * b * c;
	}
	
	public void showInfo() {
		System.out.println("bla bla bla");
	}
}

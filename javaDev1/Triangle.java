public class Triangle {
	double x = 3;
	double y = 4;
	double a = 0.6;

	public Triangle(double x, double y) {
		this.x = x;
		this.y = y; // this指代的是当前类的。 this.x ：这个类的x ； x ：形参x
	}
	
	public Triangle(double x, double y, double a) {
		this.x = x;
		this.y = y;
		this.a = a;
	}
	
	public double CaArea() {
		return 0.5 * x * y * Math.sin(a);
	}
	
	public double AltAnglePlusCaArea(double a) {
		this.a = a;
		return CaArea();
	}

}

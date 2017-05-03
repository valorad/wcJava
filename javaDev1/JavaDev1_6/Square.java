package JavaDev1_6;

public class Square extends Rectangle {
	double a = 0;
	
	public double getDiagonal() {
		return Math.sqrt(2) * a;
	}
	public double getArea() {
		return a * a;
	}
}

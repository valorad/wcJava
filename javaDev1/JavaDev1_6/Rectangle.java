package JavaDev1_6;

import JavaDev1_6.Shape.DiagArea;

public class Rectangle implements DiagArea {
	double w = 0;
	double h = 0;
	public double getDiagonal() {
		return Math.sqrt(w * w + h * h );
	}
	public double getArea() {
		return w * h;
	}
}

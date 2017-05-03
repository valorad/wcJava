package JavaDev1_5;

public class Rectangle extends Shape {
	double x = 0.0;
	double y = 0.0;
	
	double calculateArea() {
		return x * y;
	}
	 public void showArea(){

		 super.showArea();
    }
}

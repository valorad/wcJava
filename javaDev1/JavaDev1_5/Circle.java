package JavaDev1_5;

public class Circle extends Shape {
	double r = 0.0;
	
	double calculateArea() {

		return r * Math.PI;
	}
	 public void showArea(){
   	     System.out.println("Area = " + calculateArea());
    }
}

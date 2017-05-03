package JavaDev1_5;

public class Square extends Rectangle {
	double a = 0.0;
	
	double calculateArea() {
		
		return a * a;
	}
	 public void showArea(){
   	     System.out.println("Area = " + calculateArea());
    }
}

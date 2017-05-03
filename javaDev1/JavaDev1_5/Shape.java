package JavaDev1_5;

public abstract class Shape {
	abstract double calculateArea();
    public void showArea(){
   	     System.out.println("Area = " + calculateArea());
    }

}

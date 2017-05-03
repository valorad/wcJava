package JavaDev1_6;

public class Program {

	public static void main(String[] args) {
		Rectangle rec = new Rectangle();
		rec.w = 10.6;
		rec.h = 8.8;
		System.out.println("矩形对角线：" + rec.getDiagonal());
		System.out.println("矩形面积：" + rec.getArea());
		
		Square sqr = new Square();
		sqr.a = 666;
		System.out.println("矩形对角线：" + sqr.getDiagonal());
		System.out.println("矩形面积：" + sqr.getArea());
	}

}

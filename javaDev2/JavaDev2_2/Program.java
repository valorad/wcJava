package JavaDev2_2;

import java.util.*;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			double[] edge = new double[3];
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);//Use Scanner to input figures
			
			for (int i = 0; i < 3; i++){
				System.out.println("Please input your edge " + (i + 1));
				edge[i] = in.nextDouble();
			}
			
			Sjx tri = new Sjx(edge[0], edge[1], edge[2]);
			
			System.out.println(tri.getArea());
			tri.showInfo();
			
		}
		catch (NotSjxException n3e){
			//System.out.println(n3e.getMessage());
			n3e.printStackTrace();
		}
		
	}

}

package JavaDev2_3;

import java.util.*;

public class Program {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int a = 0;
		Scanner in = new Scanner(System.in);
		
		
		do {
			System.out.println("Please input a POSITIVE number other than 999");
			a = in.nextInt();
			try {
				regNum num = new regNum(a);
				System.out.println(num.regnum);
			}
			catch (Exception e) {
				System.out.println(e.toString());
			}			
		} while (a != 999);
		
		System.out.println("999 entered, program terminated");
	}
}

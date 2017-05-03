package jd4;


import java.io.Serializable;
import java.awt.Graphics;

public abstract class Geometry implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5360082333159584069L;
	int [][] cords = new int[100][100];
	
	public void draw(Graphics g) {
		try {
			System.out.println("Shape drawing completed");
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
}

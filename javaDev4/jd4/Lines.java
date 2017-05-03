package jd4;

import java.awt.Graphics;

public class Lines extends Geometry {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4434860931797516557L;
	
	@Override
	public void draw(Graphics g) {
		
		try {
			//把已有的字符串型的数组数据全部转换成整型
			for (int i = 0; i < Media.ptsCounts; i++) {
				for (int j = 0; j < 2; j++) {
					cords[i][j] = Integer.parseInt(Media.cords[i][j]);
				}
			}
			//画线
			g.drawLine(cords[0][0],cords[0][1],cords[1][0],cords[1][1]);//画一条线。
			System.out.println("Line drawing completed");
		}
		catch (Exception e) {
			System.out.println("Failed to draw a line: " + e.toString());
		}
	}
	
}

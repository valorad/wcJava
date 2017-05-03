package jd4;

import java.awt.Graphics;

public class Points extends Geometry{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 991897001770070135L;

	@Override
	public void draw(Graphics g) {
		
		try {
			//把已有的字符串型的数组数据全部全部转换成整型
			for (int i = 0; i < Media.ptsCounts; i++) {
				for (int j = 0; j < 2; j++) {
					cords[i][j] = Integer.parseInt(Media.cords[i][j]);
				}
			}
			//画点
			g.drawLine(cords[0][0],cords[0][1],cords[0][0],cords[0][1]);//画一个点。
			System.out.println("Point drawing completed");
		}
		catch (Exception e) {
			System.out.println("Failed to draw a point: " + e.toString());
		}
	}
}

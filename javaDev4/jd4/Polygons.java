package jd4;

import java.awt.Graphics;
import java.awt.Polygon;

public class Polygons extends Geometry {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7807255584738293073L;
	Polygon polygon1 = new Polygon();
	
	@Override
	public void draw(Graphics g) {
		try {
			//把已有的字符串型的数组数据全部全部转换成整型
			for (int i = 0; i < Media.ptsCounts; i++) {
				for (int j = 0; j < 2; j++) {
					cords[i][j] = Integer.parseInt(Media.cords[i][j]);
					if (j == 1) {
						polygon1.addPoint(cords[i][j - 1], cords[i][j]);
					}				
				}
			}
			//画线
			g.drawPolygon(polygon1);//画一个多边形。
			System.out.println("Polygon drawing completed");			
		}
		catch (Exception e) {
			System.out.println("Failed to draw a polygon: " + e.toString());
		}
	}
}

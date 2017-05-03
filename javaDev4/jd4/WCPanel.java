package jd4;

import java.util.ArrayList;
import java.awt.Graphics;
import javax.swing.*;

public class WCPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3101123662896448777L;
	Geometry[] lstDraw = null;
	ArrayList<Geometry> lstDraw2 = new ArrayList<Geometry>();

	public void addObject(Geometry obj) {
		if (lstDraw == null) {
				lstDraw = new Geometry[1];
				lstDraw[0] = obj;
		}
		else {
			Geometry[] tmp = new Geometry[lstDraw.length + 1];
			for(int i = 0; i < lstDraw.length; i++) {
				tmp[i] = lstDraw[i];
			}
			tmp[tmp.length - 1] = obj;
			
			lstDraw = tmp;
		}
		
		lstDraw2.add(obj);
	}

	public void paint(Graphics g) {

		for (int i = 0; i < lstDraw2.size(); i++) {
			lstDraw2.get(i).draw(g);
		}
	}
}

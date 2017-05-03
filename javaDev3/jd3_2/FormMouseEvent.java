package jd3_2;

import java.awt.event.*;
import javax.swing.*;

public class FormMouseEvent {
	JFrame me = new JFrame("Java Dev 3 by WC");
	JLabel lb1 = new JLabel();
	JLabel lb2 = new JLabel();
	JLabel lb3 = new JLabel();
	JLabel lb4 = new JLabel();

	public FormMouseEvent() {
		me.setLayout(null);
		lb1.setText("Mouse Pos.");

		lb2.setText("0" + " , " + "0");

		lb3.setText("Currently Click on");

		lb4.setText("Not clicked yet");

		
		lb1.setBounds(100,150, 100, 25);
		lb2.setBounds(250,150, 100, 25);
		lb3.setBounds(100,210, 100, 25);
		lb4.setBounds(250,210, 100, 25);
		/* * 100 左定点坐标 * 150 左上定点坐标 * 50 Button的宽 * 25 Button的高 */
		
		me.add(lb1);
		me.add(lb2);
		me.add(lb3);
		me.add(lb4);
		me.setSize(600, 500);
		me.setVisible(true);
		
		InitMsEvt();

	}
	
	private void InitMsEvt() {
		me.addMouseListener(new MouseAdapter() {

			public void mousePressed(MouseEvent e) {
				int btn = e.getModifiers();
				if (btn == 8) {
					lb4.setText("Middle Wheel");
				}
				else if (btn == 16) {
					lb4.setText("Left Button");
				}
				else if (btn == 4) {
					lb4.setText("Right Button");
				}
				else {
					lb4.setText("Special Button");
				}
				lb2.setText(e.getX() + " , " + e.getY());
			}
		});
		me.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseMoved(MouseEvent e) {
				lb2.setText(e.getX() + " , " + e.getY());
			}			
		});

	}
}

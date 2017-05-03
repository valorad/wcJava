package JavaDev2_4;

import java.awt.*;

public class Form1 {

	Frame frm = new Frame("Java Dev 2 by wc");
	Panel pn = new Panel();
	Panel pn2 = new Panel();
	TextArea ta = new TextArea();
	TextField tf = new TextField();
	Button btn1 = new Button("btn1");
	Button btn2 = new Button("btn2");
	Button btn3 = new Button("btn3");
	List cb1 = new List();
	
	@SuppressWarnings("deprecation")
	public Form1() {
		cb1.addItem("4", 0);
		BorderLayout layout = new BorderLayout();
		BorderLayout layout2 = new BorderLayout();
		BorderLayout layoutR = new BorderLayout();
		frm.setLayout(layout);
		pn.setLayout(layout2);
		pn2.setLayout(layoutR);
		
		
		pn2.add(btn1, BorderLayout.NORTH);
		pn2.add(btn2, BorderLayout.WEST);
		pn2.add(btn3, BorderLayout.CENTER);
		pn2.add(cb1, BorderLayout.SOUTH);

		pn.add(ta, BorderLayout.WEST);
		pn.add(tf, BorderLayout.SOUTH);
		pn.add(pn2, BorderLayout.EAST);

		frm.add(pn,BorderLayout.CENTER);
		frm.setSize(600, 600);
		frm.setVisible(true);
	}

}

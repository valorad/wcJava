package JavaDev2_5;

import java.awt.*;

public class FormCalc {
	Frame FormCalc = new Frame("Java Dev 2 by wc");
	TextField tf1 = new TextField();
	Panel pn1 = new Panel();
	
	Button [] btns = new Button[16];
	
	public FormCalc() {
		BorderLayout main1 = new BorderLayout();
		FormCalc.setLayout(main1);
		
		GridLayout pnlo = new GridLayout(4, 4);
		pn1.setLayout(pnlo);
		
		tf1.setText("0");
		tf1.setSize(200, 100);
		int num;
		
		for (num = 0; num <= 9; num++) {
			btns[num] = new Button(Integer.toString(num));
			pn1.add(btns[num]);
		}
		
		btns[10] = new Button(".");
		btns[11] = new Button("=");
		btns[12] = new Button("+");
		btns[13] = new Button("-");
		btns[14] = new Button("*");
		btns[15] = new Button("/");
		
		for (num = 10; num <= 15; num++) {		
			pn1.add(btns[num]);
		}
		
		FormCalc.add(tf1, BorderLayout.NORTH);
		FormCalc.add(pn1);
		FormCalc.setSize(600, 600);
		FormCalc.setVisible(true);
		
	}
}

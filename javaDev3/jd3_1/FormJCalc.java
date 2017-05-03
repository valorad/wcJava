package jd3_1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class FormJCalc {
	JFrame jfc = new JFrame("Java Dev 3 by WC");
	JTextField jtf1 = new JTextField();
	JPanel jpn1 = new JPanel();
	JButton [] jbtns = new JButton[16];
	
	public FormJCalc() {
		BorderLayout main1 = new BorderLayout();
		jfc.setLayout(main1);	
		GridLayout pnlo = new GridLayout(4, 4);
		jpn1.setLayout(pnlo);
		
		jtf1.setText("0");
		jtf1.setSize(200, 100);
		int i;
		
		for (i = 0; i <= 9; i++) {
			final int i2 = i;
			jbtns[i] = new JButton(Integer.toString(i));
			jbtns[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					jtf1.setText(Integer.toString(i2));
				}
			});
			jpn1.add(jbtns[i]);
		}
		jbtns[10] = new JButton(".");
		jbtns[11] = new JButton("=");
		jbtns[12] = new JButton("+");
		jbtns[13] = new JButton("-");
		jbtns[14] = new JButton("*");
		jbtns[15] = new JButton("/");
		
		for (i = 10; i <= 15; i++) {		
			jpn1.add(jbtns[i]);
		}
		
		jfc.add(jtf1, BorderLayout.NORTH);
		jfc.add(jpn1);
		jfc.setSize(600, 600);
		jfc.setVisible(true);
		
		//Events
		jfc.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		jfc.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
			int value = JOptionPane.showConfirmDialog(jfc, "Are you sure?");
			if (value == JOptionPane.OK_OPTION) {
				System.exit(0);
			}
		}});
	}
}

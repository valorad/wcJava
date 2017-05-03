package jd4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

public class FormManInput extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3486395822557450488L;
	
	String d0it = "In..."; // Default text shown in each TextField
	int count = 0;// tmp nums in cords
	int scale = 0;
	
	JFrame mip = new JFrame("Java Dev 4 by WC");
	JPanel pn1 = new JPanel();
	JPanel pn2 = new JPanel();
	JLabel lb1 = new JLabel("Manually Input data (x, y)  ||  (x, y)...");
	
	JTextField [][] txfds = null;
	
	JButton btn1 = new JButton("OK");
	JButton btn2 = new JButton("Cancel");
	
	public FormManInput(int numtf) {
		BorderLayout main1 = new BorderLayout();
		mip.setLayout(main1);
		
		scale = (int)(Math.sqrt(numtf * 2));
		GridLayout pnlo = new GridLayout(scale, scale);
		pn1.setLayout(pnlo);
		
		txfds = new JTextField [numtf][2];
		
		// Initialize Every text field
		
		for (int i = 0; i < txfds.length; i++) {
			for (int j = 0; j < 2; j++) {
				txfds[i][j] = new JTextField();
				txfds[i][j].setText(d0it);
				//动态添加事件整不来
//				txfds[i][j].addFocusListener(new FocusListener() {
//					@Override
//					public void focusGained(FocusEvent arg0) {
//						if (this.getparentid.getText().equals(d0it)) {
//							txfds[i][j].setText("");
//						}						
//					}
//					@Override
//					public void focusLost(FocusEvent arg0) {
//						
//						
//					}
//				});
				pn1.add(txfds[i][j]);
			}
		}
		
		pn2.add(btn1);
		pn2.add(btn2);
		
		mip.add(lb1, BorderLayout.NORTH);
		mip.add(pn1);
		mip.add(pn2, BorderLayout.SOUTH);
		
		mip.setSize(numtf * 30 + 300, numtf * 20 + 100);
		mip.setVisible(true);
		
		InitEvt(); //Initializing Event
	}
	
	public void InitEvt() {
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int sts = cpData();
				if (sts == -1) {
					JOptionPane.showMessageDialog(null, "Invalid Coordinates input", "Data Error", JOptionPane.ERROR_MESSAGE); 
				}
				else if (sts == 0) {
					Media.inputComplete = 1;
					mip.dispose();
				}
			}			
		});
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Media.inputComplete = -1;
				mip.dispose();
			}
			
		});
		
		
	}
	
	public int cpData() {
		count = 0;
		for (int i = 0; i < txfds.length; i++) {
			for (int j = 0; j < 2; j++) {
				if (txfds[i][j].getText().equals(d0it)) {
					break;
				}
				else {
					Media.cords[i][j] = txfds[i][j].getText();
				}					
			}
		}
		// Count valid numbers in cords
		for (int i = 0; i < Media.cords.length; i++) {
			for (int j = 0; j < 2; j++) {
				if (Media.cords[i][j] == null) {
					break;
				}
				else {
					count++;
				}
			}
		}
		if (count % 2 == 0 && count >= 2) {
			Media.ptsCounts = count / 2;
			return 0;
		}
		else {
			return -1;
		}
	}
	
}

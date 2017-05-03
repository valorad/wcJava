package finaltsk;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.*;

public class FormLogin {
	JFrame lgin = new JFrame("Java Dev Task by WC");
	JPanel pn1 = new JPanel();
	JPanel pn2 = new JPanel();
	JLabel lb1 = new JLabel("Username");
	JLabel lb2 = new JLabel("Password");
	JTextField username = new JTextField("IBM");
	JTextField paswd = new JTextField("ibmuser");
	JButton btnok = new JButton("OK");
	
	public FormLogin() {
		BorderLayout main1 = new BorderLayout();
		lgin.setLayout(main1);
		GridLayout pnlo = new GridLayout(2, 2);
		pn1.setLayout(pnlo);		
		
		pn1.add(lb1);
		pn1.add(username);
		pn1.add(lb2);
		pn1.add(paswd);
		
		pn2.add(btnok);
		
		lgin.add(pn1, BorderLayout.NORTH);
		lgin.add(pn2);
		
		lgin.setSize(300, 300);
		
		lgin.setVisible(true);
		init();
	}
	
	public void loadCheck(String pathName) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pathName)));

		String LdUsname = "";
		String LdPswd = "";
		String LdComname = "";
		String LdAddr = "";
		int res = 0;
		String line = br.readLine();
		line = br.readLine(); // to avoid line 1
		String [] splitt = line.split(",");
		
		LdUsname = splitt[0];
		LdPswd = splitt[1];
		
		for (int aa = 0; aa < 4; aa++) {
			if (LdUsname.equals(username.getText()) && LdPswd.equals(paswd.getText())) {
				LdComname = splitt[2];
				LdAddr = splitt[3];
				res = 1;
				break;
			}
			if (aa != 3) {
				line = br.readLine();
				splitt = line.split(",");
				LdUsname = splitt[0];
				LdPswd = splitt[1];				
			}
		}
		
		if (res == 1) {
			//System.out.println(LdComname + LdAddr);
			JOptionPane.showMessageDialog(lgin, "Company Name is : " + LdComname + "\n and the company is at " + LdAddr);
		}
		else {
			//System.out.println("smth wrong");
			JOptionPane.showMessageDialog(lgin, "Invalid log-in session. You are not authorized to do so");
		}		
		br.close();
	}
	
	
	public void init() {
		btnok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					loadCheck("E:\\user.txt");
				}
				catch(Exception e) {
					//System.out.println(e.toString());
					//JOptionPane.showMessageDialog(lgin, "Invalid log-in session. You are not authorized to do so");
				}	

			}
		});
	}

}

package jd3_4;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.*;


import javax.swing.*;

public class FormEnSelect {
	
	JFrame EnS = new JFrame("Java Dev 3 by WC");
	JLabel lb1 = new JLabel();
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JButton btn1 = new JButton();
	JButton btn2 = new JButton();
	JPanel pn1 = new JPanel();
	JPanel pn2 = new JPanel();
	JFileChooser fc = new JFileChooser();
	
	String fileName = "";
	String d0FileName = "File Name";
	String d0KW = "Key Word";
	String fileContent = "";
	
	public FormEnSelect() {
		BorderLayout main1 = new BorderLayout();
		EnS.setLayout(main1);
		GridLayout pnlo = new GridLayout(2, 2);
		pn1.setLayout(pnlo);
		
		pn1.add(tf1);
		pn1.add(btn1);
		pn1.add(tf2);		
		pn1.add(btn2);
		
		lb1.setText("Demo Vocabulary Query");
	
		// 设置当前目录
		fc.setCurrentDirectory(new File("."));
		fc.setAcceptAllFileFilterUsed(false);
		final String[][] fileENames = {
				{ ".txt", "Text Files(*.txt)" }
		         };		
		
		// 显示所有文件
		fc.addChoosableFileFilter(new javax.swing.filechooser.FileFilter() {
			public boolean accept(File file) {
				return true;
			}
			public String getDescription() {
				return "所有文件(*.*)";
			}
		});
		  
		// 循环添加需要显示的文件
		for (final String[] fileEName : fileENames) {
		   
			fc.setFileFilter(new javax.swing.filechooser.FileFilter() {
				public boolean accept(File file) { 
					if (file.getName().endsWith(fileEName[0]) || file.isDirectory()) {
						return true;
					}
		     return false;
		   }
		 
		   public String getDescription() {		    return fileEName[1];		   }
		  });
		 }
		

		btn1.setText("Open");
		btn2.setText("Execute");
		
		tf1.setText(d0FileName);
		tf2.setText(d0KW);
		
		EnS.add(lb1, BorderLayout.NORTH);
		EnS.add(pn1);
		EnS.setSize(400, 100);
		
		InitEvt();
		EnS.setVisible(true);
	}
	
	public void InitEvt(){
		actBTN();
		actTF();
	}
	
	public void actBTN(){
		//打开文件
		btn1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fc.showDialog(null, null);
				try{
					fileName = fc.getSelectedFile().toString();
					tf1.setText(fileName);
					fileContent = load(fileName);
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(EnS, "Failed to open file");
					ex.printStackTrace();
				}
			}	
		});
		
		//执行并保存Log
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int status = 0;
				
				try {
					if (fileContent.trim().equals("")) {
						JOptionPane.showMessageDialog(EnS, "File corrupted or not properlly loaded, aborted");
					}
					else {
						save("E:\\log.txt", Query());
						status = 1;						
					}
				}
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(EnS, "Log creation failure");
				}
				finally {
					if (status == 1) {
						JOptionPane.showMessageDialog(EnS, "Query complete, log created");
					}
				}
			}
			
		});
	}
	
	public void actTF() {
		tf1.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (tf1.getText().equals(d0FileName)) {
					tf1.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (tf1.getText().equals("")) {
					tf1.setText(d0FileName);
				}				
			}
			
		});
		
		tf2.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (tf2.getText().equals(d0KW)) {
					tf2.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (tf2.getText().equals("")) {
					tf2.setText(d0KW);
				}				
			}
			
		});		
	}
	
	public String load(String pathName) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pathName)));
		String line = br.readLine();
		String linem = "";
		
		while(line != null){
			linem += line;
			line = br.readLine();
		}
		br.close();
		return linem;
	}
	
	public void save(String pathName, String cnt) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(pathName));
		bw.write(cnt);
		bw.flush(); //刷新缓冲区的数据到文件
		bw.close();
	}	
	
	public String Query() {
		Pattern pat = Pattern.compile("^" + tf2.getText() + ".*");
		String query = "";
		
		String[] split = fileContent.split("\\s+");
		for(String each : split) {
			Matcher mtc = pat.matcher(each);
			if (mtc.matches()) {
				System.out.println("'" + each + "'");
				each += " ";
				query += each;
			}
		}
		return query;
	}
	
	
}

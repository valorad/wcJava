package jd3_3;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.*;

public class FormFileManp {
	JFrame fileM = new JFrame("Java Dev 3 by WC");
	JLabel lb1 = new JLabel();

	JTextField tf1 = new JTextField();
	JPanel pn1 = new JPanel();
	JButton btn1 = new JButton();
	JButton btn2 = new JButton();
	
	JFileChooser fc = new JFileChooser();
	
	final String d0text = "Type something here...";
	String fileName = "";
	String fileContent = "";
	
	public FormFileManp() {
		BorderLayout main1 = new BorderLayout();
		fileM.setLayout(main1);
		lb1.setText("Demo File Manipulation");
		
		tf1.setText(d0text);
		btn1.setText("Save");
		btn2.setText("Load");
		
		pn1.add(btn1);
		pn1.add(btn2);			

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
		
		fileM.setSize(600, 200);
		fileM.add(lb1, BorderLayout.NORTH);
		fileM.add(tf1);
	
		fileM.add(pn1, BorderLayout.SOUTH);
		
		initEvt(); //初始化事件
		fileM.setVisible(true);
	}
	
	/*		Functions Start		*/
	public void save(String pathName) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(pathName));
		bw.write(tf1.getText());
		bw.flush(); //刷新缓冲区的数据到文件
		bw.close();
	}
	
	public void load(String pathName) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(pathName)));
		String line = br.readLine();
		String linem = "";
		tf1.setText("");
		while(line != null){
			linem += line;
			line = br.readLine();
		}
	    tf1.setText(linem);
		br.close();
	}
	
	public Object ShowSvDialog() {
		JFileChooser fc = new JFileChooser();
		fc.setDialogType(JFileChooser.FILES_ONLY);
		fc.setDialogTitle("Save to");
		fc.setMultiSelectionEnabled(false);
		fc.showSaveDialog(fc);
		if (fc.getSelectedFile() == null) {
			return null;
		}
		return fc.getSelectedFile().getPath();
	}
	
	public void initEvt() {
		actTF();
		actBTN();
	}

	/*		Functions End		*/
	
	/*		Events Start		*/
	public void actTF() {
		tf1.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (tf1.getText().equals(d0text)) {
					tf1.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (tf1.getText().equals("")) {
					tf1.setText(d0text);
				}				
			}
			
		});
	}
	
	public void actBTN() {
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					save(ShowSvDialog().toString());
				}
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					fc.showDialog(null, null);
					fileName = fc.getSelectedFile().toString();
					if (fc.getSelectedFile() != null) {
						load(fileName);
					}
				}
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});			
	}
	/*		Events End		*/		
}

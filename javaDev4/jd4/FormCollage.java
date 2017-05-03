package jd4;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FormCollage {

	JFrame collage = new JFrame("Java Dev 4 by WC");
	JLabel lb1 = new JLabel();
	Object obj;
	WCPanel pnLoad = new WCPanel();
	JMenuBar menubar1 = new JMenuBar();
	JMenu menu1 = new JMenu("File");
	JMenuItem mitm11 = new JMenuItem("Save Binary Data to [E:\\wcShape.dat]");
	JMenuItem mitm12 = new JMenuItem("Load Binary Data from [E:\\wcShape.dat]");
	JMenu menu2 = new JMenu("Draw");
	JMenuItem mitm21 = new JMenuItem("Fixed-Draw a Point");
	JMenuItem mitm22 = new JMenuItem("Fixed-Draw a Line");
	JMenuItem mitm23 = new JMenuItem("Fixed-Draw a Polygon");
	JMenuItem mitm24 = new JMenuItem("Free Style");
	JMenu menu3 = new JMenu("More");
	JMenuItem mitm31 = new JMenuItem("About");
	JMenu menu4 = new JMenu("***Input Data [MUST DO IT ON START!!!]***");
	JMenuItem mitm41 = new JMenuItem("Input 1 point");
	JMenuItem mitm42 = new JMenuItem("Input 2 points");
	JMenuItem mitm43 = new JMenuItem("Input 8 points");
	
	public FormCollage() {

		BorderLayout main1 = new BorderLayout();
		collage.setLayout(main1);
		
		menu1.add(mitm11);
		menu1.add(mitm12);
		
		menu2.add(mitm21);
		menu2.add(mitm22);
		menu2.add(mitm23);
		menu2.add(mitm24);
		
		menu3.add(mitm31);
		
		menu4.add(mitm41);
		menu4.add(mitm42);
		menu4.add(mitm43);
		
		menubar1.add(menu1);
		menubar1.add(menu2);
		menubar1.add(menu3);
		menubar1.add(menu4);
		
		lb1.setText("Java Collage by wc");
		
		
		collage.add(menubar1, BorderLayout.NORTH);
		collage.add(lb1, BorderLayout.SOUTH);
		collage.add(pnLoad, BorderLayout.CENTER);

		collage.setSize(650, 500);
		collage.setVisible(true);
		
		
		InitEvt(); //Initializing Events
	}
	
	public void InitEvt() {
		
		//Menu 1 Actions Start
		mitm11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				saveFile(obj);
			}
		});
		mitm12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadFile();
			}
		});		
		//Menu 1 Actions End
		
		//Menu 2 Actions Start
		mitm21.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fixedDrawPoint();
			}
		});	
		
		mitm22.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fixedDrawLine();
			}
		});	
		
		mitm23.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				fixedDrawPolygon();
			}
		});			
		//Menu 2 Actions End
		
		//Menu 3 Actions Start
		mitm31.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Java Development Experiment No.4 (Project Java Collage) by wc.\n All rights reserved wc/wcxaaa, 2016.\n Thank you for using this program, plus special thanks to (\"dehumanized\") Mr. Yu as well for the great challenge assigned! :\\ ", "Thank you for using Java Collage by wc", JOptionPane.INFORMATION_MESSAGE );
			}
		});			
		//Menu 3 Actions End
		

		
		//Menu 4 Actions Start
		mitm41.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				FormManInput fmi = new FormManInput(1); //调出输入窗口，下同 
			}
		});

		mitm42.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				FormManInput fmi = new FormManInput(2);
			}
		});
		
		mitm43.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unused")
				FormManInput fmi = new FormManInput(8);
			}
		});		
		//Menu 4 Actions End
		
	}
	
	public void fixedDrawPoint() {
		/*有空再研究*/
		/*
		FormManInput fmi = new FormManInput(1); //Input Data
		fmi.opDialog();
//		while (Media.inputComplete == 0) {
//			try {
//				Thread.currentThread();
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
		System.out.println("bzbzbbbb778bbbzbzbbbbb8b88");
		*/
//		Media.cords[0][0] = "260";
//		Media.cords[0][1] = "360";
		
		Points pn4 = new Points();
		obj = pn4;
		pnLoad.addObject((Geometry) obj);
		pnLoad.repaint();
		collage.setSize(650, 499);
		
	}
	
	public void fixedDrawLine() {
		Lines pn3 = new Lines();
		obj = pn3;
		pnLoad.addObject((Geometry) obj);
		pnLoad.repaint();
		collage.setSize(650, 499);
	}
	
	public void fixedDrawPolygon() {
		Polygons pn5 = new Polygons();
		obj = pn5;
		pnLoad.addObject((Geometry) obj);
		pnLoad.repaint();
		collage.setSize(650, 499);
	}
	
	public void saveFile(Object obj) {
		int sts = 0;
		try {
			FileOutputStream fo = new FileOutputStream("E:\\wcShape.dat");
			ObjectOutputStream oo = new ObjectOutputStream(fo);
			oo.writeObject(obj);
			oo.close();
			fo.close();
			sts = 0;
		}
		catch (Exception e) {	
			e.printStackTrace();
			sts = -1;
		}
		finally {
			if(sts == 0) {
				JOptionPane.showMessageDialog(null, "Data successfully saved to E:\\wcShape.dat", "Save to", JOptionPane.INFORMATION_MESSAGE );
			}
			else if (sts == -1) {
				JOptionPane.showMessageDialog(null, "Faield to save data to E:\\wcShape.dat", "Save to", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void loadFile() {
		int sts = 0;		
		try {
			FileInputStream fi = new FileInputStream("E:\\wcShape.dat");
			ObjectInputStream oi = new ObjectInputStream(fi);
			collage.add(pnLoad, BorderLayout.CENTER);
			obj = oi.readObject();		
			pnLoad.addObject((Geometry) obj);
			pnLoad.repaint();
			oi.close();
			fi.close();
			sts = 0;
		}
		catch (Exception e) {	
			e.printStackTrace();
			sts = -1;
		}
		finally {
			if(sts == 0) {
				JOptionPane.showMessageDialog(null, "Data successfully loaded from E:\\wcShape.dat", "Load from", JOptionPane.INFORMATION_MESSAGE );
			}
			else if (sts == -1) {
				JOptionPane.showMessageDialog(null, "Faield to load data from E:\\wcShape.dat", "Load from", JOptionPane.ERROR_MESSAGE);
			}
		}		
	}
	
}

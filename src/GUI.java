
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener{
	private JFrame frame;
	private JPanel panel, panel1, mainPanel;
	private JTextField rw;
	private JButton cm;

	
	public GUI() {
		
		 frame = new JFrame();
		
		 cm = new JButton("Click for repeated words");
		 
		 panel  = new JPanel(); 
		 panel1 = new JPanel();
		 mainPanel = new JPanel();
		 rw = new JTextField(100);
		 
		 panel.add(cm);
		 panel1.add(rw);
		 mainPanel.add(panel);
		 mainPanel.add(panel1);
			
		mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		mainPanel.setLayout(new GridLayout());
		
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Welcome to The Raven by Edgar Allen Poe's");
		frame.pack();
		frame.setVisible(true);
		
		
		cm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String data, words;
					//boolean info;
			        ArrayList<String> word = new ArrayList<String>();    
			        int count =1;
						FileReader file = null;
						try {
							file = new FileReader("eap.txt");
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				        BufferedReader br = new BufferedReader(file);    
						try {
							while ((data = br.readLine()) != null) {
								String string [] = data.toLowerCase().split("[(' '),]");
								for(String a : string) {
									word.add(a);
								}
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
							
							for(int i = 0; i < word.size(); i++) {
							 count = 1;
								for(int j =i+1; j < word.size(); j++) {
									if(word.get(i).equals(word.get(j))) {
										count++;
									}
								}
								words = word.get(i);
									
										rw.setText(String.valueOf(words+ "  - "+count));
										count = 1;
									
								}
							
							}
				
			
			
		});
	

}
	public static void main(String[] args) {
		new GUI();
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
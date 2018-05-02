package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import jMetal.OptimizationProcess;

public class RunTab {
	
	private JPanel run;
	private JTextField path;

	public RunTab(JFrame frame, Gui gui) {
		JPanel run = new JPanel();	
		run.setLayout(null);
		
		JButton btnSaveConfiguration = new JButton("Save configuration");
		btnSaveConfiguration.setBounds(133, 416, 144, 49);
		run.add(btnSaveConfiguration);
		
		path = new JTextField();
		path.setBounds(120, 77, 348, 22);
		run.add(path);
		path.setColumns(10);
		
		JButton btnLoadConfiguration = new JButton("Load configuration");
		btnLoadConfiguration.setBounds(520, 76, 137, 22);
		run.add(btnLoadConfiguration);
		
		JLabel lblXmlPath = new JLabel("Xml path");
		lblXmlPath.setBounds(39, 80, 56, 16);
		run.add(lblXmlPath);
		
		JButton btnRun = new JButton("Run");
		btnRun.setBounds(402, 416, 144, 49);
		run.add(btnRun);
		btnRun.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	OptimizationProcess.main(null);
	        	
	        }
		});
		
	}

	public JPanel getRun() {
		return run;
	}
	
	
}

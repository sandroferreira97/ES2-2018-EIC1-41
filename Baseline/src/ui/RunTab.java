package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import generic.Problem;
import jMetal.OptimizationProcess;

public class RunTab {
	
	private static JPanel run;
	public static Problem prob;
	private JTextField path;
	private static JComboBox binaryAlgorithms;
	private static String[] algorithm = {""};
	static String[] AlgorithsForDoubleProblemType = new String[]{"NSGAII","SMSEMOA","GDE3","IBEA","MOCell","MOEAD","PAES","RandomSearch"};
	static String[] AlgorithsForIntegerProblemType = new String[]{"NSGAII","SMSEMOA","MOCell","PAES","RandomSearch"};
	static String[] AlgorithsForBinaryProblemType = new String[]{"NSGAII","SMSEMOA","MOCell","MOCH","PAES","RandomSearch","SPEA2"};
	
	public RunTab(JFrame frame, Gui gui) {
		run = new JPanel();	
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
		
		
//		JLabel lblAlgorithms = new JLabel("Choose your Algorithm:");
//		lblAlgorithms.setBounds(40, 300, 200, 16);
//		run.add(lblAlgorithms);
//		lblAlgorithms.setVisible(true);
//		
//		binaryAlgorithms = new JComboBox();
//		binaryAlgorithms.setBounds(255, 300, 116, 22);
//		run.add(binaryAlgorithms);
//		binaryAlgorithms.setVisible(true);		
		
		JButton btnRun = new JButton("Run");
		btnRun.setBounds(402, 416, 144, 49);
		run.add(btnRun);
		btnRun.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	OptimizationProcess oP = new OptimizationProcess(prob);
	        	oP.run();
	        }
		});	
	}
	
//	public static void algorithms(int x) {
//		if(x == 0) {
//			algorithm = new String[] {" "};
//		}
//		if(x == 1) {
//			algorithm = AlgorithsForBinaryProblemType;
//		}
//		if(x == 2) {
//			algorithm = AlgorithsForIntegerProblemType;
//		}
//		if(x == 3) {
//			algorithm = AlgorithsForDoubleProblemType;
//		}
//		binaryAlgorithms.setModel(new DefaultComboBoxModel(algorithm));
//		run.repaint();
//		Gui.repaint();
//	}

	public JPanel getRun() {
		return run;
	}
	
	public static String getAlg() {
		return (String) binaryAlgorithms.getModel().getSelectedItem();
	}
	
	
	
}

package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import generic.Problem;
import generic.Xml;
import jMetal.OptimizationProcess;

// adicionar sitio para meter jars

public class RunTab {

	private static JPanel run;
	public static Problem prob;
	public static JLabel lblJarName;
	private JTextField path;
	private static JComboBox binaryAlgorithms;
	private static String[] algorithm = { "" };
	static String[] AlgorithsForDoubleProblemType = new String[] { "NSGAII", "SMSEMOA", "GDE3", "IBEA", "MOCell",
			"MOEAD", "PAES", "RandomSearch" };
	static String[] AlgorithsForIntegerProblemType = new String[] { "NSGAII", "SMSEMOA", "MOCell", "PAES",
			"RandomSearch" };
	static String[] AlgorithsForBinaryProblemType = new String[] { "NSGAII", "SMSEMOA", "MOCell", "MOCH", "PAES",
			"RandomSearch", "SPEA2" };
	private Xml a;

	public RunTab(JFrame frame, Gui gui) {
		run = new JPanel();
		run.setLayout(null);

		JButton btnSaveConfiguration = new JButton("Save configuration");
		btnSaveConfiguration.setBounds(133, 416, 144, 49);
		run.add(btnSaveConfiguration);
		btnSaveConfiguration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(AdvancedConfigurationTab.getProblem().getName());
				a.saveConfig(AdvancedConfigurationTab.getProblem());
			}
		});



		JButton btnLoadConfiguration = new JButton("Load");
		btnLoadConfiguration.setBounds(380, 76, 137, 22);
		run.add(btnLoadConfiguration);
		btnLoadConfiguration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter("XML", "xml");
			    chooser.setFileFilter(filter);
			    int returnVal = chooser.showOpenDialog(run);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       System.out.println("You chose to open this file: " +chooser.getSelectedFile().getName());
			    }
			}
		});

		JLabel lblXmlPath = new JLabel("Load configuration from a previously saved XML file:");
		lblXmlPath.setBounds(80, 80, 300, 16);
		run.add(lblXmlPath);


		JLabel lblJar = new JLabel("Jar");
		lblJar.setBounds(80, 200, 200, 16);
		run.add(lblJar);

		JCheckBox jar = new JCheckBox();
		jar.setBounds(120, 200, 200, 16);
		run.add(jar);
		
		JLabel lblPath = new JLabel("Upload Jar file:");
		lblPath.setBounds(80, 300, 200, 16);
		run.add(lblPath);
		lblPath.setVisible(false);
			
		JButton btnLoadJar = new JButton("Load");
		btnLoadJar.setBounds(170, 300, 80, 16);
		run.add(btnLoadJar);
		btnLoadJar.setVisible(false);
		btnLoadJar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter("Jar files", "jar");
			    chooser.setFileFilter(filter);
			    int returnVal = chooser.showOpenDialog(run);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			    	lblJarName.setText(chooser.getSelectedFile().getName());
			    }
			}
		});

		jar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jar.isSelected()) {
					lblPath.setVisible(true);
					btnLoadJar.setVisible(true);
				}else {
					lblPath.setVisible(false);
					btnLoadJar.setVisible(false);
				}
			}
		});

		JButton btnRun = new JButton("Run");
		btnRun.setBounds(402, 416, 144, 49);
		run.add(btnRun);
		
		lblJarName = new JLabel("");
		lblJarName.setBounds(260, 301, 270, 16);
		run.add(lblJarName);
		
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OptimizationProcess oP = new OptimizationProcess(AdvancedConfigurationTab.getProblem());
				oP.run();
			}
		});
	}


	public JPanel getRun() {
		return run;
	}

	public static String getAlg() {
		return (String) binaryAlgorithms.getModel().getSelectedItem();
	}
}

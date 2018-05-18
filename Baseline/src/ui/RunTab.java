package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import generic.Problem;
import generic.Xml;
import jMetal.OptimizationProcess;

// adicionar sitio para meter jars

public class RunTab {

	private static JPanel run;
	public static Problem prob;
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


		JLabel lblJar = new JLabel("Jar");
		lblJar.setBounds(40, 200, 200, 16);
		run.add(lblJar);

		JCheckBox jar = new JCheckBox();
		jar.setBounds(100, 200, 200, 16);
		run.add(jar);
		
		JLabel lblPath = new JLabel("Upload Jar file:");
		lblPath.setBounds(40, 300, 200, 16);
		run.add(lblPath);
		lblPath.setVisible(false);
		
		JTextField jarPath = new JTextField();
		jarPath.setBounds(130, 300, 200, 16);
		run.add(jarPath);
		jarPath.setVisible(false);
		
		JButton btnLoadJar = new JButton("Load");
		btnLoadJar.setBounds(380, 300, 80, 16);
		run.add(btnLoadJar);
		btnLoadJar.setVisible(false);

		jar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jar.isSelected()) {
					jarPath.setVisible(true);
					lblPath.setVisible(true);
					btnLoadJar.setVisible(true);
				}else {
					jarPath.setVisible(false);
					lblPath.setVisible(false);
					btnLoadJar.setVisible(false);
				}
			}
		});

		JButton btnRun = new JButton("Run");
		btnRun.setBounds(402, 416, 144, 49);
		run.add(btnRun);
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

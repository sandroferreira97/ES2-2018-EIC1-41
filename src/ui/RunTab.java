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

import generic.Functions;
import generic.Problem;
import generic.Variable;
import generic.Xml;
import jMetal.OptimizationProcess;

// adicionar sitio para meter jars

public class RunTab {

	private static JPanel run;
	public static Problem prob;
	public static JLabel lblJarName;
	private JTextField path;
	private static String jarPath; 
	private static JComboBox binaryAlgorithms;
	private static String[] algorithm = { "" };
	static String[] AlgorithsForDoubleProblemType = new String[] { "NSGAII", "SMSEMOA", "GDE3", "IBEA", "MOCell",
			"MOEAD", "PAES", "RandomSearch" };
	static String[] AlgorithsForIntegerProblemType = new String[] { "NSGAII", "SMSEMOA", "MOCell", "PAES",
			"RandomSearch" };
	static String[] AlgorithsForBinaryProblemType = new String[] { "NSGAII", "SMSEMOA", "MOCell", "MOCH", "PAES",
			"RandomSearch", "SPEA2" };
	private Xml a;
	private static ArrayList<Variable> probVariables;

	public RunTab(JFrame frame, Gui gui) {
		run = new JPanel();
		run.setLayout(null);

		JButton btnSaveConfiguration = new JButton("Save configuration");
		btnSaveConfiguration.setBounds(133, 416, 144, 49);
		run.add(btnSaveConfiguration);
		btnSaveConfiguration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(AdvancedConfigurationTab.getProblem().getName());
				a.saveConfig(AdvancedConfigurationTab.getProblem(),gui.getAdm().getXmlDir());
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
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
					a.loadConfig(chooser.getSelectedFile());
				}
			}
		});

		JLabel lblXmlPath = new JLabel("Load configuration from a previously saved XML file:");
		lblXmlPath.setBounds(80, 80, 300, 16);
		run.add(lblXmlPath);

		JLabel lblPath = new JLabel("Upload Jar file:");
		lblPath.setBounds(80, 131, 200, 16);
		run.add(lblPath);

		JButton btnLoadJar = new JButton("Load");
		btnLoadJar.setBounds(180, 131, 80, 16);
		run.add(btnLoadJar);

		btnLoadJar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Jar files", "jar");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(run);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					lblJarName.setText(chooser.getSelectedFile().getName());
					jarPath = chooser.getSelectedFile().getPath();
					System.out.println(getJarPath());
				}
			}
		});

		JButton btnRun = new JButton("Run");
		btnRun.setBounds(402, 416, 144, 49);
		run.add(btnRun);

		lblJarName = new JLabel("");
		lblJarName.setBounds(276, 131, 270, 16);
		run.add(lblJarName);

		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OptimizationProcess oP = new OptimizationProcess(AdvancedConfigurationTab.getProblem());
				oP.run();
				probVariables = AdvancedConfigurationTab.getVariableArray();
				String[] fx = Functions.readAutomatic("MyProblemInteger");
				
				probVariables = Functions.readWeights(probVariables,Integer.valueOf(fx[2]) , 10);
				VariableConfigurationTab.writeRules(probVariables,AdvancedConfigurationTab.getTestGroup());
			}
		});
	}

	public static String getJarName() {
		return lblJarName.getText();
	}

	public JPanel getRun() {
		return run;
	}

	public static String getJarPath() {
		return jarPath;
	}
	
	public static String getAlg() {
		return (String) binaryAlgorithms.getModel().getSelectedItem();
	}
}

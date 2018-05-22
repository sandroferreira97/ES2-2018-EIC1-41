package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import generic.Functions;
import generic.Problem;
import generic.Variable;

public class AdvancedConfigurationTab {

	private static JPanel configadvanced;
	private static JSpinner quantity;
	private static JTextField varname;
	private static JTextField varmin;
	private static JTextField varmax;
	private static JSpinner optCriteria;
	private static JComboBox binaryAlgorithms;
	private static String[] algorithm = { "" };
	public static int variableType;
	public static JComboBox<?> type, optType;
	public static Problem prob;
	private static ArrayList<Variable> probVariables = new ArrayList<Variable>();
	private static ArrayList<String> probAlgorithms = new ArrayList<String>();

	static String[] AlgorithsForDoubleProblemType = new String[] { "", "NSGAII", "SMSEMOA", "GDE3", "IBEA", "MOCell",
			"MOEAD", "PAES", "RandomSearch" };
	static String[] AlgorithsForIntegerProblemType = new String[] { "", "NSGAII", "SMSEMOA", "MOCell", "PAES",
			"RandomSearch" };
	static String[] AlgorithsForBinaryProblemType = new String[] { "", "NSGAII", "SMSEMOA", "MOCell", "MOCH", "PAES",
			"RandomSearch", "SPEA2" };
	private JTextField testGroup;

	public AdvancedConfigurationTab(JFrame frame, Gui gui) {

		configadvanced = new JPanel();
		configadvanced.setLayout(null);

		JLabel lbltime = new JLabel("Maximum waiting time(seconds)");
		lbltime.setBounds(40, 50, 196, 16);
		configadvanced.add(lbltime);

		JLabel lblquantity = new JLabel("Number of variables:");
		lblquantity.setBounds(40, 115, 150, 16);
		configadvanced.add(lblquantity);

		quantity = new JSpinner();
		quantity.setBounds(255, 112, 116, 22);
		configadvanced.add(quantity);

		JLabel lblRuleName = new JLabel("Rules name:");
		lblRuleName.setBounds(40, 226, 150, 16);
		configadvanced.add(lblRuleName);

		varname = new JTextField();
		varname.setBounds(255, 223, 116, 22);
		configadvanced.add(varname);
		varname.setColumns(10);
		
		

		JLabel lblVarType = new JLabel("Variable type:");
		lblVarType.setBounds(40, 272, 150, 16);
		configadvanced.add(lblVarType);

		JLabel lblvaluerange = new JLabel("Range of values:");
		lblvaluerange.setBounds(40, 323, 150, 16);
		configadvanced.add(lblvaluerange);

		varmin = new JTextField();
		varmin.setBounds(255, 320, 116, 22);
		configadvanced.add(varmin);
		varmin.setColumns(10);

		varmax = new JTextField();
		varmax.setBounds(422, 320, 116, 22);
		configadvanced.add(varmax);
		varmax.setColumns(10);

		lblvaluerange.setVisible(false);
		varmin.setVisible(false);
		varmax.setVisible(false);

		type = new JComboBox();
		type.setModel(new DefaultComboBoxModel(new String[] { "", "Binary", "Integer", "Double" }));
		type.setBounds(255, 269, 116, 22);
		configadvanced.add(type);

		JSpinner maxtime = new JSpinner();
		maxtime.setBounds(255, 47, 116, 22);
		configadvanced.add(maxtime);
		type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (type.getSelectedItem().toString().equals("")) {
					lblvaluerange.setVisible(false);
					varmin.setVisible(false);
					varmax.setVisible(false);
				}

				if (type.getSelectedItem().toString().equals("Binary")) {
					lblvaluerange.setVisible(false);
					varmin.setVisible(false);
					varmax.setVisible(false);
					setVariableType(1);
				}

				if (type.getSelectedItem().toString().equals("Integer")) {
					lblvaluerange.setVisible(true);
					varmin.setVisible(true);
					varmax.setVisible(true);
					setVariableType(2);
				}

				if (type.getSelectedItem().toString().equals("Double")) {
					lblvaluerange.setVisible(true);
					varmin.setVisible(true);
					varmax.setVisible(true);
					setVariableType(3);
				}
				
				algorithms(getVariableType());
			}
		});

		JLabel lblAlgorithms = new JLabel("Choose your Algorithm:");
		lblAlgorithms.setBounds(40, 443, 200, 16);
		configadvanced.add(lblAlgorithms);
		lblAlgorithms.setVisible(false);
		
		binaryAlgorithms = new JComboBox();
		binaryAlgorithms.setBounds(255, 440, 116, 22);
		configadvanced.add(binaryAlgorithms);
		binaryAlgorithms.setVisible(false);		
		
		
		binaryAlgorithms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAlgorithms();
			}
		});
//		
		

		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				teste();
				
				if (!gui.isConfiguration()) {
					JOptionPane.showMessageDialog(frame, "Please fill all fields in the configuration tab");
				} else if ((int) maxtime.getValue() != 0 && !type.getSelectedItem().toString().equals("")
						&& !varname.getText().equals("") && (int) quantity.getValue() != 0) {
					
					prob = new Problem(ConfigurationTab.getProbName(), ConfigurationTab.getProbDescription(),
							getVariables(), getAlgorithmsArray(), getProbType(), ConfigurationTab.getProbMail());
//					String[] fx = Functions.readAutomatic("MyProblemInteger");
//					ArrayList<Variable> v = Functions.readWeights("as",Integer.valueOf(fx[2]) , 10);
					VariableConfigurationTab.writeRules(probVariables,testGroup.getText());
					
					
					JOptionPane.showMessageDialog(frame, "Data generated with success");
					gui.setAdvanced(true);
				} else {
					JOptionPane.showMessageDialog(frame, "Please fill in the required data");

				}
			}
		});

		btnGenerate.setBounds(255, 500, 97, 25);
		configadvanced.add(btnGenerate);
		
		JLabel lblRulesGroup = new JLabel("Rules Group:");
		lblRulesGroup.setBounds(40, 169, 150, 16);
		configadvanced.add(lblRulesGroup);
		
		testGroup = new JTextField();
		testGroup.setColumns(10);
		testGroup.setBounds(255, 166, 116, 22);
		configadvanced.add(testGroup);
		
		JLabel lblOptCriteria = new JLabel("Optimization Criteria");
		lblOptCriteria.setBounds(422, 51, 116, 16);
		configadvanced.add(lblOptCriteria);
		
		optCriteria = new JSpinner();
		optCriteria.setBounds(548, 47, 52, 22);
		configadvanced.add(optCriteria);
		
		JLabel lblOptimizationType = new JLabel("Optimization type:");
		lblOptimizationType.setBounds(38, 388, 123, 14);
		configadvanced.add(lblOptimizationType);
		
		optType = new JComboBox();
		optType.setModel(new DefaultComboBoxModel(new String[] { "", "Manual", "Automatic", "Mixed" }));
		optType.setBounds(255, 385, 110, 22);
		configadvanced.add(optType);
		
		optType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(optType.getSelectedItem().toString().equals("Manual")) {
					lblAlgorithms.setVisible(true);
					binaryAlgorithms.setVisible(true);		
				}
				if(optType.getSelectedItem().toString().equals("Automatic")) {
					lblAlgorithms.setVisible(false);
					binaryAlgorithms.setVisible(false);		
				}
				// ainda não sei bem como isto funciona
				if(optType.getSelectedItem().toString().equals("Mixed")) {
					lblAlgorithms.setVisible(true);
					binaryAlgorithms.setVisible(true);		
				}
			}
		});
	}

	public static void algorithms(int x) {
		if (x == 0) {
			algorithm = new String[] { " " };
		}
		if (x == 1) {
			algorithm = AlgorithsForBinaryProblemType;
		}
		if (x == 2) {
			algorithm = AlgorithsForIntegerProblemType;
		}
		if (x == 3) {
			algorithm = AlgorithsForDoubleProblemType;
		}
		binaryAlgorithms.setModel(new DefaultComboBoxModel(algorithm));
		configadvanced.repaint();
		Gui.repaint();

	}

	public void teste() {
		
		String[] fx = Functions.readAutomatic("MyProblemInteger");
		probVariables = Functions.readWeights("MyProblemDouble", Integer.valueOf(fx[2]), 10);
		VariableConfigurationTab.writeRules(getVariables(), "ola");
	}

	public ArrayList<Variable> getVariables() {
		for (int i = 0; i < getQuantity(); i++) {
			Variable v = new Variable(getRulesName(), getProbType(), 0, 0, "");
			probVariables.add(v);
		}
		return probVariables;
	}

	public JPanel getConfigadvanced() {
		return configadvanced;
	}

	public static String getRulesName() {
		return varname.getText();
	}

	public static int getQuantity() {
		return (int) quantity.getValue();
	}

	public static int getObjQuantity() {
		return (int) optCriteria.getValue();
	}

	public static int getVarMin() {
		return Integer.valueOf(varmin.getText());
	}

	public static int getVarMax() {
		return Integer.valueOf(varmax.getText());
	}

	public static int getVariableType() {
		return variableType;
	}

	public Variable getVariable() {
		Variable v = new Variable(getRulesName(), null, 0, 0, "");
		return v;
	}

	public void setVariableType(int x) {
		variableType = x;
	}

	public ArrayList<Variable> getVariableArray() {
		return probVariables;
	}

	public void addAlgorithms() {
		probAlgorithms.add(binaryAlgorithms.getModel().getSelectedItem().toString());
	}

	public static String getAlg() {
		return binaryAlgorithms.getModel().getSelectedItem().toString();
	}

	public ArrayList<String> getAlgorithmsArray() {
		return probAlgorithms;
	}

	public String getProbType() {
		return type.getSelectedItem().toString();
	}

	public static void setProblem(Problem p) {
		prob = p;
	}

	public static Problem getProblem() {
		return prob;
	}

	public static void save(Problem p) {

	}
}

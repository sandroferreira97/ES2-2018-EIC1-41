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

import generic.Variable;

public class AdvancedConfigurationTab {

	private JPanel configadvanced;
	private static JSpinner quantity;
	private static JTextField varname;
	private static JTextField varmin;
	private static JTextField varmax;
	private Variable rules;
	
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
		lblRuleName.setBounds(40, 178, 150, 16);
		configadvanced.add(lblRuleName);
		
		varname = new JTextField();
		varname.setBounds(255, 175, 116, 22);
		configadvanced.add(varname);
		varname.setColumns(10);
		
		JLabel lblVarType = new JLabel("Variable type:");
		lblVarType.setBounds(40, 239, 150, 16);
		configadvanced.add(lblVarType);
		
		JLabel lblvaluerange = new JLabel("Range of values:");
		lblvaluerange.setBounds(40, 299, 150, 16);
		configadvanced.add(lblvaluerange);
		
		
		varmin = new JTextField();
		varmin.setBounds(255, 296, 116, 22);
		configadvanced.add(varmin);
		varmin.setColumns(10);
		
		varmax = new JTextField();
		varmax.setBounds(424, 296, 116, 22);
		configadvanced.add(varmax);
		varmax.setColumns(10);
		
		
		
		
		lblvaluerange.setVisible(false);
		varmin.setVisible(false);
		varmax.setVisible(false);
		
		JComboBox<?> type = new JComboBox();
		type.setModel(new DefaultComboBoxModel(new String[] {"", "Binary", "Integer", "Double"}));
		type.setBounds(255, 236, 116, 22);
		configadvanced.add(type);
		
		
		
		
		JSpinner maxtime = new JSpinner();
		maxtime.setBounds(255, 47, 116, 22);
		configadvanced.add(maxtime);
		type.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	
	        	if(type.getSelectedItem().toString().equals("")){
	        		lblvaluerange.setVisible(false);
	        		varmin.setVisible(false);
	        		varmax.setVisible(false);
	        	}
	        	
	        	if(type.getSelectedItem().toString().equals("Binary")){
	        		lblvaluerange.setVisible(false);
	        		varmin.setVisible(false);
	        		varmax.setVisible(false);
	        	}
	        	
	        	if(type.getSelectedItem().toString().equals("Integer")){
	        		lblvaluerange.setVisible(true);
	        		varmin.setVisible(true);
	        		varmax.setVisible(true);
	        	}
	        	
	        	if(type.getSelectedItem().toString().equals("Double")){
	        		lblvaluerange.setVisible(true);
	        		varmin.setVisible(true);
	        		varmax.setVisible(true);
	        	}
	        }
		});
		
		JLabel lblOptimizationType = new JLabel("Optimization type:");
		lblOptimizationType.setBounds(40, 350, 150, 16);
		configadvanced.add(lblOptimizationType);
		
		JLabel lblAlgorithms = new JLabel("Multi-Objective Algorithms:");
		lblAlgorithms.setBounds(40, 400, 200, 16);
		configadvanced.add(lblAlgorithms);
		lblAlgorithms.setVisible(false);
		
		JComboBox MoAlgorithms = new JComboBox();
		MoAlgorithms.setModel(new DefaultComboBoxModel(new String[] {"", "AbYSS", "CellDE", "dMPOSO", "GDE3", "FastPGA", "IBEA", "MOCHC", "MOCell", "MOEA/D-DE", "pMOEA/D-DE", "MOEA/D-DRA", "NSGA-II", "ssNSGA-II", "NSGAIIr", "NSGAIIa", "pNSGA-II", "OMOPSO", "PAES", "SMPSO", "pSMPSO", "SMPSOhv", "SPEA2"}));
		MoAlgorithms.setBounds(255, 400, 116, 22);
		configadvanced.add(MoAlgorithms);
		MoAlgorithms.setVisible(false);
		
		JLabel lblAlgorithms2 = new JLabel("Single-Objective Algorithms:");
		lblAlgorithms2.setBounds(40, 430, 200, 16);
		configadvanced.add(lblAlgorithms2);
		lblAlgorithms2.setVisible(false);
		
		JComboBox SoAlgorithms = new JComboBox();
		SoAlgorithms.setModel(new DefaultComboBoxModel(new String[] {"", "Genetic Algorithms", "PSO", "Differential Evolution", "Evolution Strategy", "CMA-ES" }));
		SoAlgorithms.setBounds(255, 430, 116, 22);
		configadvanced.add(SoAlgorithms);
		SoAlgorithms.setVisible(false);

		
		JComboBox OptimizationType = new JComboBox();
		OptimizationType.setModel(new DefaultComboBoxModel(new String[] {"", "Manual", "Automatic", "Mixed"}));
		OptimizationType.setBounds(255, 350, 116, 22);
		configadvanced.add(OptimizationType);
		
		OptimizationType.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	
	        	if(OptimizationType.getSelectedItem().toString().equals("Manual")){
	        		lblAlgorithms.setVisible(true);
	        		MoAlgorithms.setVisible(true);
	        		lblAlgorithms2.setVisible(true);
	        		SoAlgorithms.setVisible(true);
	        	}
	        	
	        	if(OptimizationType.getSelectedItem().toString().equals("")){
	        		lblAlgorithms.setVisible(false);
	        		MoAlgorithms.setVisible(false);
	        		lblAlgorithms2.setVisible(false);
	        		SoAlgorithms.setVisible(false);
	        	}
	        	
	        	if(OptimizationType.getSelectedItem().toString().equals("Automatic")){
	        		lblAlgorithms.setVisible(false);
	        		MoAlgorithms.setVisible(false);
	        		lblAlgorithms2.setVisible(false);
	        		SoAlgorithms.setVisible(false);
	        	}
	        	
	        	if(OptimizationType.getSelectedItem().toString().equals("Mixed")){
	        		lblAlgorithms.setVisible(false);
	        		MoAlgorithms.setVisible(false);
	        		lblAlgorithms2.setVisible(false);
	        		SoAlgorithms.setVisible(false);
	        	}
	        }
		});
			
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!gui.isConfiguration()){
					JOptionPane.showMessageDialog(frame, "Please fill all fields in the configuration tab");
				}else if((int)maxtime.getValue()!=0 && !type.getSelectedItem().toString().equals("")&& !varname.getText().equals("") && (int)quantity.getValue()!=0){
					
					VariableConfigurationTab.writeRules(getVariable());
					JOptionPane.showMessageDialog(frame, "Data generated with success");
					gui.setAdvanced(true);
				}else{
					JOptionPane.showMessageDialog(frame, "Please fill in the required data");
					
				}
			}
		});
		
		btnGenerate.setBounds(255, 500, 97, 25);
		configadvanced.add(btnGenerate);
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

	public static JTextField getVarmin() {
		return varmin;
	}

	public static JTextField getVarmax() {
		return varmax;
	}
	
	public Variable getVariable() {
		Variable v = new Variable(getRulesName(),null, 0,0,0);
		return v;
	}
	
	
}

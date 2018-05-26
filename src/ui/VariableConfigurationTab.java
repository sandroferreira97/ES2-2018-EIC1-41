package ui;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import generic.Functions;
import generic.Variable;
import javax.swing.JLabel;

/**
 * VariableConfigurationTab is the class that creates a tab to the frame
 *  that allows the user to personally configure a variable and its criteria
 * 
 * @author Nuno Fialho EIC1 72910
 * @author Sandro Ferreira EIC1 72911
 * @author Duarte Pinto EIC1 73117
 */

public class VariableConfigurationTab {
	
	private static JTable table;
	private static JTable crit;
	private static JPanel varconfig;
	private DefaultTableModel model;
	private DefaultTableModel model2;
	private String[] colums = { "Rule"};
	private String[] colums2= {"Criteria","Known Best Val"};
	private static Gui gui = null;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane2;
	private static JLabel lblGroup;
	
	
	/**
	 * Constructor of the class VariableConfigurationTab
	 * 
	 * @param frame where the tab will be implemented 
	 * @param gui where the tab will be implemented
	 */
	
	public VariableConfigurationTab(JFrame frame, Gui gui) {
		varconfig = new JPanel();
		varconfig.setLayout(null);
		this.gui = gui;
		
		model = new DefaultTableModel(new Object[335][1],colums) {
			
		};
		model2= new DefaultTableModel(new Object[335][1],colums2) {
			
		};
		
		
		 table = new JTable(model);
		 crit = new JTable(model2);
		 scrollPane = new JScrollPane(table);
		 scrollPane2 = new JScrollPane(crit);
		 scrollPane.setBounds(40, 113, 220, 400);
		 scrollPane2.setBounds(280,113,400,400);
		 varconfig.add(scrollPane);
		 varconfig.add(scrollPane2);
		 
		 lblGroup = new JLabel("");
		 lblGroup.setBounds(130, 70, 238, 14);
		 varconfig.add(lblGroup);

		
	}
	
	/**
	 * Function that allows the user to write a rule
	 * 
	 * @param rules is the list of the existing rules
	 * @param group is where certain rules belong
	 */
	public static void writeRules(ArrayList<Variable> rules,String group) {
		
		lblGroup.setText(group);
		
		
			((DefaultTableModel) table.getModel()).getDataVector().removeAllElements();
			((AbstractTableModel) table.getModel()).fireTableDataChanged();
		
		
		for(int i = 0; i < rules.size();i++) {
			((DefaultTableModel) table.getModel()).insertRow(i, rules.get(i).getVector());
		}
		varconfig.repaint();
		Gui.repaint();
	}

	public JPanel getVarconfig() {
		return varconfig;
	}
	
	/**
	 * Function that allows the user to write a criteria
	 * 
	 * @param numCrit ???
	 */
	public static void writeCrit(int numCrit) {
		((DefaultTableModel) crit.getModel()).getDataVector().removeAllElements();
		((AbstractTableModel) crit.getModel()).fireTableDataChanged();
		
		for(int i=0;i<numCrit;i++) {
			((DefaultTableModel) crit.getModel()).insertRow(i, new Object[] {"Criteria "+i});
		}
	}
	
	
}

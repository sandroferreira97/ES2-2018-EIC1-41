package ui;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import generic.Functions;
import generic.Variable;
import javax.swing.JLabel;

public class VariableConfigurationTab {
	
	private static JTable table;
	private static JPanel varconfig;
	private DefaultTableModel model;
	private String[] colums = { "Rule", "Weight"};
	private static Gui gui = null;
	private JScrollPane scrollPane;
	private static JLabel lblGroup;
	
	
	
	public VariableConfigurationTab(JFrame frame, Gui gui) {
		varconfig = new JPanel();
		varconfig.setLayout(null);
		this.gui = gui;
		
		model = new DefaultTableModel(new Object[335][2],colums) {

//			public boolean isCellEditable(int row, int col) {
//				if (col == 1) { // columnIndex: the column you want to make it
//								// editable
//					return true;
//				} else {
//					return false;
//				}
//			}

		};
		
		
		
		 table = new JTable(model);
		 scrollPane = new JScrollPane(table);
		 scrollPane.setBounds(111, 113, 419, 381);
		 varconfig.add(scrollPane);
		 
		 lblGroup = new JLabel("");
		 lblGroup.setBounds(242, 69, 238, 14);
		 varconfig.add(lblGroup);

		
	}
	
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
	

	
	
}

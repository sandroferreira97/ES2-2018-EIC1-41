package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VariableConfigurationTab {
	
	private JTable table;
	private JPanel varconfig;

	public VariableConfigurationTab(JFrame frame, Gui gui) {
		varconfig = new JPanel();
		varconfig.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(111, 113, 419, 381);
		varconfig.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Rule", "Weight"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(250);
		scrollPane.setViewportView(table);
	}

	public JPanel getVarconfig() {
		return varconfig;
	}
	
	
}

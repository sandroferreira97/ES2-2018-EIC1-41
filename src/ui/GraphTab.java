package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import generic.Graph;
import generic.Email;

/**
 * GraphTab is the class that creates a tab to the frame where the user can click a
 * button to see the results in a graphic.
 *
 * @author Nuno Fialho EIC1 72910
 * @author Sandro Ferreira EIC1 72911
 * @author Duarte Pinto EIC1 73117
 */

public class GraphTab {

	private JPanel graphPanel;
	
	/**
	 * Constructor of the class GraphTab
	 * 
	 * @param frame where the tab will be implemented 
	 * @param gui where the tab will be implemented
	 */	
public GraphTab(JFrame frame, Gui gui) {
	
	
	graphPanel = new JPanel();	
	graphPanel.setLayout(null);
	
	
	JButton btgraph = new JButton("Show Graph");
	btgraph.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Graph graph = new Graph(AdvancedConfigurationTab.getProblem());
			
			
			
		}
	});
	btgraph.setBounds(280, 300, 150, 25);
	
	

	graphPanel.add(btgraph);
	
	
	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	
}

public JPanel getGraph() {
	return graphPanel;
}
}

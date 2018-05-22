package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import generic.Graph;
import generic.Email;


public class GraphTab {

	private JPanel graphPanel;
	
public GraphTab(JFrame frame, Gui gui) {
	
	
	graphPanel = new JPanel();	
	graphPanel.setLayout(null);
	
	
	JButton btgraph = new JButton("Show Graph");
	btgraph.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			Graph graph = new Graph();
			
			
			
		}
	});
	btgraph.setBounds(280, 300, 150, 25);
	frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	graphPanel.add(btgraph);
	
	
}

public JPanel getGraph() {
	return graphPanel;
}
}

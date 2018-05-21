package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import generic.Graph;

public class GraphTab {

	private JPanel graph;
	
public GraphTab(JFrame frame, Gui gui) {
	graph = new JPanel();
	
	graph.setLayout(null);
	
	//graph.add(new Graph().getChartPanel());
	
}

public JPanel getGraph() {
	return graph;
}
}

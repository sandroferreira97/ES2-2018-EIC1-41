package generic;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Graph is the class that creates the graphic of the solutions, after running the algorithms
 * and allows to compare the algorithms, what is better to certain criterion 
 * 
 * @author Nuno Fialho EIC1 72910
 * @author Sandro Ferreira EIC1 72911
 * @author Duarte Pinto EIC1 73117
 *
 */

public class Graph {

	public static final String title = "Results";
	private ChartPanel chartPanel;
	private Problem prob;
	
	
	
	/**
	 * Constructor of the class graphic
	 * 
	 * @param prob is the problem that needs to be solved
	 */
	public Graph(Problem prob) {
		chartPanel = prob.createChart();
		JFrame f = new JFrame(title);
		f.setTitle(title);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setLayout(new BorderLayout(0, 5));
		f.add(chartPanel, BorderLayout.CENTER);

		chartPanel.setMouseWheelEnabled(true);
		
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		f.add(panel, BorderLayout.SOUTH);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setSize(640, 480);
		f.setVisible(true);
	}

	

}
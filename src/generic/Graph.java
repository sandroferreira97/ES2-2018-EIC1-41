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

	private static final String title = "Results";
	private ChartPanel chartPanel;
	private Problem prob;
	
	/**
	 * Constructor of the class graphic
	 * 
	 * @param prob is the problem that needs to be solved
	 */
	public Graph(Problem prob) {
		chartPanel = createChart(prob);
		JFrame f = new JFrame(title);
		f.setTitle(title);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setLayout(new BorderLayout(0, 5));
		f.add(chartPanel, BorderLayout.CENTER);

		// chartPanel.setMouseWheelEnabled(true);
		// chartPanel.setHorizontalAxisTrace(true);
		// chartPanel.setVerticalAxisTrace(true);

		JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		// panel.add(createTrace());
		// panel.add(createDate());
		// panel.add(createZoom());
		f.add(panel, BorderLayout.SOUTH);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setSize(640, 480);
		f.setVisible(true);
	}
	
	/**
	 * Function that allows to create the graphic not with the values/results,
	 * but the colors, the x-axis and y-axis name, etc...
	 * 
	 * @param prob is the problem that needs to be solved
	 * @return
	 */
	private ChartPanel createChart(Problem prob) {
		Random rand = new Random();
		
		String xAxisLabel = "Objectives";
		String yAxisLabel = "Values";

		XYDataset roiData = createDataset(prob);
		JFreeChart chart = ChartFactory.createXYLineChart(title, xAxisLabel, yAxisLabel, roiData,
				PlotOrientation.VERTICAL, true, true, false);
		XYPlot plot = chart.getXYPlot();
		XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
		renderer.setDefaultShapesVisible(true);

		for (int i = 0; i < prob.getAlgorithms().size(); i++) {
			float r = rand.nextFloat();
			float g = rand.nextFloat();
			float b = rand.nextFloat();
			Color randomColor = new Color(r, g, b);
			
			ArrayList<ArrayList<Double>> rules = Functions.readResults(prob, prob.getAlgorithms().get(i));
			for (int j = 0; j < rules.size(); j++) {
				
				for (int z = 0; z < rules.get(j).size(); z++) {
					renderer.setSeriesPaint(j, randomColor);
					renderer.setSeriesStroke(j, new BasicStroke(1.0f));
				}				
			}
		}
		
		

		// sets paint color for plot outlines
		plot.setOutlinePaint(Color.BLUE);
		plot.setOutlineStroke(new BasicStroke(2.0f));

		// sets renderer for lines
		plot.setRenderer(renderer);

		// sets plot background
		plot.setBackgroundPaint(Color.DARK_GRAY);

		// sets paint color for the grid lines
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);

		return new ChartPanel(chart);
	}
	
	/**
	 * Function that allows to crate the dataset. After running the algorithms, 
	 * this function will add the solution, values, to the graphic, creating a
	 * dataset with this values.
	 * 
	 * @param prob, is the problem that needs to be solved 
	 * @return the dataset that will be added to the graphic
	 */
	private XYDataset createDataset(Problem prob) {
		/*
		 * TimeSeriesCollection tsc = new TimeSeriesCollection();
		 * tsc.addSeries(createSeries("Algorithm1", 200));
		 * tsc.addSeries(createSeries("Algorithm2", 400)); return tsc;
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1 ;
		for (int i = 0; i < prob.getAlgorithms().size(); i++) {
			ArrayList<ArrayList<Double>> rules = Functions.readResults(prob, prob.getAlgorithms().get(i));
			for (int j = 0; j < rules.size(); j++) {
				series1 = new XYSeries(prob.getAlgorithms().get(i) + j);
				for (int z = 0; z < rules.get(j).size(); z++) {
					series1.add(z + 1, rules.get(j).get(z));
				}				
				dataset.addSeries(series1);
			}
		}
		
		return dataset;
	}

	/*
	 * private TimeSeries createSeries(String name, double scale) { TimeSeries
	 * series = new TimeSeries(name); for (int i = 0; i < 6; i++) { series.add(new
	 * Year(2005 + i), Math.pow(2, i) * scale); } return series; }
	 */

	/*
	 * private JComboBox createTrace() { final JComboBox trace = new JComboBox();
	 * final String[] traceCmds = {"Enable Trace", "Disable Trace"};
	 * trace.setModel(new DefaultComboBoxModel(traceCmds));
	 * trace.addActionListener(new ActionListener() {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) { if
	 * (traceCmds[0].equals(trace.getSelectedItem())) {
	 * chartPanel.setHorizontalAxisTrace(true);
	 * chartPanel.setVerticalAxisTrace(true); chartPanel.repaint(); } else {
	 * chartPanel.setHorizontalAxisTrace(false);
	 * chartPanel.setVerticalAxisTrace(false); chartPanel.repaint(); } } }); return
	 * trace; }
	 */

	/*
	 * private JComboBox createDate() { final JComboBox date = new JComboBox();
	 * final String[] dateCmds = {"Horizontal Dates", "Vertical Dates"};
	 * date.setModel(new DefaultComboBoxModel(dateCmds)); date.addActionListener(new
	 * ActionListener() {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) { JFreeChart chart =
	 * chartPanel.getChart(); XYPlot plot = (XYPlot) chart.getPlot(); DateAxis
	 * domain = (DateAxis) plot.getDomainAxis(); if
	 * (dateCmds[0].equals(date.getSelectedItem())) {
	 * domain.setVerticalTickLabels(false); } else {
	 * domain.setVerticalTickLabels(true); } } }); return date; }
	 */

	/*
	 * private JButton createZoom() { final JButton auto = new JButton(new
	 * AbstractAction("Auto Zoom") {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) {
	 * chartPanel.restoreAutoBounds(); } }); return auto; }
	 */

}
package generic;

import org.jfree.chart.ChartPanel;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Graph extends ApplicationFrame {
	
	
   
   public Graph() {   // the constructor will contain the panel of a certain size and the close operations 
	    super("XY Line Chart Example with JFreechart"); // calls the super class constructor
	    
	    JPanel chartPanel = createChartPanel();       
	    add(chartPanel, BorderLayout.CENTER);
	    
	    setSize(640, 480);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	}
   
   private JPanel createChartPanel() { // this method will create the chart panel containin the graph 
	    String chartTitle = "Objects Movement Chart";
	    String xAxisLabel = "X";
	    String yAxisLabel = "Y";
	    
	    XYDataset dataset = createDataset();
	    
	    JFreeChart chart = ChartFactory.createXYLineChart(chartTitle, 
	            xAxisLabel, yAxisLabel, dataset);

	   
	    customizeChart(chart);
	    
	    return new ChartPanel(chart);
	}
   
   private void customizeChart(JFreeChart chart) {   // here we make some customization
	    XYPlot plot = chart.getXYPlot();
	    XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
	    

	    // sets paint color for each series
	    renderer.setSeriesPaint(0, Color.RED);
	    renderer.setSeriesPaint(1, Color.GREEN);
	    renderer.setSeriesPaint(2, Color.YELLOW);

	    // sets thickness for series (using strokes)
	    renderer.setSeriesStroke(0, new BasicStroke(4.0f));
	    renderer.setSeriesStroke(1, new BasicStroke(3.0f));
	    renderer.setSeriesStroke(2, new BasicStroke(2.0f));
	    
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
	    
	 
	    
	}
   
   private XYDataset createDataset( ) {
	   XYSeriesCollection dataset = new XYSeriesCollection();
	    XYSeries series1 = new XYSeries("Object 1");
	    XYSeries series2 = new XYSeries("Object 2");
	    XYSeries series3 = new XYSeries("Object 3");
	    
	    
	    
	    series1.add(1.0, 2.0);
	    series1.add(2.0, 3.0);
	    series1.add(3.0, 2.5);
	    series1.add(3.5, 2.8);
	    series1.add(4.2, 6.0);
	    
	    series2.add(2.0, 1.0);
	    series2.add(2.5, 2.4);
	    series2.add(3.2, 1.2);
	    series2.add(3.9, 2.8);
	    series2.add(4.6, 3.0);
	    
	    series3.add(1.2, 4.0);
	    series3.add(2.5, 4.4);
	    series3.add(3.8, 4.2);
	    series3.add(4.3, 3.8);
	    series3.add(4.5, 4.0);
	    
	    dataset.addSeries(series1);
	    dataset.addSeries(series2);
	    dataset.addSeries(series3);
	    
	    return dataset;
   }  
  
}
package generic;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
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
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class Graph {

    private static final String title = "Results";
    private ChartPanel chartPanel = createChart();
    

    public Graph() {
        JFrame f = new JFrame(title);
        f.setTitle(title);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout(new BorderLayout(0, 5));
        f.add(chartPanel, BorderLayout.CENTER);
        //chartPanel.setMouseWheelEnabled(true);
        //chartPanel.setHorizontalAxisTrace(true);
        //chartPanel.setVerticalAxisTrace(true);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        //panel.add(createTrace());
        //panel.add(createDate());
        //panel.add(createZoom());
        f.add(panel, BorderLayout.SOUTH);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setSize(640, 480);
        f.setVisible(true);
    }

    

    private ChartPanel createChart() {
    	String xAxisLabel = "              FN                           FP                                                                                                            ";
	    String yAxisLabel = "Values";
    	
    	XYDataset roiData = createDataset();
        JFreeChart chart = ChartFactory.createXYLineChart(title, 
	            xAxisLabel, yAxisLabel, roiData);
        XYPlot plot = chart.getXYPlot();
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setDefaultShapesVisible(true);
        
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
        
        return new ChartPanel(chart);
    }

    private XYDataset createDataset() {
        /*TimeSeriesCollection tsc = new TimeSeriesCollection();
        tsc.addSeries(createSeries("Algorithm1", 200));
        tsc.addSeries(createSeries("Algorithm2", 400));
        return tsc;*/
    	XYSeriesCollection dataset = new XYSeriesCollection();
	    
		   //for (int i = 0; i<results.size(); i++) {
    	String[] rules = Functions.readAutomatic("myProblemInteger");
		   	XYSeries series1 = new XYSeries("Algorithm 1");
		    XYSeries series2 = new XYSeries("Algorithm 2");
		    XYSeries series3 = new XYSeries("Algorithm 3");
		    
		    double criterio1 = 1.0;
		    double criterio2 = 2.0;
		    
		    for (int i = 0; i<rules.length; i++) {
		    
		    series1.add(criterio1, Double.parseDouble(rules[0]));
		    series1.add(criterio2, Double.parseDouble(rules[1]));
		    }
		    
		    /*series2.add(criterio1, 1.0);
		    series2.add(criterio2, 2.4);
		    
		    
		    series3.add(1.0, 4.0);
		    series3.add(2.0, 4.4);
		    series3.add(3.0, 4.2);
		    series3.add(4.0, 3.8);
		    series3.add(5.0, 4.0);*/
		    
		    dataset.addSeries(series1);
		    dataset.addSeries(series2);
		    dataset.addSeries(series3);
		    
		  // }    
		    return dataset;
    	
    }

    /*private TimeSeries createSeries(String name, double scale) {
        TimeSeries series = new TimeSeries(name);
        for (int i = 0; i < 6; i++) {
            series.add(new Year(2005 + i), Math.pow(2, i) * scale);
        }
        return series;
    }*/
    
    /*private JComboBox createTrace() {
    final JComboBox trace = new JComboBox();
    final String[] traceCmds = {"Enable Trace", "Disable Trace"};
    trace.setModel(new DefaultComboBoxModel(traceCmds));
    trace.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (traceCmds[0].equals(trace.getSelectedItem())) {
                chartPanel.setHorizontalAxisTrace(true);
                chartPanel.setVerticalAxisTrace(true);
                chartPanel.repaint();
            } else {
                chartPanel.setHorizontalAxisTrace(false);
                chartPanel.setVerticalAxisTrace(false);
                chartPanel.repaint();
            }
        }
    });
    return trace;
}*/

/*private JComboBox createDate() {
    final JComboBox date = new JComboBox();
    final String[] dateCmds = {"Horizontal Dates", "Vertical Dates"};
    date.setModel(new DefaultComboBoxModel(dateCmds));
    date.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFreeChart chart = chartPanel.getChart();
            XYPlot plot = (XYPlot) chart.getPlot();
            DateAxis domain = (DateAxis) plot.getDomainAxis();
            if (dateCmds[0].equals(date.getSelectedItem())) {
                domain.setVerticalTickLabels(false);
            } else {
                domain.setVerticalTickLabels(true);
            }
        }
    });
    return date;
}*/

/*private JButton createZoom() {
    final JButton auto = new JButton(new AbstractAction("Auto Zoom") {

        @Override
        public void actionPerformed(ActionEvent e) {
            chartPanel.restoreAutoBounds();
        }
    });
    return auto;
}*/
    
}
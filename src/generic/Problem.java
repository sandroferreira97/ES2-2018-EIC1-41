package generic;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * This class creates the problem. It has various characteristics:
 * the problem name,the problem  description, the prblem variables,
 * the algorithms that can be used, the problem type, and the problem
 * mail
 * 
 * @author Nuno Fialho EIC1 72910
 * @author Sandro Ferreira EIC1 72911
 * @author Duarte Pinto EIC1 73117
 *
 */

@XmlRootElement(name="Problem")
public class Problem {
	private String probName;
    private String probDescription;  
	private ArrayList<Variable> probVariables;
	private ArrayList<String> probAlgorithms;
	private String probType;
	private String probEmail;
	private int time;
	private int CritNum;
	private String RuleGroup;
	private String jarpath;

	
	public Problem() {
	}
	
	
	public Problem(String probName, String probDescription, ArrayList<Variable> probVariables, ArrayList<String> probAlgorithms, String probType, String probEmail) {
		this.probName = probName;
		this.probDescription = probDescription;
		this.probVariables = probVariables;
		this.probAlgorithms = probAlgorithms;
		this.probType = probType;
		this.probEmail = probEmail;
		
	}
	
	
	@XmlElement(name="ProblemName")
	public String getName() {
		return probName;
	}
	
	public void setName(String name) {
		this.probName = name;
	}

	@XmlElement(name="ProblemDescription")
	public String getDescription() {
		return probDescription;
	}

	@XmlElementWrapper(name="Variables")
	@XmlElement(name="Variable")
	public ArrayList<Variable> getProbVariables() {
		return probVariables;
	}

	public void setProbVariables(ArrayList<Variable> variables) {
		this.probVariables = variables;
	}
	
	
	
	@XmlElementWrapper(name="Algorithms")
	@XmlElement(name="Algorith")
	public ArrayList<String> getAlgorithms() {
		return probAlgorithms;
	}

	@XmlElement(name="MaxTime")
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	@XmlElement(name="JarPath")
	public String getJarPath() {
		return jarpath;
	}
	
	public void setJarPath(String jar) {
		this.jarpath = jar;
	}
	
	@XmlElement(name="NumberOfCriteria")
	public int getCritNum() {
		return CritNum;
	}
	
	public void setCritNum(int CritNum) {
		this.CritNum = CritNum;
	}
	
	@XmlElement(name="RulesGroup")
	public String getRuleGroup() {
		return RuleGroup;
	}
	
	public void setRuleGroup(String RuleGroup) {
		this.RuleGroup = RuleGroup;
	}
	
	public void setAlgorithms(ArrayList<String> algorithms) {
		this.probAlgorithms = algorithms;
	}
	
	public void addAlgorithms(String alg) {
		this.probAlgorithms.add(alg);
	}
	
	public void setDescription(String description) {
		this.probDescription = description;
	}
	
	@XmlElement(name="Type")
	public String getType() {
		return probType;
	}
	
	public void setType(String type) {
		this.probType = type;
	}

	@XmlElement(name="UserEmail")
	public String getEmail() {
		return probEmail;
	}

	public void setEmail(String email) {
		this.probEmail = email;
	}


	/**
	 * Function that allows to crate the dataset. After running the algorithms,  this function will add the solution, values, to the graphic, creating a dataset with this values.
	 * @param  prob, is the problem that needs to be solved 
	 * @return  the dataset that will be added to the graphic
	 */
	public XYDataset createDataset() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		XYSeries series1;
		for (int i = 0; i < getAlgorithms().size(); i++) {
			ArrayList<ArrayList<Double>> rules = Functions.readResults(this, getAlgorithms().get(i));
			for (int j = 0; j < rules.size(); j++) {
				series1 = new XYSeries(getAlgorithms().get(i) + j);
				for (int z = 0; z < rules.get(j).size(); z++) {
					series1.add(z, rules.get(j).get(z));
				}
				dataset.addSeries(series1);
			}
		}
		return dataset;
	}


	/**
	 * Function that allows to create the graphic not with the values/results, but the colors, the x-axis and y-axis name, etc...
	 * @return
	 */
	public ChartPanel createChart() {
		String xAxisLabel = "Objectives";
		String yAxisLabel = "Values";
		XYDataset roiData = createDataset();
		JFreeChart chart = ChartFactory.createXYLineChart(Graph.title, xAxisLabel, yAxisLabel, roiData,
				PlotOrientation.VERTICAL, true, true, false);
		XYPlot plot = chart.getXYPlot();
		XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
		renderer.setDefaultShapesVisible(true);
		for (int i = 0; i < getAlgorithms().size(); i++) {
			Random rand = new Random();
			float r = rand.nextFloat();
			float g = rand.nextFloat();
			float b = rand.nextFloat();
			Color randomColor = new Color(r, g, b);
			ArrayList<ArrayList<Double>> rules = Functions.readResults(this, getAlgorithms().get(i));
			for (int j = 0; j < rules.size(); j++) {
				for (int z = 0; z < rules.get(j).size(); z++) {
					renderer.setSeriesPaint(j, randomColor);
					renderer.setSeriesStroke(j, new BasicStroke(1.0f));
				}
			}
		}
		plot.setOutlinePaint(Color.BLUE);
		plot.setOutlineStroke(new BasicStroke(2.0f));
		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.DARK_GRAY);
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);
		return new ChartPanel(chart);
	}
	
	
	
}
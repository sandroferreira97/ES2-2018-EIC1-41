package tests;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;
import org.junit.Test;
import org.uma.jmetal.solution.DoubleSolution;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.mail.Transport;

import generic.Admin;
import generic.Email;
import generic.Files;
import generic.Functions;
import generic.Graph;
import generic.Problem;
import generic.Variable;
import generic.Xml;
import jMetal.ExperimentsInteger;
import jMetal.OptimizationProcess;
import jMetal.ProblemBinary;
import jMetal.ProblemDouble;
import jMetal.ProblemInteger;
import ui.AdvancedConfigurationTab;
import ui.ConfigurationTab;
import ui.GraphTab;
import ui.Gui;
import ui.RunTab;

public class Tests {

	private JFrame frame;
	private Problem p;

	@Test
	public void testConfiguration() {
		Gui gui = new Gui();
		ConfigurationTab subjects = new ConfigurationTab(frame, gui);
		subjects.getProbDescription();
		subjects.getProbMail();
		subjects.getProbName();
		subjects.getConfig();
	}

	@Test
	public void testAdvancedConfiguration() {
		Gui gui = new Gui();
		AdvancedConfigurationTab subjects = new AdvancedConfigurationTab(frame, gui);
		subjects.getAlgorithmsArray();
		subjects.getConfigadvanced();
		subjects.getProbType();
		subjects.getVariables();
		subjects.getProblem();
		subjects.algorithms(2);
		subjects.algorithms(1);
		subjects.algorithms(0);
		subjects.algorithms(3);
		AdvancedConfigurationTab.type.setSelectedItem("");
		AdvancedConfigurationTab.type.setSelectedItem("Binary");
		AdvancedConfigurationTab.type.setSelectedItem("Integer");
		AdvancedConfigurationTab.type.setSelectedItem("Double");
		AdvancedConfigurationTab.btnGenerate.doClick();
		AdvancedConfigurationTab.maxtime.setValue(3);
		AdvancedConfigurationTab.quantity.setValue(2);
		AdvancedConfigurationTab.varname.setText("ola");
		AdvancedConfigurationTab.optType.setSelectedItem("");
		AdvancedConfigurationTab.optType.setSelectedItem("Manual");
		AdvancedConfigurationTab.optType.setSelectedItem("Automatic");
		AdvancedConfigurationTab.optType.setSelectedItem("Mixed");
		subjects.getProbType();
		subjects.getVariable();
		subjects.getVariableType();
		subjects.getAlg();
		
	}

	@Test
	public void testFunctions() {
		Functions f = new Functions();
		f.readAutomatic("MyProblemInteger", "NSGAII");
	}

	@Test
	public void testFiles() {
		Files f = new Files();
		f.loadR("Integer");
		f.loadTex("Integer");
	}

	@Test
	public void testEmail() {
		String username = "u";
		String password = "p";
		Email e = new Email();
		e.setAccount(username, password);
	}

	@Test
	public void testOptimization() throws IOException {

		p = new Problem();
		Gui gui = new Gui();
		AdvancedConfigurationTab subjects = new AdvancedConfigurationTab(frame, gui);
		subjects.setVariableType(2);
		OptimizationProcess op = new OptimizationProcess(p);

	}

	@Test
	public void testRunTab() throws IOException {

		p = new Problem();
		Gui gui = new Gui();
		RunTab subjects = new RunTab(frame, gui);
		subjects.getJarName();
		subjects.getJarPath();

	}

	@Test
	public void testProblem() throws IOException {
		ArrayList<Variable> v = new ArrayList<Variable>();
		ArrayList<String> s = new ArrayList<String>();
		p = new Problem("a", "a", v, s, "a", "a");
		Gui gui = new Gui();
		p.getAlgorithms();
		p.getDescription();
		p.getEmail();
		p.getName();
		p.getType();
		p.getJarPath();
		p.getCritNum();
		p.setAlgorithms(s);
		p.setCritNum(2);
		p.setJarPath("as");
		p.setDescription("oal");
		p.setTime(2);
		p.setProbVariables(v);
		p.getTime();
		p.getProbVariables();
		p.setName("name");
		p.getRuleGroup();
		p.setRuleGroup("group");
		p.addAlgorithms("alg");
		p.setType("Binary");
		p.setEmail("email");

	}

	@Test
	public void testAdmin() throws IOException {
		Admin a = new Admin("n", "mail", "2", "1", 4, 5);
		Admin b = new Admin();
		a.getEmail();
		a.getIndRuns();
		a.getMaxEval();
		a.getName();
		a.getPassword();
		a.getXmlDir();
		a.setEmail("mail");
		a.setIndRuns(2);
		a.setMaxEval(2);
		a.setName("name");
		a.setPassword("pass");
		a.setXmlDir("xmldir");
	}

	@Test
	public void testVariable() throws IOException {
		Variable v2 = new Variable();
		Variable v = new Variable("a", "a", 1, 2, "a");
		v.getMax();
		v.getMin();
		v.getName();
		v.getType();
		v.getVector();
		v.getWeight();
		v.setMax(2);
		v.setMin(1);
		v.setName("name");
		v.setType("type");
		v.setWeight("weight");
	}
	
	@Test
	public void testXml() throws IOException {
		Xml x = null ;
		ArrayList<Variable> v = new ArrayList<Variable>();
		ArrayList<String> s = new ArrayList<String>();
		p = new Problem("a", "a", v, s, "a", "a");
		
		x.saveConfig(p);
	}
	
	@Test
	public void testGraph() throws IOException {
		ArrayList<Variable> v = new ArrayList<Variable>();
		ArrayList<String> s = new ArrayList<String>();
		p = new Problem("a", "a", v, s, "a", "a");
		
		Graph g = new Graph(p);
	
	}
	

}

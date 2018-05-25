package tests;

import javax.swing.JFrame;

import org.jfree.chart.ChartPanel;
import org.junit.Test;
import org.uma.jmetal.solution.DoubleSolution;

import java.io.IOException;

import javax.mail.Transport;
import generic.Email;
import generic.Files;
import generic.Functions;
import generic.Graph;
import generic.Problem;
import jMetal.ExperimentsInteger;
import jMetal.OptimizationProcess;
import jMetal.ProblemDouble;
import jMetal.ProblemInteger;
import ui.AdvancedConfigurationTab;
import ui.ConfigurationTab;
import ui.Gui;

public class Tests {

	private JFrame frame;
	Problem p;

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
		op.run();
		
		
		
	}
	
	

}

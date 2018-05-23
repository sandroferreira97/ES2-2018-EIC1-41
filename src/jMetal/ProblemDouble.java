package jMetal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.uma.jmetal.problem.impl.AbstractDoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;

import generic.Problem;
import ui.AdvancedConfigurationTab;
import ui.ConfigurationTab;
import ui.RunTab;

public class ProblemDouble extends AbstractDoubleProblem {

	private Problem problem;

	public ProblemDouble(Problem prob) {
		this.problem = prob;
		setNumberOfVariables(prob.getProbVariables().size());
		setNumberOfObjectives(AdvancedConfigurationTab.getObjQuantity());
		setName("MyProblemDouble");

		List<Double> lowerLimit = new ArrayList<>(getNumberOfVariables());
		List<Double> upperLimit = new ArrayList<>(getNumberOfVariables());

		for (int i = 0; i < getNumberOfVariables(); i++) {
			lowerLimit.add((double) AdvancedConfigurationTab.getVarMin());
			upperLimit.add((double) AdvancedConfigurationTab.getVarMax());
		}

		setLowerLimit(lowerLimit);
		setUpperLimit(upperLimit);
	}

	public void evaluate(DoubleSolution solution) {

		String solutionString = "";
		String evaluationResultString = "";
		for (int i = 0; i < solution.getNumberOfVariables(); i++) {
			solutionString = solutionString + " " + solution.getVariableValue(i);
		}
		try {
			String line;
			Process p = Runtime.getRuntime().exec("java -jar " + RunTab.getJarPath() + " " + solutionString);
			BufferedReader brinput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = brinput.readLine()) != null) {
				evaluationResultString += line;
			}
			brinput.close();
			p.waitFor();
		} catch (Exception err) {
			err.printStackTrace();
		}
		String[] individualEvaluationCriteria = evaluationResultString.split("\\s+");
		// It is assumed that all evaluated criteria are returned in the same result
		// string
		for (int i = 0; i < solution.getNumberOfObjectives(); i++) {
			solution.setObjective(i, Double.parseDouble(individualEvaluationCriteria[i]));
		}

	}
		    
 	  	  
	}
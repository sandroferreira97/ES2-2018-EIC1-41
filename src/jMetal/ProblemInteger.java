package jMetal;

import org.uma.jmetal.problem.impl.AbstractIntegerProblem;
import org.uma.jmetal.solution.IntegerSolution;
import org.uma.jmetal.util.JMetalException;

import generic.Email;
import generic.Problem;
import ui.AdvancedConfigurationTab;
import ui.ConfigurationTab;
import ui.RunTab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProblemInteger extends AbstractIntegerProblem {

	private Problem problem;
	private int runs = 0;
	private double perc = 0;
	private static boolean first = false;
	private static boolean second = false;
	private static boolean third = false;

	public ProblemInteger(Problem prob) throws JMetalException {
		this.problem = prob;
		setNumberOfVariables(prob.getProbVariables().size());
		setNumberOfObjectives(AdvancedConfigurationTab.getObjQuantity());
		setName("MyProblemInteger");

		List<Integer> lowerLimit = new ArrayList<>(getNumberOfVariables());
		List<Integer> upperLimit = new ArrayList<>(getNumberOfVariables());

		for (int i = 0; i < getNumberOfVariables(); i++) {
			lowerLimit.add(AdvancedConfigurationTab.getVarMin());
			upperLimit.add(AdvancedConfigurationTab.getVarMax());
		}

		setLowerLimit(lowerLimit);
		setUpperLimit(upperLimit);
	}

	public void evaluate(IntegerSolution solution) {

//		runs++;
//
//		perc = ((double) runs / ExperimentsInteger.numberRuns);
//		System.out.println(perc);
//		if(perc>0.25&&!first) {
//			  first=true;
//			  Email.enviarRun(problem.getEmail(), problem.getName(), "O Programa chegou a 25% da execução");
//		  }
//		  
//		  if(perc>0.50&&!second) {
//			  second=true;
//			  Email.enviarRun(problem.getEmail(), problem.getName(), "O Programa chegou a 50% da execução");
//		  }
//		  
//		  if(perc>0.75&&!third) {
//			  third=true;
//			  Email.enviarRun(problem.getEmail(), problem.getName(), "O Programa chegou a 75% da execução");
//		  }

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
			solution.setObjective(i, Integer.parseInt(individualEvaluationCriteria[i]));
		}
	}

	public static void reset() {
		first=false;
		third=false;
		second=false;
	}
	
}

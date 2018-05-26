package jMetal;

import org.uma.jmetal.problem.impl.AbstractBinaryProblem;
import org.uma.jmetal.solution.BinarySolution;
import org.uma.jmetal.solution.impl.DefaultBinarySolution;
import org.uma.jmetal.util.JMetalException;

import generic.Email;
import generic.Problem;
import ui.AdvancedConfigurationTab;
import ui.ConfigurationTab;
import ui.RunTab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;

public class ProblemBinary extends AbstractBinaryProblem {
	private int bits;
	private Problem problem;
	private int runs = 0;
	private double perc = 0;
	private static boolean first = false;
	private static boolean second = false;
	private static boolean third = false;

	public ProblemBinary(Problem prob) throws JMetalException {
		this.problem = prob;
		setNumberOfVariables(1);
		setNumberOfObjectives(AdvancedConfigurationTab.getObjQuantity());
		setName("MyProblemBinary");
		bits = prob.getProbVariables().size();

	}

	@Override
	protected int getBitsPerVariable(int index) {
		if (index != 0) {
			throw new JMetalException("Problem MyBinaryProblem has only a variable. Index = " + index);
		}
		return bits;
	}

	@Override
	public BinarySolution createSolution() {
		return new DefaultBinarySolution(this);
	}

	@Override
	public void evaluate(BinarySolution solution) {
		runs++;

		perc = ((double) runs / ExperimentsBinary.numberRuns);
		if(perc>0.25&&!first) {
			  first=true;
			  Email.enviarRun(problem.getEmail(), problem.getName(), "O Programa chegou a 25% da execução");
		  }
		  
		  if(perc>0.50&&!second) {
			  second=true;
			  Email.enviarRun(problem.getEmail(), problem.getName(), "O Programa chegou a 50% da execução");
		  }
		  
		  if(perc>0.75&&!third) {
			  third=true;
			  Email.enviarRun(problem.getEmail(), problem.getName(), "O Programa chegou a 75% da execução");
		  }

		String solutionString = "";
		String evaluationResultString = "";
		BitSet bitset = solution.getVariableValue(0);
		solutionString = bitset.toString();
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
	
	public static void reset() {
		first=false;
		third=false;
		second=false;
	}
	

}

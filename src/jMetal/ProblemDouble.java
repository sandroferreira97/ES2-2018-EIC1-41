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

public class ProblemDouble extends AbstractDoubleProblem {
		
	private Problem problem ;
	 
	  public ProblemDouble(Problem prob) {
		this.problem = prob;
	    setNumberOfVariables(prob.getProbVariables().size());
	    setNumberOfObjectives(AdvancedConfigurationTab.getObjQuantity());
	    setName("MyProblemDouble");

	    List<Double> lowerLimit = new ArrayList<>(getNumberOfVariables()) ;
	    List<Double> upperLimit = new ArrayList<>(getNumberOfVariables()) ;

	    for (int i = 0; i < getNumberOfVariables(); i++) {
	    	lowerLimit.add((double) -5);
		    upperLimit.add((double) 5);
	    }

	    setLowerLimit(lowerLimit);
	    setUpperLimit(upperLimit);
	  }

	  public void evaluate(DoubleSolution solution){
		  
		//if (avaliar por jar) evaluateByJar(solution) else
		  evaluateByJar(solution);

//	    double[] fx = new double[getNumberOfObjectives()];
//	    double[] x = new double[getNumberOfVariables()];
//	    for (int i = 0; i < solution.getNumberOfVariables(); i++) {
//	      x[i] = solution.getVariableValue(i) ;
//	    }
//
//	    fx[0] = 0.0;
//	    for (int var = 0; var < solution.getNumberOfVariables() - 1; var++) {
//		  fx[0] += Math.abs(x[0]); // Example for testing
//	    }
//	    
//	    fx[1] = 0.0;
//	    for (int var = 0; var < solution.getNumberOfVariables(); var++) {
//	    	fx[1] += Math.abs(x[1]); // Example for testing
//	    }
//
//	    solution.setObjective(0, fx[0]);
//	    solution.setObjective(1, fx[1]);
	  }
	  
	  public void evaluateByJar(DoubleSolution solution){
		    String solutionString ="";
		    String evaluationResultString ="";
		    for (int i = 0; i < solution.getNumberOfVariables(); i++) {
		      solutionString = solutionString + " " + solution.getVariableValue(i);  
		    }
		    try {
				String line;
		    	Process p = Runtime.getRuntime().exec("java -jar c:\\Kursawe.jar" + " " + solutionString);
		    	BufferedReader brinput = new BufferedReader(new InputStreamReader(p.getInputStream()));
		    	while ((line = brinput.readLine()) != null) 
		    		{evaluationResultString+=line;}
		    	brinput.close();
		        p.waitFor();
		      }
		      catch (Exception err) { err.printStackTrace(); }
	   		String[] individualEvaluationCriteria = evaluationResultString.split("\\s+");
		    // It is assumed that all evaluated criteria are returned in the same result string
		    for (int i = 0; i < solution.getNumberOfObjectives(); i++) {
		    	solution.setObjective(i, Double.parseDouble(individualEvaluationCriteria[i]));
		    }	    
		  }
 	  	  
	}
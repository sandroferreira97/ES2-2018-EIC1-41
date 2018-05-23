package jMetal;

import org.uma.jmetal.problem.impl.AbstractIntegerProblem;
import org.uma.jmetal.solution.IntegerSolution;
import org.uma.jmetal.util.JMetalException;

import generic.Problem;
import ui.AdvancedConfigurationTab;
import ui.ConfigurationTab;
import ui.RunTab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProblemInteger extends AbstractIntegerProblem {
	
	private Problem problem ;
	
	
	public ProblemInteger(Problem prob) throws JMetalException {
		this.problem = prob;
		setNumberOfVariables(prob.getProbVariables().size());
	    setNumberOfObjectives(AdvancedConfigurationTab.getObjQuantity());
	    setName("MyProblemInteger");

	    List<Integer> lowerLimit = new ArrayList<>(getNumberOfVariables()) ;
	    List<Integer> upperLimit = new ArrayList<>(getNumberOfVariables()) ;

	    for (int i = 0; i < getNumberOfVariables(); i++) {
	      lowerLimit.add(AdvancedConfigurationTab.getVarMin());
	      upperLimit.add(AdvancedConfigurationTab.getVarMax());
	    }

	    setLowerLimit(lowerLimit);
	    setUpperLimit(upperLimit);
	}
	


	  public void evaluate(IntegerSolution solution){
		  
		  String solutionString ="";
		    String evaluationResultString ="";
		    for (int i = 0; i < solution.getNumberOfVariables(); i++) {
		      solutionString = solutionString + " " + solution.getVariableValue(i);  
		    }
		    try {
				String line;
		    	Process p = Runtime.getRuntime().exec("java -jar " + RunTab.getJarPath() + " " + solutionString);
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
			    solution.setObjective(i, Integer.parseInt(individualEvaluationCriteria[i]));    
		    }	    
	  }
	  
	  
	}

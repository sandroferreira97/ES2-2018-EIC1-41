package jMetal;

import org.uma.jmetal.problem.impl.AbstractIntegerProblem;
import org.uma.jmetal.solution.IntegerSolution;
import org.uma.jmetal.util.JMetalException;

import generic.Problem;
import ui.AdvancedConfigurationTab;
import ui.ConfigurationTab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ProblemInteger extends AbstractIntegerProblem {
	
	private Problem prob = AdvancedConfigurationTab.getProblem();
	
	
	
	public ProblemInteger(Problem prob) throws JMetalException {
		this.prob = prob;
		CreateProblem(AdvancedConfigurationTab.getProblem());
	}
	
	

//	  public ProblemInteger(int var) {
//		  setNumberOfVariables(var);
//	}


	public void CreateProblem(Problem prob) {
		setNumberOfVariables(prob.getProbVariables().size());
	    setNumberOfObjectives(2);
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
		  
		//if (avaliar por jar) evaluateByJar(solution) else
		  
	    double[] fx = new double[getNumberOfObjectives()];
	    int[] x = new int[getNumberOfVariables()];
	    for (int i = 0; i < solution.getNumberOfVariables(); i++) {
	      x[i] = solution.getVariableValue(i) ;
	    }

	    fx[0] = 0;
	    for (int var = 0; var < solution.getNumberOfVariables() - 1; var++) {
		  fx[0] += Math.abs(x[0]+Math.random()*10); // Example for testing
	    }
	    
	    fx[1] = 0;
	    for (int var = 0; var < solution.getNumberOfVariables(); var++) {
	    	fx[1] += Math.abs(x[1]+Math.random()*10); // Example for testing
	    }

	    solution.setObjective(0, fx[0]);
	    solution.setObjective(1, fx[1]);
	  }
	  	  
	  //-----------jar--------------
	  
	  public void evaluateByJar(IntegerSolution solution){
		    String solutionString ="";
		    String evaluationResultString ="";
		    for (int i = 0; i < solution.getNumberOfVariables(); i++) {
		      solutionString = solutionString + " " + solution.getVariableValue(i);  
		    }
		    try {
				String line;
		    	Process p = Runtime.getRuntime().exec("java -jar c:\\NMMin.jar" + " " + solutionString);
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

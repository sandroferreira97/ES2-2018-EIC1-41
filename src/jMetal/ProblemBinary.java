package jMetal;

import org.uma.jmetal.problem.impl.AbstractBinaryProblem;
import org.uma.jmetal.solution.BinarySolution;
import org.uma.jmetal.solution.impl.DefaultBinarySolution;
import org.uma.jmetal.util.JMetalException;

import generic.Problem;
import ui.AdvancedConfigurationTab;
import ui.ConfigurationTab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;

public class ProblemBinary extends AbstractBinaryProblem {
	  private int bits ;
	  private Problem problem ;

	  public ProblemBinary(Problem prob) throws JMetalException {
		this.problem = prob;
		setNumberOfVariables(prob.getProbVariables().size());
	    setNumberOfObjectives(AdvancedConfigurationTab.getObjQuantity());
	    setName("MyProblemBinary");
	    
	    
	  }
	  
	  @Override
	  protected int getBitsPerVariable(int index) {
	  	if (index != 0) {
	  		throw new JMetalException("Problem MyBinaryProblem has only a variable. Index = " + index) ;
	  	}
	  	
	  	return bits ;
	  }

	
//	  @Override
//	  public BinarySolution createSolution() {
//	    return new DefaultBinarySolution(this) ;
//	  }

	  @Override
	  public void evaluate(BinarySolution solution){
		 
		  //if (avaliar por jar) evaluateByJar(solution) else
		  evaluateByJar(solution);
//	    int counterOnes;
//	    int counterZeroes;
//	    counterOnes = 0;
//	    counterZeroes = 0;
//
//	    BitSet bitset = solution.getVariableValue(0) ;
//	    for (int i = 0; i < bitset.length(); i++) {
//	      if (bitset.get(i)) {
//	        counterOnes++;
//	      } else {
//	        counterZeroes++;
//	      }
//	    }
//	    // OneZeroMax is a maximization problem: multiply by -1 to minimize
//	    solution.setObjective(0, -1.0 * counterOnes);
//	    solution.setObjective(1, -1.0 * counterZeroes);		  
	  }
	  
	  // --------- jar-------------
	  
	  public void evaluateByJar(BinarySolution solution){
		  
		    String solutionString ="";
		    String evaluationResultString ="";
		    BitSet bitset = solution.getVariableValue(0) ;
		    solutionString = bitset.toString();
		    try {
				String line;
		    	Process p = Runtime.getRuntime().exec("java -jar c:\\OneZeroMax.jar" + " " + solutionString);
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

package jMetal;

import org.uma.jmetal.problem.impl.AbstractIntegerProblem;
import org.uma.jmetal.solution.IntegerSolution;
import org.uma.jmetal.util.JMetalException;
import java.util.ArrayList;
import java.util.List;

public class MyProblemInteger extends AbstractIntegerProblem {
	
	  public MyProblemInteger() throws JMetalException {
		// 10 decision variables by default  
	    this(10);
	  }

	  public MyProblemInteger(Integer numberOfVariables) throws JMetalException {
	    setNumberOfVariables(numberOfVariables);
	    setNumberOfObjectives(2);
	    setName("MyProblemInteger");

	    List<Integer> lowerLimit = new ArrayList<>(getNumberOfVariables()) ;
	    List<Integer> upperLimit = new ArrayList<>(getNumberOfVariables()) ;

	    for (int i = 0; i < getNumberOfVariables(); i++) {
	      lowerLimit.add(-5);
	      upperLimit.add(5);
	    }

	    setLowerLimit(lowerLimit);
	    setUpperLimit(upperLimit);

	  }

	  public void evaluate(IntegerSolution solution){
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
	  	  
	}

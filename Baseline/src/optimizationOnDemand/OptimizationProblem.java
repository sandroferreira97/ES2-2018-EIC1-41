package optimizationOnDemand;

import java.util.ArrayList;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import org.uma.jmetal.problem.impl.AbstractDoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;


public class OptimizationProblem extends AbstractDoubleProblem {
	
	private static final long serialVersionUID = 1L;
	private String rulesPath, hamPath, spamPath;
	
	/*
	  public OptimizationProblem(String rulesPath, String hamPath, String spamPath) {
	    this(335);
	    this.rulesPath = rulesPath;
	    this.hamPath = hamPath;
	    this.spamPath = spamPath;
	  }
	  */
	  
	 
	  public OptimizationProblem(Integer numberOfVariables) {
		numberOfVariables = Gui.getQuantity();
	    setNumberOfVariables(numberOfVariables);
	    //setNumberOfObjectives(2);
	    setName("OptimizationProblem");

	    List<Double> lowerLimit = new ArrayList<>(getNumberOfVariables()) ;
	    List<Double> upperLimit = new ArrayList<>(getNumberOfVariables()) ;

	    //intervalo de valores aqui
	    for (int i = 0; i < getNumberOfVariables(); i++) {
	      lowerLimit.add((double) Gui.getMinRange());
	      upperLimit.add((double) Gui.getMaxRange());
	    }

	    setLowerLimit(lowerLimit);
	    setUpperLimit(upperLimit);
	  }

	public void evaluate(DoubleSolution solution){
		//RP[] rules = Functions.getRules("rules.cf");
	    double[] fx = new double[getNumberOfObjectives()];
	    double[] x = new double[getNumberOfVariables()];
	    for (int i = 0; i < solution.getNumberOfVariables(); i++) {
	      x[i] = solution.getVariableValue(i) ;
	    }

//	    for(int i = 0;i < rules.length;i++){
//	    	rules[i].setPeso(x[i]);
//	    }
	    
	    fx[0] = 0.0;
	    
		  //fx[0] = Functions.Fp(rules, hamPath);
	    
	    
	    fx[1] = 0.0;
	   
	    	//fx[1] = Functions.Fn(rules, spamPath);
	    

	    solution.setObjective(0, fx[0]);
	    solution.setObjective(1, fx[1]);
	  }
	
	
	

}

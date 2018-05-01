package jMetal;

import org.uma.jmetal.problem.impl.AbstractBinaryProblem;
import org.uma.jmetal.solution.BinarySolution;
import org.uma.jmetal.solution.impl.DefaultBinarySolution;
import org.uma.jmetal.util.JMetalException;
import java.util.BitSet;

public class MyProblemBinary extends AbstractBinaryProblem {
	  private int bits ;

	  public MyProblemBinary() throws JMetalException {
		// 10 decision variables by default  
	    this(10);
	  }

	  public MyProblemBinary(Integer numberOfBits) throws JMetalException {
		setNumberOfVariables(1);
	    setNumberOfObjectives(2);
	    setName("MyProblemBinary");
	    bits = numberOfBits ;

	  }
	  
	  @Override
	  protected int getBitsPerVariable(int index) {
	  	if (index != 0) {
	  		throw new JMetalException("Problem MyBinaryProblem has only a variable. Index = " + index) ;
	  	}
	  	return bits ;
	  }

	  @Override
	  public BinarySolution createSolution() {
	    return new DefaultBinarySolution(this) ;
	  }

	  @Override
	  public void evaluate(BinarySolution solution){
	    int counterOnes;
	    int counterZeroes;
	    counterOnes = 0;
	    counterZeroes = 0;

	    BitSet bitset = solution.getVariableValue(0) ;
	    for (int i = 0; i < bitset.length(); i++) {
	      if (bitset.get(i)) {
	        counterOnes++;
	      } else {
	        counterZeroes++;
	      }
	    }
	    // OneZeroMax is a maximization problem: multiply by -1 to minimize
	    solution.setObjective(0, -1.0 * counterOnes);
	    solution.setObjective(1, -1.0 * counterZeroes);		  
	  }
  
	}

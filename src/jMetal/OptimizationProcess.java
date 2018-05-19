package jMetal;

import java.io.IOException;

import generic.Problem;
import ui.AdvancedConfigurationTab;

public class OptimizationProcess {
	
/* O conjunto de algoritmos adequados a cada tipo de problema est�o indicados aqui */
	String[] AlgorithsForDoubleProblemType = new String[]{"NSGAII","SMSEMOA","GDE3","IBEA","MOCell","MOEAD","PAES","RandomSearch"};
	String[] AlgorithsForIntegerProblemType = new String[]{"NSGAII","SMSEMOA","MOCell","PAES","RandomSearch"};
	String[] AlgorithsForBinaryProblemType = new String[]{"NSGAII","SMSEMOA","MOCell","MOCH","PAES","RandomSearch","SPEA2"};	
	
	public static ExperimentsInteger eI;
	public static Problem prob;

	public OptimizationProcess(Problem prob) {
		this.prob = prob;
	}
		
	public void run() {
	
		try {
			switch(AdvancedConfigurationTab.getVariableType()) {
			case 1:
				eI = new ExperimentsInteger(prob);
				eI.run();
				break;
				
			case 2:
				ExperimentsInteger.run();
				break;
				
			case 3:
				ExperimentsDouble.run();
				break;
			}
//			
//			
			

/* As simula��es com ExternalViaJAR no nome tem as fun��es de avalia��o 
   implementadas em .JAR externos que s�o invocados no m�todo evaluate() 
   As simula��es que executam .jar externos s�o muito mais demoradas, 
   maxEvaluations e INDEPENDENT_RUNS tem por isso valores mais baixos */
//			ExperimentsDoubleExternalViaJAR.main(null);
//			ExperimentsIntegeExternalViaJAR.main(null);
//			ExperimentsBinaryExternalViaJAR.main(null);		
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
}
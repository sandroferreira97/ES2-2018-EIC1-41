package jMetal;

import java.io.IOException;
import java.util.ArrayList;

import generic.Email;
import generic.Functions;
import generic.Problem;
import generic.Variable;
import generic.Xml;
import ui.AdvancedConfigurationTab;

public class OptimizationProcess {
	
/* O conjunto de algoritmos adequados a cada tipo de problema estão indicados aqui */
	String[] AlgorithsForDoubleProblemType = new String[]{"NSGAII","SMSEMOA","GDE3","IBEA","MOCell","MOEAD","PAES","RandomSearch"};
	String[] AlgorithsForIntegerProblemType = new String[]{"NSGAII","SMSEMOA","MOCell","PAES","RandomSearch"};
	String[] AlgorithsForBinaryProblemType = new String[]{"NSGAII","SMSEMOA","MOCell","MOCH","PAES","RandomSearch","SPEA2"};	
	
	public static ExperimentsInteger eI;
	public static ExperimentsBinary eB;
	public static ExperimentsDouble eD;
	public static Problem prob;

	public OptimizationProcess(Problem prob) {
		this.prob = prob;
	}
		
	public void run() {
	
		Xml.saveConfig(prob);
		Email.enviarRun(prob.getEmail(), prob.getName(), "O Programa começou a correr");
		
		try {
			switch(AdvancedConfigurationTab.getVariableType()) {
			case 1:
				eB = new ExperimentsBinary(prob);
				eB.run();
				break;
				
			case 2:
				eI = new ExperimentsInteger(prob);
				eI.run();
				break;
				
			case 3:
				eD = new ExperimentsDouble(prob);
				eD.run();
				break;
			}
//			
//			
			

/* As simulações com ExternalViaJAR no nome tem as funções de avaliação 
   implementadas em .JAR externos que são invocados no método evaluate() 
   As simulações que executam .jar externos são muito mais demoradas, 
   maxEvaluations e INDEPENDENT_RUNS tem por isso valores mais baixos */
//			ExperimentsDoubleExternalViaJAR.main(null);
//			ExperimentsIntegeExternalViaJAR.main(null);
//			ExperimentsBinaryExternalViaJAR.main(null);		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} 
}

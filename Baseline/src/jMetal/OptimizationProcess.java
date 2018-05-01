package jMetal;

import java.io.IOException;

public class OptimizationProcess {
	
/* O conjunto de algoritmos adequados a cada tipo de problema estão indicados aqui */
	String[] AlgorithsForDoubleProblemType = new String[]{"NSGAII","SMSEMOA","GDE3","IBEA","MOCell","MOEAD","PAES","RandomSearch"};
	String[] AlgorithsForIntegerProblemType = new String[]{"NSGAII","SMSEMOA","MOCell","PAES","RandomSearch"};
	String[] AlgorithsForBinaryProblemType = new String[]{"NSGAII","SMSEMOA","MOCell","MOCH","PAES","RandomSearch","SPEA2"};	

	public static void main(String[] args) {
		try {

/* Deverão ser comentadas ou retiradas de comentário as linhas 
   correspondentes às simulações que se pretendem executar */
//			ExperimentsDouble.main(null);
//			ExperimentsInteger.main(null);
			ExperimentsBinary.main(null);

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

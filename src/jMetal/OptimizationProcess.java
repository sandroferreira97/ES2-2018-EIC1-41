package jMetal;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import generic.Email;
import generic.Functions;
import generic.Problem;
import generic.Variable;
import generic.Xml;
import ui.AdvancedConfigurationTab;
import ui.RunTab;

public class OptimizationProcess {

	/*
	 * O conjunto de algoritmos adequados a cada tipo de problema estão indicados
	 * aqui
	 */
	String[] AlgorithsForDoubleProblemType = new String[] { "NSGAII", "SMSEMOA", "GDE3", "IBEA", "MOCell", "MOEAD",
			"PAES", "RandomSearch" };
	String[] AlgorithsForIntegerProblemType = new String[] { "NSGAII", "SMSEMOA", "MOCell", "PAES", "RandomSearch" };
	String[] AlgorithsForBinaryProblemType = new String[] { "NSGAII", "SMSEMOA", "MOCell", "MOCH", "PAES",
			"RandomSearch", "SPEA2" };

	public static ExperimentsInteger eI;
	public static ExperimentsBinary eB;
	public static ExperimentsDouble eD;
	public static Problem prob;
	private int x = 0;

	public OptimizationProcess(Problem prob) {
		this.prob = prob;
	}

	public void run() {

//		Xml.saveConfig(prob);
//		Email.enviarRun(prob.getEmail(), prob.getName(), "O Programa começou a correr");
		
		try {
			switch (AdvancedConfigurationTab.getVariableType()) {
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

//			ProblemBinary.reset();
//			ProblemDouble.reset();
//			ProblemInteger.reset();
//			Email.enviarRun(prob.getEmail(), prob.getName(),
//					"O Programa terminou a execução, Obrigado por ter utilizado o nosso programa");
//			File a = new File(prob.getName() + ".xml");
//			a.delete();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

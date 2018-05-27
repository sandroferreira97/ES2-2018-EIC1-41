package generic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ui.AdvancedConfigurationTab;

/**
 * Functions is the class that allows to read the files .rf results
 * 
 * @author Nuno Fialho EIC1 72910
 * @author Sandro Ferreira EIC1 72911
 * @author Duarte Pinto EIC1 73117
 */
public class Functions {
	
	/**
	 * This function calls readAutomatic choosing the parameters according to the variable type of the problem
	 * 
	 * @param prob is the problem to be solved
	 * @param alg is the algorithm name that is going to be used in order to find the file
	 * @return an arrayList with data from the .rf file
	 */
	public static ArrayList<ArrayList<Double>> readResults(Problem prob,String alg) {
		ArrayList<ArrayList<Double>> rules = new ArrayList<ArrayList<Double>>();
		switch (AdvancedConfigurationTab.getVariableType()) {
		// binary
		case 1:
			rules = readAutomatic("MyProblemBinary", alg);
			break;
		// integer
		case 2:
			rules = readAutomatic("MyProblemInteger", alg);
			break;
		// double
		case 3:
			rules = readAutomatic("MyProblemDouble", alg);
			break;
		}

		return rules;

	}
	

	public static String fileType() {
		String name = "";
		switch (AdvancedConfigurationTab.getVariableType()) {
		// binary
		case 1:
			name = "Binary";
			break;
		// integer
		case 2:
			name = "Integer";
			break;
		// double
		case 3:
			name = "Double";
			break;
		}

		return name;

	}
	
	/**
	 * Function that reads the .rf file
	 * 
	 * @param name
	 * @param alg
	 * @return an arrayList with data from the .rf file
	 */
	public static ArrayList<ArrayList<Double>> readAutomatic(String name, String alg) {
		ArrayList<ArrayList<Double>> f0 = new ArrayList<ArrayList<Double>>();
		
		String line = "";
		try {
			
				BufferedReader in = new BufferedReader(new FileReader(
						"experimentBaseDirectory/referenceFronts/" + name + "." + alg + ".rf"));
				while ((line = in.readLine()) != null) {
					String fx[] = line.split(" ");
					ArrayList<Double> f1 = new ArrayList<Double>();
					for(int i = 0; i < fx.length;i++) {	
						f1.add(Double.parseDouble((fx[i])));
					}
						f0.add(f1);	
				}
				in.close();
		} catch (IOException e) {
			return null;
		}

		return f0;
	}

//	public static ArrayList<Variable> readWeights(ArrayList<Variable> rules, int index, Problem prob) {
//
//		int i = 0;
//		String line = "";
//		try {
//			for (int z = 0; z < prob.getAlgorithms().size(); z++) {
//				BufferedReader in = new BufferedReader(new FileReader("experimentBaseDirectory/Experiments" + fileType()
//						+ "/data/" + prob.getAlgorithms().get(z) + "/MyProblem" + fileType() + "/BEST_HV_VAR.tsv"));
//				while ((line = in.readLine()) != null) {
//					if (i == index) {
//						String fx[] = line.split(" ");
//						for (int j = 0; j < fx.length; j++) {
//							rules.get(j).setWeight(fx[j]);
//						}
//					}
//					i++;
//				}
//
//				in.close();
//			}
//		} catch (IOException e) {
//			return null;
//		}
//
//		return rules;
//
//	}

}

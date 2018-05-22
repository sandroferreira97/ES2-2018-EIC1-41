package generic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ui.AdvancedConfigurationTab;

public class Functions {

	public static String[] readResults() {
		String[] rules = {""};
		switch (AdvancedConfigurationTab.getVariableType()) {
		//binary
		case 1:
			rules = readAutomatic("MyProblemBinary");
			break;
			//integer
		case 2:
		rules =	readAutomatic("MyProblemInteger");
			break;
			//double
		case 3:
		rules =	readAutomatic("MyProblemDouble");
			break;
		}
		
		return rules;

	}
	
	public static String[] readAutomatic(String name) {
		
		String[] rules = new String[3];
		
		Double media = 0.0;
		int control = 0;
		ArrayList<Integer> f1 = new ArrayList<Integer>();
		ArrayList<Integer> f2 = new ArrayList<Integer>();
		
		String line = "";
		try {
			BufferedReader in = new BufferedReader(new FileReader("experimentBaseDirectory/referenceFronts/"+name+".rf"));
				while ((line = in.readLine()) != null) {
				    String fx[] = line.split(" ");
				    f1.add((int) Double.parseDouble(fx[0]));
				    f2.add((int) Double.parseDouble(fx[1]));
					}
				in.close();
		} catch (IOException e) {return null;}
		
		Double min = (double) (f1.get(0) + f2.get(0));
		for(int i = 0; i < f1.size();i++){
			media = (double) (f1.get(i) + f2.get(i));
			if(media < min){
				min = media;
				control = i;
			}
			
		}
		rules[0] = f1.get(control).toString();
		rules[1] = f2.get(control).toString();
		rules[2] = "" + control;
		return rules;
		
	}
	
public static ArrayList<Variable> readWeights(String name, int index, int prob) {
		
		ArrayList<Variable> rules = new ArrayList<Variable>(20);
		int i = 0;
		String line = "";
		try {
			BufferedReader in = new BufferedReader(new FileReader("experimentBaseDirectory/ExperimentsDouble/data/NSGAII/MyProblemDouble/BEST_HV_VAR.tsv"));
				while ((line = in.readLine()) != null) {
					if(i == index){
				    String fx[] = line.split(" ");
				    	for(int j = 0; j < fx.length;j++){
				    		rules.get(j).setWeight(fx[j]);
				    		System.out.println("adeus");
				    	}
					}
					i++;
					}
				in.close();
		} catch (IOException e) {return null;}

	
		
		return rules;
		
	}

}

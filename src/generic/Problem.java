package generic;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Problem")
public class Problem {
	private String probName;
    private String probDescription;  
	private ArrayList<Variable> probVariables;
	private ArrayList<String> probAlgorithms;
	private String probType;
	private String probEmail;

	
	public Problem() {
		System.out.println("teste XML");
	}
	
	
	public Problem(String probName, String probDescription, ArrayList<Variable> probVariables, ArrayList<String> probAlgorithms, String probType, String probEmail) {
		this.probName = probName;
		this.probDescription = probDescription;
		this.probVariables = probVariables;
		this.probAlgorithms = probAlgorithms;
		this.probType = probType;
		this.probEmail = probEmail;
		
	}
	
	
	@XmlElement(name="ProblemName")
	public String getName() {
		return probName;
	}
	
	public void setName(String name) {
		this.probName = name;
	}

	@XmlElement(name="ProblemDescription")
	public String getDescription() {
		return probDescription;
	}

	@XmlElementWrapper(name="Variables")
	@XmlElement(name="Variable")
	public ArrayList<Variable> getProbVariables() {
		return probVariables;
	}

	public void setProbVariables(ArrayList<Variable> variables) {
		this.probVariables = variables;
	}
	
	
	
	@XmlElementWrapper(name="Algorithms")
	@XmlElement(name="Algorith")
	public ArrayList<String> getAlgorithms() {
		return probAlgorithms;
	}

	public void setAlgorithms(ArrayList<String> algorithms) {
		this.probAlgorithms = algorithms;
	}
	
	public void addAlgorithms(String alg) {
		this.probAlgorithms.add(alg);
	}
	
	public void setDescription(String description) {
		this.probDescription = description;
	}
	
	@XmlElement(name="Type")
	public String getType() {
		return probType;
	}
	
	public void setType(String type) {
		this.probType = type;
	}

	@XmlElement(name="UserEmail")
	public String getEmail() {
		return probEmail;
	}

	public void setEmail(String email) {
		this.probEmail = email;
	}
	
	
	
}
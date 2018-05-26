package generic;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class creates the problem. It has various characteristics:
 * the problem name,the problem  description, the prblem variables,
 * the algorithms that can be used, the problem type, and the problem
 * mail
 * 
 * @author Nuno Fialho EIC1 72910
 * @author Sandro Ferreira EIC1 72911
 * @author Duarte Pinto EIC1 73117
 *
 */

@XmlRootElement(name="Problem")
public class Problem {
	private String probName;
    private String probDescription;  
	private ArrayList<Variable> probVariables;
	private ArrayList<String> probAlgorithms;
	private String probType;
	private String probEmail;
	private int time;
	private int CritNum;
	private String RuleGroup;
	private String jarpath;

	
	public Problem() {
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

	@XmlElement(name="MaxTime")
	public int getTime() {
		return time;
	}
	
	public void setTime(int time) {
		this.time = time;
	}
	
	@XmlElement(name="JarPath")
	public String getJarPath() {
		return jarpath;
	}
	
	public void setJarPath(String jar) {
		this.jarpath = jar;
	}
	
	@XmlElement(name="NumberOfCriteria")
	public int getCritNum() {
		return CritNum;
	}
	
	public void setCritNum(int CritNum) {
		this.CritNum = CritNum;
	}
	
	@XmlElement(name="RulesGroup")
	public String getRuleGroup() {
		return RuleGroup;
	}
	
	public void setRuleGroup(String RuleGroup) {
		this.RuleGroup = RuleGroup;
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
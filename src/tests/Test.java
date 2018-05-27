package tests;


import generic.Problem;
import java.io.IOException;
import generic.Xml;
import java.util.ArrayList;
import generic.Variable;
import generic.Graph;

public class Test {
	private Problem p;

	public Problem getP() {
		return p;
	}

	public void setP(Problem p) {
		this.p = p;
	}

	public void testXml() throws IOException {
		Xml x = null;
		ArrayList<Variable> v = new ArrayList<Variable>();
		ArrayList<String> s = new ArrayList<String>();
		p = new Problem("a", "a", v, s, "a", "a");
		x.saveConfig(p);
	}

	public void testGraph() throws IOException {
		ArrayList<Variable> v = new ArrayList<Variable>();
		ArrayList<String> s = new ArrayList<String>();
		p = new Problem("a", "a", v, s, "a", "a");
		Graph g = new Graph(p);
	}
}
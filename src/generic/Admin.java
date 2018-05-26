package generic;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Admin is the class that creates an administrator
 * 
 *
 * @author Nuno Fialho EIC1 72910
 * @author Sandro Ferreira EIC1 72911
 * @author Duarte Pinto EIC1 73117
 */

@XmlRootElement(name="Admin")
public class Admin {
	private String name;
	private String email;
	private String password;
	private String xmlDir;
	private int indRuns;
	private int maxEval;
	
	public Admin() {
	}
	/**
	 * Class constructor, will crate an administrator with a name, a mail, a password and
	 * a directory to the xml file
	 *  
	 * @param n is the name 
	 * @param mail is the mail 
	 * @param pass is the password
	 * @param dir is the directory to the xml file
	 * @param ind is the number of independent runs
	 * @param max is the number of max evaluations
	 */
	public Admin(String n, String mail, String pass, String dir, int ind, int max) {
		super();
		name = n;
		email = mail;
		password = pass;
		xmlDir = dir;
		indRuns=ind;
		maxEval=max;
	}

	
	@XmlElement(name="AdminName")
	public String getName() {
		return name;
	}
	
	@XmlElement(name="indRuns")
	public int getIndRuns() {
		return indRuns;
	}
	
	@XmlElement(name="maxEval")
	public int getMaxEval() {
		return maxEval;
	}

	@XmlElement(name="AdminEmail")
	public String getEmail() {
		return email;
	}
	
	@XmlElement(name="AdminPass")
	public String getPassword() {
		return password;
	}

	@XmlElement(name="xmlDir")
	public String getXmlDir() {
		return xmlDir;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMaxEval(int max) {
		this.maxEval=max;
	}
	
	public void setIndRuns(int ind) {
		this.indRuns=ind;
	}
	
	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setXmlDir(String xmlDir) {
		this.xmlDir = xmlDir;
	}

	
	
}

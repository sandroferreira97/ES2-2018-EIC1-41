package generic;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Admin")
public class Admin {
	private String name;
	private String email;
	private String password;
	private String xmlDir;
	
	public Admin() {
	}
	
	public Admin(String n, String mail, String pass, String dir) {
		super();
		name = n;
		email = mail;
		password = pass;
		xmlDir = dir;
	}

	
	@XmlElement(name="AdminName")
	public String getName() {
		return name;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public void setXmlDir(String xmlDir) {
		this.xmlDir = xmlDir;
	}

	
	
}

package generic;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Admin")
public class Admin {
	private String Name;
	private String email;
	private String password;
	private String xmlDir;
	
	public Admin() {
	}
	
	public Admin(String name, String email, String password, String xmlDir) {
		super();
		Name = name;
		this.email = email;
		this.password = password;
		this.xmlDir = xmlDir;
	}

	
	@XmlElement(name="AdminName")
	public String getName() {
		return Name;
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
	

	public void load(String path) {
		JAXBContext jaxbContext;
		Admin
		try {
			jaxbContext = JAXBContext.newInstance(Problem.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			prob = (Problem) jaxbUnmarshaller.unmarshal(a);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
}

package generic;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ui.AdvancedConfigurationTab;
import ui.ConfigurationTab;

public abstract class Xml {

	public static void saveConfig(Problem prob) {
//		try {
//			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
//			DocumentBuilder build = dFact.newDocumentBuilder();
//			Document doc = build.newDocument();
//
//			Element problem = doc.createElement("Problem");
//			Element name = doc.createElement("ProblemName");
//			Element description = doc.createElement("ProblemDescription");
//			Element mail = doc.createElement("UserEmail");
//			Element variables = doc.createElement("Variables");
//			Element algorithms = doc.createElement("Algorithms");
//			doc.appendChild(problem);
//
//			problem.appendChild(name);
//			name.appendChild(doc.createTextNode(prob.getName()));
//
//			problem.appendChild(description);
//			description.appendChild(doc.createTextNode(prob.getDescription()));
//
//			problem.appendChild(mail);
//			mail.appendChild(doc.createTextNode(prob.getEmail()));
//
//			problem.appendChild(variables);
//			variables.appendChild(doc.createTextNode(""));
//
//			problem.appendChild(algorithms);
//			algorithms.appendChild(doc.createTextNode(""));
//
//			ArrayList<String> algorithmsArray = prob.getAlgorithms();
//			for (int i = 0; i < algorithmsArray.size(); i++) {
//				String algorithmList = algorithmsArray.get(i);
//				Element algorithm = doc.createElement(algorithmList);
//				algorithms.appendChild(algorithm);
//			}
//
//			ArrayList<Variable> vars = prob.getProbVariables();
//			String type = vars.get(0).getType();
//
//			if ((type.equals("Integer") || type.equals("Double")) && (vars.size() > 0)) {
//
//				Element var_min = doc.createElement("Min");
//				var_min.appendChild(doc.createTextNode(String.valueOf(vars.get(0).getMin())));
//				variables.appendChild(var_min);
//
//				Element var_max = doc.createElement("Max");
//				var_max.appendChild(doc.createTextNode(String.valueOf(vars.get(0).getMax())));
//				variables.appendChild(var_max);
//			}
//			for (int i = 0; i < vars.size(); i++) {
//				String varName = "Var" + i;
//				Element variable = doc.createElement(varName);
//				variables.appendChild(variable);
//
//				Element var_name = doc.createElement("Name");
//				Element var_weight = doc.createElement("Weight");
//				Element var_type = doc.createElement("Type");
//
//				// Adicionar o nome
//				var_name.appendChild(doc.createTextNode(String.valueOf(vars.get(i).getName())));
//				variable.appendChild(var_name);
//
//				// Adicionar o peso
//				var_weight.appendChild(doc.createTextNode(String.valueOf(vars.get(i).getWeight())));
//				variable.appendChild(var_weight);
//
//				// Adicionar o tipo de variavel
//				var_type.appendChild(doc.createTextNode(String.valueOf(vars.get(i).getType())));
//				variable.appendChild(var_type);
//
//			}
//
//			TransformerFactory transformerFactory = TransformerFactory.newInstance();
//			Transformer transformer = transformerFactory.newTransformer();
//
//			// Escrever no ficheiro xml
//
//			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
//			DOMSource source = new DOMSource(doc);
//			String time = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());
//			String fname = "Save_" + prob.getName() + "_" + time + ".xml";
//			StreamResult result = new StreamResult(new File(fname));
//
//			// Para testar na consola
//			// StreamResult result = new StreamResult(System.out);
//			transformer.transform(source, result);
//
//		} catch (TransformerException ex) {
//			ex.printStackTrace();
//		} catch (ParserConfigurationException ex) {
//			System.out.println("Error building document");
//		}
		
		  try {
              JAXBContext context = JAXBContext.newInstance(Problem.class);
              Marshaller m = context.createMarshaller();
              //for pretty-print XML in JAXB
              m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

              // Write to System.out for debugging
               m.marshal(prob, System.out);

              // Write to File
               
               String time = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());
   			String fname = "Save_" + prob.getName() + "_" + time + ".xml";
              m.marshal(prob, new File(fname));
          } catch (JAXBException e) {
              e.printStackTrace();
          }
	}

	public static void loadConfig(File a) {
		JAXBContext jaxbContext;
		Problem prob = null;
		try {
			jaxbContext = JAXBContext.newInstance(Problem.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			prob = (Problem) jaxbUnmarshaller.unmarshal(a);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		AdvancedConfigurationTab.setProblem(prob);
		ConfigurationTab.load(prob);
		
		
	}

}
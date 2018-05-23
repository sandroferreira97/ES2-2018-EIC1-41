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

	public static void saveConfig(Problem prob,String path) {
		
		  try {
              JAXBContext context = JAXBContext.newInstance(Problem.class);
              Marshaller m = context.createMarshaller();
              //for pretty-print XML in JAXB
              m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

              // Write to System.out for debugging
               //m.marshal(prob, System.out);

              // Write to File
               
               String time = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());
   			String fname = path+"/Save_" + prob.getName() + "_" + time + ".xml";
              m.marshal(prob, new File(fname));
          } catch (JAXBException e) {
              e.printStackTrace();
          }
	}
	
	
	public static void saveConfig(Problem prob) {
		
		  try {
            JAXBContext context = JAXBContext.newInstance(Problem.class);
            Marshaller m = context.createMarshaller();
            //for pretty-print XML in JAXB
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Write to System.out for debugging
            // m.marshal(prob, System.out);

            // Write to File
            m.marshal(prob, new File(prob.getName()+".xml"));
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
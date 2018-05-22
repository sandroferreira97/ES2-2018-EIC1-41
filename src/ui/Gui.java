
package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import java.awt.Choice;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.jfree.ui.RefineryUtilities;

import generic.Admin;
import generic.Email;
import generic.Problem;
import jMetal.OptimizationProcess;

import java.awt.Color;
import java.awt.Font;

/**
 * GUI is the class that creates the application interface
 *
 * @author Nuno Fialho EIC1 72910
 * @author Sandro Ferreira EIC1 72911
 * @author Duarte Pinto EIC1 73117
 */

public class Gui {

	private static JFrame frame;
	private boolean configuration;

	private boolean advanced;
	private AdvancedConfigurationTab AdvancedTab;
	private static Admin adm;

	String[] AlgorithsForDoubleProblemType = new String[] { "NSGAII", "SMSEMOA", "GDE3", "IBEA", "MOCell", "MOEAD",
			"PAES", "RandomSearch" };
	String[] AlgorithsForIntegerProblemType = new String[] { "NSGAII", "SMSEMOA", "MOCell", "PAES", "RandomSearch" };
	String[] AlgorithsForBinaryProblemType = new String[] { "NSGAII", "SMSEMOA", "MOCell", "MOCH", "PAES",
			"RandomSearch", "SPEA2" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					File a = new File("config.xml");
					if (a.exists()) {
						JAXBContext jaxbContext;
						try {
							jaxbContext = JAXBContext.newInstance(Admin.class);
							Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
							adm = (Admin) jaxbUnmarshaller.unmarshal(new File("config.xml"));
						} catch (JAXBException e) {
							e.printStackTrace();
						}
						
						
						
						
						Email.setAccount(adm.getEmail(), adm.getPassword());
						Gui window = new Gui();
						window.frame.setVisible(true);
					}else {
						System.out.println("config.xml file is missing");
					}
					

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		configuration = false;
		advanced = false;

		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(frame, "Are you sure to close this window?", "Really Closing?",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tab, BorderLayout.CENTER);

		//
		// Creating the Configuration Panel
		//
		ConfigurationTab Configtab = new ConfigurationTab(frame, this);
		JPanel config = Configtab.getConfig();
		tab.addTab("Configuration", null, config, null);

		//
		// Creating the Advanced Configuration Panel
		//
		AdvancedTab = new AdvancedConfigurationTab(frame, this);
		JPanel configadvanced = AdvancedTab.getConfigadvanced();
		tab.addTab("Advanced Configuration", null, configadvanced, null);

		//
		// Creating the Variable Configuration Panel
		//
		VariableConfigurationTab VarconfigTab = new VariableConfigurationTab(frame, this);
		JPanel varconfig = VarconfigTab.getVarconfig();
		tab.addTab("Variable Configuration", null, varconfig, null);

		//
		// Creating the Run panel
		//
		RunTab runTab = new RunTab(frame, this);
		JPanel run = runTab.getRun();
		tab.addTab("Run", null, run, null);

		//
		// Creating the Graph panel
		//
		GraphTab graphTab = new GraphTab(frame, this);
		JPanel graph = graphTab.getGraph();
		tab.addTab("Graph", null, graph, null);

		//
		// Creating the FAQ panel
		//
		FaqTab faqTab = new FaqTab(frame, this);
		JPanel faq = faqTab.getFaq();
		tab.addTab("FAQ", null, faq, "Frequently Asked Questions");

		//
		// Creating the help panel
		//
		HelpTab helpTab = new HelpTab(frame, this);
		JPanel help = helpTab.getHelp();
		tab.addTab("Help", null, help, null);

	}

	public boolean isConfiguration() {
		return configuration;
	}

	public void setConfiguration(boolean configuration) {
		this.configuration = configuration;
	}

	public static void repaint() {
		frame.repaint();
	}

	public boolean isAdvanced() {
		return advanced;
	}

	public void setAdvanced(boolean advanced) {
		this.advanced = advanced;
	}

	public static Admin getAdm() {
		return adm;
	}
	
	

}

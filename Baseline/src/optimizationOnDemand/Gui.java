package optimizationOnDemand;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import java.awt.Color;
import java.awt.Font;

public class Gui {

	private JFrame frame;
	private JTextField name;
	private JTextField emailuser;
	private String nomeproblema;
	private String mailuser;
	private String descricao;
	private JTextField emailresposta;
	private JTextField subject;
	private JTextField varname;
	private static JTextField varmin;
	private static JTextField varmax;
	private JTable table;
	private JTextField path;
	private boolean configuration;
	private boolean advanced;
	private static JSpinner quantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
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
		configuration=false;
		advanced=false;
		
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tab, BorderLayout.CENTER);
		
		JPanel config = new JPanel();
		tab.addTab("Configuration", null, config, null);
		config.setLayout(null);
		
		name = new JTextField();
		name.setBounds(157, 30, 351, 22);
		config.add(name);
		name.setColumns(10);
		
		JLabel probname = new JLabel("Problem name:");
		probname.setBounds(12, 33, 116, 16);
		config.add(probname);
		
		JLabel probdescipt = new JLabel("Problem description:");
		probdescipt.setBounds(12, 84, 144, 16);
		config.add(probdescipt);
		
		JEditorPane description = new JEditorPane();
		description.setBounds(158, 84, 350, 150);
		config.add(description);
		
		JLabel email = new JLabel("Email");
		email.setBounds(12, 265, 56, 16);
		config.add(email);
		
		emailuser = new JTextField();
		emailuser.setBounds(157, 262, 351, 22);
		config.add(emailuser);
		emailuser.setColumns(10);
		
		JButton validate = new JButton("Validate");
		validate.setBounds(300, 500, 100, 25);
		config.add(validate);
		validate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(emailuser.getText().length()>0 && name.getText().length()>0 && description.getText().length()>0){
					nomeproblema = name.getText();
					mailuser = emailuser.getText();
					descricao = description.getText();
					JOptionPane.showMessageDialog(frame, "Data validated with success");
					configuration=true;
				}else{
					JOptionPane.showMessageDialog(frame, "Please fill all fields");
				}
			}
		});
		
		JPanel configadvanced = new JPanel();
		tab.addTab("Advanced Configuration", null, configadvanced, null);
		configadvanced.setLayout(null);
		
		JLabel lbltime = new JLabel("Maximum waiting time(seconds)");
		lbltime.setBounds(40, 50, 196, 16);
		configadvanced.add(lbltime);
		
		JLabel lblquantity = new JLabel("Number of variables:");
		lblquantity.setBounds(40, 115, 150, 16);
		configadvanced.add(lblquantity);
		
		quantity = new JSpinner();
		quantity.setBounds(255, 112, 116, 22);
		configadvanced.add(quantity);
		
		JLabel lblRuleName = new JLabel("Rules name:");
		lblRuleName.setBounds(40, 178, 150, 16);
		configadvanced.add(lblRuleName);
		
		varname = new JTextField();
		varname.setBounds(255, 175, 116, 22);
		configadvanced.add(varname);
		varname.setColumns(10);
		
		JLabel lblVarType = new JLabel("Variable type:");
		lblVarType.setBounds(40, 239, 150, 16);
		configadvanced.add(lblVarType);
		
		JLabel lblvaluerange = new JLabel("Range of values:");
		lblvaluerange.setBounds(40, 299, 150, 16);
		configadvanced.add(lblvaluerange);
		
		
		varmin = new JTextField();
		varmin.setBounds(255, 296, 116, 22);
		configadvanced.add(varmin);
		varmin.setColumns(10);
		
		varmax = new JTextField();
		varmax.setBounds(424, 296, 116, 22);
		configadvanced.add(varmax);
		varmax.setColumns(10);
		
		
		
		
		lblvaluerange.setVisible(false);
		varmin.setVisible(false);
		varmax.setVisible(false);
		
		JComboBox<?> type = new JComboBox();
		type.setModel(new DefaultComboBoxModel(new String[] {"", "Binary", "Integer", "Double"}));
		type.setBounds(255, 236, 116, 22);
		configadvanced.add(type);
		
		
		
		
		JSpinner maxtime = new JSpinner();
		maxtime.setBounds(255, 47, 116, 22);
		configadvanced.add(maxtime);
		type.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	
	        	if(type.getSelectedItem().toString().equals("")){
	        		lblvaluerange.setVisible(false);
	        		varmin.setVisible(false);
	        		varmax.setVisible(false);
	        	}
	        	
	        	if(type.getSelectedItem().toString().equals("Binary")){
	        		lblvaluerange.setVisible(false);
	        		varmin.setVisible(false);
	        		varmax.setVisible(false);
	        	}
	        	
	        	if(type.getSelectedItem().toString().equals("Integer")){
	        		lblvaluerange.setVisible(true);
	        		varmin.setVisible(true);
	        		varmax.setVisible(true);
	        	}
	        	
	        	if(type.getSelectedItem().toString().equals("Double")){
	        		lblvaluerange.setVisible(true);
	        		varmin.setVisible(true);
	        		varmax.setVisible(true);
	        	}
	        }
		});
		
		JLabel lblOptimizationType = new JLabel("Optimization type:");
		lblOptimizationType.setBounds(40, 350, 150, 16);
		configadvanced.add(lblOptimizationType);
		
		JComboBox OptimizationType = new JComboBox();
		OptimizationType.setModel(new DefaultComboBoxModel(new String[] {"", "Manual", "Automatic", "Mixed"}));
		OptimizationType.setBounds(255, 350, 116, 22);
		configadvanced.add(OptimizationType);
			
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!configuration){
					JOptionPane.showMessageDialog(frame, "Please fill all fields in the configuration tab");
				}else if((int)maxtime.getValue()!=0 && !type.getSelectedItem().toString().equals("")&& !varname.getText().equals("") && (int)quantity.getValue()!=0){
					
					
					JOptionPane.showMessageDialog(frame, "Data generated with success");
					advanced=true;
				}else{
					JOptionPane.showMessageDialog(frame, "Please fill in the required data");
					
				}
			}
		});
		
		btnGenerate.setBounds(255, 474, 97, 25);
		configadvanced.add(btnGenerate);
		
		
		JPanel varconfig = new JPanel();
		tab.addTab("Variable Configuration", null, varconfig, null);
		varconfig.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(111, 113, 419, 381);
		varconfig.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Rule", "Weight"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(250);
		scrollPane.setViewportView(table);
		
		JPanel run = new JPanel();
		tab.addTab("Run", null, run, null);
		run.setLayout(null);
		
		JButton btnSaveConfiguration = new JButton("Save configuration");
		btnSaveConfiguration.setBounds(133, 416, 144, 49);
		run.add(btnSaveConfiguration);
		
		path = new JTextField();
		path.setBounds(120, 77, 348, 22);
		run.add(path);
		path.setColumns(10);
		
		JButton btnLoadConfiguration = new JButton("Load configuration");
		btnLoadConfiguration.setBounds(520, 76, 137, 22);
		run.add(btnLoadConfiguration);
		
		JLabel lblXmlPath = new JLabel("Xml path");
		lblXmlPath.setBounds(39, 80, 56, 16);
		run.add(lblXmlPath);
		
		JButton btnRun = new JButton("Run");
		btnRun.setBounds(402, 416, 144, 49);
		run.add(btnRun);
		
		
		JPanel faq = new JPanel();
		tab.addTab("FAQ", null, faq, "Frequently Asked Questions");
		faq.setLayout(null);
		
		JLabel lblQuestion1 = new JLabel("1- Example Question");
		lblQuestion1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQuestion1.setBackground(Color.WHITE);
		lblQuestion1.setBounds(12, 26, 181, 16);
		faq.add(lblQuestion1);
		
		JLabel lblAnswear1 = new JLabel("Example Answear");
		lblAnswear1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnswear1.setBounds(47, 55, 129, 16);
		faq.add(lblAnswear1);
		
		JPanel help = new JPanel();
		tab.addTab("Help", null, help, null);
		help.setLayout(null);
		
		JLabel lbltophelp = new JLabel("Send your problem to the administrator so he can help you");
		lbltophelp.setBounds(197, 13, 371, 16);
		help.add(lbltophelp);
		
		JLabel lblemail = new JLabel("Email for further contact");
		lblemail.setBounds(50, 65, 168, 16);
		help.add(lblemail);
		
		emailresposta = new JTextField();
		emailresposta.setBounds(192, 62, 337, 22);
		help.add(emailresposta);
		emailresposta.setColumns(10);
		
		JLabel lblSubject = new JLabel("Subject:");
		lblSubject.setBounds(50, 133, 56, 16);
		help.add(lblSubject);
		
		subject = new JTextField();
		subject.setBounds(192, 130, 337, 22);
		help.add(subject);
		subject.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(50, 210, 70, 16);
		help.add(lblDescription);
		
		JEditorPane message = new JEditorPane();
		message.setBounds(192, 210, 337, 170);
		help.add(message);
		
		JButton btnsend = new JButton("Send");
		btnsend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(message.getText().length()>0&&emailresposta.getText().length()>0&&subject.getText().length()>0){
					Email.enviar(emailresposta.getText(), subject.getText(), message.getText());
				}else{
					JOptionPane.showMessageDialog(frame, "Por favor preencha todos os dados necessários");
				}
			}
		});
		btnsend.setBounds(300, 400, 100, 25);
		help.add(btnsend);
	}
	public static int getQuantity(){
		return (int) quantity.getValue();
	}
	
	public static int getMinRange(){
		return Integer.valueOf(varmin.getText());
	}
	
	public static int getMaxRange(){
		return Integer.valueOf(varmax.getText());
	}
	
	public String getPath(){
		return path.getText();
	}
	
	
	
}
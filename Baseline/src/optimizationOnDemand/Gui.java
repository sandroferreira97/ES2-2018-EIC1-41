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
					JOptionPane.showMessageDialog(frame, "Dados validados com sucesso");
				}else{
					JOptionPane.showMessageDialog(frame, "Não foi possivel validar os dados");
				}
			}
		});
		
		JPanel configadvanced = new JPanel();
		tab.addTab("Advanced Configuration", null, configadvanced, null);
		configadvanced.setLayout(null);
		
		JLabel lbltime = new JLabel("Maximum waiting time");
		lbltime.setBounds(40, 50, 150, 16);
		configadvanced.add(lbltime);
		
		JLabel lblquantity = new JLabel("Number of variables:");
		lblquantity.setBounds(40, 115, 150, 16);
		configadvanced.add(lblquantity);
		
		JSpinner quantity = new JSpinner();
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
		
		JComboBox type = new JComboBox();
		type.setModel(new DefaultComboBoxModel(new String[] {"", "Inteiro", "Bin\u00E1rio", "Decimal"}));
		type.setBounds(255, 236, 116, 22);
		configadvanced.add(type);
		
		JLabel lblvaluerange = new JLabel("Range of values:");
		lblvaluerange.setBounds(40, 299, 150, 16);
		configadvanced.add(lblvaluerange);
		
		JLabel label = new JLabel("");
		label.setBounds(40, 353, 56, 16);
		configadvanced.add(label);
		
		
		JPanel faq = new JPanel();
		tab.addTab("FAQ", null, faq, "Frequently Asked Questions");
		faq.setLayout(null);
		
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
}

package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import generic.Problem;

/**
 * ConfigurationTab is the class that creates a tab to the frame that will allow the user to
 * create a problem, give it a name, a description and an email.
 *
 * @author Nuno Fialho EIC1 72910
 * @author Sandro Ferreira EIC1 72911
 * @author Duarte Pinto EIC1 73117
 */

public class ConfigurationTab {

	private static JTextField name;
	private static JTextField emailuser;
	private String nomeproblema;
	private static String mailuser;
	private static String descricao;
	private static JEditorPane description;
	private JPanel config;
	private static Gui gui;
	
	/**
	 * Constructor of the class ConfigurationTab
	 * 
	 * @param frame where the tab will be implemented 
	 * @param gui where the tab will be implemented
	 */
	public ConfigurationTab(JFrame frame, Gui gui) {
		this.gui=gui;
		config = new JPanel();
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
		
		description = new JEditorPane();
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
					gui.setConfiguration(true);
				}else{
					JOptionPane.showMessageDialog(frame, "Please fill all fields");
				}
			}
		});
	}


	public JPanel getConfig() {
		return config;
	}
	
	public static String getProbName() {
		return name.getText();
	}
	
	public static String getProbDescription() {
		return descricao;
	}
	
	public static String getProbMail() {
		return mailuser;
	}
	
	/**
	 * Function that allows to load a problem
	 * 
	 * @param p, is the problem that will be loaded
	 */
	public static void load(Problem p) {
		name.setText(p.getName());
		emailuser.setText(p.getEmail());
		description.setText(p.getDescription());
		gui.setConfiguration(true);
	}
}

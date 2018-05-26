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

import generic.Email;

/**
 * HelpTab is the class that creates a tab to the frame that will allow the user to
 * send an email to the administrators to get help.
 *
 * @author Nuno Fialho EIC1 72910
 * @author Sandro Ferreira EIC1 72911
 * @author Duarte Pinto EIC1 73117
 */

public class HelpTab {
	
	private JPanel help;
	private JTextField emailresposta;
	private JTextField subject;
	
	/**
	 * Constructor of the class HelpTab
	 * 
	 * @param frame where the tab will be implemented 
	 * @param gui where the tab will be implemented
	 */
	public HelpTab (JFrame frame, Gui gui) {
		help = new JPanel();
		
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

	public JPanel getHelp() {
		return help;
	}
	
	
}

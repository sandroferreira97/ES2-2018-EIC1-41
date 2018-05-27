package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * FaqTab is the class that creates a tab to the frame that has 
 * a list of questions and answers relating to a particular subject
 *
 * @author Nuno Fialho EIC1 72910
 * @author Sandro Ferreira EIC1 72911
 * @author Duarte Pinto EIC1 73117
 */

public class FaqTab {

	private JPanel faq;
	
	/**
	 * Constructor of the class FaqTab
	 * 
	 * @param frame where the tab will be implemented 
	 * @param gui where the tab will be implemented
	 */
	public FaqTab(JFrame frame, Gui gui) {
		faq = new JPanel();
		
		faq.setLayout(null);
		
		JLabel lblQuestion1 = new JLabel("1- How to get help?");
		lblQuestion1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQuestion1.setBackground(Color.WHITE);
		lblQuestion1.setBounds(12, 25, 400, 200);
		faq.add(lblQuestion1);
		
		JLabel lblAnswear1 = new JLabel("Select the help tab and explain your dificulty");
		lblAnswear1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnswear1.setBounds(47, 55, 400, 200);
		faq.add(lblAnswear1);
		
		JLabel lblQuestion2 = new JLabel("2- How to create a new problem?");
		lblQuestion2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQuestion2.setBackground(Color.WHITE);
		lblQuestion2.setBounds(12, 90, 400, 200);
		faq.add(lblQuestion2);
		
		JLabel lblQuestion3 = new JLabel("3- What is saved in the xml file?");
		lblQuestion3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQuestion3.setBackground(Color.WHITE);
		lblQuestion3.setBounds(12, 155, 400, 200);
		faq.add(lblQuestion3);
		
		
		JLabel lblAnswear2 = new JLabel("Fill in the Configuration and Advanced Configuration tabs in that order.");
		lblAnswear2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnswear2.setBounds(47, 115, 600, 200);
		faq.add(lblAnswear2);
		
		JLabel lblAnswear3 = new JLabel("Everything the user selects is saved in the XML File");
		lblAnswear3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnswear3.setBounds(47, 185, 400, 200);
		faq.add(lblAnswear3);
	}

	public JPanel getFaq() {
		return faq;
	}
}

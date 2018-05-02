package ui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FaqTab {

		private JPanel faq;
		
	public FaqTab(JFrame frame, Gui gui) {
		faq = new JPanel();
		
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
	}

	public JPanel getFaq() {
		return faq;
	}
}

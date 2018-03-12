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
	private JTextField nome;
	private JTextField emailuser;
	private String nomeproblema;
	private String mailuser;
	private String descricao;
	private JTextField emailresposta;
	private JTextField assunto;
	private JTextField nomevar;

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
		tab.addTab("Configuração", null, config, null);
		config.setLayout(null);
		
		nome = new JTextField();
		nome.setBounds(157, 30, 351, 22);
		config.add(nome);
		nome.setColumns(10);
		
		JLabel nomeprob = new JLabel("Nome do Problema:");
		nomeprob.setBounds(12, 33, 116, 16);
		config.add(nomeprob);
		
		JLabel relatorioprob = new JLabel("Descrição do Problema:");
		relatorioprob.setBounds(12, 84, 144, 16);
		config.add(relatorioprob);
		
		JEditorPane relatorio = new JEditorPane();
		relatorio.setBounds(158, 84, 350, 150);
		config.add(relatorio);
		
		JLabel email = new JLabel("Email");
		email.setBounds(12, 265, 56, 16);
		config.add(email);
		
		emailuser = new JTextField();
		emailuser.setBounds(157, 262, 351, 22);
		config.add(emailuser);
		emailuser.setColumns(10);
		
		JButton validar = new JButton("Validar");
		validar.setBounds(300, 500, 100, 25);
		config.add(validar);
		validar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(emailuser.getText().length()>0 && nome.getText().length()>0 && relatorio.getText().length()>0){
					nomeproblema = nome.getText();
					mailuser = emailuser.getText();
					descricao = relatorio.getText();
					JOptionPane.showMessageDialog(frame, "Dados validados com sucesso");
				}else{
					JOptionPane.showMessageDialog(frame, "Não foi possivel validar os dados");
				}
			}
		});
		
		JPanel configadvanced = new JPanel();
		tab.addTab("Configura\u00E7\u00E3o Avan\u00E7ada", null, configadvanced, null);
		configadvanced.setLayout(null);
		
		JLabel lbltempo = new JLabel("Tempo m\u00E1ximo de Espera");
		lbltempo.setBounds(40, 50, 150, 16);
		configadvanced.add(lbltempo);
		
		JLabel lblquantidade = new JLabel("Quantidade de variaveis:");
		lblquantidade.setBounds(40, 115, 150, 16);
		configadvanced.add(lblquantidade);
		
		JSpinner quantidade = new JSpinner();
		quantidade.setBounds(255, 112, 116, 22);
		configadvanced.add(quantidade);
		
		JLabel lblNomeDasRegras = new JLabel("Nome das regras:");
		lblNomeDasRegras.setBounds(40, 178, 150, 16);
		configadvanced.add(lblNomeDasRegras);
		
		nomevar = new JTextField();
		nomevar.setBounds(255, 175, 116, 22);
		configadvanced.add(nomevar);
		nomevar.setColumns(10);
		
		JLabel lblTipoDeVariaveis = new JLabel("Tipo de variaveis");
		lblTipoDeVariaveis.setBounds(40, 239, 150, 16);
		configadvanced.add(lblTipoDeVariaveis);
		
		JComboBox tipo = new JComboBox();
		tipo.setModel(new DefaultComboBoxModel(new String[] {"", "Inteiro", "Bin\u00E1rio", "Decimal"}));
		tipo.setBounds(255, 236, 116, 22);
		configadvanced.add(tipo);
		
		JLabel lblIntervaloDeValores = new JLabel("Intervalo de Valores:");
		lblIntervaloDeValores.setBounds(40, 299, 150, 16);
		configadvanced.add(lblIntervaloDeValores);
		
		JLabel label = new JLabel("");
		label.setBounds(40, 353, 56, 16);
		configadvanced.add(label);
		
		
		JPanel faq = new JPanel();
		tab.addTab("FAQ", null, faq, "Frequently Asked Questions");
		faq.setLayout(null);
		
		JPanel ajuda = new JPanel();
		tab.addTab("Ajuda", null, ajuda, null);
		ajuda.setLayout(null);
		
		JLabel lblEnvieAoAdministrador = new JLabel("Envie ao Administrador a sua duvida para que ele possa ajudar");
		lblEnvieAoAdministrador.setBounds(158, 13, 371, 16);
		ajuda.add(lblEnvieAoAdministrador);
		
		JLabel lblAssunto = new JLabel("Email para resposta:");
		lblAssunto.setBounds(50, 65, 130, 16);
		ajuda.add(lblAssunto);
		
		emailresposta = new JTextField();
		emailresposta.setBounds(192, 62, 337, 22);
		ajuda.add(emailresposta);
		emailresposta.setColumns(10);
		
		JLabel lblAssunto_1 = new JLabel("Assunto:");
		lblAssunto_1.setBounds(50, 133, 56, 16);
		ajuda.add(lblAssunto_1);
		
		assunto = new JTextField();
		assunto.setBounds(192, 130, 337, 22);
		ajuda.add(assunto);
		assunto.setColumns(10);
		
		JLabel lbldescri = new JLabel("Descrição:");
		lbldescri.setBounds(50, 210, 70, 16);
		ajuda.add(lbldescri);
		
		JEditorPane mensagem = new JEditorPane();
		mensagem.setBounds(192, 210, 337, 170);
		ajuda.add(mensagem);
		
		JButton btnsend = new JButton("Enviar");
		btnsend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(mensagem.getText().length()>0&&emailresposta.getText().length()>0&&assunto.getText().length()>0){
					Email.enviar(emailresposta.getText(), assunto.getText(), mensagem.getText());
				}else{
					JOptionPane.showMessageDialog(frame, "Por favor preencha todos os dados necessários");
				}
			}
		});
		btnsend.setBounds(300, 400, 100, 25);
		ajuda.add(btnsend);
	}
}

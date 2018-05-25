package generic;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import ui.AdvancedConfigurationTab;

/**
 * Email is the class that will allow the user to request help if it is needed.
 *
 * @author Nuno Fialho EIC1 72910
 * @author Sandro Ferreira EIC1 72911
 * @author Duarte Pinto EIC1 73117
 */

public class Email {
	
	/**
	 * Function that allow the user to send an email to us
	 */
	
	private static String username;
	private static String password;
	
	//enviar para o admin
	public static void enviar(String email, String assunto, String mensagem){

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(username));
			message.setSubject("HELP REQUEST FROM:    "+ email + "   SUBJECT:   "+assunto);
			message.setText(mensagem);

			Transport.send(message);

			
			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	
	
	//Enviar para o email
	public static void enviarRun(String email, String assunto, String mensagem){

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Multipart multipart = new MimeMultipart();
			
			 MimeBodyPart textBodyPart = new MimeBodyPart();
		     textBodyPart.setText(mensagem);
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email));
			message.setRecipients(Message.RecipientType.CC,InternetAddress.parse(username));
			message.setSubject(assunto);

			
			
			MimeBodyPart messageBodyPart = new MimeBodyPart();
	        String file = AdvancedConfigurationTab.getProblem().getName()+".xml";
			String fileName = AdvancedConfigurationTab.getProblem().getName()+".xml";
	        DataSource source = new FileDataSource(file);
	        messageBodyPart.setDataHandler(new DataHandler(source));
	        messageBodyPart.setFileName(fileName);
	        multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(textBodyPart);
			message.setContent(multipart);

			Transport.send(message);

			
			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public static void setAccount(String username,String pass) {
		Email.username=username;
		Email.password=pass;
	}
}

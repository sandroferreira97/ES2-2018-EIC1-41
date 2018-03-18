package optimizationOnDemand;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
	public static void enviar(String email, String assunto, String mensagem){
		final String username = "eic2.2018.41@gmail.com";
		final String password = "duartenunosandro";

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
			message.setFrom(new InternetAddress("eic2.2018.41@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("eic2.2018.41@gmail.com"));
			message.setSubject("HELP REQUEST FROM:    "+ email + "   SUBJECT:   "+assunto);
			message.setText(mensagem);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}

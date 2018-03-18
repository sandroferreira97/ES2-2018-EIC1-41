package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import optimizationOnDemand.Email;

public class TestEmail {
	
	@Test
	public void testEnviar() {
		Email subject = new Email();
		subject.enviar("email", "assunto", "mensagem");
	}
	
}

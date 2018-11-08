package com.envio.email.plataforma.mail;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
public class MailApresentacao {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private TemplateEngine thymeleaf;
	
	@Autowired
    public MailApresentacao(JavaMailSender mailSender) {
        this.mailSender = mailSender;
	}

	public void sendMail() {

		Context context = new Context();
		context.setVariable("insta", "insta");
		context.setVariable("face", "face");
		String email = thymeleaf.process("mail/apresentacao/EmailApresentacao", context);

		try {
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mail, true, "UTF-8");
			mail.addRecipients(Message.RecipientType.BCC, InternetAddress.parse("destinatario@destinatario.com"));
			helper.setSubject("Envio de email");
			helper.setText("Hello Word");
			helper.addInline("insta", new ClassPathResource("static/img/insta.png"));
			helper.addInline("face", new ClassPathResource("static/img/facebook.png"));
			mailSender.send(mail);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}

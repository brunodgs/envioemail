package com.envio.email.plataforma.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import com.envio.email.plataforma.mail.MailApresentacao;

@Controller
@ComponentScan(basePackageClasses= {MailApresentacao.class})
public class EnvioController {
	
	@Autowired
	MailApresentacao sendEmail;
	
	@PostConstruct
	public void enviarEmail() {
		
		sendEmail.sendMail();
	}

}

package com.envio.email.plataforma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EnvioEmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnvioEmailApplication.class, args);

		// Fechamento do .jar da aplicacao
		System.exit(0);
	}
}

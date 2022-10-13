package com.engdb.automatizador;

import com.engdb.automatizador.services.MarcaTempo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AutomatizadorApplication {

	private static Logger logger = LoggerFactory.getLogger(AutomatizadorApplication.class);


	public static void main(String[] args) {
		MarcaTempo marcaTempo = new MarcaTempo();

		logger.info("ANTES DE RODAR O RUN");

		SpringApplication.run(AutomatizadorApplication.class, args);

		logger.info("DEPOIS DE RODAR O RUN");
		logger.info("Tempo de execução: "+ marcaTempo.getTempoTotal());
	}
}

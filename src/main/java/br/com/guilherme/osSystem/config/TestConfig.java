package br.com.guilherme.osSystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.guilherme.osSystem.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;	
	
	@Bean
	public String instanciaDB() {
		this.dbService.instanciarDB();
		return null;
	}

}

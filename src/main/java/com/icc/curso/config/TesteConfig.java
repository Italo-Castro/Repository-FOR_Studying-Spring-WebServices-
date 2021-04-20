package com.icc.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.icc.curso.entidades.usuario;
import com.icc.curso.repositories.usuarioRepository;

@Configuration 
@Profile("test") 
public class TesteConfig implements CommandLineRunner{
	
	@Autowired
	private usuarioRepository userRepository;

	@Override
	public void run(String... args) throws Exception { 

		usuario u1 = new usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		usuario u2 = new usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		userRepository.saveAll(Arrays.asList(u1,u2));

	}
	
	
	
}

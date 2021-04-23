package com.icc.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.icc.curso.entidades.pedido;
import com.icc.curso.entidades.usuario;
import com.icc.curso.repositories.PedidoRepository;
import com.icc.curso.repositories.usuarioRepository;

@Configuration //defindo que e uma classe de configuracao
@Profile("test") //informando o profille ou seja o perfil, para que o Spring roda estas configurações que o proffile for de test

public class TesteConfig implements CommandLineRunner{
	
	@Autowired //o proprio string trata a questão da injeção de dependecia,ele propio ja instancia a classe usuarioRepository
	private usuarioRepository userRepository;
	
	@Autowired
	private PedidoRepository orderRepository;

	@Override
	public void run(String... args) throws Exception { //tudo que estiver neste metodo vai ser executado quando a aplicação for iniciada

		usuario u1 = new usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		usuario u2 = new usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		
			
		
		pedido p1 = new pedido(null, Instant.parse("2019-06-20T19:53:07Z"), u1); // u1 e o objeto usuario 1 que e passado como parametro pois eles tem relação de um para muitos pra um pois muitos pedidos podem estar associado a um so usuario.
		pedido p2 = new pedido(null, Instant.parse("2019-07-21T03:42:10Z"), u2); // u2 e o objeto usuario 1 que e passado como parametro pois eles tem relação de um para muitos pra um pois muitos pedidos podem estar associado a um so usuario
		pedido p3 = new pedido(null, Instant.parse("2019-07-22T15:21:22Z"), u1); 
		
		orderRepository.saveAll(Arrays.asList(p1,p2,p3));
		
	}
	
	
	
}

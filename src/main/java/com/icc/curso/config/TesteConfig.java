package com.icc.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.icc.curso.entidades.Categoria;
import com.icc.curso.entidades.PedidoItem;
import com.icc.curso.entidades.Produto;
import com.icc.curso.entidades.pedido;
import com.icc.curso.entidades.usuario;
import com.icc.curso.entidades.enums.PedidoStatus;
import com.icc.curso.repositories.CategoriaRepository;
import com.icc.curso.repositories.PedidoItemRepository;
import com.icc.curso.repositories.PedidoRepository;
import com.icc.curso.repositories.ProdutoRepository;
import com.icc.curso.repositories.usuarioRepository;

@Configuration // defindo que e uma classe de configuracao
@Profile("test") // informando o profille ou seja o perfil, para que o Spring roda estas
					// configurações que o proffile for de test

public class TesteConfig implements CommandLineRunner {

	@Autowired // o proprio string trata a questão da injeção de dependecia,ele propio ja
				// instancia a classe usuarioRepository
	private usuarioRepository userRepository;

	@Autowired
	private PedidoRepository orderRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository productRepository;
	 
	@Autowired
	private PedidoItemRepository pedidoItemRepository;
		
	
	
	
	@Override
	public void run(String... args) throws Exception { //tudo que estiver neste metodo vai ser executado quando a aplicação for iniciada


		Categoria  c1 = new Categoria(null,"Eletronicos");
		Categoria  c2 = new Categoria(null,"Livros");			
		Categoria  c3 = new Categoria(null,"Computadores");
		categoriaRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
		Produto produto1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto produto2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto produto3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto produto4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto produto5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		productRepository.saveAll(Arrays.asList(produto1,produto2,produto3,produto4,produto5));
		
		
		produto1.getCategories().add(c2); //adicionando a categoria2 a coleção de categorias que se encotra dentro de produtos
		produto2.getCategories().add(c1);
		produto2.getCategories().add(c3);
		produto3.getCategories().add(c3);
		produto4.getCategories().add(c3);
		produto5.getCategories().add(c2);
		
		productRepository.saveAll(Arrays.asList(produto1,produto2,produto3,produto4,produto5));
		
		
		usuario u1 = new usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		usuario u2 = new usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		userRepository.saveAll(Arrays.asList(u1,u2));		
		
		
		pedido p1 = new pedido(null, Instant.parse("2019-06-20T19:53:07Z"), u1, PedidoStatus.PAGO); // u1 e o objeto usuario 1 que e passado como parametro pois eles tem relação de um para muitos pra um pois muitos pedidos podem estar associado a um so usuario.
		pedido p2 = new pedido(null, Instant.parse("2019-07-21T03:42:10Z"),u2, PedidoStatus.AGUARDANDANDO_PAGAMENTO); // u2 e o objeto usuario 1 que e passado como parametro pois eles tem relação de um para muitos pra um pois muitos pedidos podem estar associado a um so usuario
		pedido p3 = new pedido(null, Instant.parse("2019-07-22T15:21:22Z"),u1, PedidoStatus.AGUARDANDANDO_PAGAMENTO); 
		orderRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		PedidoItem oi1 = new PedidoItem(p1, produto1, 2, produto5.getPreco());
		PedidoItem oi2 = new PedidoItem(p1, produto3, 1, produto4.getPreco());
		PedidoItem oi3 = new PedidoItem(p2, produto3, 2, produto3.getPreco());
		PedidoItem oi4 = new PedidoItem(p3, produto5, 2,produto5.getPreco());
		pedidoItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3));
		
		
	}

}

package com.icc.curso.resoucers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icc.curso.entidades.pedido;
import com.icc.curso.services.PedidoService;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoResource {
	
	@Autowired
	private PedidoService service;
	
	@GetMapping
	public ResponseEntity<List<pedido>> findAll(){
		List<pedido> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<pedido> findyById(@PathVariable Long id){
		
		pedido obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
}

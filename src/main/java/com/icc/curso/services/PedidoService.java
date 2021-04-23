package com.icc.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icc.curso.entidades.pedido;
import com.icc.curso.repositories.PedidoRepository;

@Service
public class PedidoService {

	
	@Autowired
	private PedidoRepository repository;
	
	public List<pedido> findAll(){
		return repository.findAll();
	}
	
	public pedido findById(Long id) {
		Optional<pedido> obj = repository.findById(id);
		
		return obj.get();
	}
}

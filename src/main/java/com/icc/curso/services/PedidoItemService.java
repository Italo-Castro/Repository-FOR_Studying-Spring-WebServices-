package com.icc.curso.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icc.curso.entidades.PedidoItem;
import com.icc.curso.repositories.PedidoItemRepository;

@Service
public class PedidoItemService {

	@Autowired
	private PedidoItemRepository repository;

	public List<PedidoItem> findAll() {
		return repository.findAll();
	}

	public PedidoItem findById(Long id) {
		Optional<PedidoItem> obj = repository.findById(id);

		return obj.get();
	}
}

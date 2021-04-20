package com.icc.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icc.curso.entidades.usuario;
import com.icc.curso.repositories.usuarioRepository;

@Service
public class usuarioService {

	@Autowired
	private usuarioRepository repository;
	
	public List<usuario> findAll(){
		return repository.findAll();
		
	}
	
	public usuario findById(Long id){
		Optional<usuario> obj = repository.findById(id);
		
		return obj.get();
	}
}

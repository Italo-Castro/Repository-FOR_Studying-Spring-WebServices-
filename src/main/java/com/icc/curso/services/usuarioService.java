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
	
	public usuario insert(usuario obj) {
		return repository.save(obj);
		
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public usuario update(Long id, usuario obj) {
		usuario entity = repository.getOne(id); //getOne instancia um usuario, mas nao vai no BD, ele somente deixa o obj mapeado, para que depois eu manipule ele no BD
		updateData(entity,obj);
		return repository.save(entity);
		
	}

	private void updateData(usuario entity, usuario obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
		
	}
}

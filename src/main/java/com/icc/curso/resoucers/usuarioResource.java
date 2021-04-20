package com.icc.curso.resoucers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icc.curso.entidades.usuario;
import com.icc.curso.services.usuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class usuarioResource {
	
	@Autowired
	private usuarioService service;
	
	@GetMapping
	public ResponseEntity<List<usuario>> findAll(){
		List<usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<usuario> findyById(@PathVariable Long id){
		
		usuario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
}

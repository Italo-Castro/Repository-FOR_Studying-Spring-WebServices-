package com.icc.curso.resoucers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icc.curso.entidades.usuario;

@RestController
@RequestMapping(value = "/usuario")
public class usuarioResource {

	@GetMapping
	public ResponseEntity<usuario> findAll(){
		usuario u = new usuario(1l, "Maria",",Marria@gmail.com","33225445", "12345");
		return ResponseEntity.ok().body(u);
		
	}
	
}

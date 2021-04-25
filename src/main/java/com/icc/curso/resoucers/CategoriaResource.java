package com.icc.curso.resoucers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icc.curso.entidades.Categoria;
import com.icc.curso.services.CategoriaService;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaResource {

		@Autowired
		private CategoriaService service;
		
		@GetMapping (value = "/{id}")
		public ResponseEntity<Categoria> findById(@PathVariable Long id) {
			Categoria obj = service.findById(id);
			return ResponseEntity.ok().body(obj);
		}
	
	
	
}

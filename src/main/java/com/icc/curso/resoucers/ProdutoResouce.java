package com.icc.curso.resoucers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icc.curso.entidades.Produto;
import com.icc.curso.services.ProdutoService;

@RestController
@RequestMapping(value = "/Produto")
public class ProdutoResouce {

	
	@Autowired
	private ProdutoService service;
	
	@GetMapping (value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		Produto obj = service.findById(id);
		return ResponseEntity.ok().body(obj);	
	}
}

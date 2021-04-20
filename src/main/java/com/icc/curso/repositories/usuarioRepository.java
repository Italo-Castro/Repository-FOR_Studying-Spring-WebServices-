package com.icc.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icc.curso.entidades.usuario;


@Repository
public interface usuarioRepository extends JpaRepository<usuario, Long>{
	
	 
	
}

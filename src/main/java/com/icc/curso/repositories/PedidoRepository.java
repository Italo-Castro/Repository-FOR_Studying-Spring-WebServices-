package com.icc.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icc.curso.entidades.pedido;


@Repository
public interface PedidoRepository extends JpaRepository<pedido, Long>{
	
	 
	
}

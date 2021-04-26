package com.icc.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icc.curso.entidades.PedidoItem;

@Repository
public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long>{

	
}

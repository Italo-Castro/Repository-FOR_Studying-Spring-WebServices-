package com.icc.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icc.curso.entidades.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}

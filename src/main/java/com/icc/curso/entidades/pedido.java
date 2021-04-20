package com.icc.curso.entidades;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class pedido implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id //anotattion para difinir que id e uma chave unica
	@GeneratedValue(strategy = GenerationType.IDENTITY) // definindo o auto-incrment para o id
	private Long id;
	private Instant momento;
	
	@ManyToOne //indicando que ha um relacionamento de muito pra um
	@JoinColumn(name = "clienteId") //indicando qual vair o nome da chave estrangeira
	private usuario cliente;

	public pedido() {
		
	}
	
	public pedido(Long id, Instant momento, com.icc.curso.entidades.usuario usuario) {
		super();
		this.id = id;
		this.momento = momento;
		this.cliente = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public usuario getCliente() {
		return cliente;
	}

	public void setCliente(usuario cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		pedido other = (pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}

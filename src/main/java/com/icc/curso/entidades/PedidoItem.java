package com.icc.curso.entidades;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.icc.curso.entidades.PK.PedidoItemPK;


@Entity
@Table (name = "tb_pedido_item")

public class PedidoItem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private PedidoItemPK id;
	
	private Integer quantidade;

	private double preco;
	
	public PedidoItem() {
		
	}

	public PedidoItem(pedido pedido, Produto produto,Integer quantidade, double preco) {
		id.setPedido(pedido);
		id.setProduto(produto);
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public pedido getPedido() {
		return id.getPedido();
	}
	public void SetPedido(pedido pedido) {
		id.setPedido(pedido);
	}
	public Produto getProduto() {
		return id.getProduto();
	}
	public void SetProduto(Produto produto) {
		id.setProduto(produto);
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
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
		PedidoItem other = (PedidoItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}

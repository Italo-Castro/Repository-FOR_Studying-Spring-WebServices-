package com.icc.curso.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.swing.JOptionPane;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icc.curso.entidades.enums.PedidoStatus;

@Entity
public class pedido implements Serializable{
	private static final long serialVersionUID = 1L;

	
	
	
	
	@Id //anotattion para difinir que id e uma chave unica
	@GeneratedValue(strategy = GenerationType.IDENTITY) // definindo o auto-incrment para o id
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyy-MM-dd'T'HH:mm:ss'Z' ", timezone = "GMT")
	private Instant momento;
	private Integer pedidoStatus;
	
	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)// quando for um para um, mapeamos o mesmo id para as duas classes
	private Pagamento pagamento;
	
	
	
	@ManyToOne //indicando que ha um relacionamento de muitos pra um
	@JoinColumn(name = "clienteId") //indicando qual  o nome da chave estrangeira
	private usuario cliente;
	
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<PedidoItem> pedidoItem = new HashSet<>();
	
	public pedido() {
		
	}
	
	
	public pedido(Long id, Instant momento, com.icc.curso.entidades.usuario usuario, PedidoStatus pedidoStatus) {
		super();
		this.id = id;
		this.momento = momento;
		this.cliente = usuario;
		setPedidoStatus(pedidoStatus);
	}

	public Long getId() {
		return id;
	}
	

	public PedidoStatus getPedidoStatus() {
		return PedidoStatus.valueOf(pedidoStatus);
	}

	public void setPedidoStatus(PedidoStatus pedidoStatus) {
		if(pedidoStatus != null) {
		this.pedidoStatus = pedidoStatus.getCode();
		}else {
			JOptionPane.showMessageDialog(null,"Classe pedido, ao setar um status de pedido deu erro, pois ele esta vazio");
		}
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
	
	public Set<PedidoItem> getItems(){
		return pedidoItem;
	}

	
	
	
	public Pagamento getPagamento() {
		return pagamento;
	}


	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
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

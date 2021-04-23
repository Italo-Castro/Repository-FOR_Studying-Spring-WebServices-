package com.icc.curso.entidades.enums;

public enum PedidoStatus {

	AGUARDANDANDO_PAGAMENTO(1),
	PAGO(2),
	ENTREGUE(3),
	EM_ENTREGA(4),
	CANCELADO(5);

private int code;

private PedidoStatus (int code) {
	this.code=code;
	}

	public int getCode() {
		return code;
	}
	public static PedidoStatus valueOf(int code) {
		for(PedidoStatus value : PedidoStatus.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid Order Status Code");
	}
	
}
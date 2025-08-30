package br.edu.infnet.arthurbarcellos_PB.model.domain;

import java.util.Date;

public class Pagamento {
	Cliente cliente;
	Pedido pedido;
	Date dataOperacao;
	int segredo;
	
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Date getDataOperacao() {
		return dataOperacao;
	}
	public void setDataOperacao(Date dataOperacao) {
		this.dataOperacao = dataOperacao;
	}
	public int getSegredo() {
		return segredo;
	}
	public void setSegredo(int segredo) {
		this.segredo = segredo;
	}
	
	
}

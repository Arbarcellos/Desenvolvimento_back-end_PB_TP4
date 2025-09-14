package br.edu.infnet.arthurbarcellos_PB.model.dto;

import br.edu.infnet.arthurbarcellos_PB.model.domain.Pedido;
import br.edu.infnet.arthurbarcellos_PB.model.domain.Produto;


public class ItemPedidoDTO {
	

    private Long id;
	
	private Produto produto;
    
	private Pedido pedido;
	
	private int quantidade;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
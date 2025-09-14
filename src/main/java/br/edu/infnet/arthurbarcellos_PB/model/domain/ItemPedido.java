package br.edu.infnet.arthurbarcellos_PB.model.domain;

import jakarta.persistence.*;

@Entity
public class ItemPedido{
	
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    @OneToOne
	private Produto produto;
    
    @OneToOne
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

package br.edu.infnet.arthurbarcellos_PB.model.domain;

public class ItemPedido extends Model{
	int quantidade;
	Produto produto;
	
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
}

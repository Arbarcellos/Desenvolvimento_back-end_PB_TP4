package br.edu.infnet.arthurbarcellos_PB.model.dto;

import java.util.List;

import br.edu.infnet.arthurbarcellos_PB.model.domain.ItemPedido;


public class ProdutoDTO {

    private Long id;
    

    private List<ItemPedido> itemPedido;
    
    private String nome;
    private Double preco;
    private Integer quantidadeEstoque;
    private Long barcode;
    
    

	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}
	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}
	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
	public Long getBarcode() {
		return barcode;
	}
	public void setBarcode(Long barcode) {
		this.barcode = barcode;
	}
	
    
    
	
	
}

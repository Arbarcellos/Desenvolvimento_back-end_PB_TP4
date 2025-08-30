package br.edu.infnet.arthurbarcellos_PB.model.domain;

public class Produto extends Model{
	String nome;
	Long barcode;
	int quantidade;
	double preco;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getBarcode() {
		return barcode;
	}
	public void setBarcode(Long barcode) {
		this.barcode = barcode;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
}

package br.edu.infnet.arthurbarcellos_PB.model.domain;

import jakarta.persistence.*;

@Entity
public class Endereco {
	
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	   
    @OneToOne
	private Pedido pedido;

	private String rua;
	private int numero;
	private String cidade;
	private String estado;
	private String pais;
	
	public Endereco(){}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	
	
	
}

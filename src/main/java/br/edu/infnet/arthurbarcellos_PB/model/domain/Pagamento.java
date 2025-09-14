package br.edu.infnet.arthurbarcellos_PB.model.domain;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Pagamento {
	
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	   
    @OneToOne    
	private Pedido pedido;
    
	private Date dataOperacao;
	private String segredo;
	private Boolean status;
	
	
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
	public Date getDataOperacao() {
		return dataOperacao;
	}
	public void setDataOperacao(Date dataOperacao) {
		this.dataOperacao = dataOperacao;
	}
	public String getSegredo() {
		return segredo;
	}
	public void setSegredo(String segredo) {
		this.segredo = segredo;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}

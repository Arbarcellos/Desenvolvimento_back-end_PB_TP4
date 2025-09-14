package br.edu.infnet.arthurbarcellos_PB.model.domain;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Pedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Usuario cliente;
    
    @OneToOne
	private Endereco endereco;
    
    @OneToOne
    private Pagamento pagamento;
    
    @OneToMany
    private List<ItemPedido> items;
    

    private String status; 
    private Double valorTotal;
	private String avaliacao;
	private String comentario;
	
	
	public Long getId() {return id;	}
	public void setId(Long id) {this.id = id;}
	public Usuario getCliente() {return cliente;	}
	public void setCliente(Usuario cliente) {this.cliente = cliente;	}
	public Endereco getEndereco() {return endereco;	}
	public void setEndereco(Endereco endereco) {this.endereco = endereco;	}
	public Pagamento getPagamento() {return pagamento;	}
	public void setPagamento(Pagamento pagamento) {this.pagamento = pagamento;	}
	public String getStatus() {	return status;	}
	public void setStatus(String status) {this.status = status;	}
	public Double getValorTotal() {return valorTotal;	}
	public void setValorTotal(Double valorTotal) {this.valorTotal = valorTotal;	}
	public String getAvaliacao() {return avaliacao;	}
	public void setAvaliacao(String avaliacao) {this.avaliacao = avaliacao;	}
	public String getComentario() {return comentario;	}
	public void setComentario(String comentario) {this.comentario = comentario;	}
	public List<ItemPedido> getItems() {return items;	}
	public void setItems(List<ItemPedido> items) {this.items = items;	}

	
	
	
}

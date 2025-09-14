package br.edu.infnet.arthurbarcellos_PB.model.dto;

import java.util.List;

import br.edu.infnet.arthurbarcellos_PB.model.domain.Endereco;
import br.edu.infnet.arthurbarcellos_PB.model.domain.ItemPedido;
import br.edu.infnet.arthurbarcellos_PB.model.domain.Pagamento;
import br.edu.infnet.arthurbarcellos_PB.model.domain.Usuario;


public class PedidoDTO {

    private Long id;

    private Usuario cliente;

	private Endereco endereco;

    private Pagamento pagamento;

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

	@Override
	public String toString() {

		return "ID: " + this.getId() + " STATUS: "+ this.getStatus() + "VALOR TOTAL: R$ " + this.getValorTotal();
		
	}
	
	
}
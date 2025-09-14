package br.edu.infnet.arthurbarcellos_PB.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.arthurbarcellos_PB.model.domain.Produto;
import br.edu.infnet.arthurbarcellos_PB.model.dto.ProdutoDTO;
import br.edu.infnet.arthurbarcellos_PB.model.repository.ProdutoRepository;

@Service
public class ProdutoService{
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public ProdutoDTO salvar(ProdutoDTO produtoDTO) {
	    // Lógica de negócio: Converter DTO para Entity
	    Produto produto = new Produto();
	    produto.setNome(produtoDTO.getNome());
	    produto.setItemPedido(produtoDTO.getItemPedido());
	    produto.setPreco(produtoDTO.getPreco());
	    produto.setQuantidadeEstoque(produtoDTO.getQuantidadeEstoque());
	    produto.setBarcode(produtoDTO.getBarcode());
	    
	
	    // Acessa o repositório para salvar no banco
	    Produto produtoSalvo = produtoRepository.save(produto);
	
	    // Retorna a Entity salva como DTO
	    ProdutoDTO retornoDTO = new ProdutoDTO();
	    retornoDTO.setId(produtoSalvo.getId());
	    retornoDTO.setNome(produtoSalvo.getNome());
	    retornoDTO.setItemPedido(produtoSalvo.getItemPedido());
	    retornoDTO.setPreco(produtoSalvo.getPreco());
	    retornoDTO.setQuantidadeEstoque(produtoSalvo.getQuantidadeEstoque());
	    retornoDTO.setBarcode(produtoSalvo.getBarcode());
	    
	
	    return retornoDTO;
	}
	
	public List<ProdutoDTO> buscarTodos() {
	    List<Produto> produtos = produtoRepository.findAll();
	    // Converte a lista de Entities para uma lista de DTOs
	    return produtos.stream()
	            .map(p -> {
	            	ProdutoDTO dto = new ProdutoDTO();
	                dto.setId(p.getId());
	                dto.setNome(p.getNome());
	                dto.setItemPedido(p.getItemPedido());
	                dto.setPreco(p.getPreco());
	                dto.setQuantidadeEstoque(p.getQuantidadeEstoque());
	                dto.setBarcode(p.getBarcode());	                
	                return dto;
	            })
	            .collect(Collectors.toList());
	}

}
package br.edu.infnet.arthurbarcellos_PB.model.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.arthurbarcellos_PB.model.dto.ProdutoDTO;
import br.edu.infnet.arthurbarcellos_PB.model.service.ProdutoService;


@RestController // Marca a classe como um controlador REST
@RequestMapping("/api/produto")
public class ProdutoController {

	    @Autowired 
	    private ProdutoService produtoService;
	
	    @PostMapping // Mapeia requisições POST para este método
	    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
	    	ProdutoDTO novoProduto = produtoService.salvar(produtoDTO);
	        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
	    }
	
	    @GetMapping // Mapeia requisições GET para este método
	    public ResponseEntity<List<ProdutoDTO>> buscarTodosProdutos() {
	        List<ProdutoDTO> produtos = produtoService.buscarTodos();
	        return ResponseEntity.ok(produtos);
	    }
	}
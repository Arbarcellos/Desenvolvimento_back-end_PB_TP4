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

import br.edu.infnet.arthurbarcellos_PB.model.dto.EnderecoDTO;
import br.edu.infnet.arthurbarcellos_PB.model.service.EnderecoService;


@RestController // Marca a classe como um controlador REST
@RequestMapping("/api/endereco")
public class EnderecoController {

	    @Autowired 
	    private EnderecoService enderecoService;

	    @PostMapping // Mapeia requisições POST para este método
	    public ResponseEntity<EnderecoDTO> criarEndereco(@RequestBody EnderecoDTO enderecoDTO) {
	    	EnderecoDTO novoEndereco = enderecoService.salvar(enderecoDTO);
	        return new ResponseEntity<>(novoEndereco, HttpStatus.CREATED);
	    }

	    @GetMapping // Mapeia requisições GET para este método
	    public ResponseEntity<List<EnderecoDTO>> buscarTodosEnderecos() {
	        List<EnderecoDTO> enderecos = enderecoService.buscarTodos();
	        return ResponseEntity.ok(enderecos);
	    }
	}
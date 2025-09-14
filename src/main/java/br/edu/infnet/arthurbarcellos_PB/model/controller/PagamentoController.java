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

import br.edu.infnet.arthurbarcellos_PB.model.dto.PagamentoDTO;
import br.edu.infnet.arthurbarcellos_PB.model.service.PagamentoService;


@RestController // Marca a classe como um controlador REST
@RequestMapping("/api/pagamento")
public class PagamentoController {

			    @Autowired 
			    private PagamentoService pagamentoService;

			    @PostMapping // Mapeia requisições POST para este método
			    public ResponseEntity<PagamentoDTO> criarPagamento(@RequestBody PagamentoDTO pagamentoDTO) {
			    	PagamentoDTO novoPagamento = pagamentoService.salvar(pagamentoDTO);
			        return new ResponseEntity<>(novoPagamento, HttpStatus.CREATED);
			    }

			    @GetMapping // Mapeia requisições GET para este método
			    public ResponseEntity<List<PagamentoDTO>> buscarTodosPagamentos() {
			        List<PagamentoDTO> pagamentos = pagamentoService.buscarTodos();
			        return ResponseEntity.ok(pagamentos);
			    }
	}
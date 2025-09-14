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

import br.edu.infnet.arthurbarcellos_PB.model.dto.PedidoDTO;
import br.edu.infnet.arthurbarcellos_PB.model.service.PedidoService;



@RestController // Marca a classe como um controlador REST
@RequestMapping("/api/pedido")
public class PedidoController {

		    @Autowired 
		    private PedidoService pedidoService;

		    @PostMapping // Mapeia requisições POST para este método
		    public ResponseEntity<PedidoDTO> criarPedido(@RequestBody PedidoDTO pedidoDTO) {
		    	PedidoDTO novoPedido = pedidoService.salvar(pedidoDTO);
		        return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
		    }

		    @GetMapping // Mapeia requisições GET para este método
		    public ResponseEntity<List<PedidoDTO>> buscarTodosPedidos() {
		        List<PedidoDTO> pedidos = pedidoService.buscarTodos();
		        return ResponseEntity.ok(pedidos);
		    }
}
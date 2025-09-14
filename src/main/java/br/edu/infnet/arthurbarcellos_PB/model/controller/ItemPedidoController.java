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

import br.edu.infnet.arthurbarcellos_PB.model.dto.ItemPedidoDTO;
import br.edu.infnet.arthurbarcellos_PB.model.service.ItemPedidoService;

@RestController // Marca a classe como um controlador REST
@RequestMapping("/api/itempedido")
public class ItemPedidoController {

		    @Autowired 
		    private ItemPedidoService itemPedidoService;

		    @PostMapping // Mapeia requisições POST para este método
		    public ResponseEntity<ItemPedidoDTO> criarItemPedido(@RequestBody ItemPedidoDTO itemPedidoDTO) {
		    	ItemPedidoDTO novoItemPedido = itemPedidoService.salvar(itemPedidoDTO);
		        return new ResponseEntity<>(novoItemPedido, HttpStatus.CREATED);
		    }

		    @GetMapping // Mapeia requisições GET para este método
		    public ResponseEntity<List<ItemPedidoDTO>> buscarTodosEnderecos() {
		        List<ItemPedidoDTO> itemPedidos = itemPedidoService.buscarTodos();
		        return ResponseEntity.ok(itemPedidos);
		    }
}
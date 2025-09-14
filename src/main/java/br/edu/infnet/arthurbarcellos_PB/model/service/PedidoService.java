package br.edu.infnet.arthurbarcellos_PB.model.service;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.arthurbarcellos_PB.model.domain.ItemPedido;
import br.edu.infnet.arthurbarcellos_PB.model.domain.Pedido;

import br.edu.infnet.arthurbarcellos_PB.model.dto.PedidoDTO;
import br.edu.infnet.arthurbarcellos_PB.model.dto.UsuarioDTO;
import br.edu.infnet.arthurbarcellos_PB.model.repository.EnderecoRepository;
import br.edu.infnet.arthurbarcellos_PB.model.repository.PagamentoRepository;
import br.edu.infnet.arthurbarcellos_PB.model.repository.PedidoRepository;
import br.edu.infnet.arthurbarcellos_PB.model.repository.UsuarioRepository;

@Service
public class PedidoService {

    @Autowired private PedidoRepository pedidoRepository;
    @Autowired private UsuarioRepository usuarioRepository;
    @Autowired private EnderecoRepository enderecoRepository;
    @Autowired private PagamentoRepository pagamentoRepository;

    public PedidoDTO salvar(PedidoDTO pedidoDTO) {
        Pedido pedido = new Pedido();
        pedido.setStatus(pedidoDTO.getStatus());
        pedido.setValorTotal(pedidoDTO.getValorTotal());
        pedido.setAvaliacao(pedidoDTO.getAvaliacao());
        pedido.setComentario(pedidoDTO.getComentario());

        // Busca e associa as entidades relacionadas
        pedido.setCliente(usuarioRepository.findById(pedidoDTO.getCliente().getId()).orElse(null));
        pedido.setEndereco(enderecoRepository.findById(pedidoDTO.getEndereco().getId()).orElse(null));
        pedido.setPagamento(pagamentoRepository.findById(pedidoDTO.getPagamento().getId()).orElse(null));
        
        // Associa os itens do pedido
        if (pedidoDTO.getItems() != null) {
            List<ItemPedido> items = pedidoDTO.getItems();
            pedido.setItems(items);
        }

        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        pedidoDTO.setId(pedidoSalvo.getId());
        return pedidoDTO;
    }

    public List<PedidoDTO> buscarTodos() {
        return pedidoRepository.findAll().stream()
                .map(p -> {
                    PedidoDTO dto = new PedidoDTO();
                    dto.setId(p.getId());
                    dto.setStatus(p.getStatus());
                    dto.setValorTotal(p.getValorTotal());
                    dto.setAvaliacao(p.getAvaliacao());
                    dto.setComentario(p.getComentario());
                    dto.setCliente(p.getCliente() != null ? p.getCliente() : null);
                    dto.setEndereco(p.getEndereco() != null ? p.getEndereco() : null);
                    dto.setPagamento(p.getPagamento() != null ? p.getPagamento() : null);
                    return dto;
                })
                .collect(Collectors.toList());
    }
    public List<PedidoDTO> buscarPedidos(UsuarioDTO usuario) {
    	String email = usuario.getEmail();
        List<PedidoDTO> pedidos = pedidoRepository.findByClienteEmail(email);
        return pedidos;
    }
}
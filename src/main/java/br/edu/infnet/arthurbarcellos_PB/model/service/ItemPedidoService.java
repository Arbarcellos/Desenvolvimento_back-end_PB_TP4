package br.edu.infnet.arthurbarcellos_PB.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.arthurbarcellos_PB.model.domain.ItemPedido;
import br.edu.infnet.arthurbarcellos_PB.model.dto.ItemPedidoDTO;
import br.edu.infnet.arthurbarcellos_PB.model.repository.ItemPedidoRepository;
import br.edu.infnet.arthurbarcellos_PB.model.repository.PedidoRepository;
import br.edu.infnet.arthurbarcellos_PB.model.repository.ProdutoRepository;

@Service
public class ItemPedidoService {

    @Autowired private ItemPedidoRepository itemPedidoRepository;
    @Autowired private ProdutoRepository produtoRepository;
    @Autowired private PedidoRepository pedidoRepository;

    public ItemPedidoDTO salvar(ItemPedidoDTO itemPedidoDTO) {
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setQuantidade(itemPedidoDTO.getQuantidade());

        // Busca as entidades relacionadas pelos IDs
        itemPedido.setProduto(produtoRepository.findById(itemPedidoDTO.getId()).orElse(null));
        itemPedido.setPedido(pedidoRepository.findById(itemPedidoDTO.getId()).orElse(null));

        ItemPedido itemPedidoSalvo = itemPedidoRepository.save(itemPedido);

        itemPedidoDTO.setId(itemPedidoSalvo.getId());
        return itemPedidoDTO;
    }

    public List<ItemPedidoDTO> buscarTodos() {
        return itemPedidoRepository.findAll().stream()
                .map(i -> {
                    ItemPedidoDTO dto = new ItemPedidoDTO();
                    dto.setId(i.getId());
                    dto.setQuantidade(i.getQuantidade());
                    dto.setProduto(i.getProduto());
                    dto.setPedido(i.getPedido());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
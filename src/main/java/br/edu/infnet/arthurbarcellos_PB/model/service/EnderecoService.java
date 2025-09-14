package br.edu.infnet.arthurbarcellos_PB.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.arthurbarcellos_PB.model.domain.Endereco;
import br.edu.infnet.arthurbarcellos_PB.model.dto.EnderecoDTO;
import br.edu.infnet.arthurbarcellos_PB.model.repository.EnderecoRepository;
import br.edu.infnet.arthurbarcellos_PB.model.repository.PedidoRepository;

@Service
public class EnderecoService {

    @Autowired private EnderecoRepository enderecoRepository;
    @Autowired private PedidoRepository pedidoRepository;

    public EnderecoDTO salvar(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco();
        endereco.setRua(enderecoDTO.getRua());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setCidade(enderecoDTO.getCidade());
        endereco.setEstado(enderecoDTO.getEstado());
        endereco.setPais(enderecoDTO.getPais());

        // Busca a entidade Pedido pelo ID para fazer a associação
        endereco.setPedido(pedidoRepository.findById(enderecoDTO.getId()).orElse(null));

        Endereco enderecoSalvo = enderecoRepository.save(endereco);

        enderecoDTO.setId(enderecoSalvo.getId());
        return enderecoDTO;
    }

    public List<EnderecoDTO> buscarTodos() {
        return enderecoRepository.findAll().stream()
                .map(e -> {
                    EnderecoDTO dto = new EnderecoDTO();
                    dto.setId(e.getId());
                    dto.setRua(e.getRua());
                    dto.setNumero(e.getNumero());
                    dto.setCidade(e.getCidade());
                    dto.setEstado(e.getEstado());
                    dto.setPais(e.getPais());
                    dto.setPedido(e.getPedido());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}

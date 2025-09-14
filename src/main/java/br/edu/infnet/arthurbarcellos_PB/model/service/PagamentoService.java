package br.edu.infnet.arthurbarcellos_PB.model.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.arthurbarcellos_PB.model.domain.Pagamento;
import br.edu.infnet.arthurbarcellos_PB.model.dto.PagamentoDTO;
import br.edu.infnet.arthurbarcellos_PB.model.repository.PagamentoRepository;
import br.edu.infnet.arthurbarcellos_PB.model.repository.PedidoRepository;

@Service
public class PagamentoService {

    @Autowired private PagamentoRepository pagamentoRepository;
    @Autowired private PedidoRepository pedidoRepository;

    public PagamentoDTO salvar(PagamentoDTO pagamentoDTO) {
        Pagamento pagamento = new Pagamento();
        pagamento.setDataOperacao(pagamentoDTO.getDataOperacao());
        pagamento.setSegredo(pagamentoDTO.getSegredo());
        pagamento.setStatus(pagamentoDTO.getStatus());

        pagamento.setPedido(pedidoRepository.findById(pagamentoDTO.getPedido().getId()).orElse(null));

        Pagamento pagamentoSalvo = pagamentoRepository.save(pagamento);

        pagamentoDTO.setId(pagamentoSalvo.getId());
        return pagamentoDTO;
    }

    public List<PagamentoDTO> buscarTodos() {
        return pagamentoRepository.findAll().stream()
                .map(p -> {
                    PagamentoDTO dto = new PagamentoDTO();
                    dto.setId(p.getId());
                    dto.setDataOperacao(p.getDataOperacao());
                    dto.setSegredo(p.getSegredo());
                    dto.setStatus(p.getStatus());
                    dto.setPedido(p.getPedido());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
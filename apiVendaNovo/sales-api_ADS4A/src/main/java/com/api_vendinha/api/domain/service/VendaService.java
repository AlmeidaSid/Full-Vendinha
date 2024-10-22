package com.api_vendinha.api.domain.service;

import com.api_vendinha.api.domain.dtos.request.VendaRequestDto;
import com.api_vendinha.api.domain.dtos.response.VendaResponseDto;
import com.api_vendinha.api.domain.entities.Venda;
import com.api_vendinha.api.domain.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class VendaService {
    private final VendaRepository vendaRepository;

    @Autowired
    public VendaService(VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public VendaResponseDto save(VendaRequestDto vendaRequestDto) {
        Venda venda = new Venda();
        venda.setProdutoId(vendaRequestDto.getProdutoId());
        venda.setUsuarioId(vendaRequestDto.getUsuarioId());
        venda.setQuantidade(vendaRequestDto.getQuantidade());
        venda.setTotal(vendaRequestDto.getTotal());

        Venda savedVenda = vendaRepository.save(venda);
        return convertToResponseDto(savedVenda);
    }

    public VendaResponseDto update(VendaRequestDto vendaRequestDto, Long id) {
        Optional<Venda> optionalVenda = vendaRepository.findById(id);
        if (optionalVenda.isPresent()) {
            Venda venda = optionalVenda.get();
            venda.setProdutoId(vendaRequestDto.getProdutoId());
            venda.setUsuarioId(vendaRequestDto.getUsuarioId());
            venda.setQuantidade(vendaRequestDto.getQuantidade());
            venda.setTotal(vendaRequestDto.getTotal());
            Venda updatedVenda = vendaRepository.save(venda);
            return convertToResponseDto(updatedVenda);
        }
        return null; // Ou lance uma exceção personalizada
    }

    public List<Venda> findAll() {
        return vendaRepository.findAll();
    }

    public Venda findById(Long id) {
        return vendaRepository.findById(id).orElse(null); // Ou lance uma exceção personalizada
    }

    public void deletar(Long id) {
        vendaRepository.deleteById(id);
    }

    private VendaResponseDto convertToResponseDto(Venda venda) {
        VendaResponseDto responseDto = new VendaResponseDto();
        responseDto.setId(venda.getId());
        responseDto.setProdutoId(venda.getProdutoId());
        responseDto.setUsuarioId(venda.getUsuarioId());
        responseDto.setQuantidade(venda.getQuantidade());
        responseDto.setTotal(venda.getTotal());
        return responseDto;
    }
}

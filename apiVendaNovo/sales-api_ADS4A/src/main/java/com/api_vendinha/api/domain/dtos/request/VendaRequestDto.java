package com.api_vendinha.api.domain.dtos.request;

import java.math.BigDecimal;

public class VendaRequestDto {
    private Long produtoId; // ID do produto vendido
    private Long usuarioId;  // ID do usuário que fez a venda
    private Integer quantidade; // Quantidade vendida
    private BigDecimal total; // Valor total da venda

    // Getters e Setters
    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}

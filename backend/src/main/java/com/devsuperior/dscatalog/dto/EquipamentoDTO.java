package com.devsuperior.dscatalog.dto;


import com.devsuperior.dscatalog.entities.Equipamento;

public class EquipamentoDTO {

    private Long id;
    private String nome;
    private Double valorDaCompra;
    private Double valorAluguelDia;
    private Double valorAluguelQuinzena;
    private Double valorAluguelMes;

    public EquipamentoDTO(){}

    public EquipamentoDTO(Long id, String nome, Double valorDaCompra, Double valorAluguelDia, Double valorAluguelQuinzena, Double valorAluguelMes) {
        this.id = id;
        this.nome = nome;
        this.valorDaCompra = valorDaCompra;
        this.valorAluguelDia = valorAluguelDia;
        this.valorAluguelQuinzena = valorAluguelQuinzena;
        this.valorAluguelMes = valorAluguelMes;
    }

    public EquipamentoDTO(Equipamento equipamento) {
        id = equipamento.getId();
         nome = equipamento.getNome();
        valorDaCompra = equipamento.getValorDaCompra();
        valorAluguelDia = equipamento.getValorAluguelDia();
        valorAluguelQuinzena = equipamento.getValorAluguelQuinzena();
       valorAluguelMes = equipamento.getValorAluguelMes();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValorDaCompra() {
        return valorDaCompra;
    }

    public void setValorDaCompra(Double valorDaCompra) {
        this.valorDaCompra = valorDaCompra;
    }

    public Double getValorAluguelDia() {
        return valorAluguelDia;
    }

    public void setValorAluguelDia(Double valorAluguelDia) {
        this.valorAluguelDia = valorAluguelDia;
    }

    public Double getValorAluguelQuinzena() {
        return valorAluguelQuinzena;
    }

    public void setValorAluguelQuinzena(Double valorAluguelQuinzena) {
        this.valorAluguelQuinzena = valorAluguelQuinzena;
    }

    public Double getValorAluguelMes() {
        return valorAluguelMes;
    }

    public void setValorAluguelMes(Double valorAluguelMes) {
        this.valorAluguelMes = valorAluguelMes;
    }
}

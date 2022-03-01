package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Aluguel;
import com.devsuperior.dscatalog.entities.Cliente;
import com.devsuperior.dscatalog.entities.Endereco;
import com.devsuperior.dscatalog.entities.Equipamento;
import java.util.Date;

public class AluguelDTO {

    private Long id;
    private Cliente cliente;
    private Date dataInicio;
    private Date dataTermino;
    private Double valorDoContrato;
    private Equipamento equipamento;
    private Endereco endereco;

    public AluguelDTO(){}


    public AluguelDTO(Aluguel aluguel) {
        id = aluguel.getId();
        cliente = aluguel.getCliente();
        dataInicio = aluguel.getDataInicio();
        dataTermino = aluguel.getDataTermino();
        valorDoContrato = aluguel.getValorDoContrato();
        equipamento = aluguel.getEquipamento();
        endereco = aluguel.getEndereco();
    }

    public AluguelDTO(Long id, Cliente cliente, Date dataInicio, Date dataTermino, Double valorDoContrato, Equipamento equipamento, Endereco endereco) {
        this.id = id;
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.valorDoContrato = valorDoContrato;
        this.equipamento = equipamento;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Double getValorDoContrato() {
        return valorDoContrato;
    }

    public void setValorDoContrato(Double valorDoContrato) {
        this.valorDoContrato = valorDoContrato;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "AluguelDTO{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", dataInicio=" + dataInicio +
                ", dataTermino=" + dataTermino +
                ", valorDoContrato=" + valorDoContrato +
                ", equipamento=" + equipamento +
                ", endereco=" + endereco +
                '}';
    }
}

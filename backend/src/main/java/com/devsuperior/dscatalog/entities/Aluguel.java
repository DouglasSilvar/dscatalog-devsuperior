package com.devsuperior.dscatalog.entities;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Proxy(lazy=false)
@Table(name = "tb_aluguel")
public class Aluguel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @NotNull(message = "Campo requerido")
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    private Date dataInicio;
    private Date dataTermino;
    private Double valorDoContrato;
    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    @NotNull(message = "Campo requerido")
    @OneToOne
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamento;

    public Aluguel(){}

    public Aluguel(Long id, Cliente cliente, Date dataInicio, Date dataTermino, Double valorDoContrato, Endereco endereco, Equipamento equipamento) {
        this.id = id;
        this.cliente = cliente;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.valorDoContrato = valorDoContrato;
        this.endereco = endereco;
        this.equipamento = equipamento;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    @Override
    public String toString() {
        return "Aluguel{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", dataInicio=" + dataInicio +
                ", dataTermino=" + dataTermino +
                ", valorDoContrato=" + valorDoContrato +
                ", endereco=" + endereco +
                ", equipamento=" + equipamento +
                '}';
    }
}

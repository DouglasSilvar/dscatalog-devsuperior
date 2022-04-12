package com.devsuperior.dscatalog.entities;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Proxy(lazy=false)
@Table(name = "tb_equipamento")
public class Equipamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Double valorDaCompra;
    private Double valorAluguelDia;
    private Double valorAluguelQuinzena;
    private Double valorAluguelMes;


    public Equipamento(){}

    public Equipamento(Long id, String nome, Double valorDaCompra, Double valorAluguelDia, Double valorAluguelQuinzena, Double valorAluguelMes) {
        this.id = id;
        this.nome = nome;
        this.valorDaCompra = valorDaCompra;
        this.valorAluguelDia = valorAluguelDia;
        this.valorAluguelQuinzena = valorAluguelQuinzena;
        this.valorAluguelMes = valorAluguelMes;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipamento that = (Equipamento) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(valorDaCompra, that.valorDaCompra) && Objects.equals(valorAluguelDia, that.valorAluguelDia) && Objects.equals(valorAluguelQuinzena, that.valorAluguelQuinzena) && Objects.equals(valorAluguelMes, that.valorAluguelMes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, valorDaCompra, valorAluguelDia, valorAluguelQuinzena, valorAluguelMes);
    }

    @Override
    public String toString() {
        return "Equipamento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", valorDaCompra=" + valorDaCompra +
                ", valorAluguelDia=" + valorAluguelDia +
                ", valorAluguelQuinzena=" + valorAluguelQuinzena +
                ", valorAluguelMes=" + valorAluguelMes +
                '}';
    }
}

package com.devsuperior.dscatalog.entities;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Proxy(lazy=false)
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpfCnpj;
    private String telefone1;
    private String telefone2;
    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Cliente(){}

    public Cliente(Long id, String nome, String cpfCnpj, String telefone1, String telefone2, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.endereco = endereco;
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

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getTelefone1() {
        return telefone1;
    }

    public void setTelefone1(String telefone1) {
        this.telefone1 = telefone1;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(nome, cliente.nome) && Objects.equals(cpfCnpj, cliente.cpfCnpj) && Objects.equals(telefone1, cliente.telefone1) && Objects.equals(telefone2, cliente.telefone2) && Objects.equals(endereco, cliente.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpfCnpj, telefone1, telefone2, endereco);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpfCnpj='" + cpfCnpj + '\'' +
                ", telefone1='" + telefone1 + '\'' +
                ", telefone2='" + telefone2 + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}

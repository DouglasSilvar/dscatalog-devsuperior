package com.devsuperior.dscatalog.dto;


import com.devsuperior.dscatalog.entities.Cliente;
import com.devsuperior.dscatalog.entities.Endereco;

public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpfCnpj;
    private String telefone1;
    private String telefone2;
    private Endereco endereco;

    public ClienteDTO(){}


    public ClienteDTO(Cliente cliente) {
        id = cliente.getId();
        nome = cliente.getNome();
        cpfCnpj = cliente.getCpfCnpj();
        telefone1 = cliente.getTelefone1();
        telefone2 = cliente.getTelefone2();
        endereco = cliente.getEndereco();
    }

    public ClienteDTO(Long id, String nome, String cpfCnpj, String telefone1, String telefone2, Endereco endereco) {
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
}

package com.example.casadecambio.cadastro.model.builder;

import com.example.casadecambio.cadastro.model.Cliente;

public class ClienteBuilder {
    private String nome;
    private String cpf;

    public ClienteBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ClienteBuilder setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public Cliente createCliente() {
        return new Cliente(nome, cpf);
    }
}
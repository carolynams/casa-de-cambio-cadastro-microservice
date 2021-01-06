package com.example.casadecambio.cadastro.model.builder;

import com.example.casadecambio.cadastro.model.Cliente;
import com.example.casadecambio.cadastro.model.Conta;

public class ClienteBuilder {
    private String nome;
    private String cpf;
    private Conta conta;

    public ClienteBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ClienteBuilder setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public ClienteBuilder setConta(Conta conta) {
        this.conta = conta;
        return this;
    }

    public Cliente createCliente() {
        return new Cliente(nome, cpf, conta);
    }
}
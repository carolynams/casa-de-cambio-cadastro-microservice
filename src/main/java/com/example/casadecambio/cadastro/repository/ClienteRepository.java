package com.example.casadecambio.cadastro.repository;

import com.example.casadecambio.cadastro.model.Cliente;

import java.util.List;


public interface ClienteRepository {

    Cliente save(Cliente cliente);

    Cliente findByCpf(String cpf);

    Cliente findById(Long id);

    Cliente update(Cliente cliente);

}

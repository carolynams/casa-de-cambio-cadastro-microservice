package com.casadecambio.domain.repository;

import com.casadecambio.domain.model.Cliente;

import java.util.List;

public interface ClienteRepository {

    Cliente save(Cliente cliente);

    Cliente findById(Long id);

    List<Cliente> findByCpf(Long cpf);

}

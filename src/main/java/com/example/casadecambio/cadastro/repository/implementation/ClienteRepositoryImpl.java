package com.example.casadecambio.cadastro.repository.implementation;

import com.example.casadecambio.cadastro.model.Cliente;
import com.example.casadecambio.cadastro.repository.ClienteRepository;
import com.example.casadecambio.cadastro.repository.jpa.ClienteRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    @Autowired
    private ClienteRepositoryJpa repositoryJpa;

    @Override
    public Cliente save(Cliente cliente) {
        return repositoryJpa.save(cliente);
    }

    @Override
    public Cliente findByCpf(String cpf) {
        return repositoryJpa.findByCpf(cpf);
    }

    @Override
    public Cliente findById(Long id) {
        Optional<Cliente> foundClient = repositoryJpa.findById(id);
        return foundClient.orElseThrow();
    }

    @Override
    public Cliente update(Cliente cliente) {
        return repositoryJpa.save(cliente);
    }
}

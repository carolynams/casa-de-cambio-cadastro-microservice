package com.casadecambio.infrastructure.repository;

import com.casadecambio.domain.model.Cliente;
import com.casadecambio.domain.repository.ClienteRepository;
import com.casadecambio.jpa.ClienteRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    private ClienteRepositoryJpa repositoryJpa;

    @Override
    public Cliente save(Cliente cliente) {
        return repositoryJpa.save(cliente);
    }

    @Override
    public Cliente findById(Long id) {
        Optional<Cliente> foundClient = repositoryJpa.findById(id);
        return foundClient.orElseThrow();
    }

    @Override
    public List<Cliente> findByCpf(Long cpf) {
        return repositoryJpa.findByCpf(cpf);
    }
}

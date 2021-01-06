package com.example.casadecambio.cadastro.repository.implementation;

import com.example.casadecambio.cadastro.model.Conta;
import com.example.casadecambio.cadastro.repository.ContaRepository;
import com.example.casadecambio.cadastro.repository.jpa.ContaRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class ContaRepositoryImpl implements ContaRepository {

    @Autowired
    private ContaRepositoryJpa repositoryJpa;

    @Override
    public Set<Conta> findByContaOrderByClientesNomeAsc(Long conta) {
        return repositoryJpa.findByContaOrderByClientesNomeAsc(conta);
    }
}

package com.example.casadecambio.cadastro.repository;

import com.example.casadecambio.cadastro.model.Conta;

import java.util.List;
import java.util.Set;

public interface ContaRepository {

    Set<Conta> findByContaOrderByClientesNomeAsc(Long conta);

}

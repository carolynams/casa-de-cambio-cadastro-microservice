package com.casadecambio.jpa;

import com.casadecambio.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepositoryJpa extends JpaRepository<Cliente, Long> {

    List<Cliente> findByCpf(Long cpf);

}

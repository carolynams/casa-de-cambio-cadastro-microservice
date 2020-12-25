package com.casadecambio.service;

import com.casadecambio.domain.model.Cliente;
import com.casadecambio.domain.repository.ClienteRepository;
import com.casadecambio.exceptions.DataIntegritViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.casadecambio.exceptions.DataIntegritViolationException.CPF_JA_CADASTRADO;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente save(Cliente cliente) {
        List<Cliente> cpfFound = clienteRepository.findByCpf(cliente.getCpf());
        checkIfAlreadyExists(cpfFound);
        return clienteRepository.save(cliente);
    }

    private void checkIfAlreadyExists(List<Cliente> cpfFound) {
        if (cpfFound.size() >= 1) {
            throw new DataIntegritViolationException(CPF_JA_CADASTRADO);
        }
    }
}

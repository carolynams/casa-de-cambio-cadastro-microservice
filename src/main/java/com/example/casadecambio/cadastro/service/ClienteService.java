package com.example.casadecambio.cadastro.service;

import br.com.caelum.stella.validation.CPFValidator;
import com.example.casadecambio.cadastro.exceptions.DataIntegrityViolationException;
import com.example.casadecambio.cadastro.model.Cliente;
import com.example.casadecambio.cadastro.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.casadecambio.cadastro.exceptions.DataIntegrityViolationException.*;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente save(Cliente cliente) {
        String cpf = cliente.getCpf();
        validateCpf(cpf);
        checkIfAlreadyExists(cliente);
        return repository.save(cliente);
    }

    private void checkIfAlreadyExists(Cliente cliente) {
        Cliente clienteFromDB = repository.findByCpf(cliente.getCpf());
        if (nonNull(clienteFromDB)) {
            isSameEntity(clienteFromDB, cliente.getCpf());
        }
    }

    private void isSameEntity(Cliente cliente, String cpf) {
        if (!cliente.getCpf().equals(cpf)) {
            throw new DataIntegrityViolationException(CPF_JA_CADASTRADO);
        }
    }

    private void validateCpf(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        try {
            cpfValidator.assertValid(cpf);
        } catch (Exception e) {
            throw new DataIntegrityViolationException(CPF_INVALIDO);
        }
    }

    public Cliente findByCpf(String cpf) {
        Cliente found = repository.findByCpf(cpf);
        if (isNull(found)) {
            throw new DataIntegrityViolationException(CLIENTE_NAO_ECONTRADO);
        }
        return found;
    }

    public Cliente update(Cliente cliente, Long id) {
        Cliente found = repository.findById(id);
        validateCpf(cliente.getCpf());
        return repository.update(found);
    }
}

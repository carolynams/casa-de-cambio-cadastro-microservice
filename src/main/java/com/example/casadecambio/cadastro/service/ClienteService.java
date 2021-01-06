package com.example.casadecambio.cadastro.service;

import br.com.caelum.stella.validation.CPFValidator;
import com.example.casadecambio.cadastro.exceptions.DataIntegrityViolationException;
import com.example.casadecambio.cadastro.model.Cliente;
import com.example.casadecambio.cadastro.model.Conta;
import com.example.casadecambio.cadastro.repository.ClienteRepository;
import com.example.casadecambio.cadastro.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

import static java.util.Objects.nonNull;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ContaRepository contaRepository;

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

        Conta conta = cliente.getConta();
        Set<Conta> foundConta = contaRepository.findByContaOrderByClientesNomeAsc(conta.getConta());
        if (foundConta.size() >= 1) {
            throw new DataIntegrityViolationException(DataIntegrityViolationException.CONTA_CADASTRADA);
        }
    }

    private void isSameEntity(Cliente cliente, String cpf) {
        if (!cliente.getCpf().equals(cpf)) {
            throw new DataIntegrityViolationException(DataIntegrityViolationException.CPF_JA_CADASTRADO);
        }
    }

    private void validateCpf(String cpf) {
        CPFValidator cpfValidator = new CPFValidator();
        try {
            cpfValidator.assertValid(cpf);
        } catch (Exception e) {
            throw new DataIntegrityViolationException(DataIntegrityViolationException.CPF_INVALIDO);
        }
    }

    public Cliente findByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

    public Cliente update(Cliente cliente, Long id) {
        Cliente found = repository.findById(id);
        Conta foundConta = contaRepository.findById(found.getConta().getId());
        foundConta.update(cliente.getConta());
        validateCpf(cliente.getCpf());
        return repository.update(found);
    }
}

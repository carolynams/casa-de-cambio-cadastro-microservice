package com.example.casadecambio.cadastro.model.dto;

import com.example.casadecambio.cadastro.model.Cliente;
import com.example.casadecambio.cadastro.model.Conta;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

import static org.springframework.beans.BeanUtils.copyProperties;

@Getter
@Setter
public class ClienteDTO {

    private String nome;
    private String cpf;

    @ManyToOne(cascade = CascadeType.ALL)
    private Conta conta;

    public ClienteDTO toDTO(Cliente cliente) {
        copyProperties(cliente, this);
        return this;
    }
}

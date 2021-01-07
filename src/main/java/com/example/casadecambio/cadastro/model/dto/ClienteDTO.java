package com.example.casadecambio.cadastro.model.dto;

import com.example.casadecambio.cadastro.model.Cliente;
import lombok.Getter;
import lombok.Setter;

import static org.springframework.beans.BeanUtils.copyProperties;

@Getter
@Setter
public class ClienteDTO {

    private String nome;
    private String cpf;

   public ClienteDTO toDTO(Cliente cliente) {
        copyProperties(cliente, this);
        return this;
    }
}

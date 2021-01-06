package com.example.casadecambio.cadastro.model;

import com.example.casadecambio.cadastro.model.dto.ClienteDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static org.springframework.beans.BeanUtils.copyProperties;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String cpf;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conta_id")
    private Conta conta;

    public Cliente(String nome, String cpf, Conta conta) {
        this.nome = nome;
        this.cpf = cpf;
        this.conta = conta;
    }

    public Cliente() {
    }

    public Cliente fromDTO(ClienteDTO clienteDTO) {
        copyProperties(clienteDTO, this);
        return this;
    }
}

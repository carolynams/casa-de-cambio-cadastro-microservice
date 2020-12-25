package com.casadecambio.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    private Long id;

    private String nome;

    private Long cpf;

    @JsonFormat(pattern = "dd/mm/YYYY")
    private LocalDate dataDeNascimento;

    @ManyToOne()
    @JoinColumn(name = "conta_id")
    private Conta conta;
}

package com.casadecambio.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "CONTA")
public class Conta {

    @Id
    private Long id;

    private String agencia;

    private String conta;

    private String senha;

    @JsonFormat(pattern = "dd/mm/YYYY HH:mm:ss")
    private LocalDateTime dataDeCriacao;

    private BigDecimal saldo;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL)
    private List<Cliente> clientes;

}

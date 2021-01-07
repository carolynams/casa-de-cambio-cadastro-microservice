package com.example.casadecambio.cadastro.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "CONTA")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long agencia;

    private Long conta;

    private String senha;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataDeCriacao;

    private BigDecimal saldo;

    @JsonIgnore
    @OneToMany(mappedBy = "conta")
    private List<Cliente> clientes;

    public Conta(Long agencia, Long conta, String senha, BigDecimal saldo) {
        this.agencia = agencia;
        this.conta = conta;
        this.senha = senha;
        this.saldo = saldo.setScale(3, RoundingMode.HALF_UP);
        this.clientes = new ArrayList<>();
        this.dataDeCriacao = LocalDateTime.now();
    }

    public Conta() {
        this.dataDeCriacao = LocalDateTime.now();
    }

    public Conta update(Conta conta) {
        BeanUtils.copyProperties(conta, this, "id");
        return this;
    }
}

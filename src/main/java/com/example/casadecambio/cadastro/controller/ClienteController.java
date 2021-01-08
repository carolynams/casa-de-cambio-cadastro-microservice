package com.example.casadecambio.cadastro.controller;

import com.example.casadecambio.cadastro.model.Cliente;
import com.example.casadecambio.cadastro.model.dto.ClienteDTO;
import com.example.casadecambio.cadastro.service.ClienteService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping("/save")
    @ApiOperation("Salva o Cliente")
    public ResponseEntity<Cliente> save(@Valid @RequestBody Cliente cliente) {
        return ResponseEntity.ok().body(service.save(cliente));
    }

    @GetMapping("/{cpf}")
    @ApiOperation("Busca o cliente por CPF")
    public ResponseEntity<Cliente> findByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok().body(service.findByCpf(cpf));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente, @PathVariable Long id) {
        return ResponseEntity.ok().body(service.update(cliente, id));
    }
}

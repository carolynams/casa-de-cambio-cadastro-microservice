package com.springspecialistalgaworks.service;

import com.springspecialistalgaworks.model.Cliente;
import com.springspecialistalgaworks.notification.Notificador;
import org.springframework.beans.factory.annotation.Autowired;

public class AtivacaoClienteService {

    @Autowired(required = false)
    private Notificador notificador;

    public AtivacaoClienteService(Notificador notificador) {
        this.notificador = notificador;

        System.out.println("AtivacaoClienteService: " + notificador);
    }

    public void ativar(Cliente cliente) {
        cliente.ativar();

        if (notificador != null) {
            notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
        } else {
            System.out.println("Não existe notificador, mas cliente foi ativado");
        }
    }

}
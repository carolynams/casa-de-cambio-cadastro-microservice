package com.springspecialistalgaworks.notification;

import com.springspecialistalgaworks.model.Cliente;

public interface Notificador {

    void notificar(Cliente cliente, String mensagem);

}

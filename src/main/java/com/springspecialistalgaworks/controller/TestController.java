package com.springspecialistalgaworks.controller;

import com.springspecialistalgaworks.model.Cliente;
import com.springspecialistalgaworks.service.AtivacaoClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    private AtivacaoClienteService service;

    public TestController(AtivacaoClienteService service) {
        this.service = service;
        System.out.println("TestController");
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        Cliente joao = new Cliente("João", "joao@sds.com ", "959595959");
        service.ativar(joao);
        return "Hello!";
    }
}

package br.queixas.spring01.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //indica classe controller do tipo REST
@CrossOrigin("*") //aceita pedidos de qualquer origem
@RequestMapping("/start")
public class Hello {
    @GetMapping("/hello") //método GET, URI /hello
    public String hello() {
        return "Hello World!";
    }
}

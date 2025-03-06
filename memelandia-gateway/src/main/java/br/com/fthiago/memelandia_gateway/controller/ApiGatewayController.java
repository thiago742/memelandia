package br.com.fthiago.memelandia_gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class ApiGatewayController {
    @GetMapping
    public String test() {
        return "API Gateway está rodando!";
    }
}
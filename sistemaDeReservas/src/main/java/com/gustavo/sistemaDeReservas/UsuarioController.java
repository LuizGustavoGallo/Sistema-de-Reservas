package com.gustavo.sistemaDeReservas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UsuarioController {

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Minha primeira mensagem";
    }
}

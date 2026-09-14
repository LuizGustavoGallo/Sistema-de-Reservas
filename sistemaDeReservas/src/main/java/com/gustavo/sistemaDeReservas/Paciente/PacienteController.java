package com.gustavo.sistemaDeReservas.Paciente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PacienteController {

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Minha primeira mensagem";
    }
}

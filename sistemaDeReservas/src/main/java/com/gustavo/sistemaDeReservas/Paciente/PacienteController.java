package com.gustavo.sistemaDeReservas.Paciente;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public PacienteModel criar(@RequestBody PacienteModel novoPaciente){
        return pacienteService.criarPaciente(novoPaciente);
    }

}

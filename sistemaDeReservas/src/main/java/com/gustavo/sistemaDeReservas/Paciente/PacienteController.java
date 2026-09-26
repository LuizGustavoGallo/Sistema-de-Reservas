package com.gustavo.sistemaDeReservas.Paciente;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public PacienteModel novoPaciente(@Valid @RequestBody PacienteRequestDTO pacienteRequestDTO){
        PacienteModel paciente = new PacienteModel(
                pacienteRequestDTO.nome(),
                pacienteRequestDTO.email(),
                pacienteRequestDTO.idade(),
                pacienteRequestDTO.telefone());
        return pacienteService.criarPaciente(paciente);
    }

    @PostMapping("/login")
    public PacienteModel login(@RequestParam String email){
        return pacienteService.login(email);
    }
}

package com.gustavo.sistemaDeReservas.Medico;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService medicoService;

    public MedicoController(MedicoService medicoService){
        this.medicoService = medicoService;
    }

    @GetMapping
    public List<MedicoModel> buscarPorEspecialidade(@RequestParam String especialidade){
        return medicoService.buscaPorEspecialidade((especialidade));
    }

    @PostMapping
    public MedicoModel novo(@RequestBody MedicoModel novoMedico){
        return medicoService.criarMedico(novoMedico);
    }
}

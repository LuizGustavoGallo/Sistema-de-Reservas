package com.gustavo.sistemaDeReservas.Consulta;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService){
        this.consultaService = consultaService;
    }

    @PostMapping
    public ConsultaModel agendar(@RequestParam Long pacienteId,
                                 @RequestParam Long medicoId,
                                 @RequestParam LocalDate data,
                                 @RequestParam LocalTime horaInicio){
        return consultaService.agendar(pacienteId, medicoId, data, horaInicio);
    }

    @GetMapping("/horarios-disponiveis")
    public List<LocalTime> horariosDisponiveis(@RequestParam Long medicoId, @RequestParam LocalDate data){
        return consultaService.horariosDisponiveis(medicoId, data);
    }
}

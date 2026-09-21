package com.gustavo.sistemaDeReservas.Consulta;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;

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
                                 @RequestParam LocalTime horaInicio,
                                 @RequestParam LocalTime horaFim){
        return consultaService.agendar(pacienteId, medicoId, data, horaInicio, horaFim);
    }
}

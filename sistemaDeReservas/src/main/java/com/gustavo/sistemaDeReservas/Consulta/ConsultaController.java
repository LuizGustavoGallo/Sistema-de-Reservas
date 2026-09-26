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
    public ConsultaModel agendar(@RequestBody AgendarConsultaDTO agendarConsultaDTO){
        return consultaService.agendar(
                agendarConsultaDTO.pacienteId(),
                agendarConsultaDTO.medicoId(),
                agendarConsultaDTO.data(),
                agendarConsultaDTO.horaInicio()
        );
    }

    @GetMapping("/horarios-disponiveis")
    public List<LocalTime> horariosDisponiveis(@RequestParam Long medicoId, @RequestParam LocalDate data){
        return consultaService.horariosDisponiveis(medicoId, data);
    }

    @GetMapping("/paciente/{pacienteId}")
    public List<ConsultaModel> agendasPaciente(@PathVariable Long pacienteId){
        return consultaService.listarPorPaciente(pacienteId);
    }

    @GetMapping("/medico/{medicoId}")
    public List<ConsultaModel> agendasMedico(@PathVariable Long medicoId){
        return consultaService.listarPorMedico(medicoId);
    }
}

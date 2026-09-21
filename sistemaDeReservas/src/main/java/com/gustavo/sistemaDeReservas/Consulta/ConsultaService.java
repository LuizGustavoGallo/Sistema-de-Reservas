package com.gustavo.sistemaDeReservas.Consulta;

import com.gustavo.sistemaDeReservas.Medico.MedicoModel;
import com.gustavo.sistemaDeReservas.Medico.MedicoNaoEncontradoException;
import com.gustavo.sistemaDeReservas.Medico.MedicoRepository;
import com.gustavo.sistemaDeReservas.Paciente.PacienteModel;
import com.gustavo.sistemaDeReservas.Paciente.PacienteNaoEncontradoException;
import com.gustavo.sistemaDeReservas.Paciente.PacienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;

    private final MedicoRepository medicoRepository;

    private final PacienteRepository pacienteRepository;

    public ConsultaService( ConsultaRepository consultaRepository,
                            PacienteRepository pacienteRepository,
                            MedicoRepository medicoRepository) {
        this.consultaRepository = consultaRepository;
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
    }

    public ConsultaModel agendar(Long pacienteId, Long medicoId, LocalDate data, LocalTime horaInicio, LocalTime horaFim){

        PacienteModel paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new PacienteNaoEncontradoException("Paciente não encontrado"));

        MedicoModel medico = medicoRepository.findById(medicoId)
                .orElseThrow(() -> new MedicoNaoEncontradoException("Médico não encontrado"));

        ConsultaModel consulta = new ConsultaModel(StatusConsulta.AGENDADA, data, horaInicio, horaFim, paciente, medico);

        return consultaRepository.save(consulta);
    }
}

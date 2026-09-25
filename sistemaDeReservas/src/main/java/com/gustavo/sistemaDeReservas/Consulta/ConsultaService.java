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
import java.util.ArrayList;
import java.util.List;

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

    public ConsultaModel agendar(Long pacienteId, Long medicoId, LocalDate data, LocalTime horaInicio){

        PacienteModel paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new PacienteNaoEncontradoException("Paciente não encontrado"));

        MedicoModel medico = medicoRepository.findById(medicoId)
                .orElseThrow(() -> new MedicoNaoEncontradoException("Médico não encontrado"));

        LocalTime horaFim = horaInicio.plusHours(1);

        List<ConsultaModel> conflitos = consultaRepository.buscarConflitos(medicoId, data, horaInicio, horaFim);

        if(!conflitos.isEmpty()){
            throw new ConflitoDeHorarioException("Horario indisponivel para consulta");
        }

        ConsultaModel consulta = new ConsultaModel(StatusConsulta.AGENDADA, data, horaInicio, horaFim, paciente, medico);

        return consultaRepository.save(consulta);
    }

    public List<LocalTime> horariosDisponiveis(Long medicoId, LocalDate data){

        List<LocalTime> horariosPossiveis = new ArrayList<>();
        LocalTime horario = LocalTime.of(8, 0);
        LocalTime fimExpediente = LocalTime.of(18, 0);
        LocalTime inicioAlmoco = LocalTime.of(12, 0);
        LocalTime fimAlmoco = LocalTime.of(14,0);

        while (horario.isBefore(fimExpediente)){
            boolean horarioAlmoco = !horario.isBefore(inicioAlmoco) && horario.isBefore(fimAlmoco);

            if(!horarioAlmoco){
                horariosPossiveis.add(horario);
            }
            horario = horario.plusHours(1);
        }

        List<ConsultaModel> consultasDoDia = consultaRepository.findByMedicoIdAndData(medicoId, data);

        List<LocalTime> horariosOcupados = consultasDoDia.stream()
                .map(ConsultaModel::getHoraInicio)
                .toList();

        horariosPossiveis.removeAll(horariosOcupados);

        return horariosPossiveis;
    }

    public List<ConsultaModel> listarPorPaciente(Long pacienteId){
        return consultaRepository.findByPacienteId(pacienteId);
    }

    public List<ConsultaModel> listarPorMedico(Long medicoId){
        return consultaRepository.findByMedicoId(medicoId);
    }



}

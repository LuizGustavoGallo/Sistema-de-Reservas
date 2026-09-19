package com.gustavo.sistemaDeReservas.Paciente;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository){
        this.pacienteRepository = pacienteRepository;
    }

    public PacienteModel criarPaciente(PacienteModel novoPaciente){
        return pacienteRepository.save(novoPaciente);
    }

    public PacienteModel login(String email){
        Optional<PacienteModel> paciente = pacienteRepository.findByEmail(email);

        if (paciente.isEmpty()){
            throw new PacienteNaoEncontradoException("Paciente não encontrado. Cadastre-se primeiro.");
        }
        return paciente.get();
    }
}

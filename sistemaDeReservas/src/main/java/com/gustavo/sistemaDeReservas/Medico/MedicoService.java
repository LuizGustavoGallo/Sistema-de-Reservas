package com.gustavo.sistemaDeReservas.Medico;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository){
        this.medicoRepository = medicoRepository;
    }

    public List<MedicoModel> buscaPorEspecialidade(String especialidade){
        return medicoRepository.findByEspecialidade(especialidade);
    }

    public MedicoModel criarMedico(MedicoModel novoMedico){
        return medicoRepository.save(novoMedico);
    }
}

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

    public boolean existeCrm(String crm){
        return medicoRepository.findByCrm(crm).isPresent();
    }

    public MedicoModel criarMedico(MedicoModel novoMedico){
        if (existeCrm(novoMedico.getCrm())){
            throw new CrmDuplicationException("Já existe um médico cadastrado com esse CRM");
        }
        return medicoRepository.save(novoMedico);
    }
}

package com.gustavo.sistemaDeReservas.Medico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MedicoRepository extends JpaRepository<MedicoModel, Long> {
    List<MedicoModel> findByEspecialidade(String especialidade);

    Optional<MedicoModel> findByCrm(String crm);
}

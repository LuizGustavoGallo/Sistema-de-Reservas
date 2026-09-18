package com.gustavo.sistemaDeReservas.Medico;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicoRepository extends JpaRepository<MedicoModel, Long> {
    List<MedicoModel> findByEspecialidade(String especialidade);
}

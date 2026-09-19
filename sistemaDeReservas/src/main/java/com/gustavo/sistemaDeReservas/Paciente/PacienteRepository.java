package com.gustavo.sistemaDeReservas.Paciente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<PacienteModel, Long> {

    Optional<PacienteModel> findByEmail(String email);
}

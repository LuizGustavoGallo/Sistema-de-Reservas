package com.gustavo.sistemaDeReservas.Consulta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ConsultaRepository extends JpaRepository<ConsultaModel, Long> {

    @Query("SELECT c FROM ConsultaModel c WHERE c.medico.id = :medicoId " +
            "AND c.data = :data " +
            "AND c.status = 'AGENDADA' " +
            "AND c.horaInicio < :horaFim AND c.horaFim > :horaInicio")
    List<ConsultaModel> buscarConflitos(Long medicoId, LocalDate data, LocalTime horaInicio, LocalTime horaFim);
}

package com.gustavo.sistemaDeReservas.Consulta;

import java.time.LocalDate;
import java.time.LocalTime;

public record AgendarConsultaDTO(
        Long pacienteId,
        Long medicoId,
        LocalDate data,
        LocalTime horaInicio
) {
}

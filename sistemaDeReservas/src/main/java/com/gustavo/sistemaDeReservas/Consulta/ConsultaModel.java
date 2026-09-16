package com.gustavo.sistemaDeReservas.Consulta;

import com.gustavo.sistemaDeReservas.Medico.MedicoModel;
import com.gustavo.sistemaDeReservas.Paciente.PacienteModel;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tb_Consulta")
@Getter
@Setter
@NoArgsConstructor
public class ConsultaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StatusConsulta status;

    private LocalDate data;
    private LocalTime horaInicio;
    private LocalTime horaFim;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private PacienteModel paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private MedicoModel medico;

    public ConsultaModel(StatusConsulta status, LocalDate data, LocalTime horaInicio, LocalTime horaFim, PacienteModel paciente, MedicoModel medico) {
        this.status = status;
        this.data = data;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.paciente = paciente;
        this.medico = medico;
    }
}

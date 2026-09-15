package com.gustavo.sistemaDeReservas.Medico;

import com.gustavo.sistemaDeReservas.Paciente.PacienteModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_medico")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String especialidade;


}

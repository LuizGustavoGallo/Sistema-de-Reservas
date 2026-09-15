package com.gustavo.sistemaDeReservas.Medico;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_medico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String especialidade;


}

package com.gustavo.sistemaDeReservas.Medico;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Table(name = "tb_medico")
@Getter
@Setter
@NoArgsConstructor
public class MedicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String especialidade;

    @Column(unique = true)
    private String crm;

    public MedicoModel(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public MedicoModel(String nome, String especialidade, String crm) {
        this(nome, especialidade);
        this.crm = crm;
    }
}

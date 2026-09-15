package com.gustavo.sistemaDeReservas.Paciente;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_Paciente")
@Getter
@Setter
@NoArgsConstructor
public class PacienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private int idade;
    private String telefone;

    public PacienteModel(String nome, String email, int idade, String telefone) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.telefone = telefone;
    }
}
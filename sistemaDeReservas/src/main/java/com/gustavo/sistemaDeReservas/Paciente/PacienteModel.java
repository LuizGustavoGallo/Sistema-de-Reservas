package com.gustavo.sistemaDeReservas.Paciente;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

    @NotBlank(message = "Obrigatório informar o nome")
    private String nome;

    @Email(message = "Email inválido")
    @NotBlank(message = "Informe o Email")
    @Column(unique = true)
    private String email;
    private int idade;

    @Pattern(regexp = "\\d{10,11}", message = "Informe um telefone válido")
    @Column(unique = true)
    private String telefone;

    public PacienteModel(String nome, String email, int idade, String telefone) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.telefone = telefone;
    }
}
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

    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "Nome deve conter apenas letras")
    @NotBlank(message = "Espaço nome é obrigatorio")
    private String nome;

    @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "Nome deve conter apenas letras")
    @NotBlank(message = "Informe sua especialidade.")
    private String especialidade;

    public MedicoModel(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }
}

package com.gustavo.sistemaDeReservas.Paciente;

import jakarta.validation.constraints.*;

public record PacienteRequestDTO(
        @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "Nome deve conter apenas letras")
        @NotBlank(message = "Obrigatório informar o nome") String nome,

        @Email(message = "Email inválido")
        @NotBlank(message = "Informe o Email") String email,

        @Min(value = 0, message = "Idade não pode ser negativa.")
        @Max(value = 120, message = "Idade inválida.") int idade,

        @Pattern(regexp = "\\d{10,11}", message = "Informe um telefone válido") String telefone
) {}

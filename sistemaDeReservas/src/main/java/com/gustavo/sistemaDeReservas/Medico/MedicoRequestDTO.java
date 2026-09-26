package com.gustavo.sistemaDeReservas.Medico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record MedicoRequestDTO(
        @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "Nome deve conter apenas letras")
        @NotBlank(message = "Obrigatorio informar o nome") String nome,

        @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "Informe o nome da especialidade correta.")
        @NotBlank(message = "Informe sua especialidade.") String especialidade,

        @Pattern(regexp = "^\\d{4,6}-[A-Z]{2}$", message = "CRM inválido. Formato esperado: [00000-SP]")
        @NotBlank String crm
) {}

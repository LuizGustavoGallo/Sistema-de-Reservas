package com.gustavo.sistemaDeReservas.Consulta;

public class ConflitoDeHorarioException extends RuntimeException {
    public ConflitoDeHorarioException(String mensagem) {
        super(mensagem);
    }
}

package com.gustavo.sistemaDeReservas.Paciente;

public class PacienteNaoEncontradoException extends RuntimeException {
    public PacienteNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}

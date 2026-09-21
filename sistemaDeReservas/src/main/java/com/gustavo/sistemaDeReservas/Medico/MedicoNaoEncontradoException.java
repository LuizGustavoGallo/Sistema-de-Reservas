package com.gustavo.sistemaDeReservas.Medico;

public class MedicoNaoEncontradoException extends RuntimeException {
    public MedicoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}

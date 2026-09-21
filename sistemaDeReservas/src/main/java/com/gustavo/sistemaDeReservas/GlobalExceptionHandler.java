package com.gustavo.sistemaDeReservas;

import com.gustavo.sistemaDeReservas.Medico.MedicoModel;
import com.gustavo.sistemaDeReservas.Medico.MedicoNaoEncontradoException;
import com.gustavo.sistemaDeReservas.Paciente.PacienteNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PacienteNaoEncontradoException.class)
    public ResponseEntity<String> handlePacienteNaoEncontrado(PacienteNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

   @ExceptionHandler(MedicoNaoEncontradoException.class)
    public ResponseEntity<String> handleMedicoNaoEncontrado(MedicoNaoEncontradoException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
   }
}

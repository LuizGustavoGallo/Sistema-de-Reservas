package com.gustavo.sistemaDeReservas.Medico;

import com.gustavo.sistemaDeReservas.Paciente.PacienteModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_medico")
public class MedicoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String especialidade;

    public MedicoModel() {
    }

    public MedicoModel(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}

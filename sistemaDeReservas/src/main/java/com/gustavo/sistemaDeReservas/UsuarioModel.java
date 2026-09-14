package com.gustavo.sistemaDeReservas;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_sistema_de_reservas")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String email;
    int idade;
    int telefone;

    public UsuarioModel() {
    }

    public UsuarioModel(String nome, String email, int idade, int telefone) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
}

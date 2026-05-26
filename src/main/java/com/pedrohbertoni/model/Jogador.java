package com.pedrohbertoni.model;

public class Jogador {
    private String nome;
    private Simbolo simbolo;

    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Simbolo getSimbolo() {
        return simbolo;
    }
    public void setSimbolo(Simbolo simbolo) {
        this.simbolo = simbolo;
    }
    public Jogador(String nome, Simbolo simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;
    }
}

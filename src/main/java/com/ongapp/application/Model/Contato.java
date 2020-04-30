package com.ongapp.application.Model;


public class Contato {

    String evento;
    String nome;

    public Contato(String evento, String nome){
        this.evento = evento;
        this.nome = nome;
    }

    public String getEvento(){
        return this.evento;
    }


    public String getNome(){
        return this.nome;
    }
}
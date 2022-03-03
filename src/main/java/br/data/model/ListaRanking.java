package br.data.model;

import lombok.Data;

@Data
public class ListaRanking {

    private String nome;
    private int quantidade;

    public ListaRanking() {
    }

    public ListaRanking(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

}

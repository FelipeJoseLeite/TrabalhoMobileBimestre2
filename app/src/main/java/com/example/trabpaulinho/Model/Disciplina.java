package com.example.trabpaulinho.Model;

public class Disciplina {
    private int id;
    private String nome;
    private int primBim;
    private int segBim;
    private int tercBim;
    private int quarBim;

    public Disciplina() {
    }

    public Disciplina(int id, String nome, int primBim, int segBim, int tercBim, int quarBim) {
        this.id = id;
        this.nome = nome;
        this.primBim = primBim;
        this.segBim = segBim;
        this.tercBim = tercBim;
        this.quarBim = quarBim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrimBim() {
        return primBim;
    }

    public void setPrimBim(int primBim) {
        this.primBim = primBim;
    }

    public int getSegBim() {
        return segBim;
    }

    public void setSegBim(int segBim) {
        this.segBim = segBim;
    }

    public int getTercBim() {
        return tercBim;
    }

    public void setTercBim(int tercBim) {
        this.tercBim = tercBim;
    }

    public int getQuarBim() {
        return quarBim;
    }

    public void setQuarBim(int quarBim) {
        this.quarBim = quarBim;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

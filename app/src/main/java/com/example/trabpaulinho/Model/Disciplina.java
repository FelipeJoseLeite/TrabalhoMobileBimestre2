package com.example.trabpaulinho.Model;

public class Disciplina {
    private int id;
    private String nome;
    private double primBim;
    private double segBim;
    private double tercBim;
    private double quarBim;

    public Disciplina() {
    }

    public Disciplina(int id, String nome, double primBim, double segBim, double tercBim, double quarBim) {
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

    public double getPrimBim() {
        return primBim;
    }

    public void setPrimBim(double primBim) {
        this.primBim = primBim;
    }

    public double getSegBim() {
        return segBim;
    }

    public void setSegBim(double segBim) {
        this.segBim = segBim;
    }

    public double getTercBim() {
        return tercBim;
    }

    public void setTercBim(double tercBim) {
        this.tercBim = tercBim;
    }

    public double getQuarBim() {
        return quarBim;
    }

    public void setQuarBim(double quarBim) {
        this.quarBim = quarBim;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

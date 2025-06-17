package br.com.investmanager.model;

import java.time.LocalDate;

public class Aporte {
    private Ativo ativo;
    private double valor;
    private LocalDate data;

    public Aporte(Ativo ativo, double valor, LocalDate data) {
        this.ativo = ativo;
        this.valor = valor;
        this.data = data;
    }

    @Override
    public String toString() {
        return data + " - " + ativo.getNome() + " (" + ativo.getTipoAtivo() + ") - R$ " + valor;
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}

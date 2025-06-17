package br.com.investmanager.model;

public class Ativo {
    private String nome;
    private TipoAtivo tipoAtivo;

    public Ativo(String nome, TipoAtivo tipoAtivo) {
        this.nome = nome;
        this.tipoAtivo = tipoAtivo;
    }

    @Override
    public String toString() {
        return nome + " (" + tipoAtivo + ")";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoAtivo getTipoAtivo() {
        return tipoAtivo;
    }

    public void setTipoAtivo(TipoAtivo tipoAtivo) {
        this.tipoAtivo = tipoAtivo;
    }
}

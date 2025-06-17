package br.com.investmanager.repository;

import br.com.investmanager.model.Aporte;
import br.com.investmanager.model.Ativo;

import java.util.ArrayList;

public class InMemoryRepository {
    private ArrayList<Ativo> ativos;
    private ArrayList<Aporte> aportes;

    public InMemoryRepository() {
        this.ativos = new ArrayList<>();
        this.aportes = new ArrayList<>();
    }

    public void adicionarAtivo(Ativo ativo){
        ativos.add(ativo);
    }

    public void adicionarAporte(Aporte aporte){
        aportes.add(aporte);
    }

    public ArrayList<Ativo> listarAtivos(){
        return ativos;
    }

    public ArrayList<Aporte> listarAportes(){
        return aportes;
    }
}

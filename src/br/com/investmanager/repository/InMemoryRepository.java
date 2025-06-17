package br.com.investmanager.repository;

import br.com.investmanager.model.Aporte;
import br.com.investmanager.model.Ativo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryRepository {
    private List<Ativo> ativos;
    private List<Aporte> aportes;

    public InMemoryRepository() {
        this.ativos = new ArrayList<>();
        this.aportes = new ArrayList<>();
    }

    public void adicionarAtivo(Ativo ativo) {
        ativos.add(ativo);
    }

    public void adicionarAporte(Aporte aporte) {
        aportes.add(aporte);
    }

    public List<Ativo> listarAtivos() {
        return Collections.unmodifiableList(ativos);
    }

    public List<Aporte> listarAportes() {
        return Collections.unmodifiableList(aportes);
    }
}

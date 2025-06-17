package br.com.investmanager.service;

import br.com.investmanager.model.Aporte;
import br.com.investmanager.model.Ativo;
import br.com.investmanager.model.TipoAtivo;
import br.com.investmanager.repository.InMemoryRepository;

import java.time.LocalDate;
import java.util.List;

public class InvestimentService {
    private InMemoryRepository repository;

    public InvestimentService(InMemoryRepository repository) {
        this.repository = repository;
    }

    public void cadastrarAtivo(String nome, TipoAtivo tipoAtivo){
        Ativo novoAtivo = new Ativo(nome, tipoAtivo);
        repository.adicionarAtivo(novoAtivo);
    }

    public void cadastrarAporte(Ativo ativo, double valor, LocalDate data){
        Aporte novoAporte = new Aporte(ativo, valor, data);
        repository.adicionarAporte(novoAporte);
    }

    public double calcularTotalInvestido(){
        List<Aporte> aportes = repository.listarAportes();
        double total = 0;
        for (Aporte aporte : aportes) {
            total += aporte.getValor();
        }
        return total;
    }

    public void listarAportesPorAtivo(Ativo ativo){
        List<Aporte> aportes = repository.listarAportes();
        for (Aporte aporte : aportes) {
            if (aporte.getAtivo().getNome().equals(ativo.getNome()) && aporte.getAtivo().getTipoAtivo() == ativo.getTipoAtivo()) {
                System.out.println(aporte);
            }
        }
    }


}

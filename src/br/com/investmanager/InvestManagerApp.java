package br.com.investmanager;

import br.com.investmanager.model.Ativo;
import br.com.investmanager.model.TipoAtivo;
import br.com.investmanager.repository.InMemoryRepository;
import br.com.investmanager.service.InvestimentService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class InvestManagerApp {
    public static void main(String[] args) {
        InMemoryRepository repository = new InMemoryRepository();
        InvestimentService service = new InvestimentService(repository);
        Scanner scanner = new Scanner(System.in);

        boolean rodando = true;
        while (rodando) {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar Ativo");
            System.out.println("2 - Cadastrar Aporte");
            System.out.println("3 - Calcular Total Investido");
            System.out.println("4 - Listar Aportes por Ativo");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do ativo: ");
                    String nome = scanner.nextLine();

                    System.out.println("Tipo do ativo (ACAO, FUNDO_IMOBILIARIO, CRIPTOMOEDA, RENDA_FIXA, OUTRO): ");
                    String tipoStr = scanner.nextLine();
                    TipoAtivo tipoAtivo = TipoAtivo.valueOf(tipoStr.toUpperCase());

                    service.cadastrarAtivo(nome, tipoAtivo);
                    System.out.println("Ativo cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.print("Nome do ativo do aporte: ");
                    String nomeAporte = scanner.nextLine();

                    System.out.println("Tipo do ativo do aporte (ACAO, FUNDO_IMOBILIARIO, CRIPTOMOEDA, RENDA_FIXA, OUTRO): ");
                    String tipoAporteStr = scanner.nextLine();
                    TipoAtivo tipoAporte = TipoAtivo.valueOf(tipoAporteStr.toUpperCase());

                    Ativo ativoAporte = new Ativo(nomeAporte, tipoAporte);

                    System.out.print("Valor do aporte: ");
                    double valor = scanner.nextDouble();

                    System.out.print("Ano do aporte: ");
                    int ano = scanner.nextInt();
                    System.out.print("Mês do aporte: ");
                    int mes = scanner.nextInt();
                    System.out.print("Dia do aporte: ");
                    int dia = scanner.nextInt();
                    scanner.nextLine(); // consumir quebra de linha

                    LocalDate data = LocalDate.of(ano, mes, dia);

                    service.cadastrarAporte(ativoAporte, valor, data);
                    System.out.println("Aporte cadastrado com sucesso!");
                    break;

                case 3:
                    double total = service.calcularTotalInvestido();
                    System.out.println("Total investido: R$ " + total);
                    break;

                case 4:
                    System.out.print("Nome do ativo: ");
                    String nomeBusca = scanner.nextLine();

                    System.out.println("Tipo do ativo (ACAO, FUNDO_IMOBILIARIO, CRIPTOMOEDA, RENDA_FIXA, OUTRO): ");
                    String tipoBuscaStr = scanner.nextLine();
                    TipoAtivo tipoBusca = TipoAtivo.valueOf(tipoBuscaStr.toUpperCase());

                    Ativo ativoBusca = new Ativo(nomeBusca, tipoBusca);
                    service.listarAportesPorAtivo(ativoBusca);
                    break;

                case 0:
                    rodando = false;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
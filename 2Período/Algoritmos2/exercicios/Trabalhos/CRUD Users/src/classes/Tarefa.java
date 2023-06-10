package src.classes;

import src.enums.Prioridade;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Tarefa {
    private String nome;
    private String descricao;
    private Etiqueta etiqueta;
    private String professor;
    private LocalDate dataPostagem;
    private Prioridade prioridade;

    public Tarefa() {

    }

    public Tarefa(String nome, String descricao, Etiqueta etiqueta, String professor, LocalDate dataPostagem, Prioridade prioridade) {
        this.nome = nome;
        this.descricao = descricao;
        this.etiqueta = etiqueta;
        this.professor = professor;
        this.dataPostagem = dataPostagem;
        this.prioridade = prioridade;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    public String getProfessor() {
        return professor;
    }

    public LocalDate getDataPostagem() {
        return dataPostagem;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setEtiqueta(Etiqueta etiqueta) {
        this.etiqueta = etiqueta;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public void setDataPostagem(LocalDate dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public static void incluir(List<Tarefa> tarefas, Tarefa tarefa) {
        tarefas.add(tarefa);
        System.out.println("Tarefa incluída com sucesso!");
    }

    public static void alterar(List<Tarefa> tarefas, int indice, Tarefa novaTarefa) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.set(indice, novaTarefa);
            System.out.println("Tarefa alterada com sucesso!");
        } else {
            System.out.println("Índice de tarefa inválido.");
        }
    }

    public static void excluir(List<Tarefa> tarefas, int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            tarefas.remove(indice);
            System.out.println("Tarefa excluída com sucesso!");
        } else {
            System.out.println("Índice de tarefa inválido.");
        }
    }

    public static void tipoImprimir() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 0) {
            System.out.println("Que tipo de impressão você deseja?");
            System.out.println("Menu de Impressões:");
            System.out.println("1. Imprimir todas as tarefas (sem ordem)");
            System.out.println("2. Imprimir todas as tarefas ordenadas por data");
            System.out.println("3. Imprimir todas as tarefas ordenadas por prioridade");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        // Chame o método correspondente para imprimir todas as tarefas sem ordem

                        Tarefa.imprimir();
                        break;
                    case 2:
                        // Chame o método correspondente para imprimir todas as tarefas ordenadas por data

                        Tarefa.imprimirOrdenadoData();
                        break;
                    case 3:
                        // Chame o método correspondente para imprimir todas as tarefas ordenadas por prioridade

                        Tarefa.imprimirOrdenadoPrioridade();
                        break;
                    case 0:
                        System.out.println("Voltando...");
                        break;
                    default:
                        System.out.println("Opção inválida. Digite uma opção válida.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número correspondente à opção desejada.");
            }
        }
    }

    public static void imprimir() {
        System.out.println("Imprimindo todas as tarefas!");
    }

    public static void imprimirOrdenadoData() {
        System.out.println("Tarefas (Ordenado por data)");
    }

    public static void imprimirOrdenadoPrioridade() {
        System.out.println("Tarefas (Filtradas por Prioridade)!");

    }

}

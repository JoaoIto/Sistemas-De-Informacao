package src.classes;

import src.enums.Prioridade;

import java.time.LocalDate;
import java.util.*;

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

    public static void incluir(List<Etiqueta> etiquetas) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome da tarefa:");
        String nome = scanner.nextLine();

        System.out.println("Digite a descrição da tarefa:");
        String descricao = scanner.nextLine();

        System.out.println("Selecione uma etiqueta para a tarefa:");
        Etiqueta.exibirEtiquetas(etiquetas);

        // Restante do código para criar a tarefa com a etiqueta selecionada
    }


    public static void alterar() {
            System.out.println("Tarefa alterada com sucesso!");
    }

    public static void excluir() {
            System.out.println("Tarefa excluída com sucesso!");
    }

    public static void tipoImprimir() {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

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
        int opcao = -1;
        System.out.println("Imprimindo todas as tarefas!");
    }

    public static void imprimirOrdenadoData() {
        int opcao = -1;
        System.out.println("Tarefas (Ordenado por data)");
    }

    public static void imprimirOrdenadoPrioridade() {
        int opcao = -1;
        System.out.println("Tarefas (Filtradas por Prioridade)!");
    }

}

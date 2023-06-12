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

    @Override
    public String toString() {
        return "Tarefa{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", etiqueta=" + etiqueta +
                ", professor='" + professor + '\'' +
                ", dataPostagem=" + dataPostagem +
                ", prioridade=" + prioridade +
                '}';
    }

    public static void incluir(List<Etiqueta> etiquetas, List<Tarefa> tarefas) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome da tarefa:");
        String nome = scanner.nextLine();

        System.out.println("Digite a descrição da tarefa:");
        String descricao = scanner.nextLine();

        System.out.println("Selecione uma etiqueta para a tarefa:");
        for (int i = 0; i < etiquetas.size(); i++) {
            System.out.println((i + 1) + ". " + etiquetas.get(i));
        }
        int opcaoEtiqueta = Integer.parseInt(scanner.nextLine());
        Etiqueta etiquetaSelecionada = etiquetas.get(opcaoEtiqueta - 1);
        System.out.println("Etiqueta selecionada: " + etiquetaSelecionada);

        System.out.println("Selecione a prioridade da tarefa:");
        for (Prioridade prioridade : Prioridade.values()) {
            System.out.println(prioridade.getId() + ". " + prioridade.getLabel());
        }
        int opcaoPrioridade = Integer.parseInt(scanner.nextLine());
        Prioridade prioridadeSelecionada = Prioridade.values()[opcaoPrioridade - 1];

        System.out.println("Digite o nome do professor:");
        String professor = scanner.nextLine();

        System.out.println("Digite a data de postagem (AAAA-MM-DD):");
        String dataPostagemString = scanner.nextLine();
        LocalDate dataPostagem = LocalDate.parse(dataPostagemString);

        Tarefa novaTarefa = new Tarefa(nome, descricao, etiquetaSelecionada, professor, dataPostagem, prioridadeSelecionada);
        tarefas.add(novaTarefa);
        // Adiciona a tarefa à lista de tarefas existente

        System.out.println("Tarefa adicionada com sucesso!");
    }



    public static void alterar() {
            System.out.println("Tarefa alterada com sucesso!");
    }

    public static void excluir() {
            System.out.println("Tarefa excluída com sucesso!");
    }

    public static void tipoImprimir(List<Tarefa> tarefas) {
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

                        Tarefa.imprimir(tarefas);
                        break;
                    case 2:
                        // Chame o método correspondente para imprimir todas as tarefas ordenadas por data

                        Tarefa.imprimirOrdenadoData(tarefas);
                        break;
                    case 3:
                        // Chame o método correspondente para imprimir todas as tarefas ordenadas por prioridade

                        Tarefa.imprimirOrdenadoPrioridade(tarefas);
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

    public static void imprimir(List<Tarefa> tarefas) {
        int opcao = -1;
        if (tarefas.isEmpty()) {
            System.out.println("Não há tarefas cadastradas.");
        } else {
            System.out.println("Lista de todas as tarefas (sem ordem):");
            for (Tarefa tarefa : tarefas) {
                System.out.println(tarefa.toString());
            }
        }
    }

    public static void imprimirOrdenadoData(List<Tarefa> tarefas) {
        int opcao = -1;
        System.out.println("Tarefas (Ordenado por data)");
    }

    public static void imprimirOrdenadoPrioridade(List<Tarefa> tarefas) {
        int opcao = -1;
        System.out.println("Tarefas (Filtradas por Prioridade)!");
    }

}

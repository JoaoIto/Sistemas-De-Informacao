package src.classes;

import src.enums.Prioridade;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.stream.IntStream;

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

        LocalDate dataCriacao = null;
        LocalDate dataPostagem = null;

        boolean formatoValido = false;

        while (!formatoValido) {
            System.out.print("Digite a data de criação da tarefa (dd/mm/yyyy): ");
            String dataDigitada = scanner.nextLine();

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                dataPostagem = LocalDate.parse(dataDigitada, formatter);
                formatoValido = true;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Digite novamente no formato dd/mm/yyyy.");
            }
        }

        Tarefa novaTarefa = new Tarefa(nome, descricao, etiquetaSelecionada, professor, dataPostagem, prioridadeSelecionada);
        tarefas.add(novaTarefa);

        System.out.println("Tarefa adicionada com sucesso!");
    }

    public static void alterar(List<Tarefa> tarefas) {
        Scanner scanner = new Scanner(System.in);

        if (tarefas.isEmpty()) {
            System.out.println("Não há tarefas para alterar.");
            return;
        }

        System.out.println("Tarefas disponíveis:");
        tipoImprimir(tarefas);

        boolean indiceValido = false;
        int indice = -1;

        while (!indiceValido) {
            try {
                System.out.print("Digite o índice da tarefa que deseja alterar: \n");
                indice = Integer.parseInt(scanner.nextLine());

                if (indice >= 0 && indice < tarefas.size()) {
                    indiceValido = true;
                } else {
                    System.out.println("Índice inválido. Digite novamente.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Índice inválido. Digite novamente.\n");
            }
        }

        Tarefa tarefaSelecionada = tarefas.get(indice);
        System.out.println("Tarefa selecionada: " + tarefaSelecionada);

        // Alterar os atributos da tarefa
        System.out.println("Digite o novo nome da tarefa: ");
        String novoNome = scanner.nextLine();
        tarefaSelecionada.setNome(novoNome);
        System.out.print("Digite a nova descrição da tarefa: ");
        String novaDescricao = scanner.nextLine();
        tarefaSelecionada.setDescricao(novaDescricao);

        System.out.print("Digite a nova data de criação da tarefa (dd/mm/aaaa): ");
        String novaDataCriacao = scanner.nextLine();
        try {
            LocalDate dataCriacao = LocalDate.parse(novaDataCriacao, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            tarefaSelecionada.setDataPostagem(dataCriacao);
        } catch (DateTimeParseException e) {
            System.out.println("Formato de data inválido. A data não foi alterada.");
        }

        System.out.println("Tarefa alterada com sucesso: \n" + tarefaSelecionada + "\n");
    }

    public static void excluir(List<Tarefa> tarefas) {
        Scanner scanner = new Scanner(System.in);

        if (tarefas.isEmpty()) {
            System.out.println("Não há tarefas para deletar.");
            return;
        }

        System.out.println("Tarefas disponíveis:");
        tipoImprimir(tarefas); // Implemente o método para imprimir as tarefas na tela

        boolean indiceValido = false;
        int indice = -1;

        while (!indiceValido) {
            try {
                System.out.print("Digite o índice da tarefa que deseja deletar: ");
                indice = Integer.parseInt(scanner.nextLine());

                if (indice >= 0 && indice < tarefas.size()) {
                    indiceValido = true;
                } else {
                    System.out.println("Índice inválido. Digite novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Índice inválido. Digite novamente.");
            }
        }

        Tarefa tarefaRemovida = tarefas.remove(indice);
        System.out.println("Tarefa removida com sucesso: " + tarefaRemovida);
    }

    public static void tipoImprimir(List<Tarefa> tarefas) {
        Scanner scanner = new Scanner(System.in);

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("Que tipo de impressão você deseja?\n");
            System.out.println("Menu de Impressões:");
            System.out.println("1. Imprimir todas as tarefas (sem ordem)");
            System.out.println("2. Imprimir todas as tarefas ordenadas por data");
            System.out.println("3. Imprimir todas as tarefas ordenadas por prioridade");
            System.out.println("0. Voltar\n");
            System.out.print("Opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        imprimir(tarefas);
                        break;
                    case 2:
                       imprimirOrdenadoData(tarefas);
                        break;
                    case 3:
                       imprimirOrdenadoPrioridade(tarefas);
                        break;
                    case 0:
                        System.out.println("Voltando ao menu principal...\n");
                        return;  // Retorna ao método chamador (exibirMenu)
                    default:
                        System.out.println("Opção inválida. Digite uma opção válida.\n");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número correspondente à opção desejada.\n");
            }
        }
    }

    public static void imprimir(List<Tarefa> tarefas) {
        int opcao = -1;
        if (tarefas.isEmpty()) {
            System.out.println("Não há tarefas cadastradas!\n");
        } else {
            System.out.println("Lista de todas as tarefas (sem ordem):\n");
            for (Tarefa tarefa : tarefas) {
                System.out.println(tarefa.toString());
            }
        }
    }

    public static void imprimirOrdenadoData(List<Tarefa> tarefas) {
        List<Tarefa> tarefasOrdenadas = new ArrayList<>(tarefas);
        Collections.sort(tarefasOrdenadas, Comparator.comparing(Tarefa::getDataPostagem));

        System.out.println("\nTarefas ordenadas por data de criação:\n");
        IntStream.range(0, tarefasOrdenadas.size())
                .forEach(i -> {
                    Tarefa tarefa = tarefasOrdenadas.get(i);
                    System.out.println((i + 1) + ". " + tarefa);
                });

    }

    public static void imprimirOrdenadoPrioridade(List<Tarefa> tarefas) {
        List<Tarefa> tarefasOrdenadas = new ArrayList<>(tarefas);
        Collections.sort(tarefasOrdenadas, Comparator.comparing(Tarefa::getPrioridade));

        System.out.println("\nTarefas ordenadas por prioridade:\n");
        IntStream.range(0, tarefasOrdenadas.size())
                .forEach(i -> System.out.println((i + 1) + ". " + tarefasOrdenadas.get(i)));

    }


}

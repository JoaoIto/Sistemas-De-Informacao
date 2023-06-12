package src.classes;

import src.enums.Prioridade;

import java.util.*;

public class Etiqueta {
    private String tipo;
    private String descricao;

    public Etiqueta(String tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + ", Descrição: " + descricao;
    }

    public static void tipoImprimir(List<Etiqueta> etiquetas) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nQue tipo de impressão você deseja?");
            System.out.println("1. Imprimir etiquetas por tipo");
            System.out.println("2. Imprimir etiquetas por descrição");
            System.out.println("3. Imprimir etiquetas em ordem inversa");
            System.out.println("0. Voltar");

            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de leitura

            switch (opcao) {
                case 1:
                    imprimirPorTipo(etiquetas);
                    break;
                case 2:
                    imprimirPorDescricao(etiquetas);
                    break;
                case 3:
                    imprimirPorOrdemInversa(etiquetas);
                    break;
                case 0:
                    System.out.println("Voltando ao menu de etiquetas...");
                    break;
                default:
                    System.out.println("Opção inválida. Digite uma opção válida.");
                    break;
            }
        } while (opcao != 0);
    }

    private static void imprimirPorTipo(List<Etiqueta> etiquetas) {
        System.out.println("\nImprimindo etiquetas por tipo:");
        for (Etiqueta etiqueta : etiquetas) {
            System.out.println("Tipo: " + etiqueta.getTipo() + ", Descrição: " + etiqueta.getDescricao());
        }
    }

    private static void imprimirPorDescricao(List<Etiqueta> etiquetas) {
        System.out.println("Imprimindo etiquetas por descrição:");
        List<Etiqueta> etiquetasOrdenadas = new ArrayList<>(etiquetas);
        Collections.sort(etiquetasOrdenadas, Comparator.comparing(Etiqueta::getDescricao));
        for (Etiqueta etiqueta : etiquetasOrdenadas) {
            System.out.println("Tipo: " + etiqueta.getTipo() + ", Descrição: " + etiqueta.getDescricao());
        }
    }

    private static void imprimirPorOrdemInversa(List<Etiqueta> etiquetas) {
        System.out.println("\nImprimindo etiquetas em ordem inversa:");
        List<Etiqueta> etiquetasInversas = new ArrayList<>(etiquetas);
        Collections.reverse(etiquetasInversas);
        for (Etiqueta etiqueta : etiquetasInversas) {
            System.out.println("Tipo: " + etiqueta.getTipo() + ", Descrição: " + etiqueta.getDescricao());
        }
    }

    public static void incluir(List<Etiqueta> etiquetas) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nDigite o tipo da nova etiqueta: ");
        String tipoEtiqueta = scanner.nextLine();

        System.out.print("Digite a descrição da nova etiqueta: ");
        String descricaoEtiqueta = scanner.nextLine();

        etiquetas.add(new Etiqueta(tipoEtiqueta, descricaoEtiqueta));

        System.out.println("Nova etiqueta criada com sucesso!\n");
    }


    public static void alterar(List<Etiqueta> etiquetas){
        System.out.println("Alterando etiquetas\n");
    }

    public static void excluir(List<Etiqueta> etiquetas) {
        Scanner scanner = new Scanner(System.in);

        if (etiquetas.isEmpty()) {
            System.out.println("Não há etiquetas para deletar.");
            return;
        }

        System.out.println("Etiquetas disponíveis:");
        tipoImprimir(etiquetas); // Implemente o método para imprimir as etiquetas na tela

        boolean indiceValido = false;
        int indice = -1;

        while (!indiceValido) {
            try {
                System.out.print("Digite o índice da etiqueta que deseja deletar: ");
                indice = Integer.parseInt(scanner.nextLine());

                if (indice >= 0 && indice < etiquetas.size()) {
                    indiceValido = true;
                } else {
                    System.out.println("Índice inválido. Digite novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Índice inválido. Digite novamente.");
            }
        }

        Etiqueta etiquetaRemovida = etiquetas.remove(indice);
        System.out.println("Etiqueta removida com sucesso: " + etiquetaRemovida);
    }

}

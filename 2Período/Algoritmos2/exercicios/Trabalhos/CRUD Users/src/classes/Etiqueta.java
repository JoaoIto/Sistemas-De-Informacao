package src.classes;

import src.enums.Prioridade;

import java.util.List;
import java.util.Scanner;

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

    public static void exibirEtiquetas(List<Etiqueta> etiquetas) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Etiquetas disponíveis:");
        for (int i = 0; i < etiquetas.size(); i++) {
            System.out.println((i + 1) + ". " + etiquetas.get(i));
        }
        System.out.println("0. Criar nova etiqueta");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer de leitura

        if (opcao == 0) {
            System.out.print("Digite o tipo da nova etiqueta: ");
            String tipoEtiqueta = scanner.nextLine();

            System.out.print("Digite a descrição da nova etiqueta: ");
            String descricaoEtiqueta = scanner.nextLine();

            etiquetas.add(new Etiqueta(tipoEtiqueta, descricaoEtiqueta));

            System.out.println("Nova etiqueta criada com sucesso!");
        } else if (opcao >= 1 && opcao <= etiquetas.size()) {
            Etiqueta etiquetaSelecionada = etiquetas.get(opcao - 1);
            System.out.println("Etiqueta selecionada: " + etiquetaSelecionada);
            // Faça o que desejar com a etiqueta selecionada
        } else {
            System.out.println("Opção inválida. Digite uma opção válida.");
        }
    }
}

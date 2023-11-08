import classes.ArvoreBinaria;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserirNo(arvoreBinaria.noRaiz, 20);
        arvoreBinaria.inserirNo(arvoreBinaria.noRaiz, 10);
        arvoreBinaria.inserirNo(arvoreBinaria.noRaiz, 30);
        arvoreBinaria.inserirNo(arvoreBinaria.noRaiz, 25);
        arvoreBinaria.inserirNo(arvoreBinaria.noRaiz, 35);

        System.out.println("Em-Ordem");
        arvoreBinaria.emOrdem(arvoreBinaria.noRaiz);

        System.out.println("\nPré-Ordem");
        arvoreBinaria.preOrdem(arvoreBinaria.noRaiz);

        System.out.println("\nPós-Ordem");
        arvoreBinaria.posOrdem(arvoreBinaria.noRaiz);

        // Remover um nó (por exemplo, remover o nó com valor 30)
        int elementoParaRemover = 30;
        arvoreBinaria.removerNo(elementoParaRemover);

        System.out.println("\nEm-Ordem");
        arvoreBinaria.emOrdem(arvoreBinaria.noRaiz);
    }
}
import classes.ArvoreAVL;
import classes.No;

public class Main {
    public static void main(String[] args) {
        // Criar uma árvore AVL
        ArvoreAVL arvoreAVL = new ArvoreAVL();

        // Inserir elementos na árvore
        arvoreAVL.inserir(30);
        arvoreAVL.inserir(20);
        arvoreAVL.inserir(40);
        arvoreAVL.inserir(10);
        arvoreAVL.inserir(25);

        // Exibir a altura da árvore antes do balanceamento
        System.out.println("Altura da árvore antes do balanceamento: " + arvoreAVL.alturaArvore(arvoreAVL.raiz));

        // Realizar balanceamento
        arvoreAVL.raiz = arvoreAVL.balancear(arvoreAVL.raiz);

        // Exibir a altura da árvore após o balanceamento
        System.out.println("Altura da árvore após o balanceamento: " + arvoreAVL.alturaArvore(arvoreAVL.raiz));

        // Exibir fator de balanceamento após o balanceamento
        int fatorDepois = arvoreAVL.fatorBalanceamento(arvoreAVL.raiz);
        System.out.println("Fator de balanceamento após o balanceamento: " + fatorDepois);

        int elementoBuscado = 20;
        No resultadoBusca = arvoreAVL.buscar(elementoBuscado);

        if (resultadoBusca != null) {
            System.out.println("Elemento " + elementoBuscado + " encontrado na árvore.");
        } else {
            System.out.println("Elemento " + elementoBuscado + " não encontrado na árvore.");
        }
    }
}

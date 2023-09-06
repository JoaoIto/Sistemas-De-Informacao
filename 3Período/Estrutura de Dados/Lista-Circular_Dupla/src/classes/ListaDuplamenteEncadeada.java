package src.classes;

public class ListaDuplamenteEncadeada {
    private No primeiroNo;
    private No ultimoNo;
    private int tamanho;

    public ListaDuplamenteEncadeada(){
        this.primeiroNo = null;
        this.ultimoNo = null;
    }

    public void inserirNoFim(int dado) {
        No novoNo = new No(dado);
        if (estaVazia()) {
            primeiroNo = novoNo;
            ultimoNo = novoNo;
        } else {
            novoNo.anterior = ultimoNo;
            ultimoNo.proximo = novoNo;
            ultimoNo = novoNo;
        }
    }

    public void mostrar() {
        No atual = primeiroNo;
        while (atual != null) {
            System.out.print(atual.dado + " <-> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }

    public boolean estaVazia() {
        return primeiroNo == null;
    }

    public void inserirNoInicio(int dado) {
        No novoNo = new No(dado);
        if (estaVazia()) {
            primeiroNo = novoNo;
            ultimoNo = novoNo;
        } else {
            novoNo.proximo = primeiroNo;
            primeiroNo.anterior = novoNo;
            primeiroNo = novoNo;
        }
    }

    public void removerDoInicio() {
        if (!estaVazia()) {
            primeiroNo = primeiroNo.proximo;
            if (primeiroNo != null) {
                primeiroNo.anterior = null;
            } else {
                primeiroNo = null;
            }
        }
    }

    public void removerDoFim() {
        if (!estaVazia()) {
            ultimoNo = ultimoNo.anterior;
            if (ultimoNo != null) {
                ultimoNo.proximo = null;
            } else {
                ultimoNo = null;
            }
        }
    }
}

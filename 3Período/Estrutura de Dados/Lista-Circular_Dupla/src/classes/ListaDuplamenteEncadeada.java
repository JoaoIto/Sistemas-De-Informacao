package src.classes;

public class ListaDuplamenteEncadeada {
    private NoDuplo primeiroNo;
    private NoDuplo ultimoNo;
    private int tamanho;

    public ListaDuplamenteEncadeada() {
        // Cria um nó "null" inicial, mas ele não contém dados.
        primeiroNo = new NoDuplo(-1); // Valor arbitrário, pode ser qualquer valor não utilizado.
        ultimoNo = primeiroNo;
        tamanho = 0;
    }

    public void inserirNoFim(int dado) {
        NoDuplo novoNo = new NoDuplo(dado);
        novoNo.anterior = ultimoNo;
        ultimoNo.proximo = novoNo;
        ultimoNo = novoNo;
        tamanho++;
    }

    public void mostrar() {
        NoDuplo atual = primeiroNo.proximo; // Começa a partir do primeiro nó real.
        while (atual != null) {
            System.out.print(atual.dado + " <-> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }

    public boolean estaVazia() {
        return tamanho == 0;
    }

    public void inserirNoInicio(int dado) {
        NoDuplo novoNo = new NoDuplo(dado);
        novoNo.proximo = primeiroNo.proximo;
        if (primeiroNo.proximo != null) {
            primeiroNo.proximo.anterior = novoNo;
        }
        primeiroNo.proximo = novoNo;
        novoNo.anterior = primeiroNo;
        if (ultimoNo == primeiroNo) {
            ultimoNo = novoNo;
        }
        tamanho++;
    }

    public void removerDoInicio() {
        if (tamanho == 0) {
            return;
        }
        NoDuplo noRemovido = primeiroNo.proximo;
        primeiroNo.proximo = noRemovido.proximo;
        if (noRemovido.proximo != null) {
            noRemovido.proximo.anterior = primeiroNo;
        }
        if (ultimoNo == noRemovido) {
            ultimoNo = primeiroNo;
        }
        tamanho--;
    }

    public void removerDoFim() {
        if (tamanho <= 1) {
            limpar();
        } else {
            NoDuplo noRemovido = ultimoNo;
            ultimoNo = noRemovido.anterior;
            ultimoNo.proximo = null;
            tamanho--;
        }
    }

    public void limpar() {
        primeiroNo.proximo = null;
        ultimoNo = primeiroNo;
        tamanho = 0;
    }

    public int getTamanho() {
        return tamanho;
    }
}
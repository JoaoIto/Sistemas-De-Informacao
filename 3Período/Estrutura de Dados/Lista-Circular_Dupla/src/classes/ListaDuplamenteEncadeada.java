package src.classes;

public class ListaDuplamenteEncadeada {
    private NoDuplo primeiroNo;
    private NoDuplo ultimoNo;
    private int tamanho;

    public ListaDuplamenteEncadeada() {
        // Cria um nó "null" inicial, mas ele não contém dados.
        primeiroNo = null;
        ultimoNo = primeiroNo;
        tamanho = 0;
    }

    public void imprimirRecursivo() {
        imprimirRecursivoAux(primeiroNo);
    }

    private void imprimirRecursivoAux(NoDuplo noAuxiliar) {
        if (noAuxiliar == null) {
            System.out.println("null");
            return;
        }

        System.out.print(noAuxiliar.dado + " <-> ");
        imprimirRecursivoAux(noAuxiliar.proximo);
    }

    public void inserirNoFim(int dado) {
        NoDuplo novoNo = new NoDuplo(dado);
        if (tamanho == 0) {
            // Se a lista estiver vazia, define o primeiro nó como o novo nó.
            primeiroNo = novoNo;
        } else {
            NoDuplo ultimo = primeiroNo;
            while (ultimo.proximo != null) {
                ultimo = ultimo.proximo;
            }
            novoNo.anterior = ultimo;
            ultimo.proximo = novoNo;
        }
        tamanho++;
    }

    public void mostrar() {
        NoDuplo atual = primeiroNo;
        System.out.print("null <-> ");
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

    public void imprimirCrescente() {
        NoDuplo atual = primeiroNo;
        System.out.print("null <-> ");
        while (atual != null) {
            System.out.print(atual.dado + " <-> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }

    public void imprimirDecrescente() {
        NoDuplo atual = ultimoNo;
        System.out.print("null <-> ");
        while (atual != null) {
            System.out.print(atual.dado + " <-> ");
            atual = atual.anterior;
        }
        System.out.println("null");
    }


}
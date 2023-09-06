package src.classes;

class ListaDuplamenteEncadeada {
    private No cabeca;
    private No cauda;

    public ListaDuplamenteEncadeada() {
        this.cabeca = null;
        this.cauda = null;
    }

    public void inserirNoFim(int dado) {
        No novoNo = new No(dado);
        if (estaVazia()) {
            cabeca = novoNo;
            cauda = novoNo;
        } else {
            novoNo.anterior = cauda;
            cauda.proximo = novoNo;
            cauda = novoNo;
        }
    }

    public void mostrar() {
        No atual = cabeca;
        while (atual != null) {
            System.out.print(atual.dado + " <-> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }

    public boolean estaVazia() {
        return cabeca == null;
    }

    public void inserirNoInicio(int dado) {
        No novoNo = new No(dado);
        if (estaVazia()) {
            cabeca = novoNo;
            cauda = novoNo;
        } else {
            novoNo.proximo = cabeca;
            cabeca.anterior = novoNo;
            cabeca = novoNo;
        }
    }

    public void removerDoInicio() {
        if (!estaVazia()) {
            cabeca = cabeca.proximo;
            if (cabeca != null) {
                cabeca.anterior = null;
            } else {
                cauda = null;
            }
        }
    }

    public void removerDoFim() {
        if (!estaVazia()) {
            cauda = cauda.anterior;
            if (cauda != null) {
                cauda.proximo = null;
            } else {
                cabeca = null;
            }
        }
    }
}

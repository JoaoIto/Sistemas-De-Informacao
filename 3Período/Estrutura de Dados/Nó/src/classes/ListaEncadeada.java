package src.classes;

public class ListaEncadeada {
    private No primeiroNo;
    private No ultimoNo;
    private int tamanho;

    public ListaEncadeada(){
        this.primeiroNo = null;
        this.ultimoNo = null;
    }

    public void adiciona(String elemento){
        No novoNo = new No(elemento);
        this.primeiroNo = novoNo;

        if(getTamanho() == 0){
            this.primeiroNo = novoNo;
        }else{
            this.ultimoNo.setProximo(novoNo);
        }

        this.ultimoNo = novoNo;
        this.tamanho++;
    }

    public void imprimir(){
        No noAuxiliar = this.primeiroNo;
        System.out.println(noAuxiliar.getElemento());

        while (noAuxiliar.getProximo() != null){
            noAuxiliar = noAuxiliar.getProximo();
        }
    }

    public No getPrimeiroNo() {
        return primeiroNo;
    }

    public No getUltimoNo() {
        return ultimoNo;
    }

    public void setUltimoNo(No ultimoNo) {
        this.ultimoNo = ultimoNo;
    }

    public void setPrimeiroNo(No primeiroNo) {
        this.primeiroNo = primeiroNo;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    // Inserir nó no final da Lista
    public void inserirNoFinal(String elemento) {
        No novoNo = new No(elemento);
        if (tamanho == 0) {
            primeiroNo = novoNo;
        } else {
            ultimoNo.setProximo(novoNo);
        }
        ultimoNo = novoNo;
        tamanho++;
    }

    // Quantidade de nós (Tamanho)
    public int getTamanho() {
        return tamanho;
    }

    // Percorrer a Lista (imprimir)
    public void percorrer() {
        No noAuxiliar = primeiroNo;
        while (noAuxiliar != null) {
            System.out.println(noAuxiliar.getElemento());
            noAuxiliar = noAuxiliar.getProximo();
        }
    }

    // Limpar a Lista
    public void limpar() {
        primeiroNo = null;
        ultimoNo = null;
        tamanho = 0;
    }

    // Pesquisar um nó ou posição específica da Lista
    public No pesquisar(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            return null; // Posição inválida
        }

        No noAtual = primeiroNo;
        for (int i = 0; i < posicao; i++) {
            noAtual = noAtual.getProximo();
        }
        return noAtual;
    }

    // Inserir em posição específica da Lista
    public void inserirNaPosicao(String elemento, int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }

        if (posicao == tamanho) {
            inserirNoFinal(elemento);
        } else {
            No novoNo = new No(elemento);

            if (posicao == 0) {
                novoNo.setProximo(primeiroNo);
                primeiroNo = novoNo;
            } else {
                No noAnterior = pesquisar(posicao - 1);
                novoNo.setProximo(noAnterior.getProximo());
                noAnterior.setProximo(novoNo);
            }
            tamanho++;
        }
    }

    // Remover nó no início da Lista
    public void removerInicio() {
        if (tamanho == 0) {
            return;
        }
        primeiroNo = primeiroNo.getProximo();
        tamanho--;
        if (tamanho == 0) {
            ultimoNo = null;
        }
    }

    // Remover nó no final da Lista
    public void removerFinal() {
        if (tamanho <= 1) {
            limpar();
        } else {
            No noAnterior = pesquisar(tamanho - 2);
            noAnterior.setProximo(null);
            ultimoNo = noAnterior;
            tamanho--;
        }
    }

    // Remover de qualquer posição da Lista
    public void removerNaPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            throw new IllegalArgumentException("Posição inválida");
        }

        if (posicao == 0) {
            removerInicio();
        } else if (posicao == tamanho - 1) {
            removerFinal();
        } else {
            No noAnterior = pesquisar(posicao - 1);
            noAnterior.setProximo(noAnterior.getProximo().getProximo());
            tamanho--;
        }
    }

    // Inserir de forma ordenada na Lista
    public void inserirOrdenado(String elemento) {
        No novoNo = new No(elemento);

        if (tamanho == 0 || elemento.compareTo(primeiroNo.getElemento()) < 0) {
            novoNo.setProximo(primeiroNo);
            primeiroNo = novoNo;
        } else {
            No noAtual = primeiroNo;
            while (noAtual.getProximo() != null && elemento.compareTo(noAtual.getProximo().getElemento()) >= 0) {
                noAtual = noAtual.getProximo();
            }
            novoNo.setProximo(noAtual.getProximo());
            noAtual.setProximo(novoNo);
        }
        if (novoNo.getProximo() == null) {
            ultimoNo = novoNo;
        }
        tamanho++;
    }
}

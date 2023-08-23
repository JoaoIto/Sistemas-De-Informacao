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

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}

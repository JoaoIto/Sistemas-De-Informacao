package classes;

public class ArvoreAVL {
    public No raiz;

    public ArvoreAVL() {
        this.raiz = null;
    }

    public void inserir(int elemento) {
        this.raiz = inserir(this.raiz, elemento);
    }

    private No inserir(No no, int elemento) {
        if (no == null) {
            return new No(elemento);
        }

        if (elemento < no.elemento) {
            no.esquerda = inserir(no.esquerda, elemento);
        } else if (elemento > no.elemento) {
            no.direita = inserir(no.direita, elemento);
        } else {
            // Elemento já existe
            return no;
        }

        atualizarAltura(no);

        return balancear(no);
    }

    public No balancear(No no) {
        if (no == null) {
            return null;
        }

        // Calcular o fator de balanceamento do nó
        int fatorBalanceamento = alturaNo(no.esquerda) - alturaNo(no.direita);

        // Caso do fator de balanceamento positivo (desbalanceamento à esquerda)
        if (fatorBalanceamento > 1) {
            // Caso LL: Rotação à direita
            if (alturaNo(no.esquerda.esquerda) >= alturaNo(no.esquerda.direita)) {
                return rotacaoDireita(no);
            } else { // Caso LR: Rotação à esquerda e depois à direita
                no.esquerda = rotacaoEsquerda(no.esquerda);
                return rotacaoDireita(no);
            }
        }
        // Caso do fator de balanceamento negativo (desbalanceamento à direita)
        else if (fatorBalanceamento < -1) {
            // Caso RR: Rotação à esquerda
            if (alturaNo(no.direita.direita) >= alturaNo(no.direita.esquerda)) {
                return rotacaoEsquerda(no);
            } else { // Caso RL: Rotação à direita e depois à esquerda
                no.direita = rotacaoDireita(no.direita);
                return rotacaoEsquerda(no);
            }
        }
        return no;
    }

    private No rotacaoEsquerda(No y) {
        No x = y.direita;
        No esquerdaDoAtual = x.esquerda;

        x.esquerda = y;
        y.direita = esquerdaDoAtual;

        atualizarAltura(y);
        atualizarAltura(x);

        return x;
    }

    private No rotacaoDireita(No x) {
        No y = x.esquerda;
        No direitaDoAtual = y.direita;

        y.direita = x;
        x.esquerda = direitaDoAtual;

        atualizarAltura(x);
        atualizarAltura(y);

        return y;
    }

    private void atualizarAltura(No no) {
        if (no != null) {
            no.altura = 1 + Math.max(alturaNo(no.esquerda), alturaNo(no.direita));
        }
    }

    private int alturaNo(No no) {
        return (no == null) ? 0 : no.altura;
    }

    public int alturaArvore(No noArvore){
        if(noArvore == null){
            return -1;
        }
        else{
            int ae = alturaArvore(noArvore.esquerda);
            int ad = alturaArvore(noArvore.direita);

            if(ae < ad){
                return ad + 1;
            }else{
                return ae + 1;
            }
        }
    }
    public int fatorBalanceamento(No noArvore) {
        if (noArvore == null) {
            return 0;
        }
        int fatorBalanceamento = alturaArvore(noArvore.esquerda) - alturaArvore(noArvore.direita);

        if (fatorBalanceamento == 1 || fatorBalanceamento == 0 || fatorBalanceamento == -1) {
            System.out.println("Árvore balanceada.");
            return fatorBalanceamento;
        } else {
            System.out.println("Árvore desbalanceada.");
            return fatorBalanceamento;
        }
    }
}

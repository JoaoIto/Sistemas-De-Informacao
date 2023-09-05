package src.classes;
public class FilaDinamica<T> {
        private No<T> frente;
        private No<T> tras;
        private int tamanho;

        public FilaDinamica() {
            frente = tras = null;
            tamanho = 0;
        }

        public int tamanho() {
            return tamanho;
        }

        public boolean estaVazia() {
            return tamanho == 0;
        }

        public void inserir(T elemento) {
            No<T> novoNo = new No<>(elemento);
            if (estaVazia()) {
                frente = tras = novoNo;
            } else {
                tras.setProximo(novoNo);
                tras = novoNo;
            }
            tamanho++;
        }

        public T retirar() {
            if (estaVazia()) {
                throw new IllegalStateException("A fila está vazia");
            }
            T elemento = frente.getDado();
            frente = frente.getProximo();
            tamanho--;
            return elemento;
        }

        public void listarItens() {
            No<T> atual = frente;
            while (atual != null) {
                System.out.print(atual.getDado() + " ");
                atual = atual.getProximo();
            }
            System.out.println();
        }

        private static class No<T> {
            private T dado;
            private No<T> proximo;

            public No(T dado) {
                this.dado = dado;
                this.proximo = null;
            }

            public T getDado() {
                return dado;
            }

            public No<T> getProximo() {
                return proximo;
            }

            public void setProximo(No<T> proximo) {
                this.proximo = proximo;
            }
        }
    }

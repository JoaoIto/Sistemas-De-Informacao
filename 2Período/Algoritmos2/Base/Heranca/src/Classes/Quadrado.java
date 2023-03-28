package Classes;

import Classes.Retangulo;

public class Quadrado extends Retangulo{

    public Quadrado(int lados) {
        super(lados, lados);
    }

    public void setTamanho(int tamanho){
        super.setAltura(tamanho);
        super.setLargura(tamanho);
    }

    public void imprimir(){
        System.out.println("A altura do quadrado é de: " + getAltura());
        System.out.println("A largura do quadrado é de: " + getLargura());
    }
}

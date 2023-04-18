package Questão4.src.classes;

import java.util.Scanner;

public class Cor {
    private String nome;
    private int idCor;

    public Cor(){

    }
    public Cor(String nome, int idCor){
        this.nome = nome;
        this.idCor = idCor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdCor() {
        return idCor;
    }

    public void setIdCor(int idCor) {
        this.idCor = idCor;
    }

    public static Cor lerDados(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o nome da cor a ser adicionada: ");
        String corNome = scan.next();
        System.out.println("Digite o id a ser adicionado nessa cor: ");
        int corId = scan.nextInt();

        Cor cor = new Cor(corNome, corId);
        return cor;
    }
}

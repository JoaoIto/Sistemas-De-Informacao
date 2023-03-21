package src.app;
import java.util.Scanner;
import src.classes.Carros;

public class main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem vindo ao sistema da concessionária de cadastro de carros");

        System.out.println("Deseja fazer o cadastro de carros agora?  Se SIM digite 1, se NAO 2");
        int escolha = sc.nextInt();

        switch (escolha) {
            case 1:
            System.out.println("Quantos carros deseja cadastrar? ");
            int qntd = sc.nextInt();

                Carros carros = new Carros();
                Carros[] arrayCarros = carros.Cadastrar(qntd);

            case 2:
                System.out.println("Encerrado!");
        }
    }
}

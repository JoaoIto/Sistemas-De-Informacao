package app;
import java.util.Scanner;
import classes.MaquinaRefrigerante;
import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        MaquinaRefrigerante maquina = new MaquinaRefrigerante();
        List<MaquinaRefrigerante> list = new ArrayList<>();

        list.add(new MaquinaRefrigerante("Coca", 1, 15.00));
        list.add(new MaquinaRefrigerante("Pepsi", 2, 12.00));
        list.add(new MaquinaRefrigerante("GuaranÃ¡-Jesus", 3, 6.00));
        list.add(new MaquinaRefrigerante("H2O_250ml", 4, 7.00));
        list.add(new MaquinaRefrigerante("Red-Bull_Lata", 5, 9.00));

        for (MaquinaRefrigerante var : list) {
            System.out.printf("%d %s R$%.2f\n", var.getCodProduto(), var.getNome(), var.getPrecoProduto());
        }
        System.out.println();
        System.out.println("Escolha um refrigerante e insira a quantia em dinheiro");
        maquina.selecionarRefrigerante(list, sc.nextInt(), sc.nextDouble());


    }
}

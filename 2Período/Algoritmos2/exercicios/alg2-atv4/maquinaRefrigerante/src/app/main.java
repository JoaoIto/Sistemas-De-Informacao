package app;
import java.util.Scanner;
import classes.MaquinaRefrigerante;

public class main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		MaquinaRefrigerante[] refrigerantes = new MaquinaRefrigerante[5];
		MaquinaRefrigerante refrigerante = new MaquinaRefrigerante();
		
		refrigerantes[0] = new MaquinaRefrigerante("Coca_600ml", 15.0);
		refrigerantes[1] = new MaquinaRefrigerante("Pepsi_ks", 12.0);
		refrigerantes[2] = new MaquinaRefrigerante("Guaraná-Jesus_Lata", 6.0);
		refrigerantes[3] = new MaquinaRefrigerante("H2O_250ml", 7.0);
		refrigerantes[4] = new MaquinaRefrigerante("Red-Bull_Lata", 9.0);
	
		System.out.println("Digite aqui o refri de sua escolha: ");
		
		for(int i = 0; i < refrigerantes.length; i++) {
			System.out.println(i + "O refrigerante: " + refrigerantes[i].getNome());
		}
		
		int escolhaRefri = scan.nextInt();
		
		switch (escolhaRefri) {
		case 1: {
			return refrigerantes[0].getPreco();
			break;
		}
		case 2:{
			return refrigerantes[1].getPreco();
		}case 3:{
			return refrigerantes[2].getPreco();
		}case 4:{
			return refrigerantes[3].getPreco();
		}case 5:{
			return refrigerantes[4].getPreco();
		}
		default: {
			System.out.println("Codigo invalido!");
		}
		
		System.out.println("Qual a sua forma de pagamento:\nDigite 1 para dinheiro ou pix, e 2 para cartão ");
		int escolha = scan.nextInt();
		
		System.out.println("O refrigerante custa: " + refrigerantes[MaquinaRefrigerante].getPreco());
		System.out.println("Insira o dinheiro requerido: ");
		refrigerante.setDinheiro(scan.nextDouble());
		
		if(escolha == 1) {
			System.out.println("Forma de pagamento: Dinheiro/PIX");
			
			if(refrigerante.getDinheiro() >= refrigerantes[escolhaRefri].getPreco()) {
				System.out.println("Troco: ");
				System.out.println("Refrigerante liberado!");
			}else {
				System.out.println("Falta dinheiro para o refrigerante!");
			}
		}else {
			System.out.println("Forma de pagamento: Cartão");
			if(dinheiro >= 15.0) {
				System.out.println("Troco: ");
				System.out.println(dinheiro - 10);
				System.out.println("Refrigerante liberado!");
			}else {
				System.out.println("Falta dinheiro para o refrigerante!");
			}
		}
	}
}

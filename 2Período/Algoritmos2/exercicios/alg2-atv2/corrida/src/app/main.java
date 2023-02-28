package app;
import modelo.Carro;

public class main {

	public static void main(String[] args) {
		System.out.println("Bem Vindo a corrida!");

		Carro gol = new Carro("Gol 1.0", "Wolks", 2012, 200.0, 1200.0);
		Carro unoDeEscadaBoTeto = new Carro("Fiat", "Uno 1.2", 2006, 250.0, 1600.0);
		Carro ferrari = new Carro("Ferrari", "458 3.0 V8", 2016, 600.0, 900.0);
		
		gol.imprimir();
		System.out.println("");
		unoDeEscadaBoTeto.imprimir();
		System.out.println("");
		ferrari.imprimir();
		System.out.println("");
		
		for(int i = 1; i < 20; i++) {
			System.out.println("TACA-LE PAU NESSE CARINHO!");
			System.out.println(i);
				gol.acelerar();
				unoDeEscadaBoTeto.acelerar();
				ferrari.acelerar();
			if(i == 6 || i == 11 || i == 15) {
				System.out.println("VAI BATEEERRR");
				gol.frear();
				unoDeEscadaBoTeto.frear();
				ferrari.frear();
			}
		}
		
		gol.imprimir();
		System.out.println("");
		unoDeEscadaBoTeto.imprimir();
		System.out.println("");
		ferrari.imprimir();
		System.out.println("");
	}

}

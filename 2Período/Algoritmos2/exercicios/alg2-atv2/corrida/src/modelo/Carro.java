package modelo;

public class Carro {
	public String marca;
	public String modelo;
	public int ano;
	public double velocidade;
	public double cilindrada;
	public double peso;
	
	public Carro(String modelo1, String marca1, int ano, Double cilindrada1, Double peso1) {
		this.modelo = modelo1;
		this.marca = marca1;
		this.cilindrada = cilindrada1;
		this.peso = peso1;
		this.velocidade = 0.0;
	}
	
	public void acelerar() {
		this.velocidade = 0.0;
		this.velocidade += 5;
		this.velocidade += this.velocidade * (this.cilindrada * 
				0.15) - this.calculeRedutorPeso(); //Deve ser calculado até 15% da cilindrada, com 1 para cada 300kg de peso
	}
	
	private int calculeRedutorPeso() {
		double pesoAuxiliar = peso; // Não podemos alterar direto atributo peso, sendo assim, usamos variavel auxiliar
		int count = 0;
		
		while(pesoAuxiliar >= 300) {
			count++;
			pesoAuxiliar -= 300; // Usando logica de velocidade, 1 para cada 300kg de peso
		}
		
		return count;
	}
	
	public void frear() {
		velocidade =  velocidade * 0.75;
	}
	
	public void imprimir() {
		System.out.println(marca + " - " + modelo);
		System.out.println("Velocidade: " + velocidade);
	}
}
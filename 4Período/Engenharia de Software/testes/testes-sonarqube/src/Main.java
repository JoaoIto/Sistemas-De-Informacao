package src;

public class Main {
    public static void main(String[] args) {
        int vagas = 3; // Quantidade de vagas no estacionamento
        int quantidadeCarros = 5; // Quantidade de carros tentando estacionar

        Estacionamento estacionamento = new Estacionamento(vagas);

        for (int i = 0; i < quantidadeCarros; i++) {
            Carro carro = new Carro("Carro " + (i + 1), estacionamento);
            carro.start();
        }
    }
}
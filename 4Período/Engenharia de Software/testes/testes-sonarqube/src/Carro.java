package src;

class Carro extends Thread {
    private String nome;
    private Estacionamento estacionamento;

    public Carro(String nome, Estacionamento estacionamento) {
        this.nome = nome;
        this.estacionamento = estacionamento;
    }

    @Override
    public void run() {
        try {
            estacionamento.entrar(nome);
            Thread.sleep(2000); // Simula o tempo que o carro fica no estacionamento
            estacionamento.sair(nome);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
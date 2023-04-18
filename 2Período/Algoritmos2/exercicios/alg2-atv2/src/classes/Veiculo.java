package src.classes;

public class Veiculo {
    private String tipo;
    private String marca;
    private String modelo;
    private int ano;
    private int cilindrada;
    private double peso;
    private double velocidade;

    public Veiculo(String marca, String modelo, int ano, int cilindrada, double peso) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cilindrada = cilindrada;
        this.peso = peso;
    }

    public Veiculo() {

    }

    public void acelerar(){
        this.velocidade = 0.0;
        this.velocidade += 5;
        this.velocidade += this.velocidade * (this.cilindrada *
                0.15) - this.calculeRedutorPeso(); //Deve ser calculado até 15% da cilindrada, com 1 para cada 300 kg de peso
    }
    private int calculeRedutorPeso() {
        double pesoAuxiliar = peso; // Não podemos alterar direto atributo peso, sendo assim, usamos variavel auxiliar
        int count = 0;

        while(pesoAuxiliar >= 300) {
            count++;
            pesoAuxiliar -= 300; // Usando logica de velocidade, 1 para cada 300 kg de peso
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
}

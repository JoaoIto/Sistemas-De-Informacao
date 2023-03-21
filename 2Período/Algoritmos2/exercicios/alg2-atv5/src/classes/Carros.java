package src.classes;

import java.util.Scanner;

public class Carros {
    private String modelo;
    private int anoFabricante;
    private String marca;
    private double preco;

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
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

    public int getAnoFabricante() {
        return anoFabricante;
    }

    public void setAnoFabricante(int anoFabricante) {
        this.anoFabricante = anoFabricante;
    }

    public Carros[] Cadastrar(int qntd) {
        Scanner sc = new Scanner(System.in);

        Carros[] carros = new Carros[qntd]; // criação do array de carros

        // loop para cadastro dos carros
        for (int i = 0; i < carros.length; i++) {
            System.out.println("Cadastro de carro #" + (i+1));
            System.out.print("Modelo: ");
            String modelo = sc.nextLine();
            System.out.print("Marca: ");
            String marca = sc.nextLine();
            System.out.print("Ano: ");
            int anoFabricante = sc.nextInt();
            System.out.print("Preço: ");
            double preco = sc.nextDouble();

            // limpa o buffer do scanner
            sc.nextLine();

            // cria o carro com as informações fornecidas
            Carros carro = new Carros();
            carro.setModelo(modelo);
            carro.setMarca(marca);
            carro.setAnoFabricante(anoFabricante);
            carro.setPreco(preco);

            // adiciona o carro criado no array de carros
            carros[i] = carro;
        }

        // imprime os carros cadastrados
        Imprimir(carros);

        return carros;
    }
    public Carros[] Imprimir(Carros[] carros) {
        System.out.println("Lista de Carros:");
        for (Carros carro : carros) {
            System.out.println("Modelo: " + carro.getModelo());
            System.out.println("Marca: " + carro.getMarca());
            System.out.println("Ano Fabricante: " + carro.getAnoFabricante());
            System.out.println("Preço: " + carro.getPreco());
            System.out.println("-----------------------------");
        }
        return carros;
    }

}

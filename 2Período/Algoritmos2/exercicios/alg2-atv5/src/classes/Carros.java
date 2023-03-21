package src.classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Carros {
    private String modelo;
    private LocalDate anoFabricante;
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

    public LocalDate getAnoFabricante() {
        return anoFabricante;
    }

    public void setAnoFabricante(LocalDate anoFabricante) {
        this.anoFabricante = anoFabricante;
    }

    public Carros[] Cadastrar(int qntd) {
        Scanner sc = new Scanner(System.in);

        Carros[] carros = new Carros[qntd]; // criação do array de carros

        // loop para cadastro dos carros
        for (int i = 0; i < carros.length; i++) {
            System.out.println("Cadastro de carro #" + (i + 1));
            System.out.print("Modelo: ");
            String modelo = sc.nextLine();
            System.out.print("Marca: ");
            String marca = sc.nextLine();
            System.out.print("Digite uma data de lançamento no formato dd/MM/yyyy: ");
            String dataString = sc.nextLine();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate data = LocalDate.parse(dataString, formatter);
            System.out.print("Preço: ");
            double preco = sc.nextDouble();

            // limpa o buffer do scanner
            sc.nextLine();

            // cria o carro com as informações fornecidas
            Carros carro = new Carros();
            carro.setModelo(modelo);
            carro.setMarca(marca);
            carro.setAnoFabricante(LocalDate.ofEpochDay(data.getYear())); // define o anoFabricante como o ano da data
            carro.setPreco(preco);

            // adiciona o carro criado no array de carros
            carros[i] = carro;
        }

        // imprime os carros cadastrados
        Imprimir(carros);

        return carros;
    }

    public void Imprimir(Carros[] carros) {
        System.out.println("Lista de Carros:");
        for (Carros carro : carros) {
            System.out.println("Modelo: " + carro.getModelo());
            System.out.println("Marca: " + carro.getMarca());
            System.out.println("Data de Lançamento: " + carro.getAnoFabricante().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            System.out.println("Preço: " + carro.getPreco());
            System.out.println("-----------------------------");
        }
    }

}

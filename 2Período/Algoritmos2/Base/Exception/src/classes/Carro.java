package src.classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Carro {
    private String modelo;
    private Cor cor;
    private LocalDate anoLancamento;

    public Carro(){

    }
    public Carro(String modelo, Cor cor, LocalDate anoLancamento) {
        this.modelo = modelo;
        this.cor = cor;
        this.anoLancamento = anoLancamento;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public LocalDate getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(LocalDate anoLancamento) {
        this.anoLancamento = anoLancamento;
    }


    public String toString() {
        return "Carros{" +
                "modelo=" + modelo +
                ", cor='" + cor + '\'' +
                ", ano de lançamento ='" + anoLancamento + '\'' +
                '}';
    }
    public static Carro[] lerDados(int qntd) {
        Scanner scan = new Scanner(System.in);
        Carro[] carros = new Carro[qntd];

        for (int i = 0; i < carros.length; i++) {
            try {
                System.out.println("Digite o modelo do carro: ");
                String modelo = scan.nextLine();

                if (modelo.isEmpty()) {
                    throw new IllegalArgumentException("Modelo inválido");
                }

                System.out.println("Digite a cor do carro: ");
                Cor cor = Cor.lerDados();

                LocalDate data = null;
                boolean dataValida = false;
                while (!dataValida) {
                    try {
                        System.out.print("Digite uma data de lançamento no formato dd/MM/yyyy: ");
                        String dataString = scan.nextLine();

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        data = LocalDate.parse(dataString, formatter);
                        dataValida = true;
                    } catch (Exception e) {
                        System.out.println("Data de lançamento inválida. Digite novamente.");
                    }
                }

                Carro carro = new Carro();
                carro.setModelo(modelo);
                carro.setCor(cor);
                carro.setAnoLancamento(data);
                carros[i] = carro;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro ao ler dados do carro: " + e.getMessage());
                i--; // Permite ao usuário corrigir o dado inválido
            } catch (Exception e) {
                System.out.println("Erro ao ler dados do carro: Dado inválido");
                i--; // Permite ao usuário corrigir o dado inválido
            }
        }

        imprimir(carros);
        return carros;
    }


    public static void imprimir(Carro[] carros){
        for (Carro carro : carros) {
            if(carro.getCor().getNome() == "azul") {
                System.out.println("Modelo: " + carro.getModelo());
                System.out.println("Data de Lançamento: " + carro.getAnoLancamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                System.out.println("Preço: " + carro.getCor());
                System.out.println("-----------------------------");
            }else{
                break;
            }
        }
    }
}
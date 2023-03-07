package classes;
import java.util.List;

public class MaquinaRefrigerante {


    private String nomeProduto;
    private int codProduto;
    private double precoProduto;
    private double dinheiro;

    public MaquinaRefrigerante() {
    }

    public MaquinaRefrigerante(String nome, int codProduto, double precoProduto) {
        this.nomeProduto = nome;
        this.codProduto = codProduto;
        this.precoProduto = precoProduto;
    }

    public String getNome() {
        return nomeProduto;
    }

    public void setNome(String nome) {
        this.nomeProduto = nome;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }


    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public double getDinheiro() {
        return dinheiro;
    }

    public void inserirDinheiro(double dinheiro) {
        this.dinheiro += dinheiro;
    }
    public void selecionarRefrigerante(List<MaquinaRefrigerante> lista, int codProduto, double dinheiro) {
        for (MaquinaRefrigerante refrigerante : lista) {
            if (refrigerante.getCodProduto() == codProduto) {
                System.out.println("Você escolheu: " + refrigerante.getNome());
                System.out.println("Preço: R$" + refrigerante.getPrecoProduto());
                refrigerante.inserirDinheiro(dinheiro);
                if (refrigerante.getDinheiro() >= refrigerante.getPrecoProduto()) {
                    System.out.printf("Troco %.2fR$\n", (refrigerante.getDinheiro() - refrigerante.getPrecoProduto()));
                    System.out.println("Venda realizada");
                } else {
                    System.out.println("Dinheiro insuficiente");
                }
            }
        }
    }


}
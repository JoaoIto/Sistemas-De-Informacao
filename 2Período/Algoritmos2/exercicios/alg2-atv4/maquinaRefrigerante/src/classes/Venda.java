package classes;
import classes.MaquinaRefrigerante;

public class Venda {
    private Double valorVenda;
    private Double valorInserido;
    private Double valorTroco;
    private String produto;
    private MaquinaRefrigerante maquina;
    
    public Venda() {
    }

    public Venda(Double valorVenda, Double valorInserido, Double valorTroco, String produto) {
        this.valorVenda = valorVenda;
        this.valorInserido = valorInserido;
        this.valorTroco = valorTroco;
        this.produto = produto;
    }

    public Double getValorVenda() {
        return maquina.getPreco();
    }

    public void setValorVenda(Double valorVenda) {
        maquina.setPreco(valorVenda);;
    }

    public Double getValorInserido() {
        return valorInserido;
    }

    public void setValorInserido(Double valorInserido) {
        this.valorInserido = valorInserido;
    }

    public Double getValorTroco() {
        return valorTroco;
    }

    public void setValorTroco(Double valorTroco) {
        this.valorTroco = valorTroco;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }
}

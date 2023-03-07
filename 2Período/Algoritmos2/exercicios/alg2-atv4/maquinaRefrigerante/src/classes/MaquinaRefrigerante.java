package classes;

public class MaquinaRefrigerante {
	private String nomeProduto;
	private Double precoProduto;
	private Double dinheiro;
	
	public MaquinaRefrigerante() {	
	}
	
	public MaquinaRefrigerante(String nome, Double preco) {
		super();
		this.nomeProduto = nome;
		this.precoProduto = preco;
	}
	
	public String getNome() {
		return nomeProduto;
	}
	
	public void setNome(String nome) {
		this.nomeProduto = nome;
	}
	
	public Double getPreco() {
		return precoProduto;
	}
	
	public void setPreco(Double preco) {
		this.precoProduto = preco;
	}
	
	public void setDinheiro(Double dinheiro) {
		this.dinheiro = dinheiro;
	}
	
	public Double getDinheiro() {
		return dinheiro;
	}
	
	public void inserirDinheiro(Double dinheiro) {
		this.dinheiro += dinheiro;
	}
	
	
}
package src.classes;

public class PessoaJuridica extends Pessoa{
    private String cnpj;

    @Override
    public void imprimir() {
        System.out.println("Nome é: " + getNome());
        System.out.println("CNPJ: " + getCnpj());
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}

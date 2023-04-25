package src.classes;

public class PessoaFisica extends Pessoa{
    private String cpf;

    @Override
    public void imprimir() {
        System.out.println("Nome é: " + getNome());
        System.out.println("CPF: " + getCpf());
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}

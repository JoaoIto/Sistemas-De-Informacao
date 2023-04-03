package classes;

public class PessoaFisica extends Pessoa{
    Pessoa pessoa;
    private String cpf;
    private String celular;

    public PessoaFisica(Pessoa pessoa, String celular, String cpf) {
        super(pessoa.getId(), pessoa.getNome(), pessoa.getEmail());
        this.celular = celular;
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override public void imprimir(){
        System.out.println("O cpf da Pessoa física é: " + this.cpf);
        System.out.println("O celular da pessoa é: " + this.celular);
        System.out.println("\n");
    }
}

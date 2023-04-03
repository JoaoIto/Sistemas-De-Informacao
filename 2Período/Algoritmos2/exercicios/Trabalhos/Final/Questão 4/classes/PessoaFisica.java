package classes;

public class PessoaFisica extends Pessoa{
    static Pessoa pessoa;
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

    public void imprimir(PessoaFisica pessoaFisica){
        super.imprimir(pessoa);
        System.out.println("O cpf da Pessoa física é: " + pessoaFisica.getCpf());
        System.out.println("O celular da pessoa é: " + pessoaFisica.getCelular());
        System.out.println("\n");
    }
}

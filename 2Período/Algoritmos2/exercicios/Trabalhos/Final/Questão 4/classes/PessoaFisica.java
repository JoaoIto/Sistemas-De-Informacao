package classes;

public class PessoaFisica extends Pessoa {
    private String cpf;
    private String celular;

    public PessoaFisica(Pessoa pessoa, String celular, String cpf) {
        super(pessoa.getId(), pessoa.getNome(), pessoa.getEmail());
        this.celular = celular;
        this.cpf = cpf;
    }

    public PessoaFisica() {
        super();
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
}
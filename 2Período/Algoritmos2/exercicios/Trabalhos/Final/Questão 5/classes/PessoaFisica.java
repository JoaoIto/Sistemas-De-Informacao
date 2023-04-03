package classes;

public class PessoaFisica extends Pessoa {
    private String cpf;
    private String celular;

    public PessoaFisica(Pessoa pessoa, String celular, String cpf) {
        super(pessoa.getId(), pessoa.getNome(), pessoa.getEmail());
        this.celular = celular;
        this.cpf = cpf;
    }

    public PessoaFisica() {}

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

    @Override
    public String toString() {
        return "PessoaFisica{" +
                "cpf='" + cpf + '\'' +
                ", celular='" + celular + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PessoaFisica)) return false;
        if (!super.equals(o)) return false;
        PessoaFisica that = (PessoaFisica) o;
        return getCpf().equals(that.getCpf()) &&
                getCelular().equals(that.getCelular());
    }
}

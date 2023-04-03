package classes;

import java.util.Objects;

public class PessoaJuridica extends Pessoa {
    private String cnpj;
    private String inscricaoEstadual;
    private String telefoneFixo;

    public PessoaJuridica(Pessoa pessoa, String cnpj, String inscricaoEstadual, String telefoneFixo) {
        super(pessoa.getId(), pessoa.getNome(), pessoa.getEmail());
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.telefoneFixo = telefoneFixo;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    @Override
    public String toString() {
        return "PessoaJuridica{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", cnpj='" + getCnpj() + '\'' +
                ", inscricaoEstadual='" + getInscricaoEstadual() + '\'' +
                ", telefoneFixo='" + getTelefoneFixo() + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaJuridica that = (PessoaJuridica) o;
        return Objects.equals(cnpj, that.cnpj) &&
                Objects.equals(inscricaoEstadual, that.inscricaoEstadual) &&
                Objects.equals(telefoneFixo, that.telefoneFixo);
    }
}

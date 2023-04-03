package classes;

public class PessoaJuridica extends Pessoa{
    Pessoa pessoa;
    private String cnpj;
    private String inscricaoEstadual;
    private String telefoneFixo;

    public PessoaJuridica(Pessoa pessoa, String cnpj, String inscricaoEstadual, String telefoneFixo) {
        super(pessoa.getId(), pessoa.getNome(), pessoa.getEmail());
        this.cnpj = cnpj;
        this.inscricaoEstadual =  inscricaoEstadual;
        this.telefoneFixo = telefoneFixo;
    }
    public PessoaJuridica() {
        super();
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
}
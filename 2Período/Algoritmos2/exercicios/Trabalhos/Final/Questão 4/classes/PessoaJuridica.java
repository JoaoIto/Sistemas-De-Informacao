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

    public void imprimir(PessoaJuridica pessoaJuridica){
        super.imprimir(pessoa);
        System.out.println("O cnpj de pessoa jurídica é: " + pessoaJuridica.getCnpj());
        System.out.println("A inscrição estadual dessa pessoa jurídica é: " + pessoaJuridica.getInscricaoEstadual());
        System.out.println("O telefone fixo dessa pessoa jurídica é: " + pessoaJuridica.getTelefoneFixo());
        System.out.println("\n");
    }
}

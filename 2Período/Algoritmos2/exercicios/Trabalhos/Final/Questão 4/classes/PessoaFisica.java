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

    @Override public void imprimir(){
        super.imprimir();

        System.out.println("O cpf da Pessoa física é: " + this.cpf);
        System.out.println("O celular da pessoa é: " + this.celular);
        System.out.println("\n");
    }
}

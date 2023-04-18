package classes;

public class Pessoa {
    private Integer id;
    private String nome;
    private String email;

    public Pessoa(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Pessoa() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static void imprimir(Pessoa pessoa) {
        System.out.println("O id da pessoa é: " + pessoa.getId());
        System.out.println("O nome da pessoa é: " + pessoa.getNome());
        System.out.println("O email da pessoa é: " + pessoa.getEmail());

        if (pessoa instanceof PessoaFisica) {
            PessoaFisica pessoaFisica = (PessoaFisica) pessoa;
            System.out.println("O cpf da Pessoa física é: " + ((PessoaFisica)pessoa).getCpf());
            System.out.println("O celular da pessoa é: " + ((PessoaFisica)pessoa).getCelular());
        } else if (pessoa instanceof PessoaJuridica) {
            PessoaJuridica pessoaJuridica = (PessoaJuridica) pessoa;
            System.out.println("O cnpj de pessoa jurídica é: " + ((PessoaJuridica)pessoa).getCnpj());
            System.out.println("A inscrição estadual dessa pessoa jurídica é: " + ((PessoaJuridica)pessoa).getInscricaoEstadual());
            System.out.println("O telefone fixo dessa pessoa jurídica é: " + ((PessoaJuridica)pessoa).getTelefoneFixo());
        }

        System.out.println("\n");
    }

}
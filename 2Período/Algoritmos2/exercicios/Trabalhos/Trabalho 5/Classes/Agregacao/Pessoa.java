package Classes.Agregacao;
import Classes.Agregacao.Endereco;

// Aqui temos um exemplo de classe para agregacao:

/* A referência para a classe é herdada, é feita
a partir de um próprio objeto é colocado como atributo
na classe; */



/* Esta classe possui um endereçamento de
1 - n Endereços, já que pode ter vários endereços
relacionadas, pois ele é criado como um atributo da própria pessoa
com essa referência de objeto */

/* Na sua instância, se entende que, o objeto Pessoa, pode ser criado
independentemente da classe de endereços, não necessariamente
associando-lhe, porém, entende-se que esse relacionamento parte que,
não é bom que endereço possa ser criado sem uma pessoa relacionada a ele
e assim, temos uma agregação;
 */

public class Pessoa {
    private String nome;
    private int idade;
    private String cpf;
    private Endereco endereco; // Referência a objeto a ser herdado

    // Construtor
    public Pessoa(String nome, int idade, String cpf, Endereco endereco) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.endereco = endereco;
    }

    // Métodos getters e setters
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
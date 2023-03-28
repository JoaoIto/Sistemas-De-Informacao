package Classes.Agregacao;

// Este é o objeto a ser herdado pela classe de Pessoa;

/* Ele mesmo já possui seus próprios atributos, e pode ser construído
sem precisar de uma pessoa, independentemente, e também pode ser usado
juntamente com pessoa, que é a forma a ser usada, com o relacionamento
de associação
*/

public class Endereco {
    private String rua;
    private int numero;
    private String cidade;
    private String estado;

    // Construtor
    public Endereco(String rua, int numero, String cidade, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
    }

    // Métodos getters e setters
    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }
}
package Classes;

public class Functionario {
        private String nome;
        private String cpf;
        private double salario;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getBonificacao(){
        return this.salario + 0.05;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getInformacoes(){
         String info = "Meu nome é: " + getNome() +
                 " Meu CPF é: " + getCpf() +
                 " Meu salário atual é: " + getSalario();

         return info;
    }
}

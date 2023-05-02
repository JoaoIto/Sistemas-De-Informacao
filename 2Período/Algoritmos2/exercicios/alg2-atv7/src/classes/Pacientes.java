package src.classes;

import src.enums.Identificacao;

import java.time.LocalDate;

public class Pacientes {
    private String nome;
    private LocalDate dataNascimento;
    private Identificacao identificacao;
    private String problema;

    public Pacientes(String nome, LocalDate dataNascimento, Identificacao identificacao, String problema){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.identificacao = identificacao;
        this.problema = problema;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Identificacao getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(Identificacao identificacao) {
        this.identificacao = identificacao;
    }

    public String getProblema() {
        return problema;
    }

    public void setProblema(String problema) {
        this.problema = problema;
    }
}

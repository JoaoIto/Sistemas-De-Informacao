package src.classes;

import java.util.Scanner;
import src.classes.Telefone;

public class Aluno {
    private String nome;
    private Telefone telefone;
    private double nota1;
    private double nota2;
    private double media;
    private String aprovacao;
    private String status;

    public Aluno() {

    }

    public Aluno(String nome, Telefone telefone, String status, double nota1, double nota2) {
        this.nome = nome;
        this.telefone = telefone;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.media = (nota1 + nota2) / 2;
        this.status = status;
    }

    public String getAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(double media) {
        if(this.media < 6){
            this.aprovacao = "Reprovado";
        }else{
            this.aprovacao = "Aprovado";
        }
    }

    public String getNome() {
        return nome;
    }

    public double getMedia() {
        return ((getNota1() + getNota2()) / 2);
    }

    public void setMedia(double nota1, double nota2) {
        this.media = (nota1 + nota2) / 2;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
}

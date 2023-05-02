package src.app;

import src.classes.Pacientes;
import src.enums.Identificacao;

import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Cadastro de pacientes: ");

        Pacientes[] pacientes = new Pacientes[4];

        pacientes[0] = new Pacientes("Joao", LocalDate.of(2005, 8, 23), Identificacao.IDENTIDADE, "lordose");
        pacientes[1] = new Pacientes("Unitins - Ulissis", LocalDate.of(2005, 1, 16), Identificacao.CNPJ, "tendinite");
        pacientes[2] = new Pacientes("Emily", LocalDate.of(2005, 1, 16), Identificacao.CPF, "Lesão nas costas");
        pacientes[3] = new Pacientes("Sofia", LocalDate.of(2005, 04, 20), Identificacao.CARTEIRA_NASCIMENTO, "Pulmão comprometido");

        for (int i = 0; i < pacientes.length; i++) {
            System.out.println("Este é o paciente " + i + ": \n");
            System.out.println("Nome do paciente: " + pacientes[i].getNome());
            System.out.println("Data de Nascimento: " + pacientes[i].getDataNascimento());
            System.out.println("Identificação solicitada: " + pacientes[i].getIdentificacao());
            System.out.println("Problema do paciente: " + pacientes[i].getProblema() + "\n \n");
        }
    }
}

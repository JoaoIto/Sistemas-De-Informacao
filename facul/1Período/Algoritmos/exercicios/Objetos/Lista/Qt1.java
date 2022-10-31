/* 01 - Escreva um programa que contenha um registro com os campos 
nome, peso e altura. O programa deve permitir ao usuário
 preencher os valores para os campos de um registro, 
 calcular e apresentar o valor do IMC da pessoa representada. */

import java.util.Scanner;
import java.util.Random;

class Pessoa{
    String nome;
    float peso, altura;
}
public class Qt1
{
    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);

        float imc;

        Pessoa p1;
        p1 = new Pessoa();

        System.out.println("Informe o nome: ");
        p1.nome = leitor.next();

        System.out.println("Informe o peso: ");
        p1.peso = leitor.nextFloat();

        System.out.println("Informe a altura: ");
        p1.altura = leitor.nextFloat();

        imc = p1.peso / (p1.altura * p1.altura);

        System.out.println(p1.nome + " tem o IMC de: " + imc);

    }
}

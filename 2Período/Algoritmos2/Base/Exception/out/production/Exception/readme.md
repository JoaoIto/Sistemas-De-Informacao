# Exeptions

Excpetions são trechos de código na qual entendemos que queremos minimizar os problemas as serem tratados
que podem ser gerados **por algum recebimento ou quebra de código errado.**

````java
package src.app;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Integer age;

        System.out.println("Informe a sua idade: ");
        age = scan.nextInt();

        System.out.println("A idade é de: " + age);
    }
}

````
A linha de código basicamnete captura o valor da variável de idade, e assim a imprime no console. Mas digamos que temos
o erro de que o usuário digitou um valor em string... Dará erro! Para isso usamos a Exception!

````java

````


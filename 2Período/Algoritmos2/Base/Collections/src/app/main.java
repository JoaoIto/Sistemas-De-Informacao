package src.app;

import src.classes.Pessoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Pessoa joao = new Pessoa("Joao", "24243278873", 17);
        Pessoa mly = new Pessoa("Emily", "382394592", 18);
        Pessoa janio = new Pessoa("Janio", "54935562935", 32);

        List<Pessoa> listPessoa = new ArrayList<>();
        listPessoa.add(joao);
        listPessoa.add(mly);
        listPessoa.add(janio);

        List<String> list = new ArrayList<>();
        list.add("e");
        list.add("a");
        list.add("d");
        list.add("b");
        list.add("c");
        list.add("f");

        for(String value: list){
            System.out.println(value);
        }

        listPessoa.sort((p1, p2) -> p1.getCpf().compareTo(p2.getCpf()));
        listPessoa.forEach(pessoa -> System.out.println(pessoa));
        listPessoa.stream()
                .filter(pessoa -> pessoa.getAge() <= 18)
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(pessoa -> System.out.println(pessoa));
        ;
    
        System.out.println("Teste");
    }
}

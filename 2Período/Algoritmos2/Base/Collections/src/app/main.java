package src.app;

import src.classes.Pessoa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Pessoa joao = new Pessoa("Joao", "24243278873", 17);
        Pessoa mly = new Pessoa("Emily", "382394592", 18);
        Pessoa janio = new Pessoa("Janio", "54935562935", 32);

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

        Collections.sort(list);

        for(String value: list){
            System.out.println(value);
        }
    }
}

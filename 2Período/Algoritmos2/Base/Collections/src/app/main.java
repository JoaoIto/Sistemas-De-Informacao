package src.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
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

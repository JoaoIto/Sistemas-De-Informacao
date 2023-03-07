package App;

import Classes.Pessoa;
import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        LocalDate dataBrasil = LocalDate.of(2023, 1, 31);

        Pessoa pessoa = new Pessoa();

        System.out.println(dataBrasil);
        pessoa.lerDados();
        pessoa.imprimir(pessoa);
    }
}
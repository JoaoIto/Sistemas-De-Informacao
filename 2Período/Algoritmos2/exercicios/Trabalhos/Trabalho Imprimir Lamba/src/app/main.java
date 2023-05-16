package src.app;

import src.classes.Pessoa;
import java.util.*;

public class main {
    public static void main(String[] args) {
        List<Pessoa> listaPessoas = new ArrayList<>();

        for (int i = 0; i < 1; i++) {
            Pessoa pessoa = Pessoa.lerDados();
            listaPessoas.add(pessoa);
        }

        Pessoa.imprimirListaOrdenadaPorNome(listaPessoas);
        Pessoa.imprimirListaOrdenadaPorIdade(listaPessoas);
        Pessoa.imprimirListaOrdenadaPorSexo(listaPessoas);
    }

}
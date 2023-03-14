package src.app;

import src.Classes.Autor;
import src.Classes.Livro;

import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        Autor autor = new Autor();

        autor.setNome("Joao");
        autor.setId(1);
        autor.setDataNascimento(LocalDate.of(2005, 8, 23));
        autor.setPais("Brasil");
        autor.setSexo("m");

        Livro livro = new Livro();
        livro.setAutor(autor);
        livro.setAnoLancamento(2013);
        livro.setTitulo("Harry Potter");
        livro.setIsbn("1372wbfd238");
        livro.setId(1);
        Livro[] livros = new Livro[2];

        for(int i = 0; i < livros.length; i++){
            Livro autores[] = new Livro[i];
            autores[i].setAutores(autores);
        }

        System.out.println("Autor: " + autor.getNome());
        System.out.println("Livro: " + livro.getTitulo() + ", isbn: " + livro.getIsbn());
        System.out.println("Autores: " + livro.getAutores());
    }
}

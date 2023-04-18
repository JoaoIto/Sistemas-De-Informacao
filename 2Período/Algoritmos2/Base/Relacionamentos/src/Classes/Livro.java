package src.Classes;

public class Livro {
    private Integer id;
    private String titulo;
    private Integer anoLancamento;
    private String isbn;
    private Livro[] autores;

    /* // Constructor livro: public Livro(Integer id, String titulo, Integer anoLancamento, String isbn, Autor autores){
        this.id = id;
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.isbn = isbn;
        this.autores = new Autor[]{autores};
    }*/

    public Livro[] getAutores() {
        return autores;
    }

    public void setAutores(Livro[] autores) {
        this.autores = autores;
    }

    public src.Classes.Autor getAutor() {
        return autor;
    }

    public void setAutor(src.Classes.Autor autor) {
        this.autor = autor;
    }


    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Autor autor;
}

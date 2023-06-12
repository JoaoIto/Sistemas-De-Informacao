package src.app;
import src.Exceptions.LoginException;
import src.classes.*;
import src.enums.Prioridade;
import src.enums.TipoUsuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws LoginException {
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Joao", "joao@email.com", "2308", TipoUsuario.ALUNO));
        usuarios.add(new Usuario("Janio", "janio@email.com", "1234", TipoUsuario.PROFESSOR));
        usuarios.add(new Usuario("Admin", "admin@email.com", "0000", TipoUsuario.ADMIN));

        // Criando duas etiquetas
        List<Etiqueta> etiquetas = new ArrayList<>();
        Etiqueta code = new Etiqueta("Code", "Etiqueta para código");
        Etiqueta book = new Etiqueta("Book", "Etiqueta para livros");
        Etiqueta personal = new Etiqueta("Personal", "Etiqueta para tarefas pessoais");

        etiquetas.add(code);
        etiquetas.add(book);
        etiquetas.add(personal);

        // Criando duas tarefas utilizando as etiquetas e prioridades definidas
        List<Tarefa> tarefas = new ArrayList<>();
        Tarefa tarefa1 = new Tarefa("Tarefa 1", "Descrição da Tarefa 1", code, "Professor 1", LocalDate.now(), Prioridade.COMUM);
        Tarefa tarefa2 = new Tarefa("Tarefa 2", "Descrição da Tarefa 2", book, "Professor 2", LocalDate.now(), Prioridade.IMPORTANTE);

        tarefas.add(tarefa1);
        tarefas.add(tarefa2);

        Usuario.autenticar(usuarios, etiquetas, tarefas);
    }
}
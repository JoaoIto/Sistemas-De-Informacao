package src.app;
import src.classes.*;
import src.enums.TipoUsuario;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static src.classes.Usuario.exibirMenu;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Usuario> usuarios = new ArrayList<>();

        // Criação dos usuários
        Usuario userAluno = new Usuario("Joao", "joao@email.com", "2308", TipoUsuario.ALUNO);
        usuarios.add(userAluno);

        Usuario userProf = new Usuario("Janio", "janio@email.com", "1234", TipoUsuario.PROFESSOR);
        usuarios.add(userProf);

        Usuario userAdmin = new Usuario("Admin", "admin@email.com", "0000", TipoUsuario.ADMIN);
        usuarios.add(userAdmin);

        // Login
        System.out.println("Bem-vindo! Por favor, faça o login.");
        System.out.print("Usuário: ");
        String nomeUsuario = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        // Verifica as credenciais
        Usuario usuarioAutenticado = Usuario.autenticar(nomeUsuario, senha, usuarios);
        if (usuarioAutenticado != null) {
            // Exibe o menu para o tipo de usuário autenticado
            exibirMenu(usuarioAutenticado.getTipoUsuario());
        } else {
            System.out.println("Usuário ou senha incorretos. O programa será encerrado.");
        }
    }
}

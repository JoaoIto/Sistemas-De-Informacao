package src.classes;

import src.classes.Tarefa;
import src.classes.Etiqueta;
import src.enums.Prioridade;
import src.enums.TipoUsuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    private String nome;
    private String email;
    private List<Telefone> telefoneLista;
    private List<Usuario> usuarios = new ArrayList<Usuario>();
    private String senha;
    private TipoUsuario tipoUsuario;

    public Usuario() {

    }

    public Usuario(String nome, String email, String senha, TipoUsuario tipoUsuario) {
        super();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Telefone> getTelefoneLista() {
        return telefoneLista;
    }

    public void setTelefoneLista(List<Telefone> telefoneLista) {
        this.telefoneLista = telefoneLista;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", email=" + email + ", senha=" + senha
                + ", telefoneLista=" + telefoneLista + ", tipoUsuario=" + tipoUsuario + "]";
    }

    public static void autenticar(List<Usuario> usuarios) {
        Scanner scanner = new Scanner(System.in);

        boolean autenticado = false;

        while (!autenticado) {
            System.out.println("Faça o login.");
            System.out.print("Usuário: ");
            String usuario = scanner.nextLine();

            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            for (Usuario usuarioAtual : usuarios) {
                if (usuarioAtual.getNome().equals(usuario) && usuarioAtual.getSenha().equals(senha)) {
                    System.out.println("Login efetuado com sucesso!");

                    if (usuarioAtual.getTipoUsuario() == TipoUsuario.ALUNO) {
                        exibirMenuAluno();
                    } else if (usuarioAtual.getTipoUsuario() == TipoUsuario.PROFESSOR) {
                        exibirMenuProfessor();
                    } else if (usuarioAtual.getTipoUsuario() == TipoUsuario.ADMIN) {
                        exibirMenuAdmin();
                    }

                    autenticado = true;
                    break;
                }
            }

            if (!autenticado) {
                System.out.println("Usuário ou senha inválidos. Tente novamente.");
            }
        }
    }


    public static void exibirMenuAluno() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 0) {
            System.out.println("Menu do Aluno");
            System.out.println("1. Listar tarefas");
            System.out.println("2. Criar tarefa");
            System.out.println("3. Deletar tarefa");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        // Chame o método correspondente para listar as tarefas
                        break;
                    case 2:
                        // Chame o método correspondente para criar uma nova tarefa
                        break;
                    case 3:
                        // Chame o método correspondente para deletar uma tarefa
                        break;
                    case 0:
                        System.out.println("Saindo do Menu do Aluno...");
                        break;
                    default:
                        System.out.println("Opção inválida. Digite uma opção válida.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número correspondente à opção desejada.");
            }
        }
    }


    private static void exibirMenuProfessor() {
        System.out.println("Menu do Professor");
        // Implemente as opções do menu do Professor aqui
    }

    private static void exibirMenuAdmin() {
        System.out.println("Menu do Admin");
        // Implemente as opções do menu do Admin aqui
    }
}


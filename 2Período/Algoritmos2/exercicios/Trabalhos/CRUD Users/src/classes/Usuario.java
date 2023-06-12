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

    public static void autenticar(List<Usuario> usuarios, List<Etiqueta> etiquetas, List<Tarefa> tarefas) {
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
                    System.out.println("Login efetuado com sucesso! \n");

                    if (usuarioAtual.getTipoUsuario() == TipoUsuario.ALUNO) {
                        exibirMenuAluno(usuarios, etiquetas, tarefas); // Passa a lista de etiquetas como argumento
                    } else if (usuarioAtual.getTipoUsuario() == TipoUsuario.PROFESSOR) {
                        exibirMenuProfessor(usuarios, etiquetas, tarefas);
                    } else if (usuarioAtual.getTipoUsuario() == TipoUsuario.ADMIN) {
                        exibirMenuAdmin(usuarios, etiquetas, tarefas);
                    }

                    autenticado = true;
                    if (usuarioAtual.getTipoUsuario() == TipoUsuario.ALUNO)
                        exibirMenuAluno(usuarios, etiquetas, tarefas); // Passa a lista de etiquetas como argumento
                    else if (usuarioAtual.getTipoUsuario() == TipoUsuario.PROFESSOR)
                        exibirMenuProfessor(usuarios, etiquetas, tarefas);
                    else if (usuarioAtual.getTipoUsuario() == TipoUsuario.ADMIN) {
                        exibirMenuAdmin(usuarios, etiquetas, tarefas);
                    }
                }
            }

            if (!autenticado) {
                System.out.println("Usuário ou senha inválidos. Tente novamente.");
            }
        }
    }

    public static void exibirMenuAluno(List<Usuario> usuarios, List<Etiqueta> etiquetas, List<Tarefa> tarefas) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu do Aluno\n");
            System.out.println("1. Listar tarefas");
            System.out.println("2. Criar tarefa");
            System.out.println("3. Deletar tarefa");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    Tarefa.tipoImprimir(tarefas);
                    break;
                case 2:
                    Tarefa.incluir(etiquetas, tarefas);
                    break;
                case 3:
                    Tarefa.excluir();
                    break;
                case 0:
                    System.out.println("Saindo do Menu do Aluno... \n");
                    autenticar(usuarios, etiquetas, tarefas);
                default:
                    System.out.println("Opção inválida. Digite uma opção válida.");
                    break;
            }
        } while (opcao != 0);
    }




    private static void exibirMenuProfessor(List<Usuario> usuarios, List<Etiqueta> etiquetas, List<Tarefa> tarefas) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("Menu do Professor\n");
            System.out.println("1. Listar tarefas");
            System.out.println("2. Criar tarefa");
            System.out.println("3. Deletar tarefa");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    Tarefa.tipoImprimir(tarefas);
                    break;
                case 2:
                    Tarefa.incluir(etiquetas, tarefas);
                    break;
                case 3:
                    Tarefa.excluir();
                    break;
                case 0:
                    System.out.println("Saindo do Menu do Professor...\n");
                    autenticar(usuarios, etiquetas, tarefas);
                default:
                    System.out.println("Opção inválida. Digite uma opção válida.");
                    break;
            }
        } while (opcao != 0);
    }

    private static void exibirMenuAdmin(List<Usuario> usuarios, List<Etiqueta> etiquetas, List<Tarefa> tarefas) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("Menu do Admin\n");
            System.out.println("1. Listar tarefas");
            System.out.println("2. Criar tarefa");
            System.out.println("3. Deletar tarefa");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    Tarefa.tipoImprimir(tarefas);
                    break;
                case 2:
                    Tarefa.incluir(etiquetas, tarefas);
                    break;
                case 3:
                    Tarefa.excluir();
                    break;
                case 0:
                    System.out.println("Saindo do Menu do Admin...\n");
                    autenticar(usuarios, etiquetas, tarefas);
                default:
                    System.out.println("Opção inválida. Digite uma opção válida.");
                    break;
            }
        } while (opcao != 0);
    }
}


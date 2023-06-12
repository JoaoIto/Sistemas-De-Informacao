package src.classes;

import src.Exceptions.LoginException;
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

    public static void autenticar(List<Usuario> usuarios, List<Etiqueta> etiquetas, List<Tarefa> tarefas) throws LoginException {
        Scanner scanner = new Scanner(System.in);
        boolean autenticado = false;

        while (!autenticado) {
            System.out.println("Bem vindo ao app de tarefas Trello!");
            System.out.println("Faça o login: ");
            System.out.println("Caso queira encerrar o login, digite 0!\n");
            System.out.print("Usuário: ");
            String usuario = scanner.nextLine();

            if (usuario.equals("0")) {
                System.out.println("Encerrando a autenticação...");
                throw new LoginException("Autenticação cancelada pelo usuário");
            }

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
                }
            }

            if (!autenticado) {
                System.out.println("Usuário ou senha inválidos. Tente novamente.");
            }
        }
    }

    public static void imprimirUsuarios(List<Usuario> usuarios) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nUsuários existentes:\n");
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            System.out.println((i + 1) + ". " + usuario.getNome());
        }

        System.out.println("0. Sair");

        System.out.print("\nQual usuário deseja alterar as informações? ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer de leitura

        if (opcao == 0) {
            System.out.println("Saindo do menu de usuários...");
        } else if (opcao >= 1 && opcao <= usuarios.size()) {
            Usuario usuarioSelecionado = usuarios.get(opcao - 1);

            if (confirmacaoSenha(usuarioSelecionado)) {
                alterarInformacoesUsuario(usuarioSelecionado);
            } else {
                System.out.println("Senha incorreta. Não é possível alterar as informações do usuário.");
            }
        } else {
            System.out.println("Opção inválida. Digite um número correspondente a um usuário válido.");
        }
    }


    public static boolean confirmacaoSenha(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a senha do usuário: ");
        String senha = scanner.nextLine();

        if (usuario.getSenha().equals(senha)) {
            return true;
        } else {
            return false;
        }
    }


    public static void alterarInformacoesUsuario(Usuario usuario) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nAlterar informações do usuário\n");
        System.out.print("Digite o novo nome do usuário: ");
        String novoNome = scanner.nextLine();

        System.out.print("Digite o novo e-mail do usuário: ");
        String novoEmail = scanner.nextLine();

        System.out.print("Digite a nova senha do usuário: ");
        String novaSenha = scanner.nextLine();

        // Atualizar as informações do usuário
        usuario.setNome(novoNome);
        usuario.setEmail(novoEmail);
        usuario.setSenha(novaSenha);

        System.out.println("Informações do usuário alteradas com sucesso!");
    }

    public static void exibirMenuAluno(List<Usuario> usuarios, List<Etiqueta> etiquetas, List<Tarefa> tarefas) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (true) {
            System.out.println("\nMenu do Aluno\n");
            System.out.println("1. Listar tarefas");
            System.out.println("2. Criar tarefa");
            System.out.println("3. Deletar tarefa");
            System.out.println("4. Alterar tarefa");
            System.out.println("5. Menu de Etiquetas");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                if (opcao == 0) {
                    System.out.println("Saindo do Menu do Aluno...\n");
                    Usuario.autenticar(usuarios, etiquetas, tarefas);
                    break;
                }

                switch (opcao) {
                    case 1:
                        Tarefa.tipoImprimir(tarefas);
                        break;
                    case 2:
                        Tarefa.incluir(etiquetas, tarefas);
                        break;
                    case 3:
                        Tarefa.excluir(tarefas);
                        break;
                    case 4:
                        Tarefa.alterar(tarefas);
                        break;
                    case 5:
                        exibirMenuEtiquetas(etiquetas);
                        break;
                    default:
                        System.out.println("Opção inválida. Digite uma opção válida.");
                        break;
                }
            } catch (NumberFormatException | LoginException e) {
                System.out.println("Opção inválida. Digite um número correspondente à opção desejada.");
            }
        }
    }

    public static void exibirMenuEtiquetas(List<Etiqueta> etiquetas) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (true) {
            System.out.println("\nMenu de Etiquetas\n");
            System.out.println("1. Listar etiquetas");
            System.out.println("2. Criar etiqueta");
            System.out.println("3. Deletar etiqueta");
            System.out.println("4. Alterar etiqueta");
            System.out.println("0. Voltar");
            System.out.print("Opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                if (opcao == 0) {
                    System.out.println("Voltando ao menu anterior...\n");
                    break;
                }

                switch (opcao) {
                    case 1:
                        Etiqueta.tipoImprimir(etiquetas);
                        break;
                    case 2:
                        Etiqueta.incluir(etiquetas);
                        break;
                    case 3:
                        Etiqueta.excluir(etiquetas);
                        break;
                    case 4:
                        Etiqueta.alterar(etiquetas);
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

    public static void exibirMenuProfessor(List<Usuario> usuarios, List<Etiqueta> etiquetas, List<Tarefa> tarefas) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (true) {
            System.out.println("\nMenu do Professor: \n");
            System.out.println("1. Listar tarefas");
            System.out.println("2. Criar tarefa");
            System.out.println("3. Deletar tarefa");
            System.out.println("4. Alterar tarefa");
            System.out.println("5. Menu de Etiquetas");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                if (opcao == 0) {
                    System.out.println("Saindo do Menu do Professor...\n");
                    Usuario.autenticar(usuarios, etiquetas, tarefas);
                    break;
                }

                switch(opcao){
                    case 1:
                        Tarefa.tipoImprimir(tarefas);
                        break;
                    case 2:
                        Tarefa.incluir(etiquetas, tarefas);
                        break;
                    case 3:
                        Tarefa.excluir(tarefas);
                        break;
                    case 4:
                        Tarefa.alterar(tarefas);
                        break;
                    case 5:
                        exibirMenuEtiquetas(etiquetas);
                        break;
                    default:
                        System.out.println("Opção inválida. Digite uma opção válida.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número correspondente à opção desejada.");
            } catch (LoginException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void exibirMenuAdmin(List<Usuario> usuarios, List<Etiqueta> etiquetas, List<Tarefa> tarefas) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (true) {
            System.out.println("\nMenu do Admin\n");
            System.out.println("1. Listar tarefas");
            System.out.println("2. Criar tarefa");
            System.out.println("3. Deletar tarefa");
            System.out.println("4. Alterar tarefa");
            System.out.println("5. Menu de Etiquetas");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                if (opcao == 0) {
                    System.out.println("Saindo do Menu do Admin...\n");
                    Usuario.autenticar(usuarios, etiquetas, tarefas);
                    break;
                }

                switch (opcao) {
                    case 1:
                        Tarefa.tipoImprimir(tarefas);
                        break;
                    case 2:
                        Tarefa.incluir(etiquetas, tarefas);
                        break;
                    case 3:
                        Tarefa.excluir(tarefas);
                        break;
                    case 4:
                        Tarefa.alterar(tarefas);
                        break;
                    case 5:
                        exibirMenuEtiquetas(etiquetas);
                        break;
                    default:
                        System.out.println("Opção inválida. Digite uma opção válida.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número correspondente à opção desejada.");
            } catch (LoginException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


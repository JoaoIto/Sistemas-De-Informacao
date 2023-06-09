package src.classes;

import src.enums.TipoUsuario;

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

    public static Usuario autenticar(String nomeUsuario, String senhaUsuario, List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (usuario.nome.equals(nomeUsuario) && usuario.senha.equals(senhaUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    public static void exibirMenu(TipoUsuario tipoUsuario) {
        // Exibe o menu de acordo com o tipo de usuário
        if (tipoUsuario == TipoUsuario.ADMIN) {
            System.out.println("Menu do Administrador");
            System.out.println("1. Listar todas as tarefas");
            System.out.println("2. Criar tarefa pra aluno");
            System.out.println("3. Deletar tarefa");
            // Adicione aqui as opções do menu para o usuário administrador
        } else if (tipoUsuario == TipoUsuario.PROFESSOR) {
            System.out.println("Menu do Professor");
            System.out.println("1. Listar todas as tarefas");
            System.out.println("2. Criar tarefa pra aluno");
            System.out.println("3. Deletar tarefa");
            // Adicione aqui as opções do menu para o usuário administrador
        } else if (tipoUsuario == TipoUsuario.ALUNO) {
            System.out.println("Menu do Usuário Comum");
            System.out.println("1. Listar tarefas: ");
            System.out.println("2. Criar tarefa");
            System.out.println("3. Deletar tarefa");
            // Adicione aqui as opções do menu para o usuário comum
        }

        // Aqui você pode implementar a lógica para tratar a escolha do usuário no menu.
        // Pode ser feito usando estruturas de controle, como if-else ou switch-case.
    }

    public static void incluir() {
        Scanner scan = new Scanner(System.in);
        Usuario usuario = new Usuario();
    }

    public void alterar() {
        // Implementação da operação update()
    }

    public void excluir() {
        // Implementação da operação delete()
    }

    public void imprimir(){

    }
}

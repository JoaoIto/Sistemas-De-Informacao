package src.test;

import org.junit.Assert;
import org.junit.Test;
import src.Exceptions.LoginException;
import src.classes.Etiqueta;
import src.classes.Tarefa;
import src.classes.Usuario;
import src.enums.TipoUsuario;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class UsuarioServiceTest {
    @Test(expected = LoginException.class)
    public void testAutenticarCancelado() throws LoginException {
        // Cenário
        List<Usuario> usuarios = new ArrayList<>();
        List<Etiqueta> etiquetas = new ArrayList<>();
        List<Tarefa> tarefas = new ArrayList<>();
        String input = "0\n"; // Simula as entradas do usuário
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Execução
        Usuario.autenticar(usuarios, etiquetas, tarefas);
    }

    @Test(expected = LoginException.class)
    public void testAutenticarInvalido() throws LoginException {
        // Cenário
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("usuario1", "email@email.com", "senha123", TipoUsuario.ALUNO));
        List<Etiqueta> etiquetas = new ArrayList<>();
        List<Tarefa> tarefas = new ArrayList<>();
        String input = "usuario2\nsenha456\n0\n"; // Simula as entradas do usuário
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Execução
        Usuario.autenticar(usuarios, etiquetas, tarefas);
    }

    // Teste que tentei usar, funciona, porém não entendi bem como funciona...
    // Teste de fazer a autenticação de um usuário tipoAluno...

    /*
    @Test
    public void testAutenticarAluno() throws LoginException {
        // Cenário
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("usuario1", "email@email.com", "senha123", TipoUsuario.ALUNO));
        List<Etiqueta> etiquetas = new ArrayList<>();
        List<Tarefa> tarefas = new ArrayList<>();
        String input = "aluno1\nsenha123\n0\n"; // Simula as entradas do usuário
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        // Execução
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Usuario.autenticar(usuarios, etiquetas, tarefas);

        // Verificação
        String output = outputStream.toString();
        Assert.assertTrue(output.contains("Login efetuado com sucesso!"));
        Assert.assertTrue(output.contains("Menu do Aluno"));
    }
    */
}

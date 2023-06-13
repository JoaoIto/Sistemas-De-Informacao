# JUnit tests in Java

Os testes unitários, em sua maioria de forma automática, escritas em Java
foram utilizados a biblioteca JUnit, para que consigamos escrever de uma forma
mais clara e limpa os nossos testes.

## Usuario cancelado: 

Vamos criar um teste unitário para conseguimos testas o caso de na iniciação
de login, quando colocamos o valor 0, ele possa realmente ser cancelado, e 
assim o teste seria concluído com sucesso!

- Cenário:

1. Cria-se três listas vazias: usuarios, etiquetas e tarefas.


2. Define-se uma string input com o valor "0\n", que simula a entrada do usuário. O "0" indica que o usuário deseja cancelar a autenticação.


3. Cria-se um ***``ByteArrayInputStream``*** utilizando a string input para simular a entrada do usuário através do System.in.

- O System.setIn(inputStream) redireciona o System.in para utilizar o ByteArrayInputStream criado, para que a entrada simulada seja lida pelo código.
Execução:


4. Chama-se o método Usuario.autenticar(usuarios, etiquetas, tarefas) para testar a autenticação do usuário.
Espera-se que o método lance uma exceção do tipo LoginException, pois o usuário cancelou a autenticação.
Verificação:

***Nenhuma verificação específica é feita nesse teste***, pois a expectativa é que uma exceção seja lançada. Caso a exceção não seja lançada, o teste falhará automaticamente.

````java
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
````

---

## Usuario inválido: 

Esse teste garante que, quando o usuário digitar um usuário inválido durante a autenticação, uma exceção LoginException será lançada. Isso ajuda a verificar se o código trata corretamente o caso de um usuário inválido.

Quando ele lançará que o usuário não existe por exemplo...

- Cria-se uma lista usuarios contendo um único usuário válido.


- Cria-se duas listas vazias: etiquetas e tarefas.


- Define-se uma string input com o valor "usuario2\nsenha456\n0\n", que simula a entrada do usuário. Essa entrada contém um usuário inválido ("usuario2") e uma senha inválida ("senha456"). 


- O "0" indica que o usuário deseja encerrar a autenticação.


- Cria-se um ByteArrayInputStream utilizando a string input para simular a entrada do usuário através do System.in.


- O System.setIn(inputStream) redireciona o System.in para utilizar o ByteArrayInputStream criado, para que a entrada simulada seja lida pelo código.

````java
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
````

---

### Código para execução: 

Ele inicia a execução dos testes chamando o método estático ``runClasses`` da classe JUnitCore, ***passando a classe de teste AutenticacaoTest.class como argumento***.

O resultado da execução dos testes é armazenado em um objeto Result.

Em seguida, é percorrida a lista de falhas (failures) do resultado, e cada falha é impressa no console.

Por fim, é verificado se todos os testes foram executados com sucesso, com base no resultado obtido, e uma mensagem apropriada é exibida.

````java
public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(UsuarioServiceTest.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        if (result.wasSuccessful()) {
            System.out.println("Todos os testes passaram com sucesso!");
        } else {
            System.out.println("Alguns testes falharam.");
        }
    }
}
````
---

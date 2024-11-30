# Teste de Integração com MongoDB em Memória - API

Este teste de integração foi implementado para verificar o funcionamento de operações de banco de dados dentro de uma aplicação, utilizando o **Jest** e o **MongoDB em Memória**. O objetivo do teste é simular interações com um banco de dados MongoDB em um ambiente isolado e garantir que as funções da API, como recuperação e inserção de usuários, estejam funcionando corretamente.

## Objetivo do Teste

O objetivo principal é:

1. Inicializar um banco de dados MongoDB em memória utilizando o **MongoMemoryServer**.
2. Mockar a conexão com o banco de dados (MongoClient) para interagir com o MongoDB em memória durante os testes.
3. Testar a recuperação de dados de um usuário do banco de dados simulado.
4. Garantir que a aplicação pode realizar operações de leitura e escrita com o banco de dados de forma correta.

## **Caso de Teste 2: Teste de Integração - Jest**

| **ID** | **Caso de Teste (Título)**                        | **Funcionalidade**                                              | **Pré-condição**                                    | **Procedimento**                                                                                                                                                       | **Resultado Esperado**                                                                                                                                                                 |
|--------|--------------------------------------------------|----------------------------------------------------------------|-----------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 2      | **Teste de Integração - Jest**                   | Verificar a integração com o banco de dados em memória.         | O banco de dados em memória deve estar configurado.  | 1. Inicializar o MongoDB em memória.<br>2. Configurar o mock do MongoClient.<br>3. Testar a busca do usuário com o e-mail específico.<br>4. Testar a inserção de uma transação no banco de dados.           | O MongoDB em memória é iniciado corretamente. A busca do usuário retorna os dados simulados (ID, email, senha). A inserção de uma transação retorna um ID fictício. |

---

## O que o Teste Faz

1. **Inicializa o MongoDB em memória**:
    - O teste começa criando um servidor MongoDB em memória usando o **MongoMemoryServer**. Esse servidor simula uma instância do MongoDB em um ambiente isolado, sem necessidade de uma instância real de banco de dados.

2. **Configura mocks para as funções de banco de dados**:
    - A função `getMongoClient`, que normalmente conecta o aplicativo ao banco de dados MongoDB, é mockada para retornar um cliente simulado (`mockMongoClient`). Esse cliente simulado é configurado para retornar operações de banco de dados mockadas, como a inserção de transações e a busca de usuários.

3. **Testa a inicialização do MongoDB em memória**:
    - O teste verifica se o servidor MongoDB em memória foi iniciado corretamente e se a URI de conexão contém o padrão `mongodb://127.0.0.1`, indicando que a conexão está apontando para o banco de dados local.

4. **Testa a recuperação de um usuário do banco de dados**:
    - O teste simula uma consulta ao banco de dados para buscar um usuário específico com o e-mail `"joaovictorpfr@gmail.com"`. O retorno do mock simula um usuário com uma senha hash. A partir disso, o teste verifica se o usuário foi recuperado com sucesso.

#### Funções Mockadas

- **MongoClient**: O cliente MongoDB utilizado pela aplicação foi mockado para simular a interação com o banco de dados sem a necessidade de um MongoDB real.

    - **db.collection('users').insertOne()**: Simula a inserção de uma transação no banco de dados.
    - **db.collection('users').findOne()**: Simula a busca de um usuário específico com base no e-mail.

- **getMongoClient**: A função `getMongoClient`, que normalmente retorna o cliente MongoDB configurado, foi mockada para garantir que o teste utilize o cliente simulado.

#### Ciclo de Vida do Teste

1. **beforeAll**:
    - Inicializa o servidor MongoDB em memória.
    - Configura o mock do cliente MongoDB.

2. **afterAll**:
    - Após os testes, o servidor MongoDB em memória é interrompido, garantindo que o ambiente de testes seja limpo.

3. **it('should initialize MongoDB in memory')**:
    - Verifica se o MongoDB foi corretamente inicializado e se a URI de conexão está conforme o esperado.

4. **it('should mock a user retrieval from the database')**:
    - Testa a operação de busca de um usuário no banco de dados simulado, verificando se a consulta retorna os dados do usuário corretamente.

## Conclusão

Este teste de integração verifica a interação entre a aplicação e um banco de dados simulado, utilizando o **MongoDB em Memória** para garantir que a lógica de banco de dados da aplicação funcione conforme esperado em um ambiente de teste controlado. Ao mockar a conexão com o MongoDB e simular as operações de leitura e escrita, o teste assegura que a aplicação é capaz de realizar operações básicas de banco de dados sem depender de um servidor MongoDB real durante os testes.

---
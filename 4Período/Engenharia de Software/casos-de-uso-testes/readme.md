# Documentação do Projeto de Engenharia de Software

## Informações Gerais

**Aluno**: João Victor Póvoa França
**Objetivo**: Testar um componente de autenticação em uma aplicação de streaming.

## Descrição do Trabalho

Este trabalho foi realizado no contexto da disciplina de Engenharia de Software e tem como objetivo principal testar um componente de autenticação dentro de uma aplicação de streaming. O foco está em garantir que as funcionalidades relacionadas ao gerenciamento de usuários, como cadastro, atualização, exclusão e busca, estejam operando corretamente e de forma segura.

## Tecnologias e Frameworks Utilizados

### Linguagens e Plataformas

- **Java**: Linguagem de programação utilizada para desenvolver a aplicação.
- **Quarkus**: Framework Java utilizado para criar a aplicação com foco em microsserviços e nativo em nuvem.
- **JUnit**: Framework de testes utilizado para escrever e executar testes unitários.
- **RestAssured**: Biblioteca para testes de APIs RESTful, utilizada para testar os endpoints da aplicação.

### Ferramentas e Serviços

- **Jakarta EE**: Conjunto de especificações para desenvolver aplicações empresariais em Java.
- **JWT (JSON Web Token)**: Técnica de autenticação utilizada para proteger os endpoints da aplicação.
- **Hashing Service**: Serviço utilizado para hash de senhas, garantindo a segurança dos dados de autenticação dos usuários.

## Estrutura dos Testes

Os testes foram desenvolvidos para verificar as seguintes operações principais:

1. **Inserção de Usuário**: Testa se um novo usuário pode ser inserido corretamente.
2. **Atualização de Usuário**: Testa se um usuário existente pode ser atualizado.
3. **Exclusão de Usuário**: Testa se um usuário pode ser excluído corretamente.
4. **Busca de Todos os Usuários**: Testa se é possível obter a lista de todos os usuários.
5. **Busca de Usuário por ID**: Testa se é possível obter um usuário específico pelo seu ID.
6. **Busca de Usuário por Nome**: Testa se é possível buscar usuários pelo nome.

Este exemplo demonstra como um teste para inserção de um novo usuário foi implementado, verificando se a API responde com o status 201 (Criado) quando um usuário válido é enviado.

## Conclusão

O projeto foca na implementação e teste de um componente de autenticação, garantindo que a aplicação de streaming seja segura e confiável. Utilizando os frameworks e tecnologias mencionados, foi possível desenvolver uma solução robusta para gerenciamento de usuários e autenticação, cobrindo todos os casos de uso principais com testes automatizados.

---

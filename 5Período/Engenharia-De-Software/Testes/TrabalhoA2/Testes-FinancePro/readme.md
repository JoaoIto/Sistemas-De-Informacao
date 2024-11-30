# Testes com Cypress e Jest

- **Objetivo:** Testar a plataforma, interface, e a API, integração, de um app de gestão de finanças, FinancePro, para que seja garantido suas funcionalidades e front-end para que seja garantido a qualidade e veracidade de seu código.

- **Cypress (Teste de Interface)**:
  O Cypress é uma ferramenta de teste end-to-end (E2E) usada para verificar a interação do usuário com a interface da aplicação. No teste com Cypress, a funcionalidade de **adicionar uma transação** foi verificada, incluindo o preenchimento de um formulário, a submissão e a confirmação de que os dados foram corretamente exibidos na tela. O Cypress facilita testes de interface devido à sua fácil configuração, integração rápida e uma documentação amigável.

- **Jest (Teste de Integração)**:
  O Jest é uma framework de testes para JavaScript, focada em testes unitários e de integração. O teste com Jest foi usado para simular e verificar operações de banco de dados usando **MongoDB em memória**. O Jest é ideal para testes de integração, pois permite a simulação de ambientes de banco de dados e a verificação das interações sem a necessidade de uma instância real de banco de dados.

### Por que usar Cypress e Jest?

- **Cypress** é utilizado para garantir que a interface da aplicação funcione corretamente, simulando interações reais de usuários de forma simples e eficaz.
- **Jest** é escolhido para realizar testes de integração, permitindo simular operações do banco de dados de forma controlada e garantir a funcionalidade da lógica de backend.

Ambas as ferramentas se integram facilmente, oferecendo testes robustos para garantir a qualidade do código tanto no frontend quanto no backend.

---

Aqui estão as tabelas separadas para cada caso de teste:

## **Caso de Teste 1: Teste de Adição de Transação - Cypress**

| **ID** | **Caso de Teste (Título)**                        | **Funcionalidade**                                              | **Pré-condição**                                    | **Procedimento**                                                                                                                                                       | **Resultado Esperado**                                                                                                                                                                 |
|--------|--------------------------------------------------|----------------------------------------------------------------|-----------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1      | **Teste de Adição de Transação - Cypress**       | Validar a adição de uma receita e a atualização da interface.   | Usuário já deve estar na página inicial do app.     | 1. Visitar a página inicial.<br>2. Clicar na aba "Receita".<br>3. Preencher o formulário com descrição, valor e data.<br>4. Clicar no botão "Adicionar Receita".<br>5. Verificar o redirecionamento para a tela inicial.<br>6. Confirmar que os elementos da tela inicial estão visíveis. | A transação é adicionada corretamente. A página é redirecionada para o Dashboard Financeiro. Os elementos "Dashboard Financeiro", "Saldo Total", "Receitas" e "Despesas" estão visíveis. |

---

### **Caso de Teste 2: Teste de Integração - Jest**

| **ID** | **Caso de Teste (Título)**                        | **Funcionalidade**                                              | **Pré-condição**                                    | **Procedimento**                                                                                                                                                       | **Resultado Esperado**                                                                                                                                                                 |
|--------|--------------------------------------------------|----------------------------------------------------------------|-----------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 2      | **Teste de Integração - Jest**                   | Verificar a integração com o banco de dados em memória.         | O banco de dados em memória deve estar configurado.  | 1. Inicializar o MongoDB em memória.<br>2. Configurar o mock do MongoClient.<br>3. Testar a busca do usuário com o e-mail específico.<br>4. Testar a inserção de uma transação no banco de dados.           | O MongoDB em memória é iniciado corretamente. A busca do usuário retorna os dados simulados (ID, email, senha). A inserção de uma transação retorna um ID fictício. |

---

Essas tabelas estão organizadas para facilitar a leitura e compreensão de cada caso de teste de maneira separada e objetiva.
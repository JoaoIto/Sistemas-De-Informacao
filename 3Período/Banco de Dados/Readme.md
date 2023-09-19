# Biblioteca

Código de estudo de banco de dados de biblioteca, com 5 questãoes, estudando os assuntos que estariam na matéria de banco de dados.

1. **Índices**:

    - **O que são**: Os índices são estruturas de dados que melhoram a eficiência das consultas em um banco de dados. Eles aceleram o processo de recuperação de registros, funcionando como um "mapa" que direciona o sistema de gerenciamento de banco de dados (DBMS) para as linhas relevantes em uma tabela.

    - **Uso no Código**: No código, você criou dois índices:
        - `autores_index_nome` na coluna `nome` da tabela `autores`, que melhora o desempenho de consultas que envolvem ordenação por nome de autores.
        - `emprestimo_data` na coluna `data_emprestimo` da tabela `emprestimos`, para melhorar o desempenho de consultas que envolvem pesquisas por data de empréstimo.

2. **Views**:

    - **O que são**: Views são consultas armazenadas que podem ser tratadas como tabelas virtuais. Elas permitem simplificar consultas complexas, fornecer segurança de acesso aos dados e até mesmo ocultar detalhes da estrutura do banco de dados.

    - **Uso no Código**: No código, você criou duas views:
        - `livros_anos2000` exibe títulos e anos de publicação de livros publicados após o ano 2000, com base na tabela `livros`.
        - `emprestimos_ativos` mostra detalhes de empréstimos em andamento, incluindo título do livro, data de empréstimo e data de devolução, com base nas tabelas `livros` e `emprestimos`.

3. **Triggers**:

    - **O que são**: Triggers são blocos de código SQL que são automaticamente executados quando ocorrem eventos específicos em uma tabela, como inserção, atualização ou exclusão de registros. Eles são usados para automatizar ações, manter integridade referencial e realizar auditorias.

    - **Uso no Código**: No código, você criou um trigger chamado `atualiza_num_emprestimos`. Este trigger é acionado após a inserção de um novo registro na tabela `emprestimos`. Ele atualiza a coluna `num_emprestimos` na tabela `livros`, incrementando o valor sempre que um novo empréstimo é registrado.

---

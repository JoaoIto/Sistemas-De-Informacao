# Componentes do sistema

Dentro de um documento de requisitos, para os casos de uso do sistema, é importante entender o que cada parte é, e qual o seu papel.

## Definição: 

![image](https://github.com/JoaoIto/Sistemas-De-Informacao/assets/78181193/a64f4259-240c-40e7-8f4b-b4a7eb3d1174)

---

A documentação de requisitos do sistema é um conjunto de documentos que descrevem as necessidades, expectativas e especificações do sistema de software que está sendo desenvolvido. Esses documentos são criados e mantidos ao longo do ciclo de vida do projeto para garantir que todos os envolvidos tenham uma compreensão clara do que está sendo desenvolvido e do que é esperado do sistema.

### Documentação de Requisitos do Sistema

#### Componentes da Documentação:

1. **Documento de Visão**: Descreve a visão geral do projeto, seus objetivos e principais funcionalidades. Ajuda a garantir que todos os envolvidos no projeto tenham uma compreensão comum dos objetivos e direção do projeto.

2. **Especificação de Requisitos de Software (SRS)**: Detalha todos os requisitos funcionais e não funcionais do sistema. Geralmente inclui uma lista de requisitos, descrições detalhadas de cada requisito e critérios de aceitação.

3. **Diagramas de Casos de Uso**: Representam as interações entre os atores (usuários) e o sistema. Os casos de uso ajudam a entender como o sistema será usado na prática e são uma parte importante da documentação de requisitos.

4. **Diagramas de Sequência**: Mostram como os diferentes componentes do sistema interagem entre si ao longo do tempo. Eles capturam o fluxo de mensagens entre os objetos do sistema e ajudam a entender o comportamento dinâmico do sistema.

5. **Modelos de Dados**: Descrevem a estrutura dos dados que o sistema irá manipular, incluindo entidades, atributos e relacionamentos.

### Base de Casos de Uso, Ator, Subsistemas e Relacionamentos

#### Componentes da Base:

1. **Casos de Uso**: Descrevem interações entre os atores (usuários externos) e o sistema para alcançar um objetivo específico. Cada caso de uso representa uma funcionalidade do sistema que agrega valor ao usuário.

2. **Ator**: Representa um usuário externo que interage com o sistema. Pode ser uma pessoa, outro sistema ou um dispositivo.

3. **Subsistemas**: São partes do sistema que possuem funcionalidades específicas e são responsáveis por realizar determinadas tarefas. Podem ser componentes de software separados ou módulos dentro do sistema principal.

4. **Relacionamentos**: Descrevem como os diferentes elementos (casos de uso, atores, subsistemas) estão relacionados entre si. Por exemplo, um ator pode estar envolvido em vários casos de uso, ou um subsistema pode ser responsável por várias funcionalidades do sistema.

### Exemplo:

Suponha que estamos desenvolvendo um sistema de gestão de biblioteca. Aqui está uma base simplificada de casos de uso, atores, subsistemas e relacionamentos:

- **Casos de Uso**:
  - Realizar Empréstimo de Livro
  - Devolver Livro
  - Pesquisar Livro
  - Cadastrar Usuário

- **Atores**:
  - Usuário (Cliente)
  - Bibliotecário

- **Subsistemas**:
  - Módulo de Empréstimo
  - Módulo de Catalogação
  - Módulo de Autenticação

- **Relacionamentos**:
  - O ator "Usuário" está envolvido nos casos de uso "Realizar Empréstimo de Livro", "Devolver Livro" e "Pesquisar Livro".
  - O ator "Bibliotecário" está envolvido nos casos de uso "Realizar Empréstimo de Livro" e "Devolver Livro".
  - O subsistema "Módulo de Empréstimo" é responsável pela funcionalidade de empréstimo de livros.
  - O subsistema "Módulo de Catalogação" é responsável pela funcionalidade de catalogação de livros.
  - O subsistema "Módulo de Autenticação" é responsável pela funcionalidade de autenticação de usuários.

---

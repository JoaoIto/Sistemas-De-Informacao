### Diagrama de Sequência Dinâmico

#### Resumo:
Um diagrama de sequência dinâmico mostra como objetos em um sistema interagem entre si ao longo do tempo. Ele captura o fluxo de mensagens entre os objetos e a ordem em que essas mensagens são trocadas durante a execução de uma funcionalidade específica do sistema.

#### Exemplo:

Considere um sistema de gestão de biblioteca onde um usuário solicita um livro. Um diagrama de sequência dinâmico para essa interação representaria como o usuário, o sistema e o livro interagem durante o processo de solicitação.

Exemplo de um Diagrama de Sequência Dinâmico:

```
Usuário                       Sistema de Gestão de Biblioteca            Livro
  |                                    |                                     |
  |   Solicita o livro desejado        |                                     |
  |----------------------------------->|                                     |
  |                                    |  Verifica a disponibilidade       |
  |                                    |----------------------------------->|
  |                                    |                                     |
  |                                    |  Reserva o livro para o usuário   |
  |                                    |<-----------------------------------|
  |   Recebe a confirmação da reserva |                                     |
  |<-----------------------------------|                                     |
  |                                    |  Prepara o livro para retirada    |
  |                                    |----------------------------------->|
  |                                    |                                     |
```

Este diagrama mostra a interação entre o usuário, o sistema de gestão de biblioteca e o livro ao longo do tempo, desde a solicitação do livro até a preparação para a retirada. Ele ilustra a troca de mensagens entre os objetos durante esse processo.

Esses exemplos devem ajudar a entender melhor a diferença entre os diagramas de sequência parcial e dinâmico e como cada um deles é utilizado para representar interações em um sistema.

---

# Tarefa / Programa

1. **Programa**:
   - **Conceito**: Um programa é um conjunto de instruções escritas para resolver um problema específico. Ele representa uma aplicação ou utilitário e é um conceito estático, o que significa que não possui um estado interno definido durante a execução e não interage diretamente com outras entidades, como o usuário ou outros programas. Um programa é um conceito passivo, aguardando ser executado.
   - **Exemplo**: Os arquivos `C:\Windows\notepad.exe` e `/usr/bin/vi` são exemplos de programas, utilizados para edição de texto.

2. **Tarefa**:
   - **Conceito**: Uma tarefa, por outro lado, é a execução sequencial, por um processador, das instruções definidas em um programa para realizar seu objetivo. É um conceito dinâmico, com um estado interno bem definido a cada momento (incluindo valores de variáveis internas e a posição atual da execução), e interage ativamente com outras entidades, como o usuário, dispositivos periféricos e/ou outras tarefas.
   - **Implementação**: As tarefas podem ser implementadas de várias formas, como processos ou threads. Um processo é uma instância de um programa em execução, enquanto uma thread é uma unidade básica de execução dentro de um processo. Ambos executam as instruções do programa, mas as threads compartilham o mesmo espaço de memória dentro de um processo, enquanto os processos têm seu próprio espaço de memória.
   - **Exemplo**: Quando você inicia o `notepad.exe` no Windows para editar um arquivo de texto, o sistema operacional cria uma tarefa (ou processo) para executar as instruções contidas no arquivo `notepad.exe`. Durante a execução, essa tarefa interage com você, o usuário, e com o sistema de arquivos para salvar ou carregar o arquivo de texto.
  
   - ---
   

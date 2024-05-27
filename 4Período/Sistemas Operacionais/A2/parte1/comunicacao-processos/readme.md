# Comunicação entre processos

Aqui falaremos do processo de comunicação entre processos em um processador, e como eles se dão
e quais são as suas formas de se comunicar.

### Comunicação entre Processos (IPC)

A comunicação entre processos (IPC) é crucial para a cooperação e sincronização de processos em um sistema operacional. Ela permite que processos troquem informações, compartilhem recursos e coordenem suas atividades.

#### Importância da IPC:
- **Cooperação entre processos:** Facilita a interação e troca de dados.
- **Coordenação e sincronização:** Essencial para manter a ordem e prevenir conflitos.
- **Multitarefa e sistemas distribuídos:** Fundamental para sistemas que executam várias tarefas simultaneamente.

### Tipos de Comunicação

#### Comunicação Síncrona
- **Definição:** Processos aguardam a conclusão da comunicação antes de continuar.
- **Exemplo:** Chamadas de Procedimento Remoto (RPC), onde o cliente espera a resposta do servidor.

#### Comunicação Assíncrona
- **Definição:** Processos continuam suas atividades enquanto a comunicação está em andamento.
- **Exemplo:** Mensagens assíncronas, onde o remetente envia uma mensagem e continua executando.

### Métodos de Comunicação

#### Comunicação Direta
- **Características:** Processos se comunicam diretamente.
- **Exemplos:**
    - **Pipes:** Canal de comunicação unidirecional entre dois processos.
    - **Sockets:** Comunicação entre processos em diferentes máquinas via rede.
    - **Memória Compartilhada:** Região de memória acessível por vários processos.

#### Comunicação Indireta
- **Características:** Processos se comunicam através de intermediários fornecidos pelo sistema operacional.
- **Exemplos:**
    - **Filas de Mensagens:** Fila mantida pelo sistema operacional para troca de mensagens.
    - **Semáforos:** Variáveis que controlam o acesso a recursos compartilhados.
    - **Sinais:** Notificação assíncrona sobre eventos ou condições.

---

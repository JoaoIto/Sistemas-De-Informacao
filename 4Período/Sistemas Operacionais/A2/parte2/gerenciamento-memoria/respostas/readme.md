## Gerenciamento de Memória: Perguntas para Dominar Cada Tópico na Prova (Com Respostas)

**Conceitos Básicos:**

**1. Pergunta Base:** Qual a diferença entre tempo de acesso e taxa de transferência de memória?

**Resposta:**

* **Tempo de acesso:** É o tempo que leva para iniciar a transferência de dados de/para a memória. Imagine o tempo que você leva para encontrar um livro em uma estante: o tempo de acesso é o tempo que você leva para localizar o livro na prateleira.
* **Taxa de transferência:** É a velocidade com que os dados são lidos ou escritos na memória, uma vez que o acesso foi iniciado. Imagine a velocidade com que você folheia o livro após encontrá-lo: a taxa de transferência é a rapidez com que você lê o conteúdo do livro.

**2. Pergunta Específica Técnica:** Em um sistema com barramento de endereçamento de 32 vias, qual a quantidade máxima de memória RAM que pode ser endereçada?

**Resposta:**

* Um barramento de 32 vias pode endereçar 2^32 endereços de memória.
* Como cada endereço de memória corresponde a 1 byte, a quantidade máxima de RAM endereçável é:

```
2^32 bytes * (1 byte/endereço) = 4.294.967.296 bytes = 4 GB
```

**Memória Virtual:**

**3. Pergunta Base:** Qual a principal função da MMU (Unidade de Gerência de Memória) no contexto da memória virtual?

**Resposta:**

A função principal da MMU é traduzir endereços lógicos, utilizados pelos programas, em endereços físicos, que correspondem à memória física real. Essa tradução é crucial para que os programas possam acessar seus dados na memória, mesmo que estejam armazenados em diferentes áreas da memória física ou até mesmo no disco rígido (memória virtual).

**4. Pergunta Específica Técnica:** Explique como a MMU lida com um Page Fault, situação em que a página de memória necessária para um processo não está presente na memória principal.

**Resposta:**

Quando ocorre um Page Fault, a MMU identifica a página ausente e gera uma interrupção para o sistema operacional. O sistema operacional então busca a página no disco rígido, carrega-a na memória principal e atualiza as tabelas de página para refletir a nova localização da página. Por fim, a MMU é notificada sobre a página carregada e o processo é retomado a partir do ponto onde foi interrompido.

**Gerenciamento de Memória:**

**5. Pergunta Base:** Quais as principais funções do gerenciamento de memória em um sistema operacional multiprogramação?

**Resposta:**

O gerenciamento de memória em um sistema multiprogramação tem diversas funções essenciais:

* **Isolamento de processos:** Garante que os processos não interfiram na memória uns dos outros, protegendo seus dados e evitando conflitos.
* **Alocação de RAM:** Atribui espaço na memória principal para cada processo em execução, de acordo com suas necessidades de memória.
* **Gerenciamento de memória virtual:** Implementa técnicas como paginação e segmentação para permitir que os processos acessem mais memória do que a disponível na memória principal, utilizando o disco rígido como armazenamento auxiliar.
* **Swapping:** Move processos inativos da memória principal para o disco rígido e vice-versa, liberando espaço para outros processos e otimizando o uso da memória.
* **Proteção de memória:** Implementa mecanismos para evitar que processos acessem áreas de memória não autorizadas, protegendo o sistema contra acessos indevidos e falhas.

**6. Pergunta Específica Técnica:** Compare e contraste as classes de MMU em termos de flexibilidade e fragmentação da memória.

**Resposta:**

| Característica | MMU Fixa | MMU Dinâmica |
|---|---|---|
| Flexibilidade | Baixa | Alta |
| Fragmentação | Interna e externa | Interna |
| Implementação | Mais simples | Mais complexa |

* **MMU Fixa:** Divide a memória em partições predefinidas e os processos são alocados em partições específicas. Essa rigidez limita a flexibilidade de alocação e pode levar à fragmentação interna e externa da memória.
* **MMU Dinâmica:** Permite que os processos sejam alocados em qualquer lugar da memória, otimizando o uso da memória e minimizando a fragmentação interna. No entanto, a implementação da MMU dinâmica é mais complexa devido à necessidade de gerenciar tabelas de alocação de memória dinâmicas.

**Monoprogramação e Multiprogramação:**

**7. Pergunta Base:** Quais as principais diferenças entre os sistemas operacionais mon

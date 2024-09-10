## A2: Resumo para Prova

## Gerenciamento de Memória: Resumo para Prova (Modo Turbinado)

**Domine os conceitos chave e elimine o thrashing da sua prova!**

**Memória Física:** A RAM do seu computador, onde os programas residem durante a execução. Imagine-a como sua mesa de trabalho, quanto maior, mais processos você pode trabalhar simultaneamente.

**Espaço de Endereçamento:** O conjunto de endereços que o processador pode usar para acessar a memória. Pense nele como o sistema de numeração das casas em uma rua: cada endereço único leva a um local específico na memória.

**Endereços Físicos vs. Lógicos:** Físicos são os endereços reais da memória, como o número da casa. Já os lógicos são usados pelos programas, como o apelido da casa ("A casa da esquina"). A MMU (Unidade de Gerência de Memória) atua como um correio, traduzindo os endereços lógicos para os físicos, garantindo que cada programa encontre sua casa na memória.

**Gerenciamento de Memória:** O maestro da orquestra da memória, garantindo que cada processo tenha seu espaço reservado e evitando conflitos. Imagine um gerente de eventos alocado em cada andar de um prédio, organizando as salas para diferentes grupos sem sobreposições.

**Classes de MMU:**

* **MMUs Fixas:** Os processos ficam em compartimentos pré-definidos, como apartamentos em um prédio. Mudanças de apartamento são complexas e podem gerar problemas.
* **MMUs Dinâmicas:** Permitem que os processos se movam livremente pela memória, como nômades em um deserto. Maior flexibilidade, mas exigem gerenciamento mais complexo.

**Estratégias de Alocação de Memória:**

* **First Fit:** O primeiro espaço livre que cabe o processo é escolhido, como encontrar a primeira vaga em um estacionamento lotado. Simples, mas pode levar à fragmentação.
* **Best Fit:** O menor espaço livre que cabe o processo é selecionado, como escolher a caixa perfeita para embalar um presente. Eficiente, mas pode gerar muitos espaços livres minúsculos.
* **Worst Fit:** O maior espaço livre é alocado, como reservar um vagão inteiro para transportar uma bicicleta. Evita fragmentação, mas pode desperdiçar espaço.
* **Next Fit:** A busca por espaço livre inicia a partir da última alocação, como lembrar onde você estacionou o carro em um shopping. Rápido, mas pode levar a subutilização da memória.
* **Quick Fit:** Mantém listas de espaços livres por tamanho, como prateleiras organizadas em um depósito. Eficiente para alocações frequentes, mas exige mais memória para gerenciar as listas.

**Thrashing:** O pesadelo do gerenciamento de memória, quando a memória RAM fica tão sobrecarregada que o sistema trava e des trava constantemente. Imagine um restaurante lotado com garçons correndo de mesa em mesa, sem tempo para atender os clientes direito.

**Causas do Thrashing:**

* **Memória Insuficiente:** Mesas demais para um restaurante pequeno.
* **Algoritmos Ineficientes:** Garçons mal treinados que se perdem entre os pedidos.
* **Processos com Grande Demanda:** Clientes que pedem pratos elaborados que demoram para preparar.

**Soluções para Thrashing:**

* **Aumentar a RAM:** Ampliar o restaurante para acomodar mais mesas.
* **Aprimorar Algoritmos:** Treinar os garçons para serem mais eficientes.
* **Limitar Processos:** Controlar o número de clientes no restaurante.
* **Técnicas de Compactação:** Reorganizar as mesas para liberar espaço.

---

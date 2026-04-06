# Lista de Exercícios: Limites e Prevenção de Falhas

**Questão 1: O *Crash* Iminente (Indeterminação Simples)**
*(Baseada na Atividade de 02/03/2026)*

O tempo de resposta $y$ (em milissegundos) de um microserviço no seu *Load Balancer* se comporta de acordo com o consumo de memória $x$ (em GB) pela seguinte função:
$$f(x) = \frac{x^2 - 4}{x - 2}$$

Se o servidor bater exatamente $2$ GB de RAM ($x = 2$), o sistema tenta dividir por zero e sofre um *crash*. Sua missão é calcular o limite do tempo de resposta quando a memória se aproxima de $2$ GB para configurar o alerta de *timeout* antes da falha.

Calcule:
$$\lim_{x \to 2} \frac{x^2 - 4}{x - 2}$$

---

**Questão 2: Gargalo no Banco de Dados (Indeterminação com Trinômio)**
*(Baseada na Atividade de 02/03/2026)*

A eficiência de leitura do seu banco de dados PostegreSQL está modelada por uma função mais complexa. Quando o número de *queries* simultâneas $x$ se aproxima de $5$ milhares, o sistema entra em colapso ($0/0$). A função de latência é:
$$f(x) = \frac{2x^2 - 9x - 5}{3x^2 - 75}$$

Para configurar a regra de bloqueio do *Firewall*, resolva essa indeterminação. (Dica: Você precisará fatorar o numerador usando as raízes de Bhaskara e o denominador evidenciando os termos).

Calcule:
$$\lim_{x \to 5} \frac{2x^2 - 9x - 5}{3x^2 - 75}$$

---

**Questão 3: *Memory Leak* a Longo Prazo (Limites no Infinito)**
*(Baseada na Atividade de 16/03/2026)*

Você fez o *deploy* de um novo container Docker e quer saber se ele tem *Memory Leak* (vazamento de memória). O consumo de RAM (em GB) em relação ao tempo de atividade do servidor $x$ (em dias) é modelado por:
$$f(x) = \frac{x^2 + 7x}{7x^2 + 5x + 5}$$

Para descobrir onde o consumo de memória vai "estacionar" após meses ligado (quando o tempo tende ao infinito), você deve calcular a assíntota horizontal dessa função.

Calcule:
$$\lim_{x \to +\infty} \frac{x^2 + 7x}{7x^2 + 5x + 5}$$

---


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

O tempo está correndo! Se a prova é hoje, precisamos ter estratégia. Olhando para os seus PDFs, os próximos assuntos na sequência lógica são **Limites Trigonométricos Fundamentais**, **Continuidade** e **Derivadas Básicas (Regra do Tombo)**.

A boa notícia? Esses três assuntos são muito mais fáceis e rápidos de aprender do que o Bhaskara que acabamos de fazer. São baseados em "macetes" e regras diretas. 

Aqui estão três questões fresquinhas, extraídas e adaptadas diretamente das suas listas de exercícios. Pegue o papel!

---

**Questão 4: Oscilação de Sinal (Limite Trigonométrico Fundamental)**
*(Baseada na Atividade de 09/03/2026)*

O seu sistema de monitoramento de rede recebe sinais em formato de ondas. Para evitar uma divisão por zero quando o tempo de resposta tende a zero ($x \to 0$), o sistema calcula o limite de uma função trigonométrica. O limite fundamental nos diz que $\lim_{x \to 0} \frac{\text{sen}(x)}{x} = 1$.

Usando as propriedades matemáticas para ajustar os coeficientes, calcule o limite desse sinal de rede:
$$\lim_{x \to 0} \frac{\text{sen}(9x)}{12x}$$

---

**Questão 5: Hot-Swap e Zero-Downtime (Continuidade de Função)**
*(Baseada na Aula de 09/03/2026 - Slide 7)*

O seu `node-balancer` tem duas regras de roteamento. A **Regra A** funciona para tráfego baixo (até 1.000 requisições, onde $x \le 1$) e a **Regra B** assume quando o tráfego é alto ($x > 1$). 
A função que define o custo de CPU $f(x)$ do sistema é dividida em duas partes:
* $f(x) = 2x^2 + 3$  **(se $x \le 1$)**
* $f(x) = 6 - x$  **(se $x > 1$)**

Sua missão como Engenheiro de Confiabilidade: Verifique se a função é **contínua** no ponto de transição $x = 1$. 
*(Dica: Calcule o limite pela esquerda substituindo $x=1$ na primeira equação, depois o limite pela direita substituindo $x=1$ na segunda equação. Se os valores forem iguais, o sistema faz a transição sem "engasgar" e a função é contínua).*

---

**Questão 6: Taxa de Aceleração de Tráfego (Introdução à Derivada)**
*(Baseada na Atividade de 23/03/2026 - Questão 1)*

Finalmente, a métrica mais importante do seu *auto-scaling*. A quantidade total de dados processados pelo seu servidor em relação ao tempo $x$ é dada pela função polinomial:
$$f(x) = x^5 - 3x^3 + 1$$

Para descobrir a **velocidade** em que os dados estão entrando (a taxa de variação instantânea), você precisa calcular a **Derivada** dessa função, denotada por $f'(x)$.
*(Dica: Use a Regra da Potência/Regra do Tombo: desça o expoente multiplicando e subtraia 1 do expoente de cada termo).*

Determine a função derivada $f'(x)$.

---



# Lista de Exercícios: Função do 2º Grau Aplicada (Versão Limpa)

**Questão 1: Análise Completa de Latência**
A variação de latência $y$ de uma das suas APIs no `node-balancer` em função da carga $x$ é dada pela seguinte equação: 
$$y = x^2 - 2x - 8$$

Faça um esboço do gráfico dessa função, determinando:
**A)** As raízes da função (os pontos onde a variação de latência é zero).
**B)** O ponto de intersecção da curva com o eixo $y$ (o que acontece quando a carga $x = 0$).
**C)** As coordenadas do vértice (o ponto de mínima variação).

---

**Questão 2: Descobrindo Constantes de Configuração**
Você está configurando uma variável de ambiente $c$ no seu sistema. A documentação diz que a função de falha do sistema é modelada por:
$$y = x^2 - 7x - 2c$$

Durante os testes de estresse, você descobriu que o sistema atinge o estado de falha (ou seja, a raiz, onde $y = 0$) exatamente quando o parâmetro de entrada de carga é $x = -3$. 
Nessas condições matemáticas, calcule e determine o valor da constante $c$.

---

**Questão 3: Estudo de Sinais do Health Check**
[cite_start]O script de *Health Check* do seu servidor avalia a saúde da máquina em tempo real através da função:
$$f(x) = -x^2 + 2x + 3$$

Faça o **estudo dos sinais** dessa função. Determine em quais intervalos numéricos de $x$ a saúde do servidor é:
**A)** Positiva ($y > 0$) - Máquina operando normalmente.
**B)** Nula ($y = 0$) - Máquina no limite de alerta (ponto de virada).
**C)** Negativa ($y < 0$) - Máquina travada/falhando.

---


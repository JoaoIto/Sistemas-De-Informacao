## Lista de Exercícios: Função do 2º Grau Aplicada

**Questão 1: Análise Completa de Latência (Baseada na Questão 6 do material)**
A variação de latência $y$ de uma das suas APIs no node-balancer em função da carga $x$ é dada pela equação: 
[cite_start]$$y = x^2 - 2x - 8$$ [cite: 553]

[cite_start]Faça um esboço mental ou no papel do gráfico dessa função, determinando [cite: 552, 558-561]:
**A)** As raízes da função (os pontos onde a variação de latência é zero).
**B)** O ponto de intersecção da curva com o eixo $y$ (o que acontece quando a carga $x = 0$).
**C)** As coordenadas do vértice (o ponto de mínima variação).

**Questão 2: Descobrindo Constantes de Configuração (Baseada na Questão 4 do material)**
Você está configurando uma variável de ambiente $c$ no seu sistema. A documentação diz que a função de falha do sistema é modelada por:
[cite_start]$$y = x^2 - 7x - 2c$$ [cite: 548]

[cite_start]Durante os testes, você descobriu que o sistema atinge o estado de falha (ou seja, a raiz, onde $y = 0$) exatamente quando o parâmetro de entrada é $x = -3$[cite: 548]. 
[cite_start]Nessas condições, calcule e determine o valor da constante $c$[cite: 549].

**Questão 3: Estudo de Sinais do Health Check (Baseada na Questão 7 do material)**
O script de *Health Check* do seu servidor avalia a saúde da máquina através da função:
[cite_start]$$f(x) = -x^2 + 2x + 3$$ [cite: 569]

[cite_start]Faça o **estudo dos sinais** dessa função[cite: 563]. Determine em quais intervalos de $x$ a saúde do servidor é:
**A)** Positiva ($y > 0$) - Máquina operando normalmente.
**B)** Nula ($y = 0$) - Máquina no limite de alerta.
**C)** Negativa ($y < 0$) - Máquina travada.

---

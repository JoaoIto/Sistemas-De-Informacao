1 - Considerando o uso de particionamento Buddy em um sistema com 4 GB de memória principal, responda as seguintes perguntas:

a)
Esboce o gráfico que representa o uso da memória caso a seguinte sequência de requisições seja apresentada no sistema: A (130 MB), B (750 MB), C (600 MB), D (300 MB) e E (230 MB).

b)
É possível no particionamento Buddy haver fragmentação externa? Justifique.

c)
Indique no gráfico que representa o uso de memória onde seria carregado o processo X, de tamanho igual a 240 MB.

2 - Suponha um sistema computacional com 64 KB de memória principal e que utilize um sistema operacional de 14 KB que implementa alocação contígua de memória. Considere também um programa de 80 KB, formado por um módulo principal de 20 Kb e três módulos independentes, cada um com 10 KB, 20 KB e 30 KB. Como o programa poderia ser executado utilizando-se apenas a técnica de overlay?


3 - Um sistema que emprega memória virtual utilizando paginação está executando um programa de tamanho de 8 Kbytes. A máquina possui uma memória física de 3 Kbytes e define quadros de 1 Kbytes. Na execução deste programa foi gerada a seguinte sequência de referências de páginas (string de referência): 5,2,3,5,2,5,1,5,4,2,3,2,1,3,2,3
Supondo que a memória principal esteja inicialmente vazia indique quais páginas estarão residentes na memória principal após cada referência de página se a política de substituição for: (a) LRU e (b) FIFO.
Qual a melhor política entre FIFO e LRU para estas referências? Justifique sua resposta


4 - Um computador possui quatro quadros. O tempo de carga, do último referência, bit de modificação e referência para cada página são mostrados abaixo:
Página
Tempo de carga
Última referência
Modificado
Referenciado
0
227
327
1
0
1
345
367
1
1
2
101
331
1
0
3
234
382
0
1
Qual página é substituída se o algoritmo de substituição for: LRU, segunda chance e NRU.


5 - Considere um sistema operacional que implementa a paginação utilizando páginas de 4Kbytes. Nesse contexto, justifique que tipo de vantagens o sistema teria se o tamanho da página fosse de:

a)
8Kbytes

b)
2Kbytes.


6 - Um computador possui quatro quadros em sua memória física. Durante a execução de um processo, as páginas 3,5,9,7 foram carregadas na memória. O tempo de carga, do último acesso, e os bits de uso (U) e de modificação (M) para cada página são mostrados abaixo:
Página
Tempo de carga
Última referência
Modificado
Referenciado
3
126
279
0
0
5
230
260
1
0
9
120
271
1
1
7
160
280
1
1
Considerando que os dois próximos acessos são para as páginas 2 e 3, nessa ordem, quais páginas serão substituídas se o algoritmo de substituição for: FIFO, LRU, segunda chance e NRU?


7 - Um computador possui quatro quadros em sua memória física. Em determinado instante, os seguintes dados estão disponíveis:
Página
Tempo de carga
Última referência
Modificado
Referenciado
7
100
231
0
1
8
112
233
1
1
5
187
230
1
0
10
200
232
0
1
Mostre qual página será removida da memória para se atender a requisição de acesso ao endereço virtual 4095, para cada um dos seguintes algoritmos: FIFO, LRU e 2ª chance e NRU.
8 - Um pequeno computador tem quatro molduras de página. Na primeira interrupção de tempo, os bits R são 0111 (o da página 0 em 0 e os demais em 1). Nas interrupções seguintes tais valores são 1011, 1010, 1101, 0010, 1010, 1100, 0001. Se o algoritmo do envelhecimento for usado, com um contador de oito bits, qual o valor dos quatro contadores após a última interrupção?

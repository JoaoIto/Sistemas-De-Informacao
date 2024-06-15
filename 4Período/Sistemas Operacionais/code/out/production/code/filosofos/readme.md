# Jantar dos filósofos

O problema consiste em cinco filósofos sentados ao redor de uma mesa circular para o
jantar, onde cada filósofo possui um prato para comer macarrão. 

Os filósofos possuem hashis e
cada um precisa de 2 hashis para comer, porém para cada par de pratos existe apenas um hashi.
Um filósofo possui duas ações: pensar ou comer.

Quando um filósofo ficar com fome ele irá
tentar pegar o hashi à sua direita e à sua esquerda, um de cada vez. Se ele conseguir pegar os
dois hashis, ele irá comer a comida em um tempo determinado e irá colocar os hashis sobre a
mesa novamente, voltando a pensar.


Caso todos os filósofos peguem um hashi ao mesmo tempo, todos irão ficar parados para
sempre aguardando o segundo hashi ficar disponível, **gerando um ***Deadlock*****.


- Se um filósofo conseguir pegar apenas o primeiro hashi e por isso devolvê-lo a mesa, esperando
um tempo fixo para tentar pegar os dois hashis novamente, teremos um caso de starvation
(inanição), onde o filósofo poderá morrer de fome. Ele poderá tentar fazer a mesma ação de
pegar e depois devolver o hashi pra sempre, nunca conseguindo comer.


- Como garantir que todos os filósofos consigam comer, sem gerar nenhuma situação de deadlock
ou starvation?


Elabore um programa em Java que apresente uma solução para esse problema.
Observações:
- Os filósofos não conversam entre si
- Os filósofos pensam e tentam comer em tempos aleatórios
- Os filósofos comem por tempos aleatórios
- Os filósofos pegam os hashis um de cada vez
  Elabore um programa em Java que apresente uma solução para esse problema. A entrega da
  atividade deverá ser um vídeo com o aluno executando o seu programa e depois explicando o
  mesmo.

---

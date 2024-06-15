# Algoritmos de particionamento

A atividade proposta consiste em implementar um algoritmo de escolha de partição livre. 

Esse algoritmo
deve permitir ao usuário informar a quantidade de partições e a quantidade de processos que serão criados.

Nas simulações, o interessante é criar menos processos do que partições. Para cada partição considere, pelo
menos, as seguintes informações:
- Tamanho da partição
- Processo que está na partição
- Fragmentação gerada
  Para cada processo, considere, pelo menos, as seguintes informações:
- PID
- Tamanho
  Os tamanhos das partições deverão ser valores aleatórios em 100 e 600. E tamanhos dos processos deverão
  ser valores aleatórios entre 100 e 500.


- E para realizar a atribuição das partições, implemente os algoritmos
  ***first-fit, best-fit e worst-fit***.


A saída do programa deverá ser a lista de partições com a situação de cada partição após as alocações serem
  realizadas. Caso ocorra fragmentação interna em uma partição, mostre o valor da fragmentação

---

# Trabalho - Corrida

Construir um programa que **realize uma corrida (km de arrancada) entre diferentes tipos de
carros e motos.** **Ganha o veículo que atingir a maior velocidade.**

1. Faça a abstração dos dados que identifique cada tipo de veículo;
   a) Classe e Atributos.


2. A corrida deve possuir no mínimo 4 veículos (de cada tipo).


3. A corrida deve acontecer em 20 segundos:
   a) A cada segundo os veículos aumentam a aceleração;
   i. Exceto para os segundos 6, 11 e 15 (os veículos realizam uma frenagem).


4. A corrida dos carros acontece antes da corrida das motos.
   Cálculo para Acelerar um veículo:
   velocidade = velocidade + 5.
   velocidade(km/h) += velocidade * (15% da cilindrada) – (1 para cada 300 kg do veículo).
   Cálculo para Frear um veículo:
   Toda vez que frear o veículo perde 25% da velocidade.
   No final deve-se imprimir os dados de todos os veículos.

---
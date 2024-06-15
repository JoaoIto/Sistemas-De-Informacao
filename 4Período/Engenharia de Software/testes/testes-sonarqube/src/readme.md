# Semáforo

No contexto dos sistemas operacionais, semáforos são uma técnica de sincronização que permite
controlar o acesso concorrente a recursos compartilhados, como memória, arquivos, impressoras e outros
objetos em um ambiente de computação multiusuário ou multithread.


E para simular essa técnica, implemente uma solução para o seguinte contexto: considere um
estacionamento onde é possível especificar a quantidade de vagas e a quantidade de carros que querem
estacionar nessas vagas.

Utilizando threads, simule a situação onde existem vários carros concorrentes
(threads) tentando utilizar o recurso compartilhado (vagas do estacionamento).


- **O programa deverá iniciar com todas as vagas disponíveis e deverá ser finalizado quanto todos os
  carros conseguirem entrar e sair do estacionamento.**

- **Para melhor entendimento do conceito de semáforos,
  nas simulações a quantidade de carros deverá ser sempre maior que a quantidade de vagas.**

- **A saída do programa deverá mostrar os carros entrando no estacionamento, saindo do
  estacionamento e quantas vagas disponíveis ainda tem, como na imagem a seguir:**

---
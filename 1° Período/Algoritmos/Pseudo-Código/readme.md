# Pseudo-código 
- (29/08/2022)

-- ***Pseudo-código* é basicamente um conceito de se escrever suas próprias linhas de código, para que seja assim uma forma de entender a partir da sua lógica e linguagem de fala padrão, uma melhor forma e mais didádica de se entender lógica da programação!**

O exercício da aula foi entender a lógica de programação era oque realmente importava a entender oque o código tem a se falar, neste sentido foi exercitado principalmente a criatividade de se criar a base de código, até chegar de fato na linguagem...

Deste modo foi desenvolvido alguns exercícios para o deselvolvimento de lógica nas linhas de pseudo-código.

Observe os exercícios abaixo:

---

1. **Escreva um algoritmo que permita calcular a média das duas notas de um aluno. Também deve informar se ele foi aprovado ou reprovado, sabendo que a média necessária para a aprovação é 7.**

```jsx
inicio

real = nota1;
real = nota2;

real = media;

escreva("Informe a sua nota1:");
leia(nota1);

escreva("Informe a sua nota2:");
leia(nota2);

media = nota1 + nota2 / 2;
escreva("sua média é:" + media);

se (media >= 7) entao
escreva("aluno aprovado");

se nao entao

escreva("aluno reprovado");

fim
```
---

**Calculo de médias, (proposto a exame final)**

```jsx
**inicio

// dados de entrada A1, A2, exame
// dados caluculados que precisam ser armazenados: media
// saida do programa: aprovado ou reprovado**

real = A1;
real = A2;
real = exame;
real = media;

escreva("Informe a nota A1:");
leia(A1);

escreva("Informe a nota A2:");
leia(A2);

media = (A1 + A2) / 2;

se (media >= 7)
escreva("Aluno aprovado");

se (media >= 4) entao
escreva("Informe a nota do exame");
leia (exame);

media = (media + exame) / 2;

se (media >= 7) entao
escreva("Aluno Aprovado");

se nao
escreva("Aluno aprovado");

**fim**
```

---

2. **Considere uma empresa que paga os seus funcionários semanalmente por hora em até 40 horas. Caso o funcionário trabalhe mais que meta de horas, ele recebe 10% a mais no seu salário. Caso não, tenha uma multa de 3%. Calcule o salário do funcionário**

```jsx
**inicio** 

real = horasTrabalhadas
real = valorHora
real = totalSalario
inteiro = meta

escreva("Quantas horas foram trabalhadas:")
leia (horasTrabalhadas)

escreva("Valor da hora de trabalho");
leia(valorHora)

totalSalario = horasTrabalhadas * valorHora

escreva("O funcionario bateu a meta? Escreva sim ou não!");
leia(meta)

se (meta == "sim")

totalSalario += 10%

se nao 

totalSalario -= 3

escreva("O salário do funcionário é:"+ totalSalario)

**fim**  
```

---

3. **Considere o cálculo de um indivíduo para uma clínica fitness, na qual deve ser mostrado os indivíduos a serem necessários para vários tipos de exercício, sendo assim, precisa-se entender qual o valor do IMC de cada indivíduo, e ainda sabendo se ele está em cada sub-classe de classificação...**

```jsx
real = peso;
real = altura;

escreva("Informe o seu peso:");
leia(peso);

escreva("Informe a sua altura");
leia (altura);

imc = peso / (altura * altura);

se (imc >= 25) entao
escreva("Acima do peso");

se (imc >= 20 && imc <= 25) entao
escreva("Peso ideal");

se (imc < 20) entao
escreva("Abaixo do peso");

```

---

### Salário líquido

```jsx
**inicio**

real salario;

escreva("Informe o seu salário bruto");
leia(salario);

se (salario <= 1500) entao
escreva("Salário é de: "+ (salario -= 10%));

se (salario <= 2500 && > 1500) entao
escreva("Salário é de: "+ (salario -= 15%));

se (salario > 2500) entao
escreva("Salário é de: "+ (salario -= 20%));

**fim**
```

---
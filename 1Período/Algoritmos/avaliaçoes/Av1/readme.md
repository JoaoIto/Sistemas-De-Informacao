# Avaliação 1:

### Questão 1: Observe as seguintes afirmações e as classifique como verdadeiras ou falsas.

```java
public class code1 {
    public static void code1(String[] args) {
        int numero = 10;

        while(numero >= 0){
            System.out.println("O dobro de: " + numero + ", é: " + numero * 2);
        }
        System.out.println("O número é: " + numero);
    }
}
```

- Na linha 5, a atribuição do valor 10 à variável "numero" é chamada de "inicialização" **(V)**

- Da forma como o programa está escrito, pode ser que o corpo do laço de repetição (linha 9) nunca se **(F)**

- O valor da variável "numero" impresso na tela na linha 11 deverá ser 11840. **(F)**

- O operador ">=" na linha 7 é um operador aritmético. **(F)**

- A expressão "numero * 2" na linha 9 altera o valor da variável "numero".** **(F)**

- A mensagem contida na linha 9 será impressa na tela 11 vezes **(F)**

- O símbolo "{" da linha 8 é opcional e poderia ser retirado sem prejuízos ao program* **(F)**

- Esse programa não necessita dos símbolos "{" e "}" das linhas 8 e 10 **(V)**

- A linha 11 do programa nunca será executada **(V)**

- Para tornar o programa correto (do ponto de vista da definição de algoritmo) basta substituir a palavra while por for **(F)**

---
### Questão 2: Sobre a interação entre os comandos IF-ELSE-ELSE IF, analise as seguintes informações e as classifique em verdadeiras ou falsas.


- O comando IF pode conter outros IFs dentro dele **(V)**

- O ELSE é opcional a não ser que tenha um ELSE IF, nesse caso o ELSE passa a ser obrigatório **(F)**

- O bloco ELSE, quando presente, será sempre executado independente se as condições do IF e ELSE IF não forem satisfeitas **(F)**

- O IF pode ser considerado um comando de desvio de fluxo condicional **(V)**

- O ELSE, assim como o IF pode conter outro ELSE dentro dele (mesmo sem outro IF) **(F)**

---

### Questão 3: Considere a sintaxe do comando FOR em linguagem Java e, observando o exemplo na imagem, indique o que representa cada um dos elementos citados abaixo:

```java
for(i = 0; i < 10; i++){
    n = i * 2;
    System.out.println("O dobro de: " + i + "é: " + n);
}
```

- ``for``: **palavra reservada**;
- ``i``: **variável de controle**;
- ``i=0;``: **inicialização**;
- ``i<10``:	**condição de permanência**;
- ``i++``: **incremento da variável de controle**;

---

### Questão 4: Qual o operador não é um operador aritmético?

- **``>=``**
---

### Questão 5: Uma variável que tem seu valor incrementado em 1 sempre que um determinado evento é reconhecido pelo programa pode ser chamada de:

- **contador**
---

#### Questão 6: Qual dos elementos a seguir pode ser considerado um desvio de fluxo incondicional? 

- **o símbolo } que encerra um bloco "while";**
---

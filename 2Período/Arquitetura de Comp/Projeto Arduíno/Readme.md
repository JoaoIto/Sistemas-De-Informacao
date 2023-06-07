# Protótipo de Software do projeto ***Trava Elétrica***


Neste trecho , primeiramente incluímos a biblioteca do keypad, que é uma lib conhecida para o reconhecimentos de teclados e conexão com o arduíno.
Depois inicializamos duas variáveis que servirá como o índice do tamanho da matriz do teclado, já que trataremos ele como objeto dentro de outro objeto
que serão as linhas e colunas do teclado. E logo após inicializamos essa matriz do teclado.

Além disso, indicamos dentro do código do software os pinos que deversão ser conectados em cada linha e coluna do arduíno. E assim, usando a biblioteca, inicializamos o objeto com o tamanho de linhas e colunas:

```c++
#include <Keypad.h>

// TECLADO 4X3
const byte LINHAS = 4;
const byte COLUNAS = 3;

char teclas[LINHAS][COLUNAS] = {
    {'1', '2', '3'},
    {'4', '5', '6'},
    {'7', '8', '9'},
    {'*', '0', '#'}};

byte pinosLinhas[LINHAS] = {9, 8, 7, 6};
byte pinosColunas[COLUNAS] = {5, 4, 3};
Keypad keypad = Keypad(makeKeymap(teclas), pinosLinhas, pinosColunas, LINHAS, COLUNAS);

```

Depois disso que vem a variável mágica, que servirá para indicar o tamanho da senha, tanto quanto a string que será a composição da senha:

```c++
// SENHA
const int tamanhoSenha = 4;
char senha[tamanhoSenha + 1] = "4321"; // Ajuste para incluir o caractere nulo no final da senha
char entradaSenha[tamanhoSenha + 1];
byte indice = 0;
bool senhaCorreta = false; // Variável de controle para verificar se a senha foi digitada corretamente

```

Agora usamos o método padrão da própria linguagem do c++, para fazer o setup do arduíno assim que inicializado junto com o software.

Ele apenas indica as pinMode, que serão de saída, assim como os leds estando desligados.

```c++
// RELÉ
const byte portaRele = 2;

void setup()
{
    pinMode(LED_BUILTIN, OUTPUT);
    pinMode(portaRele, OUTPUT); // Ajuste para usar a variável portaRele

    digitalWrite(LED_BUILTIN, LOW); // Desliga o LED interno
    digitalWrite(portaRele, HIGH);  // Desliga o relé
}

```

---

## ***```Main loop()```***

Essa é o método que rodará o principal do código, oque definirá como ele irá funcionar, oque dentro do c++, é o método de ```loop()```.

Inicializamos a variável de cada tecla do keypad, para assim usarmos de comparador, de cada string, para que seja usado em funções condicionais comuns dentro do código.

- Utilizamos o algarismo de ***"#"*** para indicar quando a própria senha que está sendo digitada pelo usuário, deve ser "apagada", ou assim inicializada, para que consigamos ter uma função de limpeza do teclado.


A função principal do nosso código é a ***```strcmp(a, b)```***. 

### ***```strcmp(a, b)```***: 
***Ela utiliza dois parâmetros para comparação, que assim devolve um "booleano", de 0 ou 1, que assim comparamos e indicamos com o led verde do relé, e assim temos a abertura do circuito elétrico para a fechadura eletrônica.***

E logo após, só precisamos utilizar o método memset para que consigamos limpar o buffer inicial.

```c++
void loop()
{
    char tecla = keypad.getKey();

    if (tecla)
    {
        if (tecla != '#')
        {
            entradaSenha[indice] = tecla;
            indice++;

            if (indice == tamanhoSenha)
            {
                entradaSenha[indice] = '\0'; // Adiciona o caractere nulo no final da senha
                indice = 0;

                if (strcmp(entradaSenha, senha) == 0)
                {
                    digitalWrite(portaRele, LOW);
                    delay(3000); // Aguarda 3 segundos
                    digitalWrite(portaRele, HIGH);
                }
                else
                {
                    digitalWrite(LED_BUILTIN, HIGH);
                    delay(3000); // Aguarda 3 segundos
                    digitalWrite(LED_BUILTIN, LOW);
                }

                memset(entradaSenha, 0, sizeof(entradaSenha));
            }
        }
    }
}
```

---
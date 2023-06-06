#include <Keypad.h>

// TECLADO 4X3
const byte LINHAS = 4;
const byte COLUNAS = 3;

char teclas[LINHAS][COLUNAS] = {
  {'1', '2', '3'},
  {'4', '5', '6'},
  {'7', '8', '9'},
  {'*', '0', '#'}
};

byte pinosLinhas[LINHAS] = {9, 8, 7, 6};
byte pinosColunas[COLUNAS] = {5, 4, 3};
Keypad keypad = Keypad(makeKeymap(teclas), pinosLinhas, pinosColunas, LINHAS, COLUNAS);

// SENHA
const int tamanhoSenha = 4;
char senha[tamanhoSenha + 1] = "4321"; // Ajuste para incluir o caractere nulo no final da senha
char entradaSenha[tamanhoSenha + 1];
byte indice = 0;

// RELÉ
const byte portaRele = 2;

bool senhaCorreta = false; // Variável de controle para verificar se a senha foi digitada corretamente

void setup() {
  pinMode(LED_BUILTIN, OUTPUT);
  pinMode(portaRele, OUTPUT); // Ajuste para usar a variável portaRele

  digitalWrite(LED_BUILTIN, LOW); // Desliga o LED interno
  digitalWrite(portaRele, HIGH); // Desliga o relé
}

void loop() {
  char tecla = keypad.getKey();

  if (tecla) {
    if (tecla != '#') {
      entradaSenha[indice] = tecla;
      indice++;

      if (indice == tamanhoSenha) {
        entradaSenha[indice] = '\0'; // Adiciona o caractere nulo no final da senha
        indice = 0;

        if (strcmp(entradaSenha, senha) == 0) {
          digitalWrite(LED_BUILTIN, LOW);
          delay(3000); // Aguarda 3 segundos
          digitalWrite(LED_BUILTIN, HIGH);
        } else {
          digitalWrite(LED_BUILTIN, HIGH);
          delay(3000); // Aguarda 3 segundos
          digitalWrite(LED_BUILTIN, LOW);
        }

        memset(entradaSenha, 0, sizeof(entradaSenha));
      }
    }
  }

}
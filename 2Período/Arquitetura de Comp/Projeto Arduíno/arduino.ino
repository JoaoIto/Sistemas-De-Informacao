#include <Keypad.h>

// Criando a senha do terminal:
char password[] = "dc0#*";

// Definindo número de linhas e colunas do teclado:
const byte ROWS = 4;
const byte COLS = 4;

// Definindo caracteres do teclado externo:
char keys[ROWS][COLS] = {
    {'1', '2', '3', 'A'},
    {'4', '5', '6', 'B'},
    {'7', '8', '9', 'C'},
    {'*', '0', '#', 'D'}};

// Definindo pinos de conexão das linhas e colunas no Arduino:
byte rowPins[ROWS] = {11, 10, 9, 8};
byte colPins[COLS] = {7, 6, 5, 4};

// Definindo pinos dos componentes:
int ledVermelho = 12;
int ledVerde = 13;
int releFechadura = 3;
int buzzer = 2;

// Definindo tempos de espera:
int tempoBuzz = 50;
int tempoAberto = 2000;

// Criando objeto para leitura das teclas:
Keypad keypad = Keypad(makeKeymap(keys), rowPins, colPins, ROWS, COLS);

// Função para trancar ou destrancar a porta:
void estadoPorta(bool trancada)
{
    if (trancada)
    {
        digitalWrite(ledVermelho, HIGH);
        digitalWrite(ledVerde, LOW);
        digitalWrite(releFechadura, HIGH);
    }
    else
    {
        digitalWrite(ledVermelho, LOW);
        digitalWrite(ledVerde, HIGH);
        digitalWrite(releFechadura, LOW);
        delay(tempoAberto);
        digitalWrite(releFechadura, HIGH);
    }
}

void setup()
{
    pinMode(LED_BUILTIN, OUTPUT);
    estadoPorta(true); // Estado inicial da porta, (trancada);

    // Estados iniciais para pinos dos componentes:
    pinMode(ledVermelho, OUTPUT);
    pinMode(ledVerde, OUTPUT);
    pinMode(releFechadura, OUTPUT);
    pinMode(buzzer, OUTPUT);
}

void loop()
{
    // Estado base para o arduíno estar funcionando caso esteja "rodando"
    digitalWrite(LED_BUILTIN, HIGH);
    delay(1000);
    digitalWrite(LED_BUILTIN, LOW);
    delay(1000);

    char key = keypad.getKey(); // Lendo a tecla pressionada

    if (key != NO_KEY)
    { // Se uma tecla foi pressionada
        digitalWrite(buzzer, HIGH);
        delay(tempoBuzz);
        digitalWrite(buzzer, LOW); // Acionando o buzzer para indicar que a tecla foi pressionada

        // Verificando se a tecla pressionada faz parte da senha:
        if (key == password[position])
        {
            position++;
            if (position == sizeof(password) - 1)
            {                       // Se a senha foi digitada corretamente
                estadoPorta(false); // Destrancando a porta
                position = 0;
            }
        }
        else
        {
            position = 0; // Reiniciando a posição da senha
        }
    }
}

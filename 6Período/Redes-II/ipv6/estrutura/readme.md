# 🧱 Estrutura de Endereços IPv6

## 📌 O que é um endereço IPv6?

Um **endereço IPv6** é uma sequência de **128 bits**, utilizada para identificar **dispositivos em redes que utilizam o protocolo IPv6**. Ele é a "identidade digital" de cada dispositivo conectado, como um número de CPF na rede.

---

## 🧮 Como é organizado um endereço IPv6?

Um endereço IPv6 é dividido em **8 blocos** de **4 dígitos hexadecimais**, separados por **dois-pontos (`:`)**. Cada bloco representa **16 bits**, e juntos somam **128 bits**.

### 📘 Exemplo de endereço IPv6:

```
2001:0db8:0000:0000:130f:0000:0000:140b
```

### 🧮 Explicação por parte:

| Bloco | Valor | Significado Geral (exemplo)               |
| ----- | ----- | ----------------------------------------- |
| 1     | 2001  | Prefixo global (rede designada pela IANA) |
| 2     | 0db8  | Usado para documentações e testes         |
| 3-4   | 0000  | Pode indicar sub-redes ou estar reservado |
| 5     | 130f  | Identificador da rede interna             |
| 6-7   | 0000  | Espaço reservado / não utilizado          |
| 8     | 140b  | Identificador do host (dispositivo final) |

---

## 🧠 Analogia:

Pense em um endereço IPv6 como um **endereço completo com CEP**. Ele inclui:

* **País** (prefixo),
* **Estado e cidade** (sub-redes),
* **Rua e número da casa** (host).

---

## 🗂️ Componentes internos (em alguns contextos técnicos)

Em redes maiores, um endereço IPv6 pode ser dividido logicamente em:

| Parte do Endereço      | Tamanho (bits) | Função                           |
| ---------------------- | -------------- | -------------------------------- |
| Prefixo da Rede        | 48 ou 64       | Identifica a rede ou sub-rede    |
| ID da Sub-rede         | variável       | Divide a rede em partes menores  |
| Interface ID (host ID) | 64             | Identifica o dispositivo na rede |

---

## 📌 Conclusão

* O endereço IPv6 é formado por **128 bits**, escritos em **8 blocos hexadecimais**.
* Tem estrutura clara e segmentada, facilitando a divisão entre rede e dispositivo.
* É mais flexível e poderoso do que o IPv4, suportando diferentes tipos de comunicação (unicast, multicast, anycast).

---

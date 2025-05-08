## 🆚 IPv4 x IPv6

### 🔹 O que é o IPv4?

O **IPv4 (Internet Protocol version 4)** é a versão mais antiga e ainda mais utilizada do protocolo IP. Ele foi criado nos anos 1980 e utiliza **endereços de 32 bits**, o que significa que pode gerar aproximadamente **4,3 bilhões** de endereços únicos (2³² = 4.294.967.296).

#### 🔸 Exemplo de endereço IPv4:

```
192.168.0.1
```

Esses endereços são formados por **quatro números separados por pontos**, e cada número vai de 0 a 255.

---

### 🔹 Por que foi criado o IPv6?

Com a explosão de dispositivos conectados — como smartphones, computadores, smart TVs, relógios, sensores, etc. — o número de endereços disponíveis no IPv4 **ficou pequeno**.

O **IPv6 (Internet Protocol version 6)** surgiu como **uma solução definitiva** para essa limitação. Ele utiliza **endereços de 128 bits**, o que resulta em **mais de 340 undecilhões de combinações possíveis** (isso é um número com 39 dígitos!).

#### 🔸 Exemplo de endereço IPv6:

```
2001:0db8:0000:0000:130f:0000:0000:140b
```

### 🔢 Comparando:

| Característica      | IPv4                       | IPv6                                    |
| ------------------- | -------------------------- | --------------------------------------- |
| Tamanho do endereço | 32 bits                    | 128 bits                                |
| Formato             | Decimal (com pontos)       | Hexadecimal (com dois-pontos)           |
| Capacidade          | \~4,3 bilhões de endereços | \~340 undecilhões (muito maior!)        |
| Exemplo             | 192.168.0.1                | 2001:0db8:0000:0000:130f:0000:0000:140b |

---

## 🧩 Estrutura do Endereço IPv6

Um endereço IPv6 é **formado por 8 blocos de 4 dígitos hexadecimais**, separados por dois-pontos (`:`). Cada bloco representa **16 bits**, e o endereço completo possui **128 bits**.

#### 🔸 Exemplo:

```
2001:0db8:0000:0000:130f:0000:0000:140b
```

### 🔧 Simplificação

Como os endereços são longos, podemos **simplificá-los** usando algumas regras:

1. **Remover zeros à esquerda:**

   ```
   0db8 → db8
   ```

2. **Substituir uma sequência de blocos com “0000” por “::”** (somente uma vez por endereço):

   ```
   2001:db8::130f:0:0:140b
   ```

#### ❌ Importante:

Você **não pode usar "::" mais de uma vez** no mesmo endereço, pois isso causaria ambiguidade (não saberíamos quantos blocos estão sendo omitidos).

---

## 🔒 Prefixo no IPv6 – O que é?

O **prefixo** é a parte inicial do endereço IPv6 que identifica **a rede** à qual o dispositivo pertence. Ele é representado por:

```
<endereço>/<quantidade de bits da rede>
```

### 🔸 Exemplo:

```
2001:db8:3003:2::/64
```

Neste caso:

* Os **64 primeiros bits** (ou os primeiros 4 blocos) são usados para identificar a rede.
* Os **64 bits restantes** servem para identificar os dispositivos (hosts) dentro dessa rede.

#### 🧠 Analogia:

É como um **CEP (prefixo)** que identifica o bairro e o número da **casa (sufixo)** que identifica a residência exata.

---

## 🌍 Como usar IPv6 em URLs?

Como os endereços IPv6 contêm **dois-pontos (`:`)**, isso pode **confundir** com a separação de porta em URLs (ex: `:8080`). Por isso, **devemos colocar o IPv6 entre colchetes** quando usado em uma URL.

### 🔸 Exemplo de URL com IPv6:

```
http://[2001:12ff:0:4::22]/index.html
```

### 🔸 Exemplo com porta:

```
http://[2001:12ff:0:4::22]:8080
```

---

## 📌 Recapitulando (Resumo Final):

* IPv4 tem **limitação** de endereços (32 bits).
* IPv6 resolve esse problema com **muito mais endereços** (128 bits).
* Endereços IPv6 são escritos em **hexadecimal**, com regras de simplificação.
* Prefixos em IPv6 funcionam como **divisores de rede**, como no CIDR (ex: `/64`).
* Para usar IPv6 em URLs, **coloque o endereço entre colchetes**.

---


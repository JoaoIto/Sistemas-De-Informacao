## **IPv4 vs. IPv6**

### 🔹 Definição

**IPv4** (Internet Protocol version 4) e **IPv6** (Internet Protocol version 6) são versões do protocolo IP, utilizado para identificar dispositivos em uma rede por meio de endereços únicos. O IPv6 surgiu como solução à limitação do número de endereços disponíveis no IPv4.

---

### 🔸 Exemplificação

* **IPv4**: Utiliza 32 bits → Total de **4.294.967.296** endereços possíveis.
* **IPv6**: Utiliza 128 bits → Total de **340.282.366.920.938.463.463.374.607.431.768.211.456** endereços.

---

### 📌 Subtópicos

* **Escassez de endereços IPv4**: Já estamos próximos do limite de endereços disponíveis.
* **Expansão com IPv6**: Suporta uma quantidade quase infinita de endereços, garantindo escalabilidade para o crescimento da internet.
* **Impacto técnico**: A mudança para IPv6 afeta a forma como roteadores operam e como os endereços são alocados e interpretados.

---

## **Estrutura do IPv6**

### 🔹 Definição

Um endereço IPv6 é formado por **oito grupos de 16 bits**, escritos em hexadecimal e separados por dois-pontos (`:`).

---

### 🔸 Exemplificação

Um endereço IPv6 completo:

```
2001:0DB8:0000:0000:130F:0000:0000:140B
```

Forma abreviada válida:

```
2001:db8:0:0:130f::140b
```

Forma inválida (uso incorreto de `::` duas vezes):

```
2001:db8::130f::140b
```

---

### 📌 Subtópicos – Regras de escrita

* ✅ **Pode** usar letras **maiúsculas ou minúsculas**.
* ✅ **Pode** **omitir zeros à esquerda**.
* ✅ **Pode** representar **vários grupos de zeros contínuos** com `::` (mas só uma vez por endereço!).

---

## **Prefixo e URL no IPv6**

### 🔹 Definição

No IPv6, o **prefixo** funciona de forma semelhante ao CIDR no IPv4, definindo a parte de rede do endereço. Ele é escrito como:

```
<endereço>/<número de bits>
```

O prefixo indica quantos bits iniciais definem a rede; os restantes servem para identificar dispositivos (hosts).

---

### 🔸 Exemplificação

* Prefixo **64 bits**:

  ```
  2001:db8::/64
  ```

* Outros exemplos:

  * Prefixo com sub-rede: `2001:db8:3003:2::/64`
  * Prefixo global: `2001:db8::/32`
  * ID da sub-rede: `3003:2`

---

### 📌 Subtópicos – URLs com IPv6

Como os endereços IPv6 contêm dois-pontos (`:`), eles devem ser colocados **entre colchetes** quando usados em URLs:

* Exemplo com porta:

  ```
  http://[2001:12ff:0:4::22]:8080
  ```

* Exemplo comum:

  ```
  http://[2001:12ff:0:4::22]/index.html
  ```

---

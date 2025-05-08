# 🧩 Prefixo IPv6 e URI

## 🔹 O que é um **prefixo IPv6**?

O **prefixo IPv6** funciona como o **"CEP" da rede**, ou seja, ele identifica a **parte do endereço** que representa a **rede** à qual um dispositivo pertence.

### 📘 Exemplo de prefixo:

```
2001:0db8:1234::/48
```

### 🧮 Explicando o exemplo:

| Parte              | Significado                                                           |
| ------------------ | --------------------------------------------------------------------- |
| `2001:0db8:1234::` | Representa os primeiros **48 bits** do endereço                       |
| `/48`              | É a **máscara de prefixo**, indicando quantos bits representam a rede |

> 🧠 **Analogia**: Imagine um endereço de casa. O prefixo seria o **bairro ou cidade** — uma parte comum a várias casas (endereços). Todos os dispositivos com o mesmo prefixo estão na mesma "região" da rede.

---

## 📌 Como é usado o prefixo?

Os prefixos são usados para:

* **Roteamento**: os roteadores leem o prefixo para saber para onde enviar pacotes.
* **Divisão de redes**: você pode criar **sub-redes** a partir de um prefixo maior.
* **Organização de endereçamento**: ajuda a agrupar dispositivos logicamente.

---

## 🧠 Tipos comuns de prefixos IPv6

| Prefixo     | Finalidade                        | Notação CIDR | Exemplo               |
| ----------- | --------------------------------- | ------------ | --------------------- |
| `2000::/3`  | Endereços **globais** (Internet)  | /3           | `2001:db8::/32`       |
| `fe80::/10` | Endereços **link-local**          | /10          | `fe80::1`             |
| `fc00::/7`  | Endereços **locais únicos (ULA)** | /7           | `fd12:3456:789a::/48` |
| `::1/128`   | **Loopback** (localhost)          | /128         | `::1`                 |

---

## 🌐 O que é uma **URI (Uniform Resource Identifier)**?

Uma **URI** é um identificador padrão usado para representar um **recurso acessível** na rede — como uma página, serviço, ou sistema.

No contexto do IPv6, a URI permite **especificar um endereço IPv6** para acessar diretamente um recurso da web.

---

## 🧾 URI com endereço IPv6

Quando usamos um IPv6 em uma URI, **precisamos colocá-lo entre colchetes** para que o navegador ou sistema saiba que aquilo é um endereço.

### 📘 Exemplo de URI com IPv6:

```
http://[2001:db8::1]:8080/index.html
```

### 🧮 Explicando:

| Parte           | Significado                               |
| --------------- | ----------------------------------------- |
| `http://`       | Protocolo                                 |
| `[2001:db8::1]` | Endereço IPv6 entre colchetes             |
| `:8080`         | Porta do serviço (neste caso, porta 8080) |
| `/index.html`   | Caminho do recurso solicitado             |

> ⚠️ **Sem os colchetes**, o navegador não entende que é um IPv6.

---

## 🧠 Analogias úteis

* **Prefixo IPv6**: como o **DDD** de uma cidade ou **código postal** — agrupa vários números de telefone (endereços).
* **URI com IPv6**: como escrever uma **carta com endereço completo**, incluindo rua, número e código da cidade (host + porta + recurso).

---

## ✅ Conclusão

* O **prefixo IPv6** identifica a **rede** dentro de um endereço completo e é essencial para roteamento.
* A **URI** permite usar endereços IPv6 diretamente para acessar serviços na web.
* Em URIs, o endereço IPv6 deve estar entre **colchetes** `[ ]` para evitar ambiguidade com a porta do serviço.

---

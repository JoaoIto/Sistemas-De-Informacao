# 🆚 IPv4 vs IPv6

## 📌 O que são IPv4 e IPv6?

**IPv4** e **IPv6** são versões do **protocolo IP (Internet Protocol)**, que é o responsável por identificar e localizar dispositivos em uma rede, como computadores, celulares, servidores e impressoras.

### 📬 Analogia:

Imagine que cada dispositivo conectado à internet precisa de um **"endereço residencial digital"**. O protocolo IP fornece esse endereço, para que os dados saibam **para onde ir e de onde vieram**.

---

## 🔹 IPv4 — Internet Protocol version 4

### ✅ Características principais:

* Criado nos anos 1980.
* Usa **endereços de 32 bits**.
* Permite cerca de **4,3 bilhões de endereços únicos**.
* É representado por **quatro números decimais separados por pontos**.

#### 📘 Exemplo:

```
192.168.0.1
```

Cada número pode variar entre 0 e 255.

### ⚠️ Limitações:

* O número de dispositivos conectados ao mundo explodiu (smartphones, TVs, sensores, etc.).
* **Já estamos esgotando os endereços IPv4 disponíveis**.

---

## 🔸 IPv6 — Internet Protocol version 6

### ✅ Características principais:

* Criado para substituir o IPv4 e **resolver a escassez de endereços**.
* Usa **endereços de 128 bits**.
* Permite aproximadamente **340 undecilhões de endereços** (isso é 340 seguido de 36 zeros!).
* É representado por **oito blocos de quatro dígitos hexadecimais**, separados por dois-pontos.

#### 📘 Exemplo:

```
2001:0db8:0000:0000:130f:0000:0000:140b
```

Cada bloco pode conter valores de `0000` até `ffff`.

### 🔧 Vantagens:

* Muito mais endereços (virtualmente inesgotáveis).
* Suporte a funcionalidades modernas como:

  * Autoconfiguração automática (sem precisar de DHCP).
  * Segurança embutida (IPsec nativo).
  * Melhor roteamento e desempenho em redes grandes.

---

## 📊 Comparativo Direto

| Característica          | IPv4                          | IPv6                                         |
| ----------------------- | ----------------------------- | -------------------------------------------- |
| Ano de criação          | 1981                          | 1998                                         |
| Tamanho do endereço     | 32 bits                       | 128 bits                                     |
| Quantidade de endereços | \~4,3 bilhões                 | \~340 undecilhões                            |
| Notação                 | Decimal (ex: 192.168.0.1)     | Hexadecimal (ex: 2001\:db8::140b)            |
| Separadores             | Pontos (.)                    | Dois-pontos (:)                              |
| Suporte a segurança     | Opcional (via IPsec)          | Embutido (IPsec nativo)                      |
| Configuração automática | Limitada                      | Suporte nativo (stateless autoconfig)        |
| Compatibilidade         | Antiga (amplamente suportada) | Nova (necessita adaptação de infraestrutura) |

---

## 🧠 Conclusão

* O **IPv4** foi essencial para o início da internet, mas está **ultrapassado em capacidade**.
* O **IPv6** é a evolução natural, projetado para suportar o **crescimento da internet** nas próximas décadas (e talvez séculos!).
* Ambos coexistem atualmente (transição gradual), mas o futuro é do **IPv6**.

---

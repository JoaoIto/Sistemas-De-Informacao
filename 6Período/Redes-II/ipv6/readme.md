# 📘 **Resumo Completo — Endereçamento IPv6 (Grupo 02)**

## 1. Introdução ao IPv6 e Comparação com IPv4

O **Protocolo IPv6 (Internet Protocol version 6)** foi criado para substituir o IPv4, devido à limitação de endereços disponíveis na versão anterior. O IPv4, com seus **32 bits**, permite cerca de **4,3 bilhões** de endereços únicos (2³²), quantidade que se tornou insuficiente com o crescimento exponencial da internet, dispositivos móveis e IoT.

Já o IPv6 utiliza **128 bits**, o que permite um espaço de endereçamento imensamente maior: **2¹²⁸ endereços possíveis** — ou cerca de 340 undecilhões. Esse número astronômico não visa apenas quantidade, mas garante escalabilidade, segurança, segmentação e roteamento eficiente para o futuro da rede global.

---

## 2. Estrutura de um Endereço IPv6

Um endereço IPv6 é representado por **oito grupos de 16 bits** (totalizando 128 bits), separados por dois-pontos (`:`) e escritos em formato **hexadecimal**, utilizando os caracteres de `0` a `9` e de `A` a `F` (ou letras minúsculas equivalentes).

### 📌 Exemplo:

```
2001:0DB8:0000:0000:130F:0000:0000:140B
```

A representação pode ser simplificada com as seguintes regras:

* Omitir **zeros à esquerda** (ex: `0DB8` vira `db8`)
* Representar sequências contínuas de grupos `0000` com `::`, mas **apenas uma vez por endereço**

### 🔎 Exemplo simplificado:

```
2001:db8:0:0:130f::140b
```

⚠️ Atenção: **duplos `::` não podem ocorrer mais de uma vez** num mesmo endereço, para evitar ambiguidade.

---

## 3. Prefixos e URLs com IPv6

O **prefixo** em IPv6 é equivalente ao **CIDR (Classless Inter-Domain Routing)** do IPv4. Ele determina **quantos bits representam a parte da rede**, e os restantes são usados para identificar hosts.

### 🔍 Exemplos:

* Prefixo global: `2001:db8::/32`
* Prefixo de sub-rede: `2001:db8:3003:2::/64`
  Nesse caso, os **64 primeiros bits** definem a rede e os **64 restantes** identificam os hosts.

Na composição de URLs, endereços IPv6 devem ser escritos **entre colchetes**:

📎 Exemplo:

```
http://[2001:12ff:0:4::22]:8080/index.html
```

---

## 4. Sub-redes em IPv6

Diferentemente do IPv4, o IPv6 oferece **grande flexibilidade para subdivisão de redes**. A sub-rede mais comum é do tipo `/64`, que permite cerca de **18 quintilhões (2⁶⁴)** de endereços por sub-rede. Organizações que recebem um bloco maior, como um `/48`, podem subdividi-lo em até **65.536 sub-redes `/64`**.

### 💡 Exemplo prático:

Uma empresa que recebe `2001:db8:abcd::/48` pode criar:

* Sub-rede 1: `2001:db8:abcd:0001::/64`
* Sub-rede 2: `2001:db8:abcd:0002::/64`
* ...
* Sub-rede 100: `2001:db8:abcd:0064::/64`

🔐 **Vantagens das sub-redes:**

* Organização lógica da rede por setores, locais ou departamentos
* Isolamento e segurança interna
* Escalabilidade extrema
* Melhoria no roteamento e gestão de tráfego

---

## 5. Tipos de Endereçamento IPv6

O IPv6 elimina o conceito de **broadcast** e adota três tipos principais de endereçamento:

### 5.1 Unicast

É o envio de pacotes de **um remetente para um único destinatário** específico. A comunicação é ponto a ponto.

#### 🧩 Tipos de Unicast:

* **Global Unicast:**

  * Roteável na internet pública
  * Exemplo: `2001:db8:abcd:0012::1`

* **Link-local Unicast:**

  * Comunicação local em uma única rede física
  * Sempre começa com `fe80::/10`
  * Exemplo: `fe80::1a2b:3c4d:5e6f:7g8h`

* **Unique Local Address (ULA):**

  * Semelhante aos endereços privados do IPv4 (`10.x.x.x`, `192.168.x.x`)
  * Usado apenas dentro de redes internas
  * Começa com `fc00::/7`
  * Exemplo: `fd12:3456:789a::1`

#### 🔍 Exemplo prático de Unicast:

* Computador A: `2001:db8:abcd:0012::10`
* Computador B: `2001:db8:abcd:0012::20`

> A envia dados diretamente para B. O roteamento utiliza o prefixo da rede para localizar o destino.

---

### 5.2 Anycast

Anycast permite atribuir **o mesmo endereço IPv6 a múltiplos nós** (dispositivos), mas os dados são entregues **ao mais próximo** (com menor custo de roteamento).

#### 📦 Aplicações típicas:

* Servidores DNS
* CDNs (Content Delivery Networks)
* Alta disponibilidade e balanceamento de carga

#### 🔍 Exemplo:

Três servidores com o endereço `2001:db8::53` estão localizados no Brasil, Europa e Ásia.
Um cliente no Brasil envia dados para `2001:db8::53`, e o roteador encaminha automaticamente ao **servidor mais próximo** — no caso, o brasileiro.

🧠 **Características:**

* Mesmo endereço em vários locais físicos
* Um destino efetivo por envio
* Não é um tipo distinto de endereço, mas um **unicast configurado como anycast**

---

### 5.3 Multicast

Multicast permite o envio de pacotes **de um remetente para vários destinatários simultaneamente**, desde que façam parte de um **grupo multicast**.

É mais eficiente que unicast ou broadcast para transmissões em grupo, como:

* Streaming de vídeo
* Protocolos de roteamento (ex: OSPFv3)
* Serviços de descoberta (ex: DHCPv6)

#### 📎 Exemplo de grupos multicast:

* `ff02::1` – todos os nós da rede local
* `ff02::2` – todos os roteadores da rede local
* `ff05::1:3` – servidores DHCPv6

🔍 Exemplo prático:
Um roteador envia uma mensagem para `ff02::1`. Todos os dispositivos conectados localmente (PCs, roteadores, impressoras) e inscritos nesse grupo recebem o pacote.

🧠 **Características:**

* Transmissão “um para muitos”
* Substitui o uso de broadcast
* Economiza largura de banda
* Utiliza endereços iniciados por `ff00::/8`

---

## 6. Considerações Finais

O IPv6 representa **um novo paradigma na arquitetura de redes**, oferecendo:

* Expansão quase ilimitada de endereços
* Estrutura hierárquica flexível
* Maior segurança nativa (com IPsec)
* Melhor suporte a mobilidade e IoT
* Eficiência em roteamento e organização

Sua adoção ainda é gradual, mas indispensável para garantir o crescimento sustentável da internet no longo prazo.

---

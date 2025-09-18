# Sistemas Distribuídos — Lista 01 (README)

## Sumário

1. [O que é um Sistema Distribuído?](#1-o-que-é-um-sistema-distribuído)
2. [Principais metas](#2-quais-as-principais-metas-de-um-sistema-distribuído)
3. [Compartilhamento de recursos: vantagens e desvantagens](#3-quais-as-vantagens-e-desvantagens-do-compartilhamento-de-recursos)
4. [Transparência em sistemas distribuídos](#4-o-que-significa-dizer-que-um-sistema-distribuído-é-transparente)
5. [Tipos de transparência](#5-quais-os-tipos-de-transparência-existem-para-sistemas-distribuídos)
6. [Transparência de localização](#6-o-que-caracteriza-a-transparência-de-localização)
7. [Transparência de replicação](#7-o-que-caracteriza-a-transparência-de-replicação)
8. [Transparência de concorrência](#8-o-que-caracteriza-a-transparência-de-concorrência)
9. [Transparência de falha](#9-o-que-caracteriza-a-transparência-de-falha)
10. [Principais tipos de sistemas distribuídos](#10-quais-os-principais-tipos-de-sistemas-distribuídos-diferencie-cada-um)
11. [Classificações dos sistemas de computação](#11-como-são-classificados-os-sistemas-de-computação-distribuídos)
12. [Tipos de sistemas de informação distribuídos](#12-quais-os-tipos-de-sistemas-de-informação-distribuídos)
13. [Estilos arquiteturais](#13-como-são-formulados-os-estilos-arquitetônicos)
14. [Créditos das imagens](#créditos-das-imagens)
15. [Referências do material da disciplina](#referências-do-material-da-disciplina)

---

## 1) O que é um Sistema Distribuído?

Um sistema distribuído é um **conjunto de computadores independentes, interligados por rede**, que para o usuário **aparentam um único sistema coerente**. Em outras palavras: componentes de hardware e software, em máquinas diferentes, **se comunicam e coordenam ações trocando mensagens**.&#x20;

---

## 2) Quais as principais metas de um Sistema Distribuído?

* **Transparência**: esconder a complexidade (acesso, localização, migração, replicação, concorrência e falhas).
* **Compartilhamento de recursos**: hardware, dados, serviços e software.
* **Abertura**: uso de **padrões abertos** para portabilidade e integração.
* **Escalabilidade**: manter desempenho com **mais usuários, regiões e domínios administrativos**.&#x20;

---

## 3) Quais as vantagens e desvantagens do compartilhamento de recursos?

**Vantagens**

* Redução de custo; **reuso** de infraestrutura, código, banco de dados e serviços.
* **Colaboração** e troca de informações facilitadas.&#x20;

**Desvantagens (típicas)**

* **Concorrência** (acessos simultâneos), **consistência** de dados e **sincronização**.
* **Segurança** e **privacidade**.
* **Dependência de rede** e possíveis **gargalos**.

---

## 4) O que significa dizer que um sistema distribuído é transparente?

Significa que o sistema **esconde do usuário** (e até de desenvolvedores) a sua distribuição e complexidade. O acesso a recursos, sua localização, eventuais migrações/replicações, a presença de concorrência e até certas **falhas** acontecem “por trás” sem exigir esforço extra do usuário final.&#x20;

---

## 5) Quais os tipos de transparência existem para sistemas distribuídos?

De acordo com o material, destacam-se: **acesso**, **localização**, **migração**, **replicação**, **concorrência** e **falhas**.&#x20;

---

## 6) O que caracteriza a Transparência de Localização?

O sistema permite **acessar um recurso sem saber onde ele está fisicamente** (ou em qual nó/região). Ex.: uma CDN servir conteúdo do “ponto mais próximo” sem o cliente perceber.&#x20;

> Ilustração (cliente-servidor):
> ![Modelo Cliente-Servidor](https://commons.wikimedia.org/wiki/Special\:FilePath/Client-server-model.svg)

---

## 7) O que caracteriza a Transparência de Replicação?

O sistema mantém **múltiplas cópias (réplicas)** de dados/serviços para **desempenho e disponibilidade**, sem que o cliente precise saber disso. Implica lidar com **consistência** entre réplicas.&#x20;

---

## 8) O que caracteriza a Transparência de Concorrência?

Vários clientes podem **acessar e manipular o mesmo recurso ao mesmo tempo**; o sistema **evita conflitos** (ex.: bloqueios, controle otimista, transações). Para o usuário, isso ocorre de forma **transparente**.&#x20;

---

## 9) O que caracteriza a Transparência de Falha?

O sistema **detecta e contorna falhas** (reativa ou proativamente), mantendo o serviço sempre que possível (ex.: **failover**). Idealmente, o usuário **não percebe** a interrupção.&#x20;

---

## 10) Quais os principais tipos de sistemas distribuídos? Diferencie cada um.

**a) Sistemas de Computação Distribuídos** (foco em **alto desempenho**)

* **Cluster**: várias máquinas similares, em rede, executando aplicações em **paralelo**, com **escalabilidade** e bom custo/benefício.
* **Grid**: **federação** de recursos de **múltiplas organizações**; compartilha servidores, armazenamento, bases de dados e até GPUs/NPUs.
* **Cloud**: provedor oferece **recursos virtualizados** (IaaS/PaaS/SaaS), em nuvem **privada, pública ou híbrida**.&#x20;

**b) Sistemas de Informação Distribuídos** (foco em **aplicações e dados**)

* **Processamento de Transações** (ACID), inclusive **transações distribuídas**.
* **Integração de Aplicações Empresariais** (EAI): **RPC/RMI**, **web services**, **pub-sub**, **microserviços**.&#x20;

**c) Sistemas Pervasivos / IoT**

* **Ubíquos**, **móveis** e **redes de sensores**, hoje agrupados no termo **IoT**.&#x20;

> Ilustração (P2P) — um contraponto ao cliente-servidor:
> ![Rede P2P](https://commons.wikimedia.org/wiki/Special\:FilePath/P2P-network.svg)

---

## 11) Como são classificados os Sistemas de Computação Distribuídos?

O material aborda a evolução das **classificações dos sistemas computacionais** que embasam o cenário distribuído:

* **Sistemas centralizados**;
* **Paralelos fortemente acoplados** (processadores **compartilham a mesma memória** e se comunicam por barramentos internos);
* **Paralelos fracamente acoplados** (maior escala, **conectados por rede**; arquiteturas **cliente-servidor, P2P ou descentralizadas**).&#x20;

---

## 12) Quais os tipos de Sistemas de Informação Distribuídos?

* **Processamento de Transações Distribuídas**: executam “tudo ou nada” (**ACID**), com **subtransações** em servidores diferentes.
* **Integração de Aplicações Empresariais**: **aplicações remotas** compartilham funcionalidades (**RPC**, **RMI**, **pub-sub**, **microserviços**).&#x20;

> Ilustração (pub-sub — exemplo conceitual):
> ![Publish/Subscribe (DDS)](https://commons.wikimedia.org/wiki/Special\:FilePath/DDS%20pub%20sub.png)

---

## 13) Como são formulados os Estilos Arquitetônicos?

Estilos **definem**:

* Como o sistema é **dividido em componentes**;
* Como os componentes **se conectam**;
* **Quais dados** trocam;
* E como são **configurados em conjunto**.

Estilos citados no material: **camadas**, **orientada a objetos/serviços**, **baseada em recursos (REST)** e **publish-subscribe**.&#x20;

> Ilustração (tipos de nuvem — referência visual):
> ![Tipos de Nuvem](https://commons.wikimedia.org/wiki/Special\:FilePath/Cloud%20computing%20types.svg)

---

## Créditos das imagens

* “Client-server model” — Wikimedia Commons. ([Wikimedia Commons][1])
* “P2P-network.svg” — Wikimedia Commons. ([Wikimedia Commons][2])
* “DDS pub sub.png” (Publish/Subscribe) — Wikimedia Commons. ([Wikimedia Commons][3])
* “Cloud computing types.svg” — Wikimedia Commons. ([Wikimedia Commons][4])

> Dica: ao usar no GitHub, os links “Special\:FilePath/…” entregam o **arquivo bruto** (SVG/PNG), o que facilita o embed nas imagens.

---

## Referências do material da disciplina

* **Slide03 — Fundamentação**: definições, metas (transparência/abertura/escalabilidade) e desafios.&#x20;
* **Slide04 — Arquiteturas**: classificações (centralizado, paralelos forte/fraco), **computação distribuída** (cluster, grid, cloud), **SI distribuídos** (transações, EAI) e **estilos arquiteturais**.&#x20;
* **Lista01-SD**: enunciado das questões 1–13.&#x20;

---

### Observações finais

* O objetivo aqui é **clareza**: respostas curtas, com vocabulário direto, e imagens que situam cada conceito.
* Se desejar, podemos adicionar **exemplos práticos** (microserviços com API Gateway, fila de mensagens, cache distribuído, replicação de banco, etc.) e pequenos **diagramas** extras focados no seu projeto.

[1]: https://commons.wikimedia.org/wiki/File%3AClient-server-model.svg?utm_source=chatgpt.com "File:Client-server-model.svg"
[2]: https://commons.wikimedia.org/wiki/File%3AP2P-network.svg?utm_source=chatgpt.com "File:P2P-network.svg"
[3]: https://commons.wikimedia.org/wiki/File%3ADDS_pub_sub.png?utm_source=chatgpt.com "File:DDS pub sub.png"
[4]: https://commons.wikimedia.org/wiki/File%3ACloud_computing_types.svg?utm_source=chatgpt.com "File:Cloud computing types.svg"

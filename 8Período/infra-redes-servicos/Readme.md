# Infraestrutura de Redes como Serviços

## 1. Contextualização da Disciplina

No 8º período do curso de Sistemas de Informação, a disciplina de Infraestrutura de Redes como Serviços ultrapassa os conceitos introdutórios e passa a abordar **arquiteturas modernas**, **desempenho**, **escalabilidade**, **integração com software** e **modelos distribuídos**.

O foco deixa de ser apenas a montagem de redes e passa a envolver:
- Entrega eficiente de serviços
- Arquiteturas orientadas a sistemas distribuídos
- Performance de aplicações
- Integração entre infraestrutura, lógica e programação

A infraestrutura passa a ser tratada como **parte estratégica do software**.

---

## 2. Infraestrutura Orientada a Serviços e Aplicações

A infraestrutura moderna não é mais isolada do desenvolvimento. Ela é projetada considerando o comportamento da aplicação, o volume de acesso e a necessidade de escalabilidade.

### 2.1 Infraestrutura como extensão da aplicação

- Redes são projetadas para atender fluxos de dados específicos
- Segurança é aplicada conforme o contexto da aplicação
- Escalabilidade é planejada junto ao código
- Infraestrutura acompanha o ciclo de vida do software

Esse modelo é conhecido como **Infrastructure-Aware Application Design**.

---

## 3. Performance em Infraestruturas de Serviços

Performance é um dos pilares da infraestrutura moderna e está diretamente relacionada à experiência do usuário e à eficiência dos sistemas.

### 3.1 Métricas de performance relevantes

| Métrica | Descrição |
|------|-----------|
| Latência | Tempo de resposta |
| Throughput | Volume de dados transmitidos |
| Disponibilidade | Tempo de serviço ativo |
| Consumo de recursos | CPU, memória, rede |
| Tempo de provisionamento | Agilidade da infraestrutura |

A análise de performance deve considerar **infraestrutura, rede e aplicação** como um conjunto.

---

## 4. Escalabilidade de Serviços

Escalabilidade é a capacidade de um sistema crescer sem perda significativa de desempenho.

### 4.1 Tipos de escalabilidade

| Tipo | Característica |
|----|----------------|
| Vertical | Aumento de recursos em um único nó |
| Horizontal | Adição de novos nós |
| Automática | Ajuste dinâmico conforme demanda |
| Programável | Controlada por regras e código |

Ambientes modernos priorizam **escalabilidade horizontal**, principalmente em arquiteturas distribuídas.

---

## 5. Arquitetura de Microsserviços

Microsserviços representam um modelo arquitetural no qual aplicações são divididas em serviços pequenos, independentes e especializados.

### 5.1 Características dos microsserviços

- Serviços independentes
- Comunicação via rede
- Escalabilidade individual
- Implantação isolada
- Falhas controladas

Cada microsserviço possui sua própria lógica, banco de dados e ciclo de vida.

---

## 6. Comunicação entre Microsserviços

A comunicação é um dos principais desafios dessa arquitetura.

### 6.1 Modelos de comunicação

| Modelo | Descrição |
|-----|-----------|
| HTTP/REST | Simples e amplamente utilizado |
| gRPC | Alta performance |
| Mensageria | Comunicação assíncrona |
| Event-driven | Baseado em eventos |

A infraestrutura de rede deve suportar **baixa latência, alta disponibilidade e tolerância a falhas**.

---

## 7. Balanceamento de Carga e Alta Disponibilidade

O balanceamento de carga é essencial para performance e escalabilidade.

### 7.1 Funções do balanceador

- Distribuir requisições
- Evitar sobrecarga
- Garantir continuidade
- Redirecionar falhas

Em ambientes corporativos e de nuvem, o balanceamento é integrado à infraestrutura como serviço.

---

## 8. Infraestrutura Lógica e Programável

Infraestruturas modernas são **definidas por software**.

### 8.1 Conceitos de infraestrutura programável

- Software Defined Networking (SDN)
- Infraestrutura como Código (IaC)
- Automação de provisionamento
- Configuração declarativa

Nesse modelo, redes, serviços e políticas são gerenciados por código, reduzindo erros humanos.

---

## 9. Integração com Programação

O profissional de Sistemas de Informação precisa compreender a relação direta entre código e infraestrutura.

### 9.1 Pontos de integração

- APIs de infraestrutura
- Configuração de serviços por código
- Monitoramento via aplicação
- Observabilidade integrada

A infraestrutura deixa de ser apenas operacional e passa a ser **parte do desenvolvimento de software**.

---

## 10. Observabilidade e Monitoramento Avançado

Monitorar não é apenas verificar se o serviço está ativo, mas entender seu comportamento.

### 10.1 Componentes da observabilidade

| Elemento | Função |
|-------|--------|
| Logs | Registro de eventos |
| Métricas | Dados quantitativos |
| Traces | Caminho das requisições |
| Alertas | Notificação de falhas |

A observabilidade é essencial em sistemas distribuídos.

---

## 11. Resiliência e Tolerância a Falhas

Sistemas modernos são projetados assumindo que falhas ocorrerão.

### 11.1 Estratégias de resiliência

- Redundância
- Isolamento de falhas
- Circuit breaker
- Retry controlado
- Fallback de serviços

Essas estratégias dependem diretamente da infraestrutura de rede e serviços.

---

## 12. Segurança Integrada à Arquitetura

A segurança é aplicada em múltiplas camadas.

### 12.1 Segurança em ambientes distribuídos

- Segmentação lógica
- Autenticação entre serviços
- Criptografia em trânsito
- Monitoramento contínuo
- Políticas automatizadas

A segurança acompanha a lógica da aplicação e não apenas o perímetro da rede.

---

## 13. Infraestrutura em Ambientes Corporativos Avançados

Organizações utilizam infraestrutura como serviço para:
- Sustentar aplicações críticas
- Atender picos de demanda
- Garantir disponibilidade contínua
- Reduzir dependência de hardware físico

A tomada de decisão envolve **aspectos técnicos, estratégicos e financeiros**.

---

## 14. Conclusão

A disciplina de Infraestrutura de Redes e Serviços, no 8º período de Sistemas de Informação, consolida a formação do aluno ao integrar **infraestrutura, programação e arquitetura de sistemas**.

O profissional formado deve ser capaz de:
- Projetar sistemas escaláveis
- Analisar performance
- Integrar infraestrutura ao código
- Garantir disponibilidade e segurança
- Tomar decisões técnicas baseadas em arquitetura

Essa visão integrada é essencial para atuar em ambientes corporativos modernos e complexos.

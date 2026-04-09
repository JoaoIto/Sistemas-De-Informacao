# Central de Serviços - Projeto BBTS

O projeto visa criar uma Central de Serviços baseada em ITIL v4 para gerenciar essa nova infraestrutura em mais de 40 localidades da BBTS.

---

## Documentação Técnica: Infraestrutura de Rede, Continuidade Energética e PCN

 **Projeto:** Central de Serviços de Infraestrutura de Redes (BBTS) [cite: 256, 257]
 **Responsável pelo Módulo:** João Victor [cite: 189, 197, 201, 207]
 **Módulos Abordados:** 09 (Infraestrutura de Rede) e 10 (Continuidade Energética e PCN) [cite: 186, 187, 198, 199]

---

## 1. Infraestrutura de Rede Externa e Redundância
 Para garantir a disponibilidade da Central de Serviços e o funcionamento contínuo da controladora em nuvem (SaaS), todas as localidades exigem redundância de acesso à internet[cite: 350].

### 1.1. Matriz de Conectividade por Localidade
*  **Sede e Data Centers (ex: Brasília, Piraí):** Utilizam link primário de fibra dedicada (Operadora A) e link secundário de fibra dedicada (Operadora B)[cite: 191, 354].  O failover ocorre de forma automática via SD-WAN[cite: 191, 354].
*  **Filiais e CEMANS (ex: RJ, SP, Curitiba):** Contam com link primário de fibra (Operadora A) e um link secundário 4G/5G (Operadora C)[cite: 191, 354].  O failover também é automático via roteador[cite: 191, 354].
*  **CATs menores (ex: Palmas, Natal):** Utilizam link primário em fibra (Operadora A) e backup 4G/5G[cite: 191, 354].  Nestes cenários, o failover é manual, sendo necessária a ativação pelo nível N2[cite: 191, 354].

### 1.2. Requisitos Críticos de Diversidade e SLA
*  **Diversidade Física (Last Mile):** Os cabos de operadoras distintas devem seguir caminhos físicos independentes, como dutos ou rotas separadas[cite: 194, 356].
*  **Entrada em Data Centers:** A entrada dos cabos deve ocorrer por lados opostos do prédio, com os distribuidores (DIOs) mantidos separados fisicamente[cite: 194, 357].
*  **Gestão de Failover:** Onde há SD-WAN ou roteamento dinâmico (BGP), a transição entre links deve ocorrer em menos de 30 segundos, sem a necessidade de intervenção manual[cite: 195, 360, 363].
*  **Acordos com Operadoras:** O SLA contratual com as operadoras de telecomunicações deve garantir disponibilidade igual ou superior a 99,5%, com um Tempo Médio de Reparo (MTTR) máximo de 4 horas para os links dedicados[cite: 195, 358].

---

## 2. Continuidade Energética
 A infraestrutura de rede Wi-Fi depende da alimentação elétrica (PoE) para os pontos de acesso (APs) e switches[cite: 64, 365].  Para mitigar interrupções, existem proteções baseadas na criticidade de cada local[cite: 366].

### 2.1. Matriz de Proteção Elétrica
*  **Sede e Data Centers:** Possuem No-break (UPS) redundante (N+1) e gerador a diesel com partida automática[cite: 203, 368].  A autonomia mínima exigida é de 72 horas para o gerador e 30 minutos para o UPS[cite: 203, 368].
*  **Filiais e CEMANS:** Contam com UPS centralizado e gerador a diesel de partida automática[cite: 203, 368].  Garantem autonomia de 24 horas no gerador e 15 minutos no UPS[cite: 203, 368].
*  **CATs menores:** Possuem apenas UPS focado no rack de rede, entregando 15 minutos de autonomia para viabilizar o shutdown ordenado dos equipamentos[cite: 203, 368].  A presença de gerador é opcional[cite: 203, 368].

### 2.2. Delimitação de Responsabilidades
*  **Eventos Externos:** As quedas de energia causadas pela concessionária externa não são de responsabilidade da Central de Serviços ou da contratada que forneceu o Wi-Fi[cite: 205, 366, 370].  A BBTS assume o risco da infraestrutura elétrica[cite: 371, 390].
*  **Atuação do N1:** Caso os APs sejam desligados por falta de energia, a controladora registrará o evento de forma automática[cite: 205, 373].  Antes de realizar o escalonamento para o N2, o analista de N1 deve verificar se a localidade está sem energia elétrica[cite: 205, 374].

---

## 3. Plano de Continuidade de Negócios (PCN)
 O PCN estabelece as diretrizes e ações de contingência para garantir que os serviços mínimos continuem operando mesmo em cenários de desastre ou indisponibilidade sistêmica[cite: 394, 395].

*  **Indisponibilidade do Sistema de Chamados (SysAid):** Caso o ITSM fique fora do ar, o registro de chamados ocorrerá por meio de planilhas emergenciais e e-mails[cite: 205, 397].  A inserção dos dados no sistema será feita de forma retroativa após o restabelecimento[cite: 397].
*  **Indisponibilidade da Controladora em Nuvem:** Se a gerência centralizada cair, os pontos de acesso (APs) continuarão operando offline de forma temporária, utilizando as configurações armazenadas em cache[cite: 205, 397, 400].  O nível N3 (fabricante) deve ser acionado imediatamente[cite: 400].
*  **Desastre ou Falha na Sede:** Em caso de queda de energia total ou desastre na sede (onde opera a Central), a equipe realizará o atendimento remotamente, conectando-se via VPN a partir de qualquer localidade com internet[cite: 205, 397].  Em situações extremas, chamados podem ser desviados para localidades próximas[cite: 400].

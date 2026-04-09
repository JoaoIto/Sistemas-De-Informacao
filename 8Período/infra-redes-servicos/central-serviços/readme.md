# Central de Serviços - Projeto BBTS

O projeto visa criar uma Central de Serviços baseada em ITIL v4 para gerenciar a infraestrutura em mais de 40 localidades da BBTS[cite: 3981, 3992]. O cenário abrange a modernização da rede sem fio corporativa por meio da aquisição de 156 pontos de acesso Wi-Fi 6, gerenciados por uma controladora em nuvem (SaaS), com licenças e garantia de 60 meses[cite: 3983].

---

## Documentação Técnica: Infraestrutura de Rede, Continuidade Energética e PCN

* **Projeto:** Central de Serviços de Infraestrutura de Redes (BBTS) [cite: 3970]
* **Módulos Abordados:** 09 (Infraestrutura de Rede e Redundância) e 10 (Continuidade Energética e PCN) [cite: 3900, 3912]

---

## 1. Infraestrutura de Rede Externa e Redundância

Para garantir a disponibilidade da Central de Serviços e o funcionamento contínuo da controladora em nuvem (SaaS), cada localidade da BBTS deve contar com redundância de acesso à internet[cite: 4063].

### 1.1. Matriz de Conectividade por Localidade
* **Sede e Data Centers (ex: Brasília, Piraí, Verbo Divino):** Utilizam link primário de fibra dedicada (Operadora A) e link secundário de fibra dedicada (Operadora B)[cite: 4067]. O failover ocorre de forma automática via SD-WAN[cite: 4067].
* **Filiais e CEMANS (ex: RJ, SP, Curitiba, Goiânia):** Contam com link primário de fibra (Operadora A) e um link secundário 4G/5G (Operadora C)[cite: 4067]. O failover também é automático via roteador[cite: 4067].
* **CATs menores (ex: Palmas, Porto Velho, Natal):** Utilizam link primário em fibra (Operadora A) e um link 4G/5G de backup[cite: 4067]. Nestes cenários, o failover é manual, sendo necessária a ativação pelo nível N2[cite: 4067].

### 1.2. Requisitos Críticos de Diversidade e SLA
* **Diversidade Física (Last Mile):** Os cabos das duas operadoras devem seguir caminhos físicos distintos, como dutos, postes ou rotas subterrâneas diferentes[cite: 4069]. Isso elimina o ponto único de falha no último trecho[cite: 4069].
* **Entrada em Data Centers:** A entrada de cabos deve ocorrer por lados opostos do prédio, terminando em caixas de emenda e DIO (Distribuidor Interno Óptico) separados fisicamente[cite: 4070].
* **Gestão de Failover:** Onde há SD-WAN ou roteamento dinâmico (BGP multihoming), a transição entre links deve ocorrer em menos de 30 segundos, sem a necessidade de intervenção manual e sem a perda de sessões da controladora em nuvem[cite: 4073, 4076].
* **Acordos com Operadoras:** O SLA contratual com as operadoras de telecomunicações deve garantir uma disponibilidade igual ou superior a 99,5%, com um Tempo Máximo de Reparo (MTTR) menor ou igual a 4 horas para os links dedicados[cite: 4071].

---

## 2. Continuidade Energética

A disponibilidade da rede Wi-Fi corporativa depende diretamente da alimentação elétrica (PoE) para os pontos de acesso e para os switches de distribuição[cite: 4078]. Para mitigar as interrupções, existem proteções baseadas na criticidade de cada local[cite: 4079].

### 2.1. Matriz de Proteção Elétrica
* **Sede e Data Centers:** Possuem No-break (UPS) redundante (N+1) e gerador a diesel com partida automática[cite: 4081]. A autonomia mínima exigida é de 72 horas para o gerador e 30 minutos para o UPS[cite: 4081].
* **Filiais e CEMANS:** Contam com UPS centralizado e gerador a diesel de partida automática[cite: 4081]. Garantem autonomia de 24 horas no gerador e 15 minutos no UPS[cite: 4081].
* **CATs menores:** Possuem apenas UPS focado no rack de rede, entregando 15 minutos de autonomia para viabilizar o shutdown ordenado dos equipamentos[cite: 4081]. A presença de gerador, nestes locais, é opcional e sob análise[cite: 4081].

### 2.2. Delimitação de Responsabilidades
* **Eventos Externos:** As quedas de energia causadas pela concessionária externa não são de responsabilidade da Central de Serviços nem da contratada fornecedora dos APs[cite: 4083]. A BBTS assume o risco e é a responsável pela infraestrutura elétrica de suas localidades[cite: 4084].
* **Falhas Internas Prediais:** A falha de equipamentos como UPS ou gerador é classificada como um incidente da gestão de facilidades (predial)[cite: 4085]. O registro ocorre no SysAid como "Incidente de Infraestrutura Predial", ficando fora do escopo de atendimento N1/N2 da Central de Redes[cite: 4085].
* **Atuação do N1:** Caso os APs sejam desligados por falta de energia, a controladora em nuvem registra o evento automaticamente como "AP offline"[cite: 4086]. Ao abrir o chamado no SysAid, o analista de N1 deve primeiro verificar se há queda de energia na localidade antes de realizar o escalonamento para o N2[cite: 4087].

---

## 3. Plano de Continuidade de Negócios (PCN)

A Central de Serviços deve possuir um plano de contingência para manter o atendimento mesmo em situações adversas extremas[cite: 4108].

* **Indisponibilidade do Sistema de Chamados (SysAid):** Caso o ITSM fique fora do ar, o registro de chamados ocorrerá por meio de registros manuais em planilhas emergenciais[cite: 4110]. A inserção dos dados no sistema será feita de forma retroativa após o restabelecimento[cite: 4110].
* **Indisponibilidade da Controladora em Nuvem:** Se o gerenciamento centralizado cair, os pontos de acesso (APs) continuarão operando offline de forma temporária, utilizando as configurações armazenadas em cache[cite: 4110, 4113]. O contato com o fabricante (N3 imediato) deve ser feito[cite: 4113].
* **Desastre ou Falha na Sede (Brasília):** Em caso de falha de energia, o gerador automático assume em menos de 10 segundos[cite: 4110]. Se houver uma falha total impeditiva, a equipe operará remotamente via VPN a partir de qualquer localidade com internet[cite: 4110].
* **Desastre Natural em Localidade:** Se uma localidade inteira for comprometida, haverá o desvio de chamados para a localidade mais próxima, seguido pelo acionamento do seguro e do plano de recuperação[cite: 4113].

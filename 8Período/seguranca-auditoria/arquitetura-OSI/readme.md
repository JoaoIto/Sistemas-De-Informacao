# Fundamentos de Segurança da Informação e Arquitetura OSI

Este documento apresenta uma visão estruturada dos conceitos de segurança de redes, baseada na recomendação ITU-T X.800 (Arquitetura de Segurança OSI) e nas definições fundamentais de William Stallings.

O objetivo é fornecer uma base teórica sólida sobre como proteger o fluxo de informações, categorizar ameaças e aplicar serviços de defesa.

---

## 1. Conceitos Fundamentais (A Tríade CIA)

A segurança da informação baseia-se em três objetivos principais, conhecidos como a Tríade CIA. Adicionalmente, o padrão OSI e Stallings incluem mais dois conceitos essenciais.

### 1.1 Confidencialidade
Garante que a informação não seja disponibilizada ou divulgada a indivíduos, entidades ou processos não autorizados.
* **Confidencialidade dos dados:** Proteção do conteúdo da mensagem.
* **Privacidade:** Controle sobre quais informações pessoais são coletadas e armazenadas.

### 1.2 Integridade
Garante que os dados não foram alterados ou destruídos de forma não autorizada.
* **Integridade dos dados:** Garantia de que o conteúdo da mensagem não foi modificado durante a transmissão.
* **Integridade do sistema:** Garantia de que o sistema executa suas funções de maneira intocada, livre de manipulação externa.

### 1.3 Disponibilidade
Garante que os sistemas e dados estejam acessíveis e utilizáveis sob demanda por entidades autorizadas. Um sistema seguro deve estar operacional quando necessário.

### 1.4 Conceitos Adicionais
* **Autenticidade:** A propriedade de ser genuíno e verificável. Garante que a mensagem vem de onde diz vir.
* **Responsabilização (Accountability):** Capacidade de rastrear ações de segurança até um indivíduo específico (essencial para auditoria e não-repúdio).

---

## 2. A Arquitetura de Segurança OSI (ITU-T X.800)

A arquitetura de segurança OSI (Open Systems Interconnection) fornece uma maneira sistemática de definir requisitos de segurança. Ela não dita *como* implementar, mas *o que* deve ser protegido. Ela é dividida em três conceitos interligados:

1.  **Ataques de Segurança:** Qualquer ação que comprometa a segurança das informações.
2.  **Mecanismos de Segurança:** Métodos usados para detectar, prevenir ou recuperar-se de um ataque.
3.  **Serviços de Segurança:** Serviços que melhoram a segurança dos sistemas de processamento e transferência de dados, utilizando um ou mais mecanismos.

---

## 3. Classificação dos Ataques de Segurança

Os ataques são categorizados com base na natureza da interação do atacante com a rede.



### 3.1 Ataques Passivos
Nestes ataques, o objetivo do oponente é obter informações que estão sendo transmitidas. **Não há alteração dos dados**. O remetente e o destinatário geralmente não percebem que estão sendo atacados.

* **Liberação de Conteúdo da Mensagem (Eavesdropping):**
    * *Descrição:* O atacante escuta a transmissão e captura informações sensíveis (senhas, e-mails).
    * *Exemplo:* Alice envia um e-mail confidencial para Bob; Darth intercepta e lê o e-mail, mas o deixa seguir para Bob.
* **Análise de Tráfego:**
    * *Descrição:* Mesmo que o conteúdo esteja criptografado (ilegível), o atacante observa o padrão das mensagens.
    * *Objetivo:* Determinar a localização, identidade dos comunicantes, frequência e tamanho das mensagens para deduzir a natureza da comunicação.

> **Nota Crítica:** Ataques passivos são difíceis de **detectar** (pois não deixam rastros nos dados), mas podem ser **prevenidos** (ex: via criptografia).

### 3.2 Ataques Ativos
Nestes ataques, o oponente tenta alterar os recursos do sistema ou afetar sua operação. Envolvem a modificação do fluxo de dados ou a criação de um fluxo falso.

* **Mascaramento (Masquerade):**
    * *Descrição:* Uma entidade finge ser outra entidade autorizada para ganhar privilégios extras.
    * *Exemplo:* Darth captura as credenciais de autenticação de Alice e envia mensagens para Bob como se fosse Alice.
* **Replay (Reencaminhamento):**
    * *Descrição:* Captura passiva de uma unidade de dados e sua retransmissão subsequente para produzir um efeito não autorizado.
    * *Exemplo:* Darth copia uma mensagem criptografada de "Transferir R$100 para Darth" enviada por Alice e a reenvia 50 vezes para o banco.
* **Modificação de Mensagem:**
    * *Descrição:* Uma parte de uma mensagem legítima é alterada, atrasada ou reordenada.
    * *Exemplo:* Alice envia "Permitir acesso a Pedro"; Darth altera para "Permitir acesso a Darth".
* **Negação de Serviço (DoS - Denial of Service):**
    * *Descrição:* Impede ou inibe o uso normal das instalações de comunicação.
    * *Exemplo:* Darth inunda o servidor de Bob com pedidos, impedindo que Alice consiga se comunicar com Bob.

> **Nota Crítica:** Ataques ativos são difíceis de **prevenir** completamente, então o foco é na **detecção** e recuperação.

---

## 4. Serviços de Segurança (X.800)

A norma X.800 define cinco categorias principais de serviços que um sistema deve prover para garantir segurança adequada:

1.  **Autenticação:** Garante que a entidade de comunicação é quem diz ser.
    * *Autenticação de Entidade:* Verifica a identidade no início da conexão (ex: Login).
    * *Autenticação de Origem de Dados:* Verifica a fonte de uma unidade de dados específica (ex: E-mail).
2.  **Controle de Acesso:** Limita e controla o acesso a sistemas e aplicações via links de comunicação. Define quem pode fazer o quê.
3.  **Confidencialidade de Dados:** Protege os dados contra divulgação não autorizada. Pode ser aplicado a toda a mensagem, campos específicos ou ao fluxo de tráfego.
4.  **Integridade de Dados:** Garante que os dados recebidos são exatamente os enviados por uma entidade autorizada (sem modificação, inserção ou exclusão).
5.  **Não-Repúdio (Irretratabilidade):** Impede que o remetente ou o destinatário neguem ter transmitido ou recebido uma mensagem.
    * *Exemplo:* Assinatura Digital prova que Alice enviou a mensagem, logo ela não pode negar o envio.

---

## 5. Modelo Geral de Segurança de Rede

Para implementar segurança, utilizamos um modelo operacional padrão:

1.  **O Principal (Sender):** Quem envia a informação.
2.  **O Canal:** O meio inseguro (Internet) por onde os dados trafegam.
3.  **O Oponente:** O hacker ou software malicioso no canal.
4.  **A Transformação Segura:** A técnica aplicada (como criptografia) que torna a informação ilegível para o oponente.
5.  **Informação Secreta (Chave):** Um dado compartilhado apenas entre Sender e Receiver, necessário para a transformação.



---

## 6. Tabela Referência de Conceitos e Práticas

Esta tabela resume os termos técnicos, suas definições e o contexto prático de aplicação.

| Termo / Conceito | Definição Simplificada | Contexto de Uso | O que é necessário para aplicar? |
| :--- | :--- | :--- | :--- |
| **Ataque Passivo** | Monitoramento sem alteração. | Espionagem industrial, roubo de credenciais via sniffing. | Ferramentas de captura de pacotes. Defesa: Criptografia forte. |
| **Ataque Ativo** | Modificação ou criação de dados falsos. | Fraudes bancárias, derrubada de sites (DDoS), injeção de dados. | Acesso à rede. Defesa: Firewalls, IPS, Autenticação forte. |
| **Criptografia (Encipherment)** | Mecanismo que torna os dados ilegíveis. | Garantir a **Confidencialidade**. Usado em HTTPS, VPNs. | Algoritmos matemáticos e Chaves (Públicas ou Privadas). |
| **Assinatura Digital** | Dados anexados que garantem origem. | Garantir **Autenticação**, **Integridade** e **Não-Repúdio**. | Par de chaves criptográficas e função de Hash. |
| **Controle de Acesso** | Restrição de permissões. | Limitar quem pode ver/editar arquivos em uma rede. | Identificação do usuário (Login) e Lista de Controle (ACL). |
| **Integridade de Dados** | Verificação de não-alteração. | Assegurar que um download não está corrompido. | Algoritmos de Hash (ex: SHA-256) ou códigos de verificação. |
| **Traffic Padding** | Inserção de dados "lixo" no tráfego. | Evitar **Análise de Tráfego** (esconder padrões). | Gerador de dados aleatórios para preencher lacunas na rede. |
| **Routing Control** | Seleção de rotas seguras. | Evitar que dados sensíveis passem por redes não confiáveis. | Configuração de roteadores e políticas de rede. |

---

## 7. Práticas Básicas de Segurança (Conclusão)

Baseado na arquitetura apresentada, a segurança eficaz não depende de uma única ferramenta, mas de camadas:

1.  **Previna o passivo:** Criptografe tudo (dados em repouso e em trânsito).
2.  **Detecte o ativo:** Use sistemas de detecção de intrusão (IDS) e logs de auditoria.
3.  **Garanta a identidade:** Use autenticação forte (Múltiplo Fator) para evitar Mascaramento.
4.  **Mantenha a integridade:** Use Hashes e Assinaturas Digitais para validar documentos e softwares críticos.

---

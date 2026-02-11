# Fundamentos de Segurança da Rede e Arquitetura OSI

Este documento consolida os conceitos essenciais de segurança da informação baseados na literatura de **William Stallings** e na recomendação **ITU-T X.800 (Arquitetura de Segurança OSI)**.

O objetivo é fornecer uma base teórica estruturada sobre ataques, serviços e mecanismos de defesa.

---

## 1. A Tríade CIA e Conceitos Fundamentais

A segurança da informação apoia-se em três pilares principais (CIA), expandidos posteriormente para incluir Autenticidade e Responsabilização.

### 1.1 Confidencialidade
Garante que a informação não seja revelada a indivíduos ou processos não autorizados.
* **Confidencialidade dos dados:** O conteúdo da mensagem é ilegível para terceiros.
* **Privacidade:** O controle sobre *quais* dados são coletados e *quem* pode acessá-los.

### 1.2 Integridade
Garante que os dados mantenham sua precisão e consistência, sem alterações indevidas.
* **Integridade dos dados:** O conteúdo não foi modificado (inserção, remoção ou alteração) durante o trânsito.
* **Integridade do sistema:** O sistema opera conforme esperado, sem manipulação externa.

### 1.3 Disponibilidade
Garante que os recursos do sistema estejam acessíveis e utilizáveis sob demanda por entidades autorizadas. Um sistema seguro que não funciona é inútil.

### Tabela Comparativa: A Tríade CIA

| Conceito | Foco Principal | Exemplo de Violação | Mecanismo de Defesa |
| :--- | :--- | :--- | :--- |
| **Confidencialidade** | Sigilo / Leitura | Alguém lê seu e-mail privado. | Criptografia (Encipherment). |
| **Integridade** | Alteração / Escrita | Alguém muda o valor de um boleto. | Hashing / Assinatura Digital. |
| **Disponibilidade** | Acesso / Tempo | O site cai e ninguém consegue logar. | Redundância / Proteção DDoS. |

---

## 2. A Arquitetura de Segurança OSI (X.800)

A norma X.800 fornece um esqueleto para a segurança de redes, organizando o tema em três categorias interligadas.

1.  **Ataques de Segurança:** Qualquer ação que comprometa a segurança das informações.
2.  **Mecanismos de Segurança:** As ferramentas (algoritmos, protocolos) usadas para detectar ou prevenir o ataque.
3.  **Serviços de Segurança:** As soluções oferecidas pelo sistema (que usam os mecanismos) para proteger os dados.

### Tabela Comparativa: Estrutura X.800

| Categoria | Pergunta que responde | Exemplo Prático |
| :--- | :--- | :--- |
| **Ataque** | *Qual é a ameaça?* | Um hacker tentando ler a senha (Sniffing). |
| **Mecanismo** | *Qual a ferramenta técnica?* | Algoritmo de Criptografia AES-256. |
| **Serviço** | *O que o sistema entrega?* | Confidencialidade de Dados (Email seguro). |

---

## 3. Classificação dos Ataques de Segurança

Os ataques são divididos pela forma como o intruso interage com a rede.



### 3.1 Ataques Passivos
O atacante apenas **monitora** a transmissão. O objetivo é obter informação. Não há alteração nos dados, o que torna a detecção muito difícil.

* **Liberação de Conteúdo (Eavesdropping):** Captura de dados sensíveis (senhas, e-mails).
* **Análise de Tráfego:** Observação de padrões (quem fala com quem, frequência, tamanho dos pacotes) para deduzir informações, mesmo que os dados estejam criptografados.

> **Regra de Ouro:** Ataques passivos são difíceis de detectar, mas fáceis de prevenir (com criptografia).

### 3.2 Ataques Ativos
O atacante **interfere** na transmissão. Envolve alteração, criação ou bloqueio de dados.

* **Mascaramento (Masquerade):** Fingir ser outra entidade para ganhar privilégios.
* **Replay (Reencaminhamento):** Capturar uma mensagem legítima e reenviá-la depois (ex: reenviar uma ordem de pagamento).
* **Modificação de Mensagem:** Alterar parte de uma mensagem legítima (mudar "Pague João" para "Pague Darth").
* **Negação de Serviço (DoS):** Sobrecarregar o sistema para impedir o uso legítimo.

> **Regra de Ouro:** Ataques ativos são difíceis de prevenir completamente, então o foco é na detecção e recuperação.

### Tabela Comparativa: Ataques Passivos vs. Ativos

| Característica | Ataque Passivo | Ataque Ativo |
| :--- | :--- | :--- |
| **Ação do Atacante** | Escutar / Monitorar. | Alterar / Criar / Bloquear. |
| **Impacto nos Dados** | Nenhum (dados chegam intactos). | Dados alterados ou perdidos. |
| **Percepção da Vítima** | Geralmente não percebe. | Percebe erros ou lentidão. |
| **Estratégia de Defesa** | **Prevenção** (Criptografia). | **Detecção** e Recuperação. |
| **Exemplos** | Escuta telefônica, Análise de tráfego. | DDoS, Phishing, Injeção de dados. |

---

## 4. Tipos de Autenticação (Detalhamento)

Dentro dos Serviços de Segurança, a Autenticação é crítica. A norma X.800 a divide em dois tipos, dependendo se existe uma conexão contínua ou não.

### 4.1 Autenticação de Entidade Pareada (Peer Entity)
Usada em comunicações **orientadas a conexão** (ex: TCP).
* **Conceito:** Garante a identidade da entidade com a qual se está conectado *em tempo real*.
* **Proteção:** Confirma que não há um impostor na linha e que a conexão não é uma gravação antiga (Replay).

### 4.2 Autenticação de Origem de Dados (Data Origin)
Usada em comunicações **sem conexão** (ex: UDP, E-mail).
* **Conceito:** Garante que um pacote específico veio da origem alegada.
* **Limitação:** Não garante que o pacote chegou na ordem certa ou que não é uma cópia, pois não há uma "sessão" ativa controlando o fluxo.

### Tabela Comparativa: Tipos de Autenticação

| Característica | Entidade Pareada (Peer Entity) | Origem de Dados (Data Origin) |
| :--- | :--- | :--- |
| **Cenário de Uso** | Conexão ao vivo (Login, Chat). | Mensagem única (E-mail, Carta). |
| **Fator Tempo** | Tempo Real (Síncrono). | Assíncrono (Pode chegar dias depois). |
| **Proteção Anti-Replay** | **Sim** (Detecta repetição). | **Não** (Não detecta duplicação). |
| **Garantia** | "Estou falando com Alice agora." | "Esta carta foi escrita por Alice." |

---

## 5. Modelo Geral de Segurança de Rede

Para proteger uma comunicação, assume-se o seguinte fluxo lógico:

1.  **Mensagem:** O dado original (texto claro).
2.  **Segredo (Chave):** Uma informação compartilhada apenas entre remetente e destinatário.
3.  **Transformação Segura:** Um algoritmo que usa a Chave para embaralhar a Mensagem.
4.  **Canal Inseguro:** A internet, onde o **Oponente** (Hacker) está escutando.



### Tabela Comparativa: Componentes do Modelo

| Componente | Função | Exemplo Prático |
| :--- | :--- | :--- |
| **Plaintext** | A informação original legível. | "Senha123". |
| **Ciphertext** | A informação ilegível após transformação. | "Xy9#kL@m". |
| **Algoritmo** | A fórmula matemática da transformação. | AES, RSA. |
| **Chave** | O segredo único que controla o algoritmo. | Um arquivo `.pem` ou senha mestra. |

---

## 6. Resumo Mestre: Conceitos, Ameaças e Soluções

Esta tabela final serve como guia rápido para identificar o problema e a solução correta na arquitetura de segurança.

| Conceito de Segurança | Tipo de Ameaça (O Ataque) | Contexto do Ataque | Solução Técnica (Mecanismo) |
| :--- | :--- | :--- | :--- |
| **Confidencialidade** | **Eavesdropping** (Escuta) | Atacante lê dados trafegando na rede Wi-Fi. | **Criptografia** (Simétrica ou Assimétrica). |
| **Confidencialidade** | **Traffic Analysis** | Atacante observa para quem você envia e-mails. | **Traffic Padding** (Inserção de dados lixo). |
| **Autenticidade** | **Masquerade** (Mascaramento) | Atacante rouba senha e loga como Admin. | **Assinatura Digital** ou Autenticação de Dois Fatores (2FA). |
| **Integridade** | **Modification** (Modificação) | Atacante altera valor de transação bancária. | **Hash** (Resumo Criptográfico) ou MAC (Message Authentication Code). |
| **Disponibilidade** | **Denial of Service** (DoS) | Atacante derruba o servidor com excesso de pedidos. | Firewalls, Balanceadores de Carga, IPS. |
| **Não-Repúdio** | **Repudation** (Negação) | Remetente diz que não enviou o contrato assinado. | **Assinatura Digital** (com Chave Privada). |
| **Controle de Acesso** | **Unauthorized Access** | Usuário comum tenta acessar pasta do RH. | **ACLs** (Listas de Controle de Acesso) e Matrizes de Permissão. |

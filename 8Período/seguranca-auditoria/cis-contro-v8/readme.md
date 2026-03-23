# CIS Controls v8 e a Arquitetura de Defesa em Profundidade

O *Center for Internet Security* (CIS) Controls é um framework de melhores práticas focado em ações prioritárias de defesa cibernética. A versão 8 foi desenhada para refletir o ecossistema atual: redes descentralizadas, adoção massiva de nuvem (Cloud Computing) e trabalho remoto.



## 1. A Estrutura Fundamental: Grupos de Implementação (IGs)

O CIS v8 não exige que todas as empresas apliquem todas as regras no primeiro dia. Ele divide as suas **153 Salvaguardas** (antigos subcontroles) em três Grupos de Implementação (Implementation Groups), criando uma trilha de maturidade.

| Grupo de Implementação | Perfil e Foco | Número de Salvaguardas |
| :--- | :--- | :--- |
| **IG1 (Higiene Básica)** | O padrão mínimo de sobrevivência cibernética para todas as empresas. Foca em repelir ataques não direcionados e automatizados. | **56** (Essencial) |
| **IG2 (Defesa Focada)** | Para organizações com equipes de TI dedicadas. Lida com múltiplos perfis de risco e conformidade regulatória. Inclui o IG1. | **74** (Cumulativo: 130) |
| **IG3 (Defesa Avançada)** | Para sistemas críticos (bancos, governos). Focado em repelir ameaças persistentes avançadas (APTs) e ataques de Dia Zero (*Zero-Day*). | **23** (Cumulativo: 153) |

---

## 2. Detalhamento Exaustivo dos 18 Controles (CIS v8)

Abaixo, cada controle é destrinchado, detalhando o seu objetivo prático e como ele se conecta aos princípios de segurança abordados no livro de Stallings.

### Categoria A: O Básico (Inventário e Proteção de Dados)
A regra de ouro da segurança e auditoria é: "Você não pode proteger aquilo que não enxerga".

**1. Inventário e Controle de Ativos Corporativos**
* **Objetivo:** Rastrear ativamente todo hardware conectado à rede infraestrutura (servidores, laptops, IoT, dispositivos móveis). 
* **Prática de Auditoria:** Ferramentas de descoberta de rede (Network Discovery) e controle de acesso baseado em porta (802.1X). Dispositivos não autorizados devem ter o acesso negado.

**2. Inventário e Controle de Ativos de Software**
* **Objetivo:** Rastrear ativamente todo sistema operacional e aplicação em execução.
* **Prática de Auditoria:** Uso de listas de permissões (*whitelisting*). Se um software não está no inventário aprovado, ele não pode ser executado.

**3. Proteção de Dados**
* **Objetivo:** Desenvolver processos e controles técnicos para identificar, classificar, tratar, reter e eliminar dados de forma segura.
* **Conexão com o Livro (Stallings):** Este controle é a aplicação direta da **Criptografia Simétrica (AES)** para dados em repouso (discos rígidos) e **Criptografia Assimétrica (RSA) / SSL/TLS** para dados em trânsito, conceitos exaustivamente detalhados nos capítulos 2 e 9 do livro.



### Categoria B: Controle de Acesso e Configuração
Fechando as portas que vêm abertas por padrão e garantindo a identidade dos usuários.

**4. Configuração Segura de Ativos e Software**
* **Objetivo:** Estabelecer e manter a configuração de segurança em todos os dispositivos. Equipamentos de fábrica vêm com senhas padrão e portas abertas.
* **Prática de Auditoria:** Aplicação de *Hardening* (endurecimento). Desabilitar serviços desnecessários (como Telnet ou FTP não seguro) e forçar o uso de SSH.

**5. Gestão de Contas**
* **Objetivo:** Gerenciar o ciclo de vida completo de contas de administradores e usuários (criação, uso, inatividade, exclusão).
* **Prática de Auditoria:** Auditorias trimestrais para desativar contas de funcionários demitidos e garantir que não existam "contas fantasmas".

**6. Gestão de Controle de Acesso**
* **Objetivo:** Conceder e revogar privilégios de acesso aos sistemas baseados no Princípio do Menor Privilégio (*Principle of Least Privilege*).
* **Conexão com o Livro (Stallings):** Envolve os serviços OSI (X.800) de **Autenticação** e **Controle de Acesso**. Exige a implementação de Autenticação Multifator (MFA) para todo acesso remoto e administrativo.

### Categoria C: Monitoramento e Correção
O ambiente muda diariamente. Novas vulnerabilidades são descobertas todas as semanas.

**7. Gestão Contínua de Vulnerabilidades**
* **Objetivo:** Avaliar continuamente vulnerabilidades em todos os ativos corporativos para remediar ou minimizar os riscos.
* **Prática de Auditoria:** Scanners automatizados (como Nessus ou OpenVAS) rodando semanalmente e políticas estritas de aplicação de *patches* (atualizações) priorizadas pelo índice CVSS (gravidade do risco).

**8. Gestão de Logs de Auditoria**
* **Objetivo:** Coletar, alertar, revisar e reter logs (registros) de eventos de segurança corporativos.
* **Prática de Auditoria:** Envio de todos os logs para um servidor centralizado e isolado (SIEM - *Security Information and Event Management*), onde um atacante não consiga apagar seus rastros caso comprometa um servidor web.

### Categoria D: Defesa Operacional
Camadas de bloqueio contra ataques externos clássicos.

**9. Proteções de E-mail e Navegador Web**
* **Objetivo:** Melhorar as proteções e detecções contra as portas de entrada mais comuns para invasores (phishing e sites maliciosos).
* **Prática de Auditoria:** Filtros anti-spam severos, bloqueio de download de arquivos executáveis não assinados e implementação de DMARC, DKIM e SPF para evitar falsificação de domínio de e-mail.

**10. Defesas contra Malware**
* **Objetivo:** Impedir a instalação e execução de programas maliciosos em toda a infraestrutura.
* **Prática de Auditoria:** Transição do antivírus clássico (baseado em assinaturas de arquivos conhecidos) para ferramentas modernas de EDR (*Endpoint Detection and Response*), que analisam o comportamento anômalo da memória e processos.

**11. Recuperação de Dados**
* **Objetivo:** Estabelecer e manter práticas de recuperação de dados suficientes para restaurar ativos no escopo de um incidente pré-incidente.
* **Prática de Auditoria:** A única defesa real contra o **Ransomware**. Exige backups isolados da rede principal (regra do 3-2-1), encriptados e rotineiramente testados quanto à integridade.



### Categoria E: Redes e Infraestrutura
Protegendo as rodovias de dados.

**12. Gestão de Infraestrutura de Rede**
* **Objetivo:** Rastrear, relatar e corrigir ativamente a infraestrutura de rede corporativa (firewalls, roteadores, switches).
* **Conexão com o Livro (Stallings):** Aplicação prática do **IPsec** para criar túneis VPN criptografados seguros entre filiais, garantindo a integridade e confidencialidade do tráfego na camada de rede.

**13. Monitoramento e Defesa de Rede**
* **Objetivo:** Operar processos e ferramentas para monitorar e defender o fluxo de informações.
* **Prática de Auditoria:** Uso de Sistemas de Detecção e Prevenção de Intrusão (IDS/IPS) e segmentação de rede (separar a rede Wi-Fi de visitantes da rede de servidores de banco de dados).

### Categoria F: O Fator Humano e o Ecossistema
Segurança além da barreira do silício.

**14. Conscientização e Treinamento em Segurança**
* **Objetivo:** Estabelecer e manter um programa para educar a força de trabalho. O ser humano é frequentemente o elo mais fraco da arquitetura OSI.
* **Prática de Auditoria:** Simulações controladas de *phishing* contra os funcionários e treinamento sobre engenharia social.

**15. Gestão de Prestadores de Serviços**
* **Objetivo:** Desenvolver um processo para avaliar provedores de serviços de TI e parceiros de negócios que tenham acesso a dados corporativos.
* **Prática de Auditoria:** Auditoria de contratos e verificação se os fornecedores possuem certificações (como SOC 2 ou ISO 27001) para evitar vazamentos de dados causados por falhas de terceiros.

### Categoria G: Engenharia e Resposta
Fechando o ciclo com desenvolvimento seguro e preparação para crises.

**16. Segurança de Software de Aplicação**
* **Objetivo:** Gerenciar o ciclo de vida de segurança de softwares desenvolvidos internamente (SDLC Seguro).
* **Prática de Auditoria:** Uso obrigatório de Análise Estática de Código (SAST) antes de cada *commit*, verificação de vulnerabilidades em bibliotecas de terceiros (SCA) e aderência ao OWASP Top 10.

**17. Gestão de Resposta a Incidentes**
* **Objetivo:** Estabelecer um programa para responder rapidamente a uma brecha de segurança, limitando o dano.
* **Prática de Auditoria:** Ter um plano documentado, com papéis definidos (quem fala com a imprensa, quem desliga os servidores, quem aciona a análise forense) e exercícios de mesa (*Tabletop exercises*) anuais.

**18. Testes de Invasão (Penetration Testing)**
* **Objetivo:** Testar as defesas da organização simulando os objetivos e ações de um atacante do mundo real.
* **Prática de Auditoria:** Contratação de empresas terceiras (Red Teams) para realizar testes de intrusão autorizados anualmente. Eles tentarão quebrar a encriptação, explorar falhas web e invadir a rede, gerando um relatório final de conformidade.

---

## 3. Síntese: A Relação Entre a Teoria (Livro) e a Prática (CIS v8)

Para consolidar o conhecimento para sua avaliação de auditoria, compreenda que o CIS v8 é o "O Quê" e o livro de Stallings é o "Como".

| Princípio do Livro (Stallings, 2014) | Aplicação Prática no CIS Controls v8 (2021) |
| :--- | :--- |
| **Autenticação e Assinaturas Digitais** (Capítulos 11 a 13) | **Controle 6 (Controle de Acesso):** Exige que administradores provem sua identidade usando chaves criptográficas multifator (MFA). |
| **Algoritmos Criptográficos Simétricos** (Capítulo 2) | **Controle 3 e 11:** Exige que todos os backups e discos rígidos (Dados em Repouso) sejam cifrados com algoritmos fortes (AES-256). |
| **Ameaças Passivas e Ativas** (Arquitetura OSI X.800) | **Controles 12 e 13:** Arquitetura de segmentação e IDS/IPS para detectar modificação de mensagens (Ativa) ou análise de tráfego (Passiva). |
| **Infraestrutura de Chaves Públicas (PKI)** (Capítulo 14) | **Controle 9 e 16:** Uso obrigatório de certificados X.509 válidos (HTTPS) para proteger o acesso a aplicações web e e-mail. |

---

## 4. Referências Consultadas e Integradas

1.  **Stallings, William (2014).** *Criptografia e Segurança de Redes: Princípios e Práticas* (6ª Edição). Pearson Education. (Referência primária para fundamentos matemáticos, algoritmos RSA/AES, arquitetura OSI e PKI).
2.  **Center for Internet Security (2021).** *CIS Controls v8*. (Referência externa integrada para fornecer a atualização arquitetural sobre Grupos de Implementação e mapeamento moderno de salvaguardas e defesas contra Ransomware/Cloud).

---

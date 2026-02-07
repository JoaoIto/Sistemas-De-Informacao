# Segurança da Informação e Auditoria de Sistemas

## 1. Introdução à Segurança da Informação

A Segurança da Informação é uma área fundamental dentro da Tecnologia da Informação, especialmente em ambientes corporativos, governamentais e acadêmicos. Seu objetivo principal é **proteger as informações e os sistemas contra acessos não autorizados, uso indevido, vazamentos, falhas e ataques cibernéticos**.

No contexto do curso de **Sistemas de Informação**, a disciplina de Segurança e Auditoria busca capacitar o aluno a compreender tanto os **aspectos técnicos** quanto os **organizacionais e estratégicos** da proteção da informação, preparando-o para atuar em ambientes reais, onde riscos, ataques e falhas são constantes.

A segurança não se limita a ferramentas, mas envolve **processos, pessoas, políticas, normas e monitoramento contínuo**.

---

## 2. Princípios Fundamentais da Segurança da Informação

A base da Segurança da Informação está sustentada pela chamada **Tríade CIA**, amplamente adotada em normas e frameworks internacionais.

| Princípio | Descrição |
|---------|----------|
| Confidencialidade | Garante que a informação seja acessada apenas por pessoas autorizadas |
| Integridade | Assegura que a informação não seja alterada de forma indevida |
| Disponibilidade | Garante que a informação esteja acessível quando necessária |

Esses princípios orientam o desenvolvimento de sistemas, a definição de controles de segurança e a realização de auditorias.

---

## 3. Criptografia: Tipos e Técnicas de Implementação

A criptografia é uma das principais ferramentas técnicas da segurança da informação, sendo utilizada para proteger dados em trânsito e em repouso.

### 3.1 Tipos de criptografia

| Tipo | Características | Exemplo de uso |
|----|----------------|---------------|
| Simétrica | Usa a mesma chave para cifrar e decifrar | Criptografia de discos |
| Assimétrica | Usa par de chaves (pública e privada) | Certificados digitais |
| Hash | Gera resumo irreversível | Armazenamento de senhas |

A criptografia está diretamente ligada à **proteção de dados**, **assinaturas digitais** e **certificação digital**, sendo essencial para sistemas seguros e compatíveis com legislações como a LGPD.

---

## 4. Assinatura Digital e Certificação Digital

A assinatura digital garante:
- Autenticidade
- Integridade
- Não repúdio

Já a certificação digital utiliza uma **Infraestrutura de Chaves Públicas (ICP)** para validar identidades digitais, sendo amplamente utilizada em:
- Sistemas governamentais
- Contratos eletrônicos
- Transações financeiras
- Sistemas corporativos

Esses mecanismos têm valor **técnico e jurídico**, sendo aceitos legalmente no Brasil.

---

## 5. Softwares Maliciosos (Malware)

Softwares maliciosos representam uma das principais ameaças à segurança da informação. Eles são desenvolvidos com o objetivo de explorar vulnerabilidades, roubar informações ou causar danos.

### 5.1 Tipos comuns de malware

| Tipo | Objetivo |
|----|---------|
| Vírus | Se propaga infectando arquivos |
| Worm | Se espalha pela rede |
| Trojan | Disfarça-se de software legítimo |
| Stealer | Rouba credenciais e dados sensíveis |
| Ransomware | Sequestra dados e exige resgate |

O uso de **stealers** e **phishing**, citado em aula, é uma das técnicas mais utilizadas atualmente para roubo de credenciais e acesso indevido a sistemas corporativos.

---

## 6. Técnicas de Intrusão e Invasão

As técnicas de intrusão exploram falhas técnicas, humanas ou processuais. Entre as mais comuns estão:
- Phishing
- Engenharia social
- Exploração de vulnerabilidades conhecidas
- Ataques a serviços expostos

### 6.1 Simulações de phishing

Simulações de phishing são práticas adotadas por empresas para:
- Avaliar o nível de conscientização dos usuários
- Identificar falhas humanas
- Treinar equipes

Essas simulações fazem parte de programas de **governança e auditoria de segurança**.

---

## 7. Vulnerabilidades e CVE

Uma vulnerabilidade é uma falha que pode ser explorada por atacantes. Para catalogar essas falhas, existe o **CVE (Common Vulnerabilities and Exposures)**.

### 7.1 CVE Details

O site **cvedetails.com**, citado em aula, é utilizado para:
- Consultar vulnerabilidades conhecidas
- Avaliar nível de severidade
- Verificar impacto em sistemas e softwares

| Elemento | Função |
|--------|-------|
| CVE ID | Identificador único da vulnerabilidade |
| CVSS | Pontuação de severidade |
| Produto afetado | Software ou sistema vulnerável |

Essa base é essencial para equipes de segurança e auditoria.

---

## 8. Monitoramento, Detecção e Resposta a Incidentes

A segurança moderna não se baseia apenas em prevenção, mas também em **detecção, notificação, análise e resposta**, conforme destacado em aula.

### 8.1 Ciclo de resposta a incidentes

| Etapa | Descrição |
|-----|----------|
| Detecção | Identificação do incidente |
| Notificação | Alerta às equipes responsáveis |
| Análise | Avaliação do impacto e origem |
| Resposta | Contenção e mitigação |
| Recuperação | Retorno à normalidade |
| Aprendizado | Melhoria contínua |

---

## 9. ETIR – Equipe de Tratamento de Incidentes de Rede

A **ETIR** é responsável por lidar com incidentes de segurança dentro de uma organização.

### 9.1 Funções da ETIR

- Monitorar eventos de segurança
- Responder a incidentes
- Analisar ataques
- Coordenar ações corretivas
- Produzir relatórios

A ETIR atua de forma integrada com outros setores, como SOC e NOC.

---

## 10. SOC, NOC e SIEM

### 10.1 SOC – Security Operations Center

O **SOC** é o centro de operações de segurança responsável pelo monitoramento contínuo de eventos e incidentes de segurança.

### 10.2 NOC – Network Operations Center

O **NOC** é responsável pela operação e disponibilidade da infraestrutura de rede.

### 10.3 SIEM – Security Information and Event Management

O **SIEM** centraliza logs e eventos, permitindo correlação e análise de ameaças.

| Estrutura | Função |
|---------|-------|
| SOC | Segurança |
| NOC | Operação de rede |
| SIEM | Análise e correlação |

---

## 11. PAM Service – Privileged Access Management

O **PAM** é um serviço de cibersegurança voltado ao controle de acessos privilegiados.

### 11.1 Importância do PAM

- Reduz riscos internos
- Controla acessos administrativos
- Registra ações críticas
- Atende requisitos de auditoria

O PAM é amplamente utilizado em ambientes corporativos e governamentais.

---

## 12. Frameworks de Segurança da Informação

A disciplina também aborda frameworks reconhecidos internacionalmente.

| Framework | Objetivo |
|---------|---------|
| NIST Cybersecurity Framework | Gestão de riscos e segurança |
| CIS Controls | Controles técnicos prioritários |
| MITRE ATT&CK | Mapeamento de táticas e técnicas de ataque |

Esses frameworks orientam auditorias, políticas e estratégias de segurança.

---

## 13. Auditoria de Sistemas de Informação

A auditoria de sistemas avalia se os controles de segurança são:
- Adequados
- Eficazes
- Conformes com normas e leis

### 13.1 Objetivos da auditoria

- Identificar vulnerabilidades
- Avaliar riscos
- Verificar conformidade legal
- Propor melhorias

A auditoria é essencial para garantir **transparência, segurança e governança**.

---

## 14. Conclusão

A Segurança da Informação e a Auditoria de Sistemas são pilares fundamentais para a atuação profissional em Sistemas de Informação. O conteúdo abordado na disciplina integra aspectos técnicos, organizacionais e legais, preparando o aluno para lidar com ameaças reais, incidentes, auditorias e exigências regulatórias.

O domínio desses conceitos é indispensável para atuar de forma ética, responsável e estratégica em ambientes corporativos e institucionais.

---

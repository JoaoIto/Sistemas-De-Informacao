# 📚 ITIL - Transição de Serviço e Operação de Serviço (Aula 10a e 10b)

## ✨ Introdução Geral

No ciclo de vida de serviços de TI, **Transição de Serviço** e **Operação de Serviço** são fases essenciais para garantir que:
- As mudanças em TI sejam feitas de forma segura e planejada;
- Os serviços operem diariamente com qualidade, estabilidade e agilidade.

O objetivo é assegurar que a TI **apoie o negócio**, mantendo a **confiabilidade** e a **eficiência** dos serviços.

---

# 🔹 Aula 10a - Transição de Serviço

### 📖 Conceito

**Transição de Serviço** é o estágio responsável por **entregar** novos ou modificados serviços de TI para o ambiente de produção.  
É a "ponte" entre o planejamento (Desenho de Serviço) e a utilização prática (Operação de Serviço).

**Principais objetivos:**
- Planejar mudanças com qualidade.
- Minimizar riscos ao alterar serviços.
- Garantir que tudo que foi desenhado seja realmente implementado.
- Fornecer informação e conhecimento confiáveis para o time de operação.

---

### 🔸 Processos da Transição de Serviço

---

## 1. Planejamento e Suporte à Transição

📌 **O que é:**  
Organizar todos os recursos, atividades e prazos necessários para que a transição seja bem-sucedida.

📌 **Objetivos:**
- Cumprir custos, prazos e qualidade planejados.
- Coordenar atividades entre projetos, fornecedores e equipes de TI.
- Gerenciar e reduzir riscos durante a transição.

📌 **Exemplo:**
- Planejar uma migração de servidor, organizando datas, responsáveis e rotinas de teste.

---

## 2. Gerenciamento de Ativos de Serviço e da Configuração (GASC)

📌 **O que é:**  
Rastrear, identificar e proteger todos os componentes (ativos) usados na entrega dos serviços.

📌 **Itens de Configuração (ICs):**
- Servidores, estações de trabalho, softwares, bancos de dados, contratos, etc.

📌 **Exemplo:**
- Se você precisar atualizar um sistema, o GASC garante que você saiba exatamente qual servidor e software serão impactados.

📌 **Importante:**
- Um IC é qualquer item **único**, **gerenciado** e **necessário** para o serviço.
- Ex.: servidor de e-mail + banco de dados + plano de continuidade = todos são ICs.

---

## 3. Gerenciamento do Conhecimento

📌 **O que é:**  
Assegurar que informações relevantes estejam sempre disponíveis para apoiar decisões.

📌 **Exemplo de fontes de conhecimento:**
- Base de Dados de Erros Conhecidos.
- Portfólio de serviços.
- Planos de projetos.

📌 **Exemplo prático:**
- Durante uma falha em um servidor, a equipe consulta a base de conhecimento para aplicar rapidamente a solução documentada.

---

## 4. Gerenciamento de Mudanças

📌 **O que é:**  
Controlar todas as mudanças feitas em serviços ou infraestrutura de TI para reduzir falhas e interrupções.

📌 **Tipos de Mudanças:**
- **Mudança Padrão:** já conhecida, com roteiro fixo (ex.: instalação de impressora).
- **Mudança Normal:** precisa de avaliação e aprovação (ex.: upgrade de sistema operacional).
- **Mudança Emergencial:** rápida, para corrigir erros graves (ex.: reparar falha em servidor crítico).

📌 **Fluxo básico de mudança:**
1. Criar Requisição de Mudança (RDM).
2. Avaliar riscos e impacto.
3. Autorizar e planejar execução.
4. Implantar e revisar.

📌 **Exemplo:**
- Quando uma falha crítica derruba o site da empresa, é aberta uma mudança emergencial para troca urgente do servidor.

---

## 5. Gerenciamento da Liberação e da Distribuição

📌 **O que é:**  
Organizar a entrega de novos serviços ou atualizações de forma segura e eficiente.

📌 **Modelos de entrega:**
- **Big Bang:** implanta tudo de uma vez.
- **Faseada:** implanta em etapas.
- **Push:** atualizações automáticas.
- **Pull:** usuário escolhe quando atualizar.
- **Automatizado:** com ferramentas de automação.
- **Manual:** instalado manualmente.

📌 **Exemplo prático:**
- Uma empresa decide atualizar o sistema de gestão: opta por fazer isso em etapas, departamento por departamento, para evitar riscos.

---

# 🔹 Aula 10b - Operação de Serviço

### 📖 Conceito

**Operação de Serviço** é o estágio onde os serviços são entregues efetivamente aos usuários.  
É o "mundo real", onde a TI precisa:
- Garantir estabilidade.
- Resolver problemas rapidamente.
- Suportar o negócio no dia a dia.

**Principais atividades:**
- Monitorar o ambiente.
- Gerenciar incidentes e problemas.
- Cumprir requisições de usuários.
- Administrar acesso seguro aos serviços.

---

### 🔸 Processos da Operação de Serviço

---

## 1. Gerenciamento de Incidentes

📌 **O que é:**  
Restaurar rapidamente um serviço interrompido ou degradado.

📌 **Fluxo do incidente:**
- Identificar ➔ Registrar ➔ Categorizar ➔ Priorizar ➔ Escalar ➔ Diagnosticar ➔ Resolver ➔ Fechar.

📌 **Exemplo:**
- Queda de internet na empresa: abrir chamado, priorizar (impacto crítico), corrigir, e normalizar o serviço o quanto antes.

---

## 2. Gerenciamento de Problemas

📌 **O que é:**  
Identificar e corrigir as causas-raiz dos incidentes.

📌 **Ferramentas usadas:**
- 5 Porquês.
- Diagrama de Ishikawa (espinha de peixe).
- Análise Temporal.

📌 **Exemplo prático:**
- Impressoras falham toda semana. O time investiga e descobre que o problema é firmware desatualizado — aplica atualização para resolver de forma definitiva.

---

## 3. Gerenciamento de Eventos

📌 **O que é:**  
Monitorar eventos que indicam que algo mudou ou falhou em TI.

📌 **Exemplo:**
- Alarme de espaço de disco chegando ao limite: permite agir antes da falha completa.

---

## 4. Execução ou Cumprimento de Requisições

📌 **O que é:**  
Atender pedidos rotineiros dos usuários.

📌 **Tipos de requisições:**
- Solicitação de novo software.
- Troca de senha.
- Instalação de impressora.

📌 **Exemplo prático:**
- Funcionário novo solicita acesso ao sistema financeiro — a equipe executa conforme processo padrão.

---

## 5. Gerenciamento de Acesso

📌 **O que é:**  
Garantir que apenas usuários autorizados acessem os serviços corretos.

📌 **Exemplo:**
- Um novo gerente ganha acesso ao módulo financeiro do ERP. Um estagiário, não.

---

# 🔸 Funções na Operação de Serviço

- **Central de Serviços (Service Desk):** ponto único de contato com usuários.
- **Gerenciamento Técnico:** manutenção da infraestrutura.
- **Gerenciamento de Aplicações:** suporte e evolução de sistemas/aplicações.
- **Gerenciamento das Operações de TI:** execução das rotinas operacionais.

📌 **Exemplo prático:**
- Um usuário liga para a Central relatando problema no e-mail. A Central registra, tenta resolver, e, se necessário, aciona o time técnico.

---

# ✅ Resumo Final

| Fase                   | Principal Foco                                      |
|-------------------------|-----------------------------------------------------|
| **Transição de Serviço** | Planejar mudanças e entregar novos serviços.       |
| **Operação de Serviço**  | Garantir a operação diária eficiente e estável.    |

**Destaques:**
- Prevenir e corrigir falhas antes que afetem o negócio.
- Implementar mudanças de forma controlada.
- Monitorar, medir e melhorar constantemente a operação.

---

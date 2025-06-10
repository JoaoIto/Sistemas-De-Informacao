## 🧠 **Resumo Completo – Testes de Software**

### 📌 Introdução

Os testes de software são uma das etapas mais críticas no desenvolvimento de sistemas, pois visam identificar falhas, aumentar a confiabilidade e garantir que o software atenda aos requisitos definidos.

> **"Por mais que se planeje o desenvolvimento, erros são inevitáveis."**

---

## 🔍 **Por que os Testes são Importantes?**

Testes evitam falhas catastróficas, como mostraram casos famosos:

| Caso                 | Consequência                                              |
| -------------------- | --------------------------------------------------------- |
| Ariane 5             | Explosão do foguete por falha de software inercial        |
| Mars Climate Orbiter | Perda de sonda por erro de conversão de unidades          |
| Therac-25            | Superdosagem de radiação em pacientes                     |
| Boeing 737 MAX       | Queda de aeronaves devido a leitura incorreta de sensores |

---

## 🧪 **Conceitos-Chave**

| Termo           | Definição                                                                     |
| --------------- | ----------------------------------------------------------------------------- |
| **Validação**   | Garante que estamos construindo o produto certo (segundo os requisitos)       |
| **Verificação** | Garante que estamos construindo o produto corretamente (consistência técnica) |
| **Teste**       | Execução real do software para observar seu comportamento                     |

---

## ⚠️ Defeitos, Erros e Falhas

* **Defeito**: erro no código ou na lógica
* **Erro**: estado inesperado em tempo de execução
* **Falha**: quando o comportamento do sistema viola suas especificações

**Origem dos defeitos:**

* Comunicação falha
* Tradução incorreta de requisitos
* Código raramente testado
* A maioria dos defeitos é introduzida por humanos

---

## 🔁 Tipos de Testes

### 1. **Funcional (Caixa Preta)**

Testa as funcionalidades de acordo com os requisitos, sem conhecer o código.

✅ Simples, acessível
❌ Não testa lógica interna

---

### 2. **Estrutural (Caixa Branca)**

Testa a lógica e a estrutura do código fonte.

✅ Ideal para encontrar bugs ocultos
❌ Custo alto e exige conhecimento técnico

---

## 🔠 Categorias de Testes

| Tipo                                 | Foco                                             |
| ------------------------------------ | ------------------------------------------------ |
| **Funcionalidade**                   | Validação dos requisitos funcionais              |
| **Usabilidade**                      | Navegação, clareza, ajuda ao usuário             |
| **Carga (Stress)**                   | Comportamento sob picos de acesso                |
| **Volume**                           | Capacidade sob grandes quantidades de dados      |
| **Compatibilidade**                  | Integração com versões e plataformas             |
| **Configuração**                     | Execução em diferentes SOs, hardwares e browsers |
| **Segurança**                        | Vulnerabilidades, acesso indevido                |
| **Performance**                      | Tempo de resposta, eficiência                    |
| **Instalação**                       | Validação dos procedimentos de instalação        |
| **Recuperação**                      | Comportamento após falhas ou interrupções        |
| **Confiabilidade e Disponibilidade** | Estabilidade e tempo de recuperação              |

---

## 🧱 **Etapas do Ciclo de Teste**

1. **Planejamento**: definir objetivos e requisitos a testar
2. **Preparação**: configurar ambientes e dados reais
3. **Execução**: rodar os testes e registrar resultados
4. **Reteste**: corrigir defeitos e testar novamente
5. **Encerramento**: validar critérios e liberar o sistema

---

## 📚 **Testes Progressivos vs Regressivos**

* **Progressivos**: acompanham o desenvolvimento, testando incrementos
* **Regressivos**: garantem que alterações não causem novos erros

---

## 🧪 **Fases de Testes de Validação**

| Fase                    | Finalidade                                                  |
| ----------------------- | ----------------------------------------------------------- |
| **Teste de Unidade**    | Testa componentes isoladamente (funções, classes, etc.)     |
| **Teste de Integração** | Testa comunicação entre componentes                         |
| **Teste de Sistema**    | Testa o software como um todo em ambiente controlado        |
| **Teste de Aceitação**  | Testado por usuários finais em situações reais ou simuladas |

---

## ✔️ **Validação do Aceite**

| Tipo de Teste   | Descrição                                                         |
| --------------- | ----------------------------------------------------------------- |
| **Alpha**       | Usuários convidados testam na sede da empresa                     |
| **Beta**        | Testes realizados em ambiente real por grupo restrito de clientes |
| **Implantação** | Versão final liberada para todos os usuários                      |

---

## 🧠 Exemplos Didáticos

| Situação                                | Teste Aplicável       |
| --------------------------------------- | --------------------- |
| Simular 10.000 usuários logando         | Teste de Carga        |
| Verificar se app funciona no Safari     | Teste de Configuração |
| Verificar falha após queda de rede      | Teste de Recuperação  |
| Verificar clareza de mensagens          | Teste de Usabilidade  |
| Testar se cálculo do saldo está correto | Teste Funcional       |

---

## 🏁 **Conclusão**

Testes de software são **essenciais para garantir qualidade, segurança e confiabilidade** de um sistema. Desde simples validações funcionais até testes complexos de carga e segurança, cada tipo cumpre um papel estratégico na entrega de soluções tecnológicas robustas e profissionais.

---


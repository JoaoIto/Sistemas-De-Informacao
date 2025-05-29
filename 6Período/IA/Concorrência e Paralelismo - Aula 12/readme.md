# Aula 12 – Concorrência e Paralelismo em Aprendizado de Máquina

> 📅 **Data:** 03/05/2025
> 🎥 [Link para a videoaula](https://www.youtube.com/watch?v=Z4-uEpVOKFc)
> 📂 [Repositório GitHub](https://github.com/sousamaf/PyParallelAI)
> 💡 [NotebookLM](https://notebooklm.google.com/?original_referer=https:%2F%2Feduca.unitins.br%23&pli=1) recomendado para apoio ao estudo

---

## 🔍 Tópicos Abordados

### 🧠 1. Conceitos Fundamentais

* **Concorrência:**
  Execução alternada de tarefas que compartilham os mesmos recursos computacionais. Dá a impressão de simultaneidade.

* **Paralelismo:**
  Execução verdadeira e simultânea de múltiplas tarefas, aproveitando múltiplos núcleos de CPU ou máquinas distintas.

---

### 🧱 2. Termos Técnicos Importantes (Glossário)

| Termo                      | Definição                                                           |
| -------------------------- | ------------------------------------------------------------------- |
| **Instância**              | Um programa em execução.                                            |
| **Thread**                 | Subunidade de execução leve, dentro de uma instância.               |
| **Processo**               | Instância de programa com espaço de memória próprio.                |
| **Multithreading**         | Execução concorrente de várias threads dentro de um processo.       |
| **Multiprocessing**        | Execução em paralelo de múltiplos processos.                        |
| **Cluster**                | Conjunto de computadores que operam como um sistema unificado.      |
| **Contêiner**              | Instância isolada de aplicação (ex: Docker).                        |
| **Fila**                   | Organização de tarefas para execução em sequência ou paralelamente. |
| **Computação Assíncrona**  | Permite que o sistema continue operando enquanto aguarda respostas. |
| **Computação por Eventos** | Tarefas são acionadas pela ocorrência de eventos específicos.       |
| **GPU**                    | Unidade gráfica ideal para paralelismo massivo.                     |

---

### ⚙️ 3. Tipos de Paralelismo em Machine Learning

| Tipo                               | Descrição                                                                              |
| ---------------------------------- | -------------------------------------------------------------------------------------- |
| **Paralelismo de Instrução**       | Executa múltiplas instruções em paralelo dentro de um processador.                     |
| **Paralelismo de Dados**           | Divide os dados entre núcleos para processamento simultâneo.                           |
| **Paralelismo de Modelo**          | Divide partes do modelo (ex: camadas da rede neural) para execuções em paralelo.       |
| **Paralelismo de Hiperparâmetros** | Executa diferentes configurações de hiperparâmetros ao mesmo tempo.                    |
| **Paralelismo de Experimentos**    | Executa diferentes experimentos de ML (modelos/abordagens distintas).                  |
| **Pipeline de Machine Learning**   | Conjunto de etapas (pré-processamento, treino, avaliação) que podem ser paralelizadas. |

---

### 🧰 4. Ferramentas e Tecnologias

| Ferramenta            | Finalidade                                                                          |
| --------------------- | ----------------------------------------------------------------------------------- |
| **Dask**              | Computação paralela e distribuída com Python. Ideal para dados grandes.             |
| **Apache Spark**      | Motor de análise unificado para grandes volumes de dados em ambientes distribuídos. |
| **Docker/Kubernetes** | Isolamento e orquestração de contêineres executando pipelines ML.                   |

---

### 📈 5. Escalabilidade e Elasticidade

* **Scalability (Escalabilidade):**
  Capacidade do sistema crescer para lidar com maior carga de trabalho.

* **Elasticity (Elasticidade):**
  Ajuste automático de recursos conforme a necessidade, típico de ambientes em nuvem.

---

## 📌 Recomendações de Estudo

* Utilize o **NotebookLM** para carregar os materiais da aula, como o glossário e o vídeo.
* Explore o **[repositório PyParallelAI](https://github.com/sousamaf/PyParallelAI)**, que contém exemplos práticos de concorrência e paralelismo em Python.
* Revise os termos do glossário e tente associá-los com situações reais de uso no desenvolvimento de modelos de ML.

---

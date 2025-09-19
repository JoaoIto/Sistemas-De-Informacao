# Sistemas Distribuídos em Ambientes de Inteligência Artificial (AI) e Machine Learning (ML)

> “Modelos de **AI/ML** modernos são grandes demais para **uma única máquina** — tanto em dados quanto em parâmetros — e, por isso, se **distribuem**.” ([Google Research][1])

Este guia organiza o conteúdo do seu relatório em uma trilha de estudo prática: **por que** distribuir, **como** distribuir (dados, modelo, pipeline, tensor), **algoritmos de sincronização**, **frameworks** e **aplicações** (operação, segurança, manutenção preditiva).

---

## 3. Sistemas Distribuídos em IA e ML

### 3.1 Por que sistemas distribuídos?

* **Escala de dados e modelos**
  Conjuntos massivos e redes profundas requerem **muita memória** e **muitas operações matriciais**; distribuir permite **treinar mais rápido** e usar datasets que não cabem em um nó. *Ex.:* DistBelief (Google) já partia modelos e parâmetros em 2012: “DistBelief models are themselves partitioned across multiple machines.” ([Google Research][1])

* **Tempo de treinamento**
  Síncrono bem otimizado consegue throughput quase linear. Caso clássico: **ResNet-50 em 1 hora** com minibatch 8192, regra de **escala linear** da taxa de aprendizado e **warmup**. > “No loss of accuracy… with minibatch sizes up to 8192 images.”

* **Disponibilidade e resiliência**
  Arquiteturas de **replicação** e **recolocação de carga** mantêm serviço mesmo com falhas de nó (essencial em produção). Em PS/Downpour, nós podem falhar e retornar sem derrubar o job. ([Google Research][1])

---

### 3.2 Aplicações de IA **sobre** sistemas distribuídos

| Área                           | O que a IA faz                                                                                 | Exemplos práticos                                                                                                                                                 |
| ------------------------------ | ---------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Balanceamento & Scheduling** | Aprende alocação de tarefas para evitar gargalos e ociosidade                                  | RL para escalonar lotes em clusters multi-GPU; heurísticas guiadas por previsão de carga                                                                          |
| **Detecção de falhas**         | Monitora métricas e **prevê** panes (anomalias)                                                | *Clássico:* taxonomias e técnicas de **detecção de anomalias** (estatística, clustering, ML). > “Anomaly detection is an important problem… across many domains.” |
| **Gerência de recursos**       | Forecast de CPU/RAM/IO e política de cota/prioridade                                           | Modelos antecipando picos para autoscaling                                                                                                                        |
| **Segurança (DDoS/IDS)**       | Classifica tráfego malicioso em **tempo real**; responde automaticamente (bloqueio/isolamento) | Revisões e frameworks recentes para **DDoS em IoT/5G** com ML/DL e até **federated learning**.                                                                    |
| **Manutenção preditiva (PdM)** | Prediz falhas e agenda manutenção planejada                                                    | Revisões apontam pipeline **sensores → pré-processamento → modelo → decisão**. (Figura e revisão aberta abaixo.)                                                  |

**Figura — DDoS (IoT):** arquitetura de *detecção on-line com adaptação a drift* (AUWPAE).
![Drift adaptive online DDoS detection framework (MDPI, 2024)](https://www.mdpi.com/electronics/electronics-13-01004/article_deploy/html/images/electronics-13-01004-g001.png)
Fonte: Beshah et al., *Electronics* (MDPI), 2024.

**Figura — PdM (componentes):** visão de alto nível de um sistema de **manutenção preditiva**.
![Key components of an AI-based PdM System (MDPI, 2024)](https://www.mdpi.com/applsci/applsci-14-00898/article_deploy/html/images/applsci-14-00898-g003.png)
Fonte: Ucar et al., *Applied Sciences* (MDPI), 2024.

---

### 3.3 Técnicas de IA utilizadas

| Técnica                | Para quê no sistema distribuído                                                   | Exemplos                                                           |
| ---------------------- | --------------------------------------------------------------------------------- | ------------------------------------------------------------------ |
| **Supervisionado**     | Classificação/Regressão (falha, demanda, saturação)                               | Regressão p/ previsão de uso; classificadores p/ *incident triage* |
| **Não supervisionado** | Clustering e **detecção de anomalias** sem rótulo                                 | Autoencoders, Isolation Forest, *k*-means para perfis de tráfego   |
| **Reforço (RL)**       | **Tomada de decisão** (roteamento, escalonamento, *auto-scaling*)                 | RL para balancear micro-batches entre nós                          |
| **Deep Learning**      | CNN (visão p/ inspeção), RNN/LSTM (séries temporais), **Transformers** (NLP/logs) | Análise de logs e *root-cause* com NLP/Transformers                |

> “Many anomaly detection techniques have been developed for different application domains.”

---

## 4. Arquiteturas e Frameworks de ML em Sistemas Distribuídos

### 4.1 Processamento paralelo (pilar do ML distribuído)

Treinamento de DL é **dominado por BLAS/GEMM** (matrizes/vetores). Escalar **horizontalmente** (mais nós) reduz tempo de época e libera memória por GPU, desde que a **comunicação** seja eficiente. ([NVIDIA Developer][2])

---

### 4.2 Treinamento distribuído: **dados vs. modelo** (e além)

#### 4.2.1 Quatro formas de paralelizar

| Estratégia                       | Como funciona                                                          | Comunicação                                    | Memória por nó         | Quando usar                                   | Imagem/fonte                                                                                                                        |
| -------------------------------- | ---------------------------------------------------------------------- | ---------------------------------------------- | ---------------------- | --------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------- |
| **Paralelismo de Dados (DP)**    | Cada nó recebe **subconjunto de dados**; o modelo é **replicado**      | **AllReduce** (ou PS) de gradientes por *step* | Alta (cópia do modelo) | Modelos “médios”, muitos dados; escalar batch | **NCCL AllReduce** ![NCCL AllReduce](https://docs.nvidia.com/deeplearning/nccl/user-guide/_images/allreduce.png) ([NVIDIA Docs][3]) |
| **Paralelismo de Modelo (MP)**   | O **modelo é particionado** entre nós                                  | Ativações/gradientes entre partições           | Menor por nó           | Modelos que **não cabem** em uma GPU          | DistBelief/PS (Downpour) ([Google Research][1])                                                                                     |
| **Paralelismo de Pipeline (PP)** | Divide o modelo em **estágios**; processa **micro-lotes** em “esteira” | Ativações (fwd) e gradientes (bwd) por estágio | Menor                  | Modelos muito profundos; melhora utilização   | **GPipe** (bolhas ↓) ![GPipe schedule](https://lilianweng.github.io/posts/2021-09-25-train-large/gpipe.png) ([Lil'Log][4])          |
| **Paralelismo de Tensor (TP)**   | **Intra-camada**: divide matrizes/kernels                              | AllReduce intra-camada                         | Menor                  | Transformers gigantes (Megatron-LM)           | **Megatron** ![Tensor parallel](https://lilianweng.github.io/posts/2021-09-25-train-large/Megatron-LM.png) ([Lil'Log][4])           |

> GPipe reduz *bubbles* com **micro-batches**; regra prática: **m > 4d** (micro-batches ≫ profundidade). ([Lil'Log][4])

#### 4.2.2 Duas arquiteturas de sincronização (núcleo do DP)

| Arquitetura                      | Ideia                                                                                                      | Vantagens                                                       | Limitações                                                   | Onde aparece                                                |
| -------------------------------- | ---------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------- | ------------------------------------------------------------ | ----------------------------------------------------------- |
| **Parameter Server (PS)**        | **Workers** mandam gradientes a **servidores de parâmetro** (shards); estes **atualizam** e devolvem pesos | Simples; tolerante a falhas; pode ser **assíncrono (Downpour)** | PS vira gargalo; *stale gradients*                           | DistBelief; Project Adam; Ray PS ([Google Research][1])     |
| **AllReduce** (ring, tree, etc.) | Cada nó **soma/agrupa** gradientes **sem servidor central**                                                | Usa toda a banda; **escala bem**                                | Latência **O(N)** no ring clássico; otimizações com NVSwitch | NCCL, Horovod; *collectives* do MPI ([NVIDIA Developer][2]) |

**Imagens de referência**

* **Parameter Server (Downpour / Sandblaster L-BFGS)**
  ![Parameter Server (DistBelief)](https://insujang.github.io/assets/images/220611/parameter_server.png)
  Fonte da figura e discussão: DistBelief; post técnico de Jang. ([Google Research][1])

* **AllReduce (NCCL)**
  ![Ring AllReduce (NVIDIA NCCL)](https://docs.nvidia.com/deeplearning/nccl/user-guide/_images/allreduce.png)
  Documentação oficial NVIDIA (coletivas e discussões de latência). ([NVIDIA Docs][3])

---

### 4.3 Algoritmos de ML distribuído (sincronização e escalonamento)

* **Parameter Server** (síncrono/assíncrono, com *shards* de parâmetros)
  *Paper de referência (OSDI’14)* detalha o desenho, consistência e tolerância a falhas, incluindo *server/worker nodes* e particionamento de parâmetros. ([USENIX][5])

* **AllReduce com Ring/Tree** e variantes **Reduce-Scatter + All-Gather** (como em NCCL), buscando **largura de banda total** e menor latência. Trabalhos recentes exploram **NVSwitch multicast** para reduzir a latência de O(N) do ring. ([NVIDIA Developer][2])

* **Pipeline schedules** (GPipe síncrono; PipeDream 1F1B; variações **flush** e **2BW**) para reduzir bolhas mantendo consistência. ([Lil'Log][4])

---

## 5. Frameworks e Ecossistema

| Ferramenta                     | Estilo                                                                  | Onde brilha                                       | Doc/Fonte                                  |
| ------------------------------ | ----------------------------------------------------------------------- | ------------------------------------------------- | ------------------------------------------ |
| **PyTorch DDP**                | **Data Parallel** com **AllReduce/NCCL**; API `DistributedDataParallel` | Treino multi-GPU/multi-nó, *de facto* na pesquisa | Docs oficiais PyTorch (DDP). ([arXiv][6])  |
| **TensorFlow `tf.distribute`** | `MultiWorkerMirroredStrategy` (síncrono); `ParameterServerStrategy`     | Prod/TF-Serving; escolha de estratégia por caso   | Guia oficial TF. ([GitHub][7])             |
| **Horovod**                    | **Ring-AllReduce** unificado (TF/PT/MXNet)                              | Escalar jobs existentes com pouco código          | Docs Horovod. ([PyTorch Documentation][8]) |
| **Ray Train**                  | Treino distribuído de alto nível; **exemplo de PS** e *actors*          | Híbridos, *hyper-param search*, *online*          | Docs Ray (Parameter Server). ([Ray][9])    |
| **Spark MLlib**                | ML distribuído **data-centric**                                         | Pré-processamento massivo + modelos clássicos     | Docs Spark MLlib. ([TensorFlow][10])       |

> “Use **DDP** para envolver seu módulo PyTorch e treinar em múltiplos processos/GPU.” (resumo do guia oficial). ([arXiv][6])

---

## 6. Boas práticas (direto ao ponto)

1. **Escolha o paralelismo certo**

   * **Só mais dados?** DP + AllReduce. **Modelo não cabe?** Pipeline/TP (ou híbrido PTD-P). ([Lil'Log][4])
2. **Otimize comunicação**

   * NCCL (GPU↔GPU), *pinning*, *bucketization* de gradientes; reduza latência (NVLink/NVSwitch) quando possível. ([NVIDIA Docs][3])
3. **Hiperparâmetros para *large batch***

   * **Regra de escala linear** + **warmup** evitarão perda de acurácia.
4. **Observabilidade & falhas**

   * *Heartbeats*, *checkpointing* frequente e reexecução idempotente (PS/AllReduce toleram falhas de formas diferentes). ([USENIX][5])
5. **Segurança & PdM**

   * Mantenha **pipelines de detecção** (DDoS/IDS) acoplados ao cluster e monitore **drift**; para PdM, feche o ciclo **sensor→decisão**.

---

## 7. Mini-mapa de estudo (com “pílulas” da literatura)

* **Distribuição na prática**

  * *DistBelief* (base histórica do PS). ([Google Research][1])
  * *AllReduce em GPU* (NVIDIA/NCCL; limitações do ring e alternativas). ([NVIDIA Docs][3])
  * *GPipe / PipeDream / Megatron-LM* (PP/TP/híbridos). ([Lil'Log][4])

* **Escala de treinamento**

  * *ImageNet em 1 hora* (regra de escala e warmup).

* **Operação e produção**

  * *Anomaly detection survey* (taxonomias para sua seção de detecção).
  * *DDoS em IoT/5G* (revisões recentes e framework on-line).
  * *PdM* (componentes e tendências).

---

## Apêndice A — Exemplos comentados (para você expandir no seu doc)

> **Ex. 1 — Data Parallel com DDP (PyTorch)**
> • *Quando usar:* Modelo cabe em cada GPU, mas falta throughput.
> • *Notas:* Fixe `seed`, use `DistributedSampler`, `DDP(model)`, backend **NCCL**, buckets de gradiente. **Aprendizado:** regra de escala linear/warmup se aumentar muito o **global batch**. ([arXiv][6])

> **Ex. 2 — Modelo que não cabe**
> • *Quando usar:* Transformer gigante.
> • *Estratégia:* **Pipeline (GPipe)** com **micro-batches** e/ou **Tensor Parallel (Megatron-LM)** nas camadas MLP/Attention. ([Lil'Log][4])

> **Ex. 3 — PS vs. AllReduce**
> • *PS* tolera bem falhas e facilita assíncrono, mas vira gargalo; *AllReduce* evita ponto central e satura banda, porém ring puro cresce em latência com N (otimize topologia). ([USENIX][5])

---

## Apêndice B — Tabelas rápidas

### B.1 Técnicas de detecção de anomalias (para logs/telemetria)

| Classe             | Ferramentas comuns                            | Observações                                                    |
| ------------------ | --------------------------------------------- | -------------------------------------------------------------- |
| Estatística        | Z-score, ARIMA, *EWMA*                        | Simples, boa linha de base                                     |
| Não-Supervisionado | *k*-means, Isolation Forest, **Autoencoders** | Úteis sem rótulos; cuidado com *concept drift*                 |
| Supervisionado     | Árvore/XGBoost, SVM, LSTM/Transformer         | Requer rótulos; medir *precision/recall* por tipo de incidente |

**Referência de base** (revisão clássica).

### B.2 Frameworks & uso recomendado

| Framework                  | Cluster             | Melhor para                                |
| -------------------------- | ------------------- | ------------------------------------------ |
| PyTorch DDP                | GPU multi-nó (NCCL) | Treinos DL gerais                          |
| TensorFlow `tf.distribute` | GPU/TPU             | Produtos TF; PS/AllReduce                  |
| Horovod                    | GPU                 | Uniformizar AllReduce em vários frameworks |
| Ray (Train/Actors)         | CPU+GPU heterogêneo | Orquestração + PS + HPO                    |
| Spark MLlib                | CPU distribuído     | Pré-processamento massivo + ML clássico    |

([arXiv][6])

---

## Créditos das figuras (uso em README)

* **Parameter Server (DistBelief, figura reproduzida em post técnico)**
  [https://insujang.github.io/assets/images/220611/parameter\_server.png](https://insujang.github.io/assets/images/220611/parameter_server.png) (cita DistBelief/NeurIPS’12). ([Better Tomorrow with Computer Science][11])
* **AllReduce (NVIDIA NCCL User Guide)**
  [https://docs.nvidia.com/deeplearning/nccl/user-guide/\_images/allreduce.png](https://docs.nvidia.com/deeplearning/nccl/user-guide/_images/allreduce.png). ([NVIDIA Docs][3])
* **GPipe schedule (blog técnico baseado no paper GPipe)**
  [https://lilianweng.github.io/posts/2021-09-25-train-large/gpipe.png](https://lilianweng.github.io/posts/2021-09-25-train-large/gpipe.png). ([Lil'Log][4])
* **Megatron-LM tensor parallel**
  [https://lilianweng.github.io/posts/2021-09-25-train-large/Megatron-LM.png](https://lilianweng.github.io/posts/2021-09-25-train-large/Megatron-LM.png). ([Lil'Log][4])
* **DDoS framework (MDPI, open access)**
  [https://www.mdpi.com/electronics/electronics-13-01004/article\_deploy/html/images/electronics-13-01004-g001.png](https://www.mdpi.com/electronics/electronics-13-01004/article_deploy/html/images/electronics-13-01004-g001.png).
* **PdM components (MDPI, open access)**
  [https://www.mdpi.com/applsci/applsci-14-00898/article\_deploy/html/images/applsci-14-00898-g003.png](https://www.mdpi.com/applsci/applsci-14-00898/article_deploy/html/images/applsci-14-00898-g003.png).

> Observação: as imagens acima são **hospedadas pelos próprios editores/autores** (documentação oficial ou revistas open access). Em repositórios públicos, mantenha a **atribuição** e os **links de origem**.

---

### Referências principais (para leitura guiada)

* **DistBelief / Parameter Server** — Dean et al., *NIPS 2012*; Li et al., *OSDI 2014*. ([Google Research][1])
* **AllReduce e escalabilidade** — NVIDIA/NCCL (blog & guia); otimizações recentes com **NVSwitch Multishot**. ([NVIDIA Developer][2])
* **Pipeline/Tensor Parallel** — GPipe & Megatron-LM (resumos didáticos). ([Lil'Log][4])
* **Large-Batch SGD** — Goyal et al., *arXiv 1706.02677* (regra de escala + warmup).
* **Anomalias** — Chandola et al., *ACM Computing Surveys (2009)*.
* **DDoS com ML** — Revisões recentes e frameworks IoT/Edge (MDPI).
* **PdM** — Ucar et al., *Applied Sciences (2024)*.
* **Frameworks** — PyTorch DDP; TensorFlow `tf.distribute`; Horovod; Ray; Spark MLlib. ([arXiv][6])

---

[1]: https://research.google.com/archive/large_deep_networks_nips2012.pdf?utm_source=chatgpt.com "Large Scale Distributed Deep Networks"
[2]: https://developer.nvidia.com/blog/massively-scale-deep-learning-training-nccl-2-4/?utm_source=chatgpt.com "Massively Scale Your Deep Learning Training with NCCL ..."
[3]: https://docs.nvidia.com/deeplearning/nccl/user-guide/docs/usage/collectives.html "Collective Operations — NCCL 2.28.3 documentation"
[4]: https://lilianweng.github.io/posts/2021-09-25-train-large/ "How to Train Really Large Models on Many GPUs? | Lil'Log"
[5]: https://www.usenix.org/system/files/conference/osdi14/osdi14-paper-li_mu.pdf?utm_source=chatgpt.com "Scaling Distributed Machine Learning with the Parameter ..."
[6]: https://arxiv.org/abs/1811.06965?utm_source=chatgpt.com "GPipe: Efficient Training of Giant Neural Networks using Pipeline Parallelism"
[7]: https://github.com/NVIDIA/Megatron-LM?utm_source=chatgpt.com "NVIDIA/Megatron-LM: Ongoing research training ..."
[8]: https://docs.pytorch.org/docs/stable/generated/torch.nn.parallel.DistributedDataParallel.html?utm_source=chatgpt.com "DistributedDataParallel — PyTorch 2.8 documentation"
[9]: https://docs.ray.io/en/latest/ray-core/examples/plot_parameter_server.html?utm_source=chatgpt.com "Parameter Server — Ray 2.49.1"
[10]: https://www.tensorflow.org/api_docs/python/tf/distribute/MultiWorkerMirroredStrategy?utm_source=chatgpt.com "tf.distribute.MultiWorkerMirroredStrategy"
[11]: https://insujang.github.io/2022-06-11/parallelism-in-distributed-deep-learning/ "Parallelism in Distributed Deep Learning · Better Tomorrow with Computer Science"

---

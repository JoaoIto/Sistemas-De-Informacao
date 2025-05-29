# Resumo: Introdução aos Transformers

Nesta aula exploramos a evolução dos modelos de Inteligência Artificial (IA), especialmente no processamento de linguagem natural (NLP), desde as Redes Neurais Recorrentes (RNNs) e suas variantes LSTM até os modernos Large Language Models (LLMs), baseados na arquitetura Transformer.

## Definição e Contexto

Os Transformers são modelos baseados no mecanismo de **atenção** que revolucionaram o campo do NLP e outras áreas que lidam com dados sequenciais. Ao contrário das RNNs, que processam dados sequencialmente, os Transformers processam a entrada toda de uma vez, focando seletivamente nas partes mais relevantes do dado de entrada através do mecanismo de atenção, especialmente o esquema **QKV (Query, Key, Value)**.

Esse avanço permitiu criar modelos mais eficazes e escaláveis, que podem ser pré-treinados em grandes volumes de dados e ajustados para tarefas específicas com alta performance.

---

## Principais Tópicos Abordados

### Evolução dos Modelos de IA

* **RNNs (LSTM)**: Capturam dependências temporais, mas possuem limitações com sequências longas.
* **Transformers**: Introduzem o mecanismo de atenção para focar em diferentes partes da entrada, dispensando processamento sequencial estrito.
* **LLMs (Large Language Models)**: Modelos de grande escala pré-treinados com arquitetura Transformer, capazes de gerar texto, responder perguntas, traduzir e muito mais.

![image](https://github.com/user-attachments/assets/043813ab-3b3f-4576-9bea-0afc8c031495)

### Visão ampla da rede:

![image](https://github.com/user-attachments/assets/1c3714b7-f10a-4a12-a0d4-d9400d0a117c)


### Mecanismo de Atenção (Attention QKV)

* **Query (Q)**: Representa o vetor da consulta.
* **Key (K)**: Representa os vetores de chaves para comparar com a consulta.
* **Value (V)**: Representa os vetores de valores que serão combinados para gerar a saída.
* O cálculo da atenção permite que o modelo atribua pesos diferentes às partes da entrada, destacando as informações mais relevantes.

### Aplicações Práticas

* Uso de modelos pré-treinados disponíveis na biblioteca **Hugging Face**.
* Demonstração prática de como carregar e usar esses modelos em Python para tarefas como classificação de texto, geração de texto e mais.

---

## Exemplos de Uso e Aplicações Reais

| Aplicação                    | Descrição                                                                              | Fonte / Ferramenta                                        |
| ---------------------------- | -------------------------------------------------------------------------------------- | --------------------------------------------------------- |
| Modelos Pré-Treinados        | Utilização de modelos Transformers prontos para diversas tarefas de NLP.               | [Hugging Face Models](https://huggingface.co/models)      |
| Grandes Modelos de Linguagem | Modelos como GPT, BERT e variantes, usados para tradução automática, resumo e diálogo. | Artigo "Attention Is All You Need" (Vaswani et al., 2017) |
| Pós-treinamento de LLMs      | Técnicas para adaptar modelos grandes a tarefas específicas, aumentando precisão.      | Survey de Tie et al., 2025                                |

---

## Código Exemplo (usando Hugging Face Transformers em Python)

```python
from transformers import pipeline

# Carregar pipeline para análise de sentimento
classifier = pipeline('sentiment-analysis')

# Exemplo de uso
result = classifier("Transformers revolucionaram o processamento de linguagem natural.")
print(result)
```

---

## Referências para Aprofundamento

* Vaswani, A. et al. (2023). *Attention Is All You Need*. DOI: 10.48550/arXiv.1706.03762
* Ma, S. et al. (2024). *The Era of 1-bit LLMs: All Large Language Models are in 1.58 Bits*.
* Xiao, T. & Zhu, J. (2023). *Introduction to Transformers: an NLP Perspective*. DOI: 10.48550/arXiv.2311.17633
* Tie, G. et al. (2025). *A Survey on Post-training of Large Language Models*. DOI: 10.48550/arXiv.2503.06072
* Hochreiter, S. & Schmidhuber, J. (1997). *Long Short-Term Memory*. Neural Computation.

---


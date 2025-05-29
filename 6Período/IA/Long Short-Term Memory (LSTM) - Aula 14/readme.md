# Resumo: Long Short-Term Memory (LSTM)

A Long Short-Term Memory (LSTM) é um tipo especial de rede neural recorrente (RNN) que foi desenvolvida para resolver o problema do desaparecimento e explosão do gradiente nas redes recorrentes tradicionais. Ela é amplamente utilizada para modelar dados sequenciais e séries temporais, como texto, áudio, séries financeiras e sinais temporais em geral.

## Exemplo: 

![image](https://github.com/user-attachments/assets/a4afd3f1-d622-46f1-b271-07c5bbcf6f76)

---

## Definição e Conceitos Básicos

LSTM foi proposta por **Hochreiter e Schmidhuber (1997)** e consiste em células especiais que mantêm informações por períodos de tempo maiores, superando limitações das RNNs tradicionais. A arquitetura da LSTM inclui:

* **Célula de memória**: mantém o estado da rede ao longo do tempo, armazenando informações relevantes.
* **Estados da célula**: representam as memórias de curto e longo prazo.
* **Portas (gates)**: mecanismos que regulam o fluxo de informações dentro da célula, divididas em:

  * **Porta de esquecimento (forget gate)**: decide quais informações descartar.
  * **Porta de entrada (input gate)**: determina quais informações novas serão armazenadas.
  * **Porta de saída (output gate)**: controla quais informações serão passadas adiante.

Essa estrutura permite que a rede LSTM retenha e utilize informações importantes ao longo de muitas etapas de tempo, o que é fundamental para tarefas como tradução automática, reconhecimento de fala e previsão em séries temporais.

---

## Principais Tópicos

### Componentes da LSTM

* **Célula de memória (cell state)**: fluxo de informações linear que carrega as memórias.
* **Forget gate**: camada sigmoide que decide o que será esquecido.
* **Input gate**: camada que seleciona quais valores novos serão adicionados à célula.
* **Output gate**: camada que gera a saída da célula, baseada no estado atualizado.

### Funcionamento Básico

* A célula LSTM lê o estado anterior e a entrada atual.
* O estado da célula é atualizado com base nas decisões das portas.
* A saída é calculada usando o estado da célula e a porta de saída.

---

## Exemplos de Uso e Aplicações Reais

| Aplicação                          | Descrição                                                         | Referência                                                                                                                                                |
| ---------------------------------- | ----------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Detecção de conteúdo ilegal        | Identificação de posts relacionados a crimes em redes sociais.    | [Artigo iieta.org](https://iieta.org/journals/ria/paper/10.18280/ria.370630)                                                                              |
| Previsão de preços de ações        | Modelagem e previsão dos movimentos do mercado financeiro.        | [Analytics Vidhya](https://www.analyticsvidhya.com/blog/2021/12/stock-price-prediction-using-lstm/)                                                       |
| Previsão de vazão de rios          | Estimativa do fluxo de água em rios, auxiliando em gestão hídrica | [UFJF Monografia](https://www2.ufjf.br/engcomputacional/wp-content/uploads/sites/482/2018/09/Monografia_LucasVassalli.pdf)                                |
| Previsão de produtividade agrícola | Estimativa da produção de arroz no Rio Grande do Sul.             | [Artigo UNIRG](https://scholar.archive.org/work/c3bantxembdr5pylzvq4sslt4a/access/wayback/http://ojs.unirg.edu.br/index.php/1/article/download/3428/1796) |
| Predição de cotação de moedas      | Previsão da cotação do Real em relação ao Bitcoin.                | [Brazilian Journals](https://ojs.brazilianjournals.com.br/ojs/index.php/BRJD/article/view/57659)                                                          |
| Predição de consumo energético     | Estimativa do consumo na região Sudoeste.                         | [Artigo UNIRG](https://ojs.unirg.edu.br/index.php/1/article/view/3255)                                                                                    |

---

## Exemplos de Códigos (Simplificado)

```python
import tensorflow as tf
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import LSTM, Dense

# Definindo um modelo simples LSTM para séries temporais
model = Sequential()
model.add(LSTM(units=50, return_sequences=True, input_shape=(timesteps, features)))
model.add(LSTM(units=50))
model.add(Dense(units=1))  # saída única para regressão

model.compile(optimizer='adam', loss='mean_squared_error')
model.summary()
```

---

## Referências para Aprofundamento

* Hochreiter, S., & Schmidhuber, J. (1997). Long Short-Term Memory. *Neural Computation*, 9(8), 1735-1780. DOI: 10.1162/neco.1997.9.8.1735
* Olah, Chris. *Understanding LSTM Networks*. 2015. [Link](https://colah.github.io/posts/2015-08-Understanding-LSTMs/)
* Projetos GitHub com LSTM para aplicações práticas:

  * Sentiment Classification using LSTM Neural Networks – Lucas Daniel Rodrigues dos Santos
  * LSTMs for Human Activity Recognition – Lucas Henderson Vieira Cunha

---


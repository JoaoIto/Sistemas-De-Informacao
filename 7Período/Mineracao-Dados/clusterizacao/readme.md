# O que é Clusterização?

Clusterização é uma técnica de aprendizado de máquina **não supervisionado** usada para agrupar dados semelhantes em conjuntos chamados **clusters**. Ao contrário da classificação, que precisa de dados rotulados para treinar, a clusterização encontra padrões e estruturas nos dados sem que as categorias sejam definidas previamente.

**Para que serve:**  
- Identificar grupos naturais dentro dos dados.  
- Facilitar a análise e a tomada de decisões ao segmentar dados complexos.  
- Usada em segmentação de clientes, detecção de anomalias, agrupamento de produtos, entre outros.  

Nas atividades práticas de mineração de dados, usa-se clusterização para explorar datasets sem rótulo ou para criar segmentos úteis para análises subsequentes.

***

## Como o Aprendizado Acontece?

Como método não supervisionado, a clusterização:

1. Recebe um conjunto de dados sem rótulos.
2. Calcula similaridades ou distâncias entre os pontos de dados com base nos atributos.
3. Agrupa esses pontos com base em critérios de proximidade ou densidade.
4. Itera para melhorar os grupos até um critério de parada ser atingido.

***

## Principais Algoritmos de Clusterização

### 1. **K-Means**

**Descrição:**  
Agrupa os dados em um número fixo \(k\) de clusters, calculando iterativamente os centróides e atribuindo cada ponto ao cluster mais próximo.

**Configuração nos datasets das atividades:**  
- É necessário definir o número \(k\) de clusters antes da execução.  
- Usa distância euclidiana para medir a proximidade.  
- Inicializa os centróides aleatoriamente (ou via k-means++ para melhor inicialização).  
- Itera até que os centróides parem de se mover ou o número máximo de iterações seja atingido.

**Como ajuda:**  
Facilita identificar grupos semelhantes, por exemplo, segmentar clientes em grupos de comportamento semelhante.

| Parâmetros Principais | Função | Exemplo Típico nas Atividades |
|----------------------|--------|------------------------------|
| `n_clusters`         | Número de grupos | 3 a 5 clusters, escolhido pelo método do cotovelo |
| `init`               | Inicialização dos centróides | 'k-means++' para melhor convergência |
| `max_iter`           | Máximo de iterações | 300 para garantir convergência |
| `random_state`       | Reprodutibilidade | 42 |

***

### 2. **Clusterização Hierárquica**

**Descrição:**  
Constrói uma árvore de clusters (dendrograma), que pode ser aglomerativa (bottom-up) ou divisiva (top-down).  
- Aglomerativa começa com cada ponto como cluster separado e junta os clusters mais próximos iterativamente.  
- Divisiva começa com todos os pontos em um cluster e os divide repetidamente.

**Configuração nas atividades:**  
- Não exige número de clusters previamente definido.  
- Escolha do local para cortar o dendrograma define os clusters finais.  
- Linkage (single, complete, average, Ward) define a forma como as distâncias entre clusters são calculadas.  

**Como ajuda:**  
Útil para entender relacionamentos hierárquicos, como em análise genética ou organização de documentos.

***

## Métricas e Avaliação da Clusterização

### Silhueta  
Indica quão bem os objetos estão agrupados:

\[
s(i) = \frac{b(i) - a(i)}{\max(a(i), b(i))}
\]

- \(a(i)\): distância média dentro do cluster do ponto \(i\)  
- \(b(i)\): distância média ao cluster mais próximo diferente  
- Valor varia entre -1 e 1, onde próximo a 1 indica bom cluster, próximo a 0 indica ponto na fronteira entre clusters e negativo indica erro na atribuição.  

### Método do Cotovelo  
Usado para escolher o número \(k\) de clusters para K-means. Plota a soma das distâncias quadráticas (inércia) em função de \(k\); o "cotovelo" indica escolha adequada.

***

## Exemplo Prático nas Atividades

Considere um dataset de clientes com atributos: Idade, Renda, Frequência de Compra:

```python
from sklearn.cluster import KMeans
import matplotlib.pyplot as plt
from sklearn.metrics import silhouette_score

# Preparação dos dados
X = df[['idade', 'renda', 'frequencia']]

# Método do cotovelo para achar k ideal
inercia = []
k_range = range(1, 11)
for k in k_range:
    kmeans = KMeans(n_clusters=k, random_state=42)
    kmeans.fit(X)
    inercia.append(kmeans.inertia_)

plt.plot(k_range, inercia, marker='o')
plt.xlabel('Número de clusters k')
plt.ylabel('Inércia')
plt.title('Método do Cotovelo')
plt.show()

# Ajuste com k definido
k_opt = 3
kmeans = KMeans(n_clusters=k_opt, random_state=42)
clusters = kmeans.fit_predict(X)

# Avaliação com silhueta
score = silhouette_score(X, clusters)
print(f'Score de Silhueta para k={k_opt}: {score:.2f}')
```

**Resultados esperados no cenário:**  
- Gráficos indicam k=3 ou 4 como boa escolha.  
- Score de silhueta >0.5 indica cluster bem definido.  
- Clientes agrupados podem ser segmentados para marketing específico.

***

## Resumo da Aplicação e Benefícios

| Aspecto              | Detalhes Práticos                             |
|----------------------|----------------------------------------------|
| **Tipo de Aprendizado** | Não supervisionado                          |
| **Uso típico nos datasets** | Segmentação, exploração de dados          |
| **Parâmetros críticos**  | Número de clusters (k), método de linkage   |
| **Métricas para validação** | Silhueta, método do cotovelo, índice Davies-Bouldin |
| **Configuração comum nas atividades** | KMeans com random_state, max_iter≈300    |
| **Impacto prático**     | Melhora o entendimento do negócio, direciona ações estratégicas |

***

Esta documentação foca na explicação clara do conceito, seu uso prático e como ele é configurado nos dados utilizados nas atividades, incluindo os parâmetros, métricas e interpretação que ajudam você a entender e aplicar clusterização de forma eficaz.

Se desejar, prossigo com a documentação didática para o próximo conteúdo (ex: regressão, classificação, etc).

[1](http://profs.ic.uff.br/~ssoares/artigos/ERI-Minicurso-SATORU.pdf)
[2](https://ejfgv.com/blog/data-science-blog/clusterizacao/)
[3](https://www.maxwell.vrac.puc-rio.br/24787/24787_5.PDF)
[4](https://aws.amazon.com/pt/what-is/data-mining/)
[5](https://ejfgv.com/clusterizacao/)
[6](https://www.cortex-intelligence.com/blog/o-que-e-clusterizacao)
[7](https://www.ibm.com/br-pt/think/topics/clustering)
[8](https://blog.somostera.com/data-science/clusteriza%C3%A7%C3%A3o-de-dados)
[9](https://optimus-solutions.com.br/clusterizacao-conceitos-basicos-principais-algoritmos-e-como-usar/)
[10](https://a10br.com/a-clusterizacao-dos-dados/)
[11](https://www.semanticscholar.org/paper/a28234623da008ff94f4a7aeb9fe9d363d2edb42)
[12](https://sol.sbc.org.br/index.php/wei/article/view/29680)
[13](http://www.abepro.org.br/publicacoes/artigo.asp?e=enegep&a=2024&c=47937)
[14](https://journals-sol.sbc.org.br/index.php/rbie/article/view/3296)
[15](https://sol.sbc.org.br/index.php/sbie/article/view/26739)
[16](https://ojs.studiespublicacoes.com.br/ojs/index.php/sees/article/view/2143)
[17](https://periodicos.ifsul.edu.br/index.php/educarmais/article/view/4120)
[18](https://periodicos.newsciencepubl.com/LEV/article/view/1712)
[19](https://sol.sbc.org.br/index.php/wei/article/view/9644)
[20](https://periodicos.ifsul.edu.br/index.php/educarmais/article/view/2691)
[21](http://pdf.blucher.com.br/designproceedings/ped2016/0217.pdf)
[22](https://revistas.ufpr.br/atoz/article/download/41340/25333)
[23](http://seer.upf.br/index.php/rbca/article/download/7082/4536)
[24](https://eademfoco.cecierj.edu.br/index.php/Revista/article/download/1786/773)
[25](http://pdf.blucher.com.br/marineengineeringproceedings/spolm2019/143.pdf)
[26](http://pdf.blucher.com.br/engineeringproceedings/cbgdp2019/08.pdf)
[27](https://www.scielo.br/j/rbmet/a/GsB7kNj4QqzDPybDCvfHcGm/?format=pdf&lang=pt)
[28](https://www.scielo.br/j/csp/a/Pb74Fw9Xnh6hQy5GyNZDxvn/?format=pdf&lang=pt)

# Gabarito regular
***

### Questão 1 – Regressão Linear

**Resposta correta: d) Todas as alternativas anteriores.**

**Explicação:**  
- O R² = 0,85 significa que 85% da variação do preço dos imóveis é explicada pelo modelo (inciso a correto).  
- O coeficiente 1500 indica que cada metro quadrado a mais eleva o preço em média R$1500 (inciso b correto).  
- P-valores muito pequenos indicam que os coeficientes são estatisticamente significativos, ou seja, não são frutos do acaso (inciso c correto).

***

### Questão 2 – Clusterização e Método do Cotovelo

**Resposta correta: c) 3**

**Explicação:**  
No gráfico de inércia, o "cotovelo" é o ponto em que a queda da inércia começa a desacelerar claramente — aqui, a partir do k=3; valores maiores trazem ganhos marginais pequenos. Essa é a escolha comum para k.

***

### Questão 3 – Matriz de Confusão e Precisão

**Resposta correta: a) 0,81**

**Cálculo:**  
Precisão = TP / (TP + FP) = 85 / (85 + 20) = 85 / 105 ≈ 0,81  
Isso significa que, das vezes que o modelo previu positivo, 81% estavam corretas.

***

### Questão 4 – AutoML (Verdadeiro ou Falso)

**Resposta correta: F) Falso**

**Explicação:**  
AutoML automatiza partes do pipeline, mas não substitui a necessidade do conhecimento do domínio, interpretação das métricas e análise crítica. Entender dados e métricas é fundamental para evitar erros e interpretar resultados.

***

### Questão 5 – Regras de Associação

**Resposta correta: a)**

**Explicação:**  
- Suporte = 0.04 significa que a regra acontece em 4% das transações.  
- Confiança = 0.75 indica que 75% das vezes em que X ocorre, Y também ocorre.  
- Lift = 1.8 > 1 mostra uma associação positiva forte — Y é 80% mais provável se X ocorreu.

***

### Questão 6 – Parâmetro `max_depth` em Random Forest

**Resposta correta: a)**

**Explicação:**  
O parâmetro `max_depth` limita a profundidade das árvores individuais, controlando a complexidade para evitar que o modelo demore muito e evite overfitting (memorização do treino).

***

### Questão 7 – Aprendizado Supervisionado vs Não Supervisionado

**Resposta correta: c) Classificação e Clusterização**

**Explicação:**  
- Classificação é aprendizado supervisionado (usa rótulos).  
- Clusterização é aprendizado não supervisionado (sem rótulos).  
- Regressão também é supervisionada, mas está em outra alternativa errada.  

***

### Questão 8 – Curva ROC e AUC

**Resposta correta: a) Modelo D é quase aleatório, A é o melhor.**

**Explicação:**  
AUC=0,5 indica modelo aleatório que não aprende nada (modelo D). AUC perto de 1 indica ótima classificação (modelo A). Modelos com AUC entre 0,7 e 0,8 são aceitos como bons.  

***

### Questão 9 – Validação Cruzada

**Resposta correta: V) Verdadeiro**

**Explicação:**  
Validação cruzada (k-fold) executa múltiplas divisões treino/teste para avaliar de forma mais confiável a performance do modelo e prevenir overfitting.

***

### Questão 10 – Parâmetros em K-Means (max_iter)

**Resposta correta: a)**

**Explicação:**  
`max_iter` define o número máximo de iterações que o algoritmo pode rodar para que os centróides se estabilizem. Se acabar antes da convergência, o resultado pode ser ruim. Portanto, aumentar `max_iter` ajuda.

***

Esse gabarito com explicações te ajuda a compreender o motivo por trás de cada resposta, reforçando conceitos fundamentais e como aplicá-los na prática.

Se desejar, pode pedir outras provas, explicações adicionais, ou documentação detalhada para qualquer conteúdo específico.

[1](https://pt.scribd.com/document/875924076/Prova-Estacio-Experiencie-Completa-Com-Gabarito-Explicado)
[2](https://www.passeidireto.com/arquivo/195465413/mineiracao-de-dados-02)
[3](https://www.passeidireto.com/arquivo/90085470/mineracao-de-dados-atividade-objetiva-2)
[4](https://www.modelitos.com.br/atividades/questionario/questionario-ae2-banco-de-dados-e-mineracao)
[5](https://pt.scribd.com/document/782486652/Avaliacao-do-Modulo-1-Mineracao-de-dados-Revisao-da-tentativa)
[6](https://www.passeidireto.com/arquivo/102779116/ao-2-mineracao-de-dados)
[7](https://questoes.grancursosonline.com.br/questoes-de-concursos/tecnologia-da-informacao-mineracao-de-dados-data-mining-8113)
[8](https://www.estrategiaconcursos.com.br/blog/comentarios-sobre-conhecimentos-de-bd-cgu-4/)
[9](https://pt.scribd.com/document/516807090/Mineracao-de-Dados-Prova)
[10](https://www.passeidireto.com/arquivo/94433699/a-2-mineracao-de-dados)
[11](http://seer.upf.br/index.php/rbca/article/download/7082/4536)
[12](http://pdf.blucher.com.br/designproceedings/ped2016/0217.pdf)
[13](https://www.scielo.br/j/eagri/a/L64GNFVCQRk39jXzZ7yCjxJ/?format=pdf&lang=pt)
[14](https://www.scielo.br/j/csp/a/Pb74Fw9Xnh6hQy5GyNZDxvn/?format=pdf&lang=pt)
[15](https://www.scielo.br/j/pab/a/CsHyp74X76YygZj5QDMkkKz/?format=pdf&lang=pt)
[16](https://revistas.ufpr.br/atoz/article/download/41284/25210)
[17](http://pdf.blucher.com.br/marineengineeringproceedings/spolm2019/122.pdf)
[18](http://pdf.blucher.com.br/marineengineeringproceedings/spolm2019/032.pdf)

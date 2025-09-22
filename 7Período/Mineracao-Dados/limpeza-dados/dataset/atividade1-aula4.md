# Respostas – Aula 04 (Pré-processamento em dataset sintético)

**1) Padronização de colunas**  
Resposta: aplicado snake_case.

**2) Conversão de tipos**  
Resposta: datas para datetime; idade/salario para numérico.

**3) Limpeza de texto**  
Resposta: normalização em nome, cidade, estado_civil, cargo.

**4) Remoção >90% NaN**  
Resposta: ['telefone'].

**5) Imputação**  
Resposta: mediana (numéricos) e moda (categóricas).

**6) Inconsistências**  
Resposta: idade fora de 14–100 → NaN; data_admissao futura → NaT.

**7) Duplicatas**  
Resposta: removidas 239.

**8) Verificações finais**  
Resposta: shape=(10000, 7), duplicatas_restantes=0.
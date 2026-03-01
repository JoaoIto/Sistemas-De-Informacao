# Atividade tabelas e gráficos

Depois que você aprendeu sobre a importância dos gráficos e das tabelas na
apresentação dos dados.

1. Acesse o Portal do IBGE, no seguinte endereço (https://cidades.ibge.gov.br/pesquisas)
2. Conheça e pesquise o conjunto de pesquisas que são disponibilizados pelo instituto.
3. Após conhecer a plataforma, escolha um dos ítens (pesquisa) do seu interesse, como por
exemplo, pesquisa de inovação.
4. Após a sua escolha, construa uma tabela e um gráfico a partir de uma série temporal
(cronológica) e comente sucintamente sobre o comportamento deste ítem ao longos dos
anos. 


### 1. A Escolha e o Link do IBGE

* **Tema Escolhido:** Produto Interno Bruto (PIB) a preços correntes.
* **Localidade:** Palmas, Tocantins.
* **Link Direto:** [IBGE Cidades - PIB de Palmas (TO)](https://cidades.ibge.gov.br/brasil/to/palmas/pesquisa/38/46996)

### 2. O Que Fazer com os Dados (Como Entender)

Quando você abre o site do IBGE, você vê uma montanha de números soltos. O que a estatística faz (e o que a sua atividade pede) é transformar isso em uma **Série Temporal**.

1. **Filtrar:** Nós ignoramos os outros municípios e focamos apenas em Palmas.
2. **Recortar o Tempo:** Pegamos uma janela de 5 anos contínuos (2017 a 2021, que são os dados consolidados mais recentes disponibilizados na série histórica completa).
3. **Mudar a Escala:** O IBGE mostra o valor em milhares de reais (ex: `10.333.419`). Para ficar didático na tabela e no gráfico, nós transformamos isso para **Bilhões de Reais** (ex: `10,3 Bilhões`).
4. **Visualizar:** Colocamos isso em um gráfico de linhas, pois é o formato perfeito para o cérebro humano enxergar "quedas" e "crescimentos" ao longo do tempo.

---

<img width="861" height="475" alt="image" src="https://github.com/user-attachments/assets/543b7095-e035-450d-8618-241310e1c360" />


---

### 3. Código Completo para o Google Colab

Abra o seu [Google Colab](https://colab.research.google.com/), crie um "Novo Notebook" (*New Notebook*), copie o código inteiro abaixo, cole na célula de código e aperte o botão de "Play" (Run).

```python
import pandas as pd
import matplotlib.pyplot as plt

# 1. DADOS REAIS EXTRAÍDOS DO IBGE (PIB de Palmas-TO em Bilhões de Reais)
dados_pib = {
    'Ano': [2017, 2018, 2019, 2020, 2021],
    'PIB (Bilhões R$)': [8.8, 9.4, 9.8, 9.5, 10.3]
}

# 2. CRIANDO A TABELA (DataFrame)
tabela_pib = pd.DataFrame(dados_pib)

# Exibindo a Tabela formatada na tela
print("--- TABELA: EVOLUÇÃO DO PIB DE PALMAS (TO) ---")
print(tabela_pib.to_string(index=False))
print("-" * 46)

# 3. CONFIGURANDO E GERANDO O GRÁFICO
plt.figure(figsize=(10, 5)) # Define o tamanho da imagem gerada

# Criando um gráfico de linhas para a série temporal
plt.plot(tabela_pib['Ano'], tabela_pib['PIB (Bilhões R$)'], 
         marker='o',          # Coloca bolinhas nos pontos de cada ano
         color='#1f77b4',     # Cor da linha (azul clássico)
         linewidth=2.5,       # Espessura da linha
         markersize=9)        # Tamanho das bolinhas

# Adicionando Títulos e Nomes aos Eixos
plt.title('Evolução do Produto Interno Bruto (PIB) - Palmas/TO', fontsize=14, fontweight='bold')
plt.xlabel('Anos (Série Histórica)', fontsize=12)
plt.ylabel('Valor em Bilhões (R$)', fontsize=12)

# Adicionando os valores exatos em cima de cada bolinha no gráfico
for x, y in zip(tabela_pib['Ano'], tabela_pib['PIB (Bilhões R$)']):
    plt.text(x, y + 0.1, f'R$ {y} B', ha='center', fontsize=10, fontweight='bold')

# Ajustes Estéticos do Gráfico
plt.grid(True, linestyle='--', alpha=0.5) # Coloca uma grade de fundo pontilhada
plt.xticks(tabela_pib['Ano']) # Garante que os números dos anos não fiquem quebrados no eixo X
plt.ylim(8.0, 11.0) # Define o limite visual do eixo Y para a linha não colar nas bordas

# Exibindo o Gráfico final
plt.show()

```

---

### 4. A Análise Sucinta (Para colocar na resposta da atividade)

A sua Atividade 2 pede que, após gerar o gráfico, você "faça uma análise sucinta dos resultados". Você pode escrever algo estruturado assim:

> **Análise da Série Temporal (PIB Palmas-TO):**
> Observando o gráfico gerado a partir dos dados do IBGE, nota-se que a economia da capital tocantinense vinha em uma tendência de crescimento sólido entre 2017 (R$ 8,8 Bi) e 2019 (R$ 9,8 Bi). No ano de 2020, a série histórica registra uma leve retração, caindo para R$ 9,5 Bilhões, o que reflete diretamente os impactos econômicos das paralisações geradas pela pandemia de COVID-19. Contudo, o dado de 2021 demonstra uma forte recuperação em "V", com o município atingindo o seu pico histórico na série (R$ 10,3 Bilhões), demonstrando a resiliência e a rápida retomada do setor de serviços e comércio na capital.

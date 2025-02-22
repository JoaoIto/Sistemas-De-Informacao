# 📖 **Documentação: Algoritmo Genético com Corte**  

## 🔥 **O que é um Algoritmo Genético com Corte?**  

O **AG com corte** é uma variação do **AG simples** onde o **cruzamento** (reprodução) ocorre a partir de um **ponto de corte** nos genes dos pais.  

🔹 **Como funciona o corte no cruzamento?**  

1. Escolhemos um **ponto de corte** aleatório dentro do cromossomo.  
2. Dividimos cada pai em duas partes: antes e depois do corte.  
3. Geramos dois novos filhos trocando as partes após o ponto de corte.  

Essa técnica mantém uma boa diversidade genética e melhora a convergência para a solução ideal.  

---

## ⚖️ **Diferença entre AG Simples e AG com Corte**  

| Característica        | AG Simples | AG com Corte |
|----------------------|------------|--------------|
| **Cruzamento** | Pais são trocados **por inteiro** para gerar filhos. | Apenas **parte dos genes** são trocados no cruzamento. |
| **Diversidade** | Pode gerar filhos idênticos aos pais. | Produz maior diversidade genética. |
| **Eficiência** | Pode demorar para convergir. | Tende a convergir mais rápido para soluções ótimas. |
| **Controle sobre herança genética** | Difícil garantir a passagem de genes vantajosos. | Genes importantes podem ser mantidos parcialmente. |

🔹 **Resumindo**: O **AG com corte** é mais eficiente e gera indivíduos com maior diversidade genética, melhorando a exploração do espaço de soluções.  

---

## 📌 **Exemplo Visual do Cruzamento com Corte**  

| **Pai 1**  | 1 | 0 | 1 | **|** 0 | 0 | 1 | 1 |
|------------|---|---|---|---|---|---|---|---|
| **Pai 2**  | 0 | 1 | 0 | **|** 1 | 1 | 0 | 0 |
| **Filho 1** | 1 | 0 | 1 | **|** 1 | 1 | 0 | 0 |
| **Filho 2** | 0 | 1 | 0 | **|** 0 | 0 | 1 | 1 |

💡 **O corte ocorre após o terceiro gene**, e os filhos trocam a parte final dos cromossomos.  

---

## 🎯 **Conclusão**  

✅ O **Algoritmo Genético com Corte** melhora a diversidade genética e acelera a convergência.  
✅ Ele é amplamente usado em problemas de otimização e aprendizado de máquina.  
✅ Comparado ao AG simples, ele proporciona uma evolução mais eficiente.  

---

Se precisar de mais detalhes ou exemplos, me avise! 🚀

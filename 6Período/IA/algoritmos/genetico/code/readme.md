## **Explicação do Código Python**
O código implementa um **algoritmo genético (AG)** para otimização,  é feito pelo prof marcos, através do link de [Algoritmo Genético](https://github.com/sousamaf/AI-Lab/tree/main/algorithms/genetic_algorithms)onde uma população de indivíduos evolui através de seleção, cruzamento e mutação.

### **Componentes principais**
1. **Inicialização da população**: 
   - Cada indivíduo é representado por um vetor binário (`0` e `1`).
   - A população inicial é gerada aleatoriamente.

2. **Avaliação**:
   - Cada indivíduo recebe um valor de aptidão baseado em um conjunto de pesos (valores dos livros).

3. **Seleção (Roleta)**:
   - Um método de seleção proporcional à aptidão, onde indivíduos melhores têm maior chance de serem escolhidos para reprodução.

4. **Cruzamento**:
   - **Cruzamento simples**: Divide os genes dos pais ao meio e troca as metades.
   - **Cruzamento uniforme**: Cada gene do filho é escolhido aleatoriamente de um dos pais.

5. **Mutação**:
   - Pequenas alterações em genes aleatórios para garantir diversidade genética.

6. **Substituição**:
   - A nova população substitui a anterior.

7. **Execução por gerações**:
   - O algoritmo roda por `N` gerações, mantendo a melhor solução.

---

## **Implementação do Algoritmo Genético em JavaScript**
Aqui está a versão do seu código Python reescrita em JavaScript:

```javascript
class AlgoritmoGenetico {
    constructor(TAM_POP, TAM_GENE, numero_geracoes = 100) {
        console.log("Algoritmo Genético executado.");
        this.TAM_POP = TAM_POP;
        this.TAM_GENE = TAM_GENE;
        this.POP = [];
        this.POP_AUX = [];
        this.aptidao = [];
        this.aptidao_perc = [];
        this.numero_geracoes = numero_geracoes;
        this.populacaoInicial();
    }

    populacaoInicial() {
        console.log("Criando população inicial!");
        for (let i = 0; i < this.TAM_POP; i++) {
            this.POP.push(Array.from({ length: this.TAM_GENE }, () => Math.round(Math.random())));
        }
    }

    preRoleta() {
        let aptidaoTotal = this.aptidao.reduce((a, b) => a + b, 0);
        this.aptidao_perc = this.aptidao.map(apt => (apt * 100) / aptidaoTotal);
    }

    roleta() {
        let sorteado = Math.random() * 100;
        let acumulado = 0;
        for (let i = 0; i < this.TAM_POP; i++) {
            acumulado += this.aptidao_perc[i];
            if (acumulado > sorteado) return i;
        }
        return 0;
    }

    operadoresGeneticos() {
        let tx_cruzamento_simples = 30;
        let tx_cruzamento_uniforme = 70;
        let tx_mutacao = 2;

        for (let geracao = 0; geracao < this.numero_geracoes; geracao++) {
            this.POP_AUX = [];
            this.avaliacao();
            this.preRoleta();

            // Cruzamento simples
            let qtd = Math.floor((this.TAM_POP * tx_cruzamento_simples) / 100);
            for (let i = 0; i < qtd; i++) {
                let pai1 = this.roleta();
                let pai2;
                do {
                    pai2 = this.roleta();
                } while (pai1 === pai2);
                this.cruzamentoSimples(pai1, pai2);
            }

            // Cruzamento uniforme
            qtd = Math.floor((this.TAM_POP * tx_cruzamento_uniforme) / 100);
            for (let i = 0; i < qtd; i++) {
                let pai1 = this.roleta();
                let pai2;
                do {
                    pai2 = this.roleta();
                } while (pai1 === pai2);
                this.cruzamentoUniforme(pai1, pai2);
            }

            // Mutação
            qtd = Math.floor((this.TAM_POP * tx_mutacao) / 100);
            for (let i = 0; i < qtd; i++) {
                let quem = Math.floor(Math.random() * this.TAM_POP);
                this.mutacao(quem);
            }

            this.substituicao();
        }
        this.exibeMelhorIndividuo();
    }

    cruzamentoSimples(pai1, pai2) {
        let meio = Math.floor(this.TAM_GENE / 2);
        let desc1 = [...this.POP[pai1].slice(0, meio), ...this.POP[pai2].slice(meio)];
        let desc2 = [...this.POP[pai2].slice(0, meio), ...this.POP[pai1].slice(meio)];
        this.POP_AUX.push(desc1, desc2);
    }

    cruzamentoUniforme(pai1, pai2) {
        let desc1 = [];
        let desc2 = [];
        for (let i = 0; i < this.TAM_GENE; i++) {
            if (Math.random() < 0.5) {
                desc1.push(this.POP[pai1][i]);
                desc2.push(this.POP[pai2][i]);
            } else {
                desc1.push(this.POP[pai2][i]);
                desc2.push(this.POP[pai1][i]);
            }
        }
        this.POP_AUX.push(desc1, desc2);
    }

    mutacao(i) {
        let g = Math.floor(Math.random() * this.TAM_GENE);
        this.POP_AUX[i][g] = this.POP_AUX[i][g] === 0 ? 1 : 0;
    }

    substituicao() {
        this.POP = [...this.POP_AUX];
    }

    avaliacao() {
        let livros = [0.6, 1.6, 0.8, 0.7, 1.2, 0.3, 0.1, 1.4, 1.3, 0.5];
        this.aptidao = this.POP.map(individuo =>
            individuo.reduce((peso, gene, i) => peso + gene * livros[i], 0)
        );
    }

    pegarMelhorIndividuo() {
        let aptMax = Math.max(...this.aptidao);
        let index = this.aptidao.indexOf(aptMax);
        return { index, aptMax };
    }

    exibeMelhorIndividuo() {
        let { index, aptMax } = this.pegarMelhorIndividuo();
        console.log(`Melhor indivíduo: ${index} | Aptidão: ${aptMax}`);
    }
}

// Executando o algoritmo
let ag = new AlgoritmoGenetico(10, 10, 100);
ag.operadoresGeneticos();
```

---

## **Comparação entre Python e JavaScript**
1. **Listas e Arrays**
   - Em Python, listas são criadas com `[]` e podem armazenar diferentes tipos.
   - Em JavaScript, `Array.from({ length: TAM_GENE }, () => Math.round(Math.random()))` cria um array de genes.

2. **Gerando números aleatórios**
   - Python: `np.random.randint(0, 2)`
   - JS: `Math.round(Math.random())`

3. **Iterações e loops**
   - Python usa `for i in range(n)`
   - JS usa `for (let i = 0; i < n; i++)`

4. **Manipulação de listas**
   - Em Python: `self.POP.append(lista)`
   - Em JS: `this.POP.push(lista)`

---


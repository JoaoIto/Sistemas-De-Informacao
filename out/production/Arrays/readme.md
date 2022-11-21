# Matrizes

**As matrizes são somente arrays com posições de mais de uma dimensão. Se entende que quando criamos uma matriz, significa basicamente que criamos um array que pode ser lidado como bidimensional, contendo normalmente, linhas e colunas. Porém ainda as matrizes podem ser multidimensionais, com mais dimensões...**

## Declaração: 

```java
int[][] matriz = new int[][];
```

## Preenchimento:


**Entendo que a matriz é somente um array correspondido por linhas e colunas, usaremos 2 laços de repetição para indicar cada 1 e dizer como preencher cada uma a partir da variável de controle!** 


```java
        float[][] matriz = new float[5][2]; 
        // declaração e instanciação de uma matriz de 
        // dimensões 5x2 (5 linhas e 2 colunas)
        Scanner leitor = new Scanner(System.in);
        
        // processamento de uma matriz
        for(int l=0; l<5; l++) {//percorre as linhas
            System.out.println("Informe as notas do aluno " + (l+1) +":");
            for(int c=0; c<2; c++) {//percorre as colunas
                // processamento de cada posição da matriz
                // preencher com valores digitados pelo usuário
                System.out.print("Nota " + (c+1) + ":");
                matriz[l][c] = leitor.nextFloat();
            }
        }
        
        // antes de iniciar o processamento da matriz
        System.out.print("Tabela de Notas:\n");
        //-------------------------------------------
        
        // processamento de uma matriz
        for(int l=0; l<5; l++){ //percorre as linhas
        // antes de iniciar o processamento da linha
            
        System.out.print(" " + (l+1) + "\t");//mostra o numero da linha
            
            // --------------------------------------------
            
            for(int c=0; c<2; c++){// percorre as colunas de uma linha 
                // imprimir a matriz na tela
                System.out.print("[" + matriz[l][c] + "]\t");
            }   // termina uma linha
            // antes de passar para a próxima linha
            System.out.print("\n");
            //-------------------------------------
            
        }
```

---

## Campo Minado!

Você com certeza já jogou aquele velho joguinho de computador antigo que você tinha que acertar com quadradinhos que estão numerados com bombas que podem acabar com a sua diversão a qualquer momento! Reproduzimos este jogo em Java!

**O jogo tem o mesmo propósito, porém para facilitar, vamos colocar as bombas em números aleatórios, ímpares que ainda podemos colocar a partir de parâmetros de linha e coluna, que colocam este valor a mostra.**
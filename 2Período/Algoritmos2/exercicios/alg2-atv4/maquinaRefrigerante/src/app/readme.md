# App.java

- 1. **Primeiramente iremos inicializar o objeto de MaquinaRefrigerante, e ainda sim iremos inicializar um vetor de *type* MaquinaRefrigerante, de maneira a também lidar com isso, a partir do objeto com a quantidade de refrigerantes exigidos.**

```java
        MaquinaRefrigerante maquina = new MaquinaRefrigerante();
        List<MaquinaRefrigerante> list = new ArrayList<>();
```

- 2. **Adicionamos os produtos existententes na máquina, obedecendo ainda a ordem dos parâmetros dos construtores do objeto e assim, podemos criar, `(<nomeObjeto>, <index>, <preco>)`:**

```java
        list.add(new MaquinaRefrigerante("Coca", 1, 15.00));
        list.add(new MaquinaRefrigerante("Pepsi", 2, 12.00));
        list.add(new MaquinaRefrigerante("GuaranÃ¡-Jesus", 3, 6.00));
        list.add(new MaquinaRefrigerante("H2O_250ml", 4, 7.00));
        list.add(new MaquinaRefrigerante("Red-Bull_Lata", 5, 9.00));
```

- 3. **Faremos agora o menu de navegação com a exibição destes itens que foram adicionados, e assim podemos basicamente ver eles como opções a partir de seus index como opção, seu número, e assim escolhemos digitando no console. E assim ele é colocado e teu preço...**

```java
        for (MaquinaRefrigerante var : list) {
            System.out.printf("%d %s R$%.2f\n", var.getCodProduto(), var.getNome(), 
            var.getPrecoProduto());
        }

        System.out.println();
        System.out.println("Escolha um refrigerante e insira a quantia em dinheiro");
```

- **Nessa parte ainda assim podemos perceber que o próprio método principal, de `main()`, não trabalha, e chamamos diretamemente os métodos da própria classe, que está bem explicado a partir do Readme de *classes*...**

- 4. **A partir precisamos dizer ao cliente para escolher e chamar os métodos da classe para simplesmente analisar, a lista, o dinheiro colocado, e o valor do refrigerante. Selecionando assim o refrigerante!**

```java
        System.out.println("Escolha um refrigerante e insira a quantia em dinheiro");
        maquina.selecionarRefrigerante(list, sc.nextInt(), sc.nextDouble());
```
```java
public class MaquinaRefrigerante
```

Esta é a classe do objeto principal utilizado na construção da nossa maquina, e nada de muito incomum temos nessa classe, além dos próprio `getters()` e `setters()` da própria classe.

O que temos ainda é um método...

- **Este é um objeto de selecionarRefrigerante, ele tem a função de analisar todos os atributos do objeto, e assim conseguir passar por todos eles a partir de uma lista de repetição.**

- **Logo depois definir qual é o escolhido usando o parâmetro que foi recebido de `codProduto` e assim consigo chamar o próprio método `getNome()` do produto em si.**

- **E depois ele faz uma lógica base para a parte de inserir dinheiro e assim subtrair pelo próprio preço dos produtos, com, também, os próprio métodos da classe...**

- **Depois só precisamos definir uma mensagem de sucesso ou não para o cliente, caso a venda seja realizada, ou ainda sim, uma mensagem de dinheiro que foi inserido seja insuficiente para o refrigerante escolhido:**

```java
    public void selecionarRefrigerante(List<MaquinaRefrigerante> lista, int codProduto, double dinheiro) {
        for (MaquinaRefrigerante refrigerante : lista) {
            if (refrigerante.getCodProduto() == codProduto) {
                System.out.println("Você escolheu: " + refrigerante.getNome());
                System.out.println("Preço: R$" + refrigerante.getPrecoProduto());
                refrigerante.inserirDinheiro(dinheiro);
                if (refrigerante.getDinheiro() >= refrigerante.getPrecoProduto()) {
                    System.out.printf("Troco %.2fR$\n", (refrigerante.getDinheiro() - refrigerante.getPrecoProduto()));
                    System.out.println("Venda realizada");
                } else {
                    System.out.println("Dinheiro insuficiente");
                }
            }
        }
    }
```

---